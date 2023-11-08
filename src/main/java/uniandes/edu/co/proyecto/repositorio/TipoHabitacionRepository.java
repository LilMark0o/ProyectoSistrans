package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer> {
    // List<Habitacion> findByTipoHabitacion_Nombre(String tipoHabitacion);
    // Optional<Habitacion> findByNombre(String nombre);

    @Query(value = "SELECT t FROM TipoHabitacion t")
    Collection<TipoHabitacion> findAllTipoHabitacion();

    @Query(value = "SELECT t FROM TipoHabitacion t WHERE t.nombre = :nombre")
    TipoHabitacion findTipoHabitacionByNombre(@Param("nombre") String nombre);

    @Query(value = "SELECT t FROM TipoHabitacion t WHERE t.id = :id")
    TipoHabitacion findTipoHabitacionById(@Param("id") int id);
}

