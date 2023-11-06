package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.ReservaServicio;

public interface ReservaServicioRepository extends JpaRepository<ReservaServicio, Integer> {

    @Query(value = "SELECT * FROM reservaservicio", nativeQuery = true)
    Collection<ReservaServicio> darReservaServicios();

    @Query(value = "SELECT * FROM reservaservicio WHERE id = :id", nativeQuery = true)
    ReservaServicio darReservaServicioPorId(@Param("id") Integer id);

    // Ajusta la sentencia SQL de inserción de acuerdo a la estructura de tu tabla
    // de reservaservicio
    @Query(value = "INSERT INTO reservaservicio (id, horainicio, horafin, servicio_id) " +
            "VALUES (:id, :horainicio, :horafin, :servicio.id)", nativeQuery = true)
    void insertarReservaServicio(@Param("id") Integer id, @Param("horainicio") Integer horainicio,
            @Param("horafin") Integer horafin, @Param("servicio") Integer servicioId);

    // Ajusta la sentencia SQL de actualización de acuerdo a la estructura de tu
    // tabla de reservaservicio
    @Query(value = "UPDATE reservaservicio SET horainicio = :horainicio, horafin = :horafin, servicio_id = :servicio.id "
            +
            "WHERE id = :id", nativeQuery = true)
    void actualizarReservaServicio(@Param("id") Integer id, @Param("horainicio") Integer horainicio,
            @Param("horafin") Integer horafin, @Param("servicio") Integer servicioId);

    @Query(value = "DELETE FROM reservaservicio WHERE id = :id", nativeQuery = true)
    void eliminarReservaServicio(@Param("id") Integer id);
}
