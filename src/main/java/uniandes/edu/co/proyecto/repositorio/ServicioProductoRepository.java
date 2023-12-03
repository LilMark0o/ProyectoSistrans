package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.proyecto.modelo.ServicioProducto;

import java.util.List;

public interface ServicioProductoRepository extends MongoRepository<ServicioProducto, String> {

        List<ServicioProducto> findByNombre(String nombre);
}