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


}
