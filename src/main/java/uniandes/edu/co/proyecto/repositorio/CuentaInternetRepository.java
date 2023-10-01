package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaInternet;

public interface CuentaInternetRepository extends JpaRepository<CuentaInternet, Integer>{

    @Query(value = "SELECT * FROM cuentainternet", nativeQuery = true)
    Collection<CuentaInternet> darCuentasInternet();

    @Query(value = "SELECT * FROM cuentainternet WHERE id = :id", nativeQuery = true)
    CuentaInternet darCuentaInternetPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentainternet (nombre, precio, hotel_id) VALUES (:nombre, :precio, :hotel_id)", nativeQuery = true)
    void insertarCuentaInternet(@Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentainternet SET nombre = :nombre, precio = :precio, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarCuentaInternet(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentainternet WHERE id = :id", nativeQuery = true)
    void eliminarCuentaInternet(@Param("id") Integer id);
    

}