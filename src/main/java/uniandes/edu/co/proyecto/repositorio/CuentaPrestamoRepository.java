package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaPrestamo;

public interface CuentaPrestamoRepository extends JpaRepository<CuentaPrestamo, Integer>{

    @Query(value = "SELECT * FROM cuentaprestamo", nativeQuery = true)
    Collection<CuentaPrestamo> darCuentasPrestamo();

    @Query(value = "SELECT * FROM cuentaprestamo WHERE id = :id", nativeQuery = true)
    CuentaPrestamo darCuentaPrestamoPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentaprestamo (nombre, precio, hotel_id) VALUES (:nombre, :precio, :hotel_id)", nativeQuery = true)
    void insertarCuentaPrestamo(@Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentaprestamo SET nombre = :nombre, precio = :precio, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarCuentaPrestamo(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentaprestamo WHERE id = :id", nativeQuery = true)
    void eliminarCuentaPrestamo(@Param("id") Integer id);
    

}