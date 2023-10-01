package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ProductoTienda;

public interface ProductoTiendaRepository extends JpaRepository<ProductoTienda, Integer> {

    @Query(value = "SELECT * FROM productotienda", nativeQuery = true)
    Collection<ProductoTienda> darProductosTienda();

    @Query(value = "SELECT * FROM productotienda WHERE idproducto = :idproducto and idtienda = :idtienda", nativeQuery = true)
    ProductoTienda findProductoTiendaByID(@Param("idproducto") Integer idtienda,
            @Param("idtienda") Integer idproducto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productotienda (idproducto, idtienda) VALUES (:idproducto, :idtienda)", nativeQuery = true)
    void insertProductoTienda(@Param("idtienda") Integer idproduct, @Param("idproducto") Integer idproducto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productotienda SET idproducto = :idproducto, idtienda = :idtienda WHERE idproducto = :oldidproducto and idtienda = :oldidtienda", nativeQuery = true)
    void updateProductoTienda(@Param("oldidproducto") Integer oldidproducto, @Param("oldidtienda") Integer oldidtienda,
            @Param("idproducto") Integer idproducto, @Param("idtienda") Integer idtienda);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentagimnasio WHERE idproducto = :idproducto and idtienda = :idtienda", nativeQuery = true)
    void deleteProductoTienda(@Param("idproducto") Integer idproducto, @Param("idtienda") Integer idtienda);

}