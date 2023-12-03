package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

import java.util.List;

public interface TipoHabitacionRepository extends MongoRepository<TipoHabitacion, String> {

    List<TipoHabitacion> findByNombre(String nombre);
}
