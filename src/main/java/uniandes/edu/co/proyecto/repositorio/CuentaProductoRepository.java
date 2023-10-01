package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaProducto;

public interface CuentaProductoRepository extends JpaRepository<CuentaProducto, Integer>{

    @Query(value = "SELECT * FROM cuentaproducto", nativeQuery = true)
    Collection<CuentaProducto> darCuentasProducto();

    @Query(value = "SELECT * FROM cuentaproducto WHERE id = :id", nativeQuery = true)
    CuentaProducto darCuentaProductoPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentaproducto (nombre, precio, hotel_id) VALUES (:nombre, :precio, :hotel_id)", nativeQuery = true)
    void insertarCuentaProducto(@Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentaproducto SET nombre = :nombre, precio = :precio, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarCuentaProducto(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentaproducto WHERE id = :id", nativeQuery = true)
    void eliminarCuentaProducto(@Param("id") Integer id);
    

}