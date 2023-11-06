package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // List<Usuario> findByTipoUsuario_Nombre(String tipoUsuario);
    // Optional<Usuario> findByUsername(String username);

    @Query(value = "SELECT u FROM Usuario u")
    Collection<Usuario> findAllUsers();

    @Query(value = "SELECT DISTINCT u.tipoUsuario FROM Usuario u")
    Collection<TipoUsuario> findAllTipoUsuario();

    @Query(value = "SELECT u FROM Usuario u WHERE u.id = :id")
    Usuario findUserById(@Param("id") int id);

    @Query(value = "SELECT u FROM Usuario u WHERE u.tipoUsuario.nombre = :tipoUsuario")
    Collection<Usuario> findUsersByTipoUsuario(@Param("tipoUsuario") String tipoUsuarioName);

    @Query(value = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    Collection<Usuario> findUsersByNombre(@Param("nombre") String nombre);

    @Query(value = "SELECT u FROM Usuario u WHERE u.username = :username")
    Usuario findUserByUsername(@Param("username") String username) ;
}
