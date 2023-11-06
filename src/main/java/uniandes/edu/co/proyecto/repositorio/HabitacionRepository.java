package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

    @Query(value = "SELECT * FROM habitacion", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitacion WHERE id = :id", nativeQuery = true)
    Habitacion darHabitacionPorId(@Param("id") int id);

    @Query(value = "SELECT * FROM habitacion WHERE tipohabitacion = :tipohabitacion", nativeQuery = true)
    Collection<Habitacion> darHabitacionesPorTipo(@Param("tipohabitacion") String tipohabitacion);

}
