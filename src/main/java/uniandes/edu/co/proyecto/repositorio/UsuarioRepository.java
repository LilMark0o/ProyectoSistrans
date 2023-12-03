package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.proyecto.modelo.Usuario;

import java.util.List;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    List<Usuario> findByNombre(String nombre);

    Usuario findByUsername(String username);
}
