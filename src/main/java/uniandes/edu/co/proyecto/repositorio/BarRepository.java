package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Bar;

public interface BarRepository extends JpaRepository<Bar, Integer> {

    @Query(value = "SELECT * FROM bar", nativeQuery = true)
    Collection<Bar> darBares();

    @Query(value = "SELECT * FROM bar WHERE id = :id", nativeQuery = true)
    Bar darBarPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bar (id, estilo, capacidad) VALUES (:id, :estilo, :capacidad)", nativeQuery = true)
    void insertarBar(@Param("id") Integer id, @Param("estilo") String estilo, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bar SET estilo = :estilo, capacidad = :capacidad WHERE id = :id", nativeQuery = true)
    void actualizarBar(@Param("id") Integer id, @Param("estilo") String estilo, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bar WHERE id = :id", nativeQuery = true)
    void eliminarBar(@Param("id") Integer id);

}
