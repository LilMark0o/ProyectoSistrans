package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Acompanante;

public interface AcompananteRepository extends JpaRepository<Acompanante, Integer>{

    @Query(value = "SELECT * FROM acompanante", nativeQuery = true)
    Collection<Acompanante> darAcompanantes();

    @Query(value = "SELECT * FROM acompanante WHERE id = :id", nativeQuery = true)
    Acompanante darAcompanantePorId(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO acompanante (nombre, usuario_id) VALUES (:nombre, :usuario_id)", nativeQuery = true)
    void insertarAcompanante(@Param("nombre") String nombre, @Param("usuario_id") Integer usuario_id);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE acompanante SET nombre = :nombre, usuario_id = :usuario_id WHERE id = :id", nativeQuery = true)
    void actualizarAcompanante(@Param("id") Integer id, @Param("nombre") String nombre, @Param("usuario_id") Integer usuario_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM acompanante WHERE id = :id", nativeQuery = true)
    void eliminarAcompanante(@Param("id") Integer id);
    



}
