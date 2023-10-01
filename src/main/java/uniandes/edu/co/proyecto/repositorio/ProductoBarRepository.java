package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ProductoBar;

public interface ProductoBarRepository extends JpaRepository<ProductoBar, Integer> {

    @Query(value = "SELECT * FROM productobar", nativeQuery = true)
    Collection<ProductoBar> darProductosBar();

    @Query(value = "SELECT * FROM productobar WHERE id = :id", nativeQuery = true)
    ProductoBar darProductoBarPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productobar (idproducto, idbar) VALUES (:idproducto, :idbar)", nativeQuery = true)
    void insertarProductoBar(@Param("idproducto") Integer idproducto, @Param("idbar") Integer idbar);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE productobar SET nombre = :nombre, precio = :precio, bar_id = :bar_id WHERE id = :id", nativeQuery = true)
    void actualizarProductoBar(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio,
            @Param("bar_id") Integer bar_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productobar WHERE id = :id", nativeQuery = true)
    void eliminarProductoBar(@Param("id") Integer id);

}
