package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

        @Query(value = "SELECT * FROM usuario", nativeQuery = true)
        Collection<Usuario> darUsuarios();

        @Query(value = "SELECT * FROM usuario WHERE id = :id", nativeQuery = true)
        Usuario darUsuarioPorId(@Param("id") int id);

        @Query(value = "SELECT * FROM usuario WHERE tipousuario = :tipousuario", nativeQuery = true)
        Collection<Usuario> darUsuariosPorTipo(@Param("tipousuario") String tipoUsuario);

        @Query(value = "SELECT * FROM usuario WHERE nombre = :nombre", nativeQuery = true)
        Collection<Usuario> buscarUsuarioPorNombre(@Param("nombre") String nombre);

        @Query(value = "SELECT * FROM usuario WHERE username = :username", nativeQuery = true)
        Usuario buscarUsuarioPorUsername(@Param("username") String username);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO usuario (id, tipodedocumento, nombre, username, password, tipousuario, hotel_id) VALUES (:id, :tipodedocumento,:nombre, :username, :password, :tipousuario, :hotel_id)", nativeQuery = true)
        void insertarUsuario(@Param("id") Integer id, @Param("nombre") String nombre,
                        @Param("username") String username,
                        @Param("password") String password, @Param("tipousuario") String tipousuario,
                        @Param("tipodedocumento") String tipodedocumento,
                        @Param("hotel_id") Integer hotel_id);

        @Modifying
        @Transactional
        @Query(value = "UPDATE usuario SET tipodedocumento = :tipodedocumento, nombre = :nombre, username = :username, password = :password, tipousuario = :tipousuario, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
        void actualizarUsuario(@Param("id") Integer id, @Param("nombre") String nombre,
                        @Param("username") String username,
                        @Param("password") String password, @Param("tipousuario") String tipousuario,
                        @Param("tipodedocumento") String tipodedocumento,
                        @Param("hotel_id") Integer hotel_id);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM usuario WHERE id = :id", nativeQuery = true)
        void eliminarUsuario(@Param("id") Integer id);

}
