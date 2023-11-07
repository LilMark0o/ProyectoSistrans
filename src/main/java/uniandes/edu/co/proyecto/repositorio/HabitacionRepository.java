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

    @Query(value = "SELECT " +
            "    h.id AS habitacion_id, " +
            "    s.nombre AS servicio_nombre, " +
            "    SUM(" +
            "        CASE " +
            "            WHEN cs.producto_id IS NOT NULL THEN p.precio " +
            "            ELSE s.precio " +
            "        END " +
            "    ) AS dinero_recolectado " +
            "FROM " +
            "    habitacion h " +
            "    LEFT JOIN reserva r ON h.id = r.habitacion_id " +
            "    LEFT JOIN cuentaservicio cs ON r.id = cs.reserva_id " +
            "    LEFT JOIN servicio s ON cs.servicio_id = s.id " +
            "    LEFT JOIN producto p ON cs.producto_id = p.id " +
            "WHERE " +
            "    cs.fecha >= TRUNC(SYSDATE) - INTERVAL '1' YEAR " +
            "    AND cs.fecha <= TRUNC(SYSDATE) " +
            "GROUP BY " +
            "    h.id, h.descripcion, s.id, s.nombre " +
            "ORDER BY " +
            "    dinero_recolectado DESC", nativeQuery = true)
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
                indice_ocupacion DESC;          

                        """, nativeQuery = true)
        List<Object[]> findHabitacionResumenData();

}
