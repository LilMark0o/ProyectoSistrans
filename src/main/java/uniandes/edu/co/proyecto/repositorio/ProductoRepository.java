package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "SELECT * FROM producto", nativeQuery = true)
    Collection<Producto> darProductos();

    @Query(value = "SELECT * FROM producto WHERE id = :id", nativeQuery = true)
    Producto darProductoPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO producto (id, nombre, precio) VALUES (:id, :nombre, :precio)", nativeQuery = true)
    void insertarProducto(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE producto SET nombre = :nombre, precio = :precio WHERE id = :id", nativeQuery = true)
    void actualizarProducto(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM producto WHERE id = :id", nativeQuery = true)
    void eliminarProducto(@Param("id") Integer id);

}