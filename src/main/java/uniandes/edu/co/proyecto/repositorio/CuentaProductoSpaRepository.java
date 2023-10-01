package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaProductoSpa;

import java.util.Collection;

public interface CuentaProductoSpaRepository extends JpaRepository<CuentaProductoSpa, Integer> {

    @Query(value = "SELECT * FROM cuentaproductospa", nativeQuery = true)
    Collection<CuentaProductoSpa> findAllCuentaProductoSpa();

    @Query(value = "SELECT * FROM cuentaproductospa WHERE idCuenta = :idcuenta and idProductoSpa = :idproducto", nativeQuery = true)
    CuentaProductoSpa findCuentaProductoSpaById(@Param("idcuenta") Integer idcuenta,
            @Param("idproducto") Integer idproducto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentaproductospa (idCuenta, idProductoSpa) VALUES (:idcuenta, :idproducto)", nativeQuery = true)
    void insertCuentaProductoSpa(@Param("idcuenta") Integer idcuenta, @Param("idproducto") Integer idproducto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentaproductospa SET idCuenta = :idcuenta, idProductoSpa = :idproducto WHERE idCuenta = :oldIdCuenta and idProductoSpa = :oldIdProducto", nativeQuery = true)
    void updateCuentaProductoSpa(@Param("oldIdCuenta") Integer oldIdCuenta,
            @Param("oldIdProducto") Integer oldIdProducto, @Param("idcuenta") Integer idcuenta,
            @Param("idproducto") Integer idproducto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentaproductospa WHERE idCuenta = :idcuenta and idProductoSpa = :idproducto", nativeQuery = true)
    void deleteCuentaProductoSpa(@Param("idcuenta") Integer idcuenta, @Param("idproducto") Integer idproducto);
}
