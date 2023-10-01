package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ProductoRestaurante;

public interface ProductoRestauranteRepository extends JpaRepository<ProductoRestaurante, Integer> {

    @Query(value = "SELECT * FROM productorestaurante", nativeQuery = true)
    Collection<ProductoRestaurante> darProductosRestaurante();

    @Query(value = "SELECT * FROM productorestaurante WHERE id = :id", nativeQuery = true)
    ProductoRestaurante darProductoRestaurantePorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productorestaurante (id, nombre, precio, restaurante_id) VALUES (:id, :nombre, :precio, :restaurante_id)", nativeQuery = true)
    void insertarProductoRestaurante(@Param("id") Integer id, @Param("nombre") String nombre,
            @Param("precio") Integer precio, @Param("restaurante_id") Integer restaurante_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productorestaurante SET nombre = :nombre, precio = :precio, restaurante_id = :restaurante_id WHERE id = :id", nativeQuery = true)
    void actualizarProductoRestaurante(@Param("id") Integer id, @Param("nombre") String nombre,
            @Param("precio") Integer precio, @Param("restaurante_id") Integer restaurante_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productorestaurante WHERE id = :id", nativeQuery = true)
    void eliminarProductoRestaurante(@Param("id") Integer id);

}