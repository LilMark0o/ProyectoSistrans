package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
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
}
