package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{

    @Query(value = "SELECT * FROM habitacion", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitacion WHERE id = :id", nativeQuery = true)
    Habitacion darHabitacionPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitacion (capacidad, costonoche, tipohabitacion, hotel_id) VALUES (:capacidad, :costonoche, :tipohabitacion, :hotel_id)", nativeQuery = true)
    void insertarHabitacion(@Param("capacidad") Integer capacidad, @Param("costonoche") Float costonoche, @Param("tipohabitacion") String tipohabitacion, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitacion SET capacidad = :capacidad, costonoche = :costonoche, tipohabitacion = :tipohabitacion, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param("id") Integer id, @Param("capacidad") Integer capacidad, @Param("costonoche") Float costonoche, @Param("tipohabitacion") String tipohabitacion, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitacion WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("id") Integer id);
    

}
