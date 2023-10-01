package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Utensilio;

public interface UtensilioRepository extends JpaRepository<Utensilio, Integer>{

    @Query(value = "SELECT * FROM utensilio", nativeQuery = true)
    Collection<Utensilio> darUtensilios();

    @Query(value = "SELECT * FROM utensilio WHERE id = :id", nativeQuery = true)
    Utensilio darUtensilioPorId(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO utensilio (id, nombre, precio, tienda_id) VALUES (:nombre, :precio)", nativeQuery = true)
    void insertarUtensilio(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Float precio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE utensilio SET nombre = :nombre, precio = :precio, tienda_id = :tienda_id WHERE id = :id", nativeQuery = true)
    void actualizarUtensilio(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio, @Param("tienda_id") Integer tienda_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM utensilio WHERE id = :id", nativeQuery = true)
    void eliminarUtensilio(@Param("id") Integer id);

}