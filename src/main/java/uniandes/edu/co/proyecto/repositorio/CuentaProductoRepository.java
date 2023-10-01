package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaProducto;

import java.util.Collection;

public interface CuentaProductoRepository extends JpaRepository<CuentaProducto, Integer> {

    @Query(value = "SELECT * FROM cuentaproducto", nativeQuery = true)
    Collection<CuentaProducto> findAllCuentaProducto();

    @Query(value = "SELECT * FROM cuentaproducto WHERE idCuenta = :idcuenta and idProducto = :idproducto", nativeQuery = true)
    CuentaProducto findCuentaProductoById(@Param("idcuenta") Integer idcuenta, @Param("idproducto") Integer idproducto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentaproducto (idCuenta, idProducto) VALUES (:idcuenta, :idproducto)", nativeQuery = true)
    void insertCuentaProducto(@Param("idcuenta") Integer idcuenta, @Param("idproducto") Integer idproducto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentaproducto SET idCuenta = :idcuenta, idProducto = :idproducto WHERE idCuenta = :oldIdCuenta and idProducto = :oldIdProducto", nativeQuery = true)
    void updateCuentaProducto(@Param("oldIdCuenta") Integer oldIdCuenta, @Param("oldIdProducto") Integer oldIdProducto,
            @Param("idcuenta") Integer idcuenta, @Param("idproducto") Integer idproducto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentaproducto WHERE idCuenta = :idcuenta and idProducto = :idproducto", nativeQuery = true)
    void deleteCuentaProducto(@Param("idcuenta") Integer idcuenta, @Param("idproducto") Integer idproducto);
}
