package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    @Query(value = "SELECT * FROM servicio", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value = "SELECT * FROM servicio WHERE id = :id", nativeQuery = true)
    Servicio darServicioPorId(@Param("id") Integer id);

    // Ajusta la sentencia SQL de inserción de acuerdo a la estructura de tu tabla
    // de servicios
    @Query(value = "INSERT INTO servicio (id, nombre, descripcion, precio, hotel_id) " +
            "VALUES (:id, :nombre, :descripcion, :precio, :hotel.id)", nativeQuery = true)
    void insertarServicio(@Param("id") Integer id, @Param("nombre") String nombre,
            @Param("descripcion") String descripcion, @Param("precio") Float precio,
            @Param("hotel") Integer hotel);

    // Ajusta la sentencia SQL de actualización de acuerdo a la estructura de tu
    // tabla de servicios
    @Query(value = "UPDATE servicio SET nombre = :nombre, descripcion = :descripcion, precio = :precio, hotel_id = :hotel.id "
            +
            "WHERE id = :id", nativeQuery = true)
    void actualizarServicio(@Param("id") Integer id, @Param("nombre") String nombre,
            @Param("descripcion") String descripcion, @Param("precio") Float precio,
            @Param("hotel") Integer hotel);

    @Query(value = "DELETE FROM servicio WHERE id = :id", nativeQuery = true)
    void eliminarServicio(@Param("id") Integer id);


     @Query(value = "SELECT " +
             "    s.id AS servicio_id, " +
             "    s.nombre AS servicio_nombre, " +
             "    COUNT(cs.id) AS cantidad_consumos " +
             "FROM " +
             "    servicio s " +
             "    JOIN cuentaservicio cs ON s.id = cs.servicio_id " +
             "WHERE " +
             "    cs.fecha >= TO_DATE(:date1, 'YYYY-MM-DD') " +
             "    AND cs.fecha <= TO_DATE(:date2, 'YYYY-MM-DD') " +
             "GROUP BY " +
             "    s.id, s.nombre " +
             "ORDER BY " +
             "    cantidad_consumos DESC " +
             "FETCH FIRST 20 ROWS ONLY", nativeQuery = true)
             List<Object[]> findServicioResumenData(@Param("date1") String date1, @Param("date2") String date2);



        @Query(value = "SELECT s.* " +
                "FROM servicio s " +
                "JOIN cuentaservicio cs ON s.id = cs.servicio_id " +
                "WHERE (:p_precio_min IS NULL OR s.precio >= :p_precio_min) " +
                "AND (:p_precio_max IS NULL OR s.precio <= :p_precio_max) " +
                "AND (:p_fecha_inicio IS NULL OR cs.fecha >= TO_DATE(:p_fecha_inicio, 'YYYY-MM-DD')) " +
                "AND (:p_fecha_fin IS NULL OR cs.fecha <= TO_DATE(:p_fecha_fin, 'YYYY-MM-DD'))", nativeQuery = true)
        List<Servicio> findServiciosByFilters(@Param("p_precio_min") Float p_precio_min, @Param("p_precio_max") Float p_precio_max, @Param("p_fecha_inicio") String p_fecha_inicio, @Param("p_fecha_fin") String p_fecha_fin);

        @Query(value = """
                WITH OcupacionPorFecha AS (
                        SELECT
                            TO_CHAR(r.checkin, 'YYYY-MM-DD') AS fecha_checkin,
                            COUNT(DISTINCT r.habitacion_id) AS ocupacion
                        FROM
                            reserva r
                        GROUP BY
                            TO_CHAR(r.checkin, 'YYYY-MM-DD')
                    ),
                    IngresosPorFecha AS (
                        SELECT
                            TO_CHAR(cs.fecha, 'YYYY-MM-DD') AS fecha_consumo,
                            SUM(
                                CASE
                                    WHEN cs.producto_id IS NOT NULL THEN p.precio
                                    ELSE s.precio
                                END
                            ) AS ingresos
                        FROM
                            cuentaservicio cs
                            LEFT JOIN servicio s ON cs.servicio_id = s.id
                            LEFT JOIN producto p ON cs.producto_id = p.id
                        GROUP BY
                            TO_CHAR(cs.fecha, 'YYYY-MM-DD')
                    )
                    SELECT
                        'Mayor Ocupación' AS tipo,
                        fecha_checkin AS fecha,
                        ocupacion AS valor
                    FROM
                        OcupacionPorFecha
                    WHERE
                        ocupacion = (SELECT MAX(ocupacion) FROM OcupacionPorFecha)
                    UNION ALL
                    SELECT
                        'Mayores Ingresos' AS tipo,
                        fecha_consumo AS fecha,
                        ingresos AS valor
                    FROM
                        IngresosPorFecha
                    WHERE
                        ingresos = (SELECT MAX(ingresos) FROM IngresosPorFecha)
                    UNION ALL
                    SELECT
                        'Menor Ocupación' AS tipo,
                        fecha_checkin AS fecha,
                        ocupacion AS valor
                    FROM
                        OcupacionPorFecha
                    WHERE
                        ocupacion = (SELECT MIN(ocupacion) FROM OcupacionPorFecha)
                        """, nativeQuery = true)
        List<Object[]> findFechaFilter();
}
