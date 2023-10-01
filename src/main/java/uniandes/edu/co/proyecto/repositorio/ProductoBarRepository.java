package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ProductoBar;

public interface ProductoBarRepository extends JpaRepository<ProductoBar, Integer> {

    @Query(value = "SELECT * FROM productoBar", nativeQuery = true)
    Collection<ProductoBar> darProductosBar();

    @Query(value = "SELECT * FROM productoBar WHERE idproducto = :idproducto and idBar = :idBar", nativeQuery = true)
    ProductoBar findProductoBarByID(@Param("idproducto") Integer idBar,
            @Param("idBar") Integer idproducto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productobar (idproducto, idbar) VALUES (:idproducto, :idBar)", nativeQuery = true)
    void insertProductoBar(@Param("idBar") Integer idproduct, @Param("idproducto") Integer idproducto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productoBar SET idproducto = :idproducto, idBar = :idBar WHERE idproducto = :oldidproducto and idBar = :oldidBar", nativeQuery = true)
    void updateProductoBar(@Param("oldidproducto") Integer oldidproducto, @Param("oldidBar") Integer oldidBar,
            @Param("idproducto") Integer idproducto, @Param("idBar") Integer idBar);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentagimnasio WHERE idproducto = :idproducto and idBar = :idBar", nativeQuery = true)
    void deleteProductoBar(@Param("idproducto") Integer idproducto, @Param("idBar") Integer idBar);

}