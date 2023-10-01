package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaLavado;

public interface CuentaLavadoRepository extends JpaRepository<CuentaLavado, Integer>{

    @Query(value = "SELECT * FROM cuentalavado", nativeQuery = true)
    Collection<CuentaLavado> darCuentasLavado();

    @Query(value = "SELECT * FROM cuentalavado WHERE id = :id", nativeQuery = true)
    CuentaLavado darCuentaLavadoPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentalavado (nombre, precio, hotel_id) VALUES (:nombre, :precio, :hotel_id)", nativeQuery = true)
    void insertarCuentaLavado(@Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentalavado SET nombre = :nombre, precio = :precio, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarCuentaLavado(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentalavado WHERE id = :id", nativeQuery = true)
    void eliminarCuentaLavado(@Param("id") Integer id);
    

}