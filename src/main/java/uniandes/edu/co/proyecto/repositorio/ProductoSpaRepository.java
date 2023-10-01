package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ProductoSpa;

public interface ProductoSpaRepository extends JpaRepository<ProductoSpa, Integer>{

    @Query(value = "SELECT * FROM productospa", nativeQuery = true)
    Collection<ProductoSpa> darProductosSpa();

    @Query(value = "SELECT * FROM productospa WHERE id = :id", nativeQuery = true)
    ProductoSpa darProductoSpaPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productospa (nombre, precio, spa_id) VALUES (:nombre, :precio, :spa_id)", nativeQuery = true)
    void insertarProductoSpa(@Param("nombre") String nombre, @Param("precio") Integer precio, @Param("spa_id") Integer spa_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productospa SET nombre = :nombre, precio = :precio, spa_id = :spa_id WHERE id = :id", nativeQuery = true)
    void actualizarProductoSpa(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio, @Param("spa_id") Integer spa_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productospa WHERE id = :id", nativeQuery = true)
    void eliminarProductoSpa(@Param("id") Integer id);
    

}