package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ProductoRestaurante;

public interface ProductoRestauranteRepository extends JpaRepository<ProductoRestaurante, Integer> {

    @Query(value = "SELECT * FROM productoRestaurante", nativeQuery = true)
    Collection<ProductoRestaurante> darProductosRestaurante();

    @Query(value = "SELECT * FROM productoRestaurante WHERE idproducto = :idproducto and idRestaurante = :idRestaurante", nativeQuery = true)
    ProductoRestaurante findProductoRestauranteByID(@Param("idproducto") Integer idRestaurante,
            @Param("idRestaurante") Integer idproducto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productoRestaurante (idproducto, idRestaurante) VALUES (:idproducto, :idRestaurante)", nativeQuery = true)
    void insertProductoRestaurante(@Param("idRestaurante") Integer idproduct, @Param("idproducto") Integer idproducto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productoRestaurante SET idproducto = :idproducto, idRestaurante = :idRestaurante WHERE idproducto = :oldidproducto and idRestaurante = :oldidRestaurante", nativeQuery = true)
    void updateProductoRestaurante(@Param("oldidproducto") Integer oldidproducto,
            @Param("oldidRestaurante") Integer oldidRestaurante,
            @Param("idproducto") Integer idproducto, @Param("idRestaurante") Integer idRestaurante);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentagimnasio WHERE idproducto = :idproducto and idRestaurante = :idRestaurante", nativeQuery = true)
    void deleteProductoRestaurante(@Param("idproducto") Integer idproducto,
            @Param("idRestaurante") Integer idRestaurante);

}