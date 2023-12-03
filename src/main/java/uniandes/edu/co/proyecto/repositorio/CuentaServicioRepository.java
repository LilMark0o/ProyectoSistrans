package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.proyecto.modelo.CuentaServicio;

import java.util.List;

public interface CuentaServicioRepository extends MongoRepository<CuentaServicio, String> {

        List<CuentaServicio> findByDescripcion(String descripcion);
}