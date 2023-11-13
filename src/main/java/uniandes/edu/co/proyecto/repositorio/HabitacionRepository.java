package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.dtos.ServicioResumenDTO;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.ServicioResumen;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

    @Query(value = "SELECT * FROM habitacion", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitacion WHERE id = :id", nativeQuery = true)
    Habitacion darHabitacionPorId(@Param("id") int id);

    @Query(value = "SELECT * FROM habitacion WHERE tipohabitacion = :tipohabitacion", nativeQuery = true)
    Collection<Habitacion> darHabitacionesPorTipo(@Param("tipohabitacion") String tipohabitacion);

    @Query(value = """
                SELECT
                        r.habitacion_id AS habitacion_id,
                        s.nombre AS servicio_nombre,
                        SUM(
                        CASE
                                WHEN cs.producto_id IS NOT NULL THEN p.precio
                                ELSE s.precio
                        END
                        ) AS dinero_recolectado
                FROM
                        reserva r
                        JOIN cuentaservicio cs ON r.id = cs.reserva_id
                        JOIN servicio s ON cs.servicio_id = s.id
                        LEFT JOIN producto p ON cs.producto_id = p.id
                WHERE
                        r.checkin >= TRUNC(SYSDATE) - INTERVAL '1' YEAR
                GROUP BY
                        r.habitacion_id, s.nombre
                ORDER BY
                        r.habitacion_id, servicio_nombre
                FETCH FIRST 50 ROWS ONLY
                    """
            , nativeQuery = true)
        List<Object[]> findServicioResumenData();

 

        @Query(value = """
                WITH ReservasPorHabitacion AS (
                SELECT
                        h.id AS habitacion_id,
                        COUNT(r.id) AS total_reservas
                FROM
                        habitacion h
                        LEFT JOIN reserva r ON h.id = r.habitacion_id
                WHERE
                        r.checkin >= TRUNC(SYSDATE) - INTERVAL '1' YEAR
                GROUP BY
                        h.id
                ),
                DiasOcupadosPorHabitacion AS (
                SELECT
                        r.habitacion_id,
                        SUM(
                        CASE
                                WHEN r.checkin >= TRUNC(SYSDATE) - INTERVAL '1' YEAR THEN
                                LEAST(r.checkout, TRUNC(SYSDATE)) - GREATEST(r.checkin, TRUNC(SYSDATE) - INTERVAL '1' YEAR) + 1
                                ELSE
                                LEAST(r.checkout, TRUNC(SYSDATE)) - TRUNC(SYSDATE) + 1
                        END
                        ) AS total_dias_ocupados
                FROM
                        reserva r
                WHERE
                        r.checkout >= TRUNC(SYSDATE) - INTERVAL '1' YEAR
                GROUP BY
                        r.habitacion_id
                )
                SELECT
                h.id AS habitacion_id,
                COALESCE(DO.total_dias_ocupados, 0) AS total_dias_ocupados,
                COALESCE(RP.total_reservas, 0) AS total_reservas,
                ROUND(
                        CASE
                        WHEN COALESCE(DO.total_dias_ocupados, 0) = 0 THEN 0
                        ELSE (DO.total_dias_ocupados / 365) * 100
                        END, 2
                ) AS indice_ocupacion
                FROM
                habitacion h
                LEFT JOIN ReservasPorHabitacion RP ON h.id = RP.habitacion_id
                LEFT JOIN DiasOcupadosPorHabitacion DO ON h.id = DO.habitacion_id
                ORDER BY
                indice_ocupacion DESC       
                FETCH FIRST 50 ROWS ONLY
                        """, nativeQuery = true)
        List<Object[]> findHabitacionResumenData();


        @Query(value = """                           
                WITH Semanas AS (
                        SELECT DISTINCT
                        TO_CHAR(DATE '2023-01-01' + (level - 1) * 7, 'YYYY-IW') AS semana,
                        TO_CHAR(DATE '2023-01-01' + (level - 1) * 7, 'YYYY-MM-DD') AS inicio_semana,
                        TO_CHAR(DATE '2023-01-01' + (level - 1) * 7 + 6, 'YYYY-MM-DD') AS fin_semana
                        FROM dual
                        CONNECT BY level <= 53 -- Suponiendo un máximo de 53 semanas en el año
                )
                , ServiciosSemana AS (
                        SELECT
                        TO_CHAR(cs.fecha, 'YYYY-IW') AS semana,
                        s.nombre AS servicio_nombre,
                        COUNT(*) AS cantidad_consumos
                        FROM cuentaservicio cs
                        JOIN servicio s ON cs.servicio_id = s.id
                        WHERE cs.fecha BETWEEN TO_DATE(:fecha_inicio, 'YYYY-MM-DD') AND TO_DATE(:fecha_fin, 'YYYY-MM-DD')
                        GROUP BY TO_CHAR(cs.fecha, 'YYYY-IW'), s.nombre
                )
                , HabitacionesSemana AS (
                        SELECT
                        TO_CHAR(r.checkin, 'YYYY-IW') AS semana,
                        h.id AS habitacion_id,
                        COUNT(*) AS cantidad_solicitudes
                        FROM reserva r
                        JOIN habitacion h ON r.habitacion_id = h.id
                        WHERE r.checkin BETWEEN TO_DATE(:fecha_inicio, 'YYYY-MM-DD') AND TO_DATE(:fecha_fin, 'YYYY-MM-DD')
                        GROUP BY TO_CHAR(r.checkin, 'YYYY-IW'), h.id
                )
                , SemanaServicioMax AS (
                        SELECT semana, servicio_nombre, cantidad_consumos,
                        ROW_NUMBER() OVER (PARTITION BY semana ORDER BY cantidad_consumos DESC) AS rn_max
                        FROM ServiciosSemana
                )
                , SemanaServicioMin AS (
                        SELECT semana, servicio_nombre, cantidad_consumos,
                        ROW_NUMBER() OVER (PARTITION BY semana ORDER BY cantidad_consumos ASC) AS rn_min
                        FROM ServiciosSemana
                )
                , SemanaHabitacionMax AS (
                        SELECT semana, habitacion_id, cantidad_solicitudes,
                        ROW_NUMBER() OVER (PARTITION BY semana ORDER BY cantidad_solicitudes DESC) AS rn_max
                        FROM HabitacionesSemana
                )
                , SemanaHabitacionMin AS (
                        SELECT semana, habitacion_id, cantidad_solicitudes,
                        ROW_NUMBER() OVER (PARTITION BY semana ORDER BY cantidad_solicitudes ASC) AS rn_min
                        FROM HabitacionesSemana
                )
                SELECT 
                        s.semana AS semana,
                        (SELECT servicio_nombre FROM SemanaServicioMax WHERE semana = s.semana AND rn_max = 1) AS servicio_mas_consumido,
                        (SELECT servicio_nombre FROM SemanaServicioMin WHERE semana = s.semana AND rn_min = 1) AS servicio_menos_consumido,
                        (SELECT TO_CHAR(habitacion_id) FROM SemanaHabitacionMax WHERE semana = s.semana AND rn_max = 1) AS habitacion_mas_solicitada,
                        (SELECT TO_CHAR(habitacion_id) FROM SemanaHabitacionMin WHERE semana = s.semana AND rn_min = 1) AS habitacion_menos_solicitada
                FROM Semanas s
                ORDER BY s.semana
                FETCH FIRST 50 ROWS ONLY
                        """, nativeQuery = true)
        List<Object[]> findHabitacionPorSemana(@Param("fecha_inicio") String fecha_inicio, @Param("fecha_fin") String fecha_fin);
}
