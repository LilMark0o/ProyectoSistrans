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

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
    // List<Usuario> findByTipoUsuario_Nombre(String tipoUsuario);
    // Optional<Usuario> findByUsername(String username);

    @Query(value = "SELECT t FROM TipoUsuario t")
    Collection<TipoUsuario> findAllTipoUsuario();

    @Query(value = "SELECT t FROM TipoUsuario t WHERE t.nombre = :nombre")
    TipoUsuario findTipoUsuarioByNombre(@Param("nombre") String nombre);
}