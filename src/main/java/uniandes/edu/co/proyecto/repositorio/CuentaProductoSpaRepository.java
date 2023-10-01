package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaProductoSpa;

public interface CuentaProductoSpaRepository extends JpaRepository<CuentaProductoSpa, Integer>{

    @Query(value = "SELECT * FROM cuentaproductospa", nativeQuery = true)
    Collection<CuentaProductoSpa> darCuentasProductoSpa();

    @Query(value = "SELECT * FROM cuentaproductospa WHERE id = :id", nativeQuery = true)
    CuentaProductoSpa darCuentaProductoSpaPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentaproductospa (nombre, precio, hotel_id) VALUES (:nombre, :precio, :hotel_id)", nativeQuery = true)
    void insertarCuentaProductoSpa(@Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentaproductospa SET nombre = :nombre, precio = :precio, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarCuentaProductoSpa(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentaproductospa WHERE id = :id", nativeQuery = true)
    void eliminarCuentaProductoSpa(@Param("id") Integer id);
    

}