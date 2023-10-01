package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaPiscina;

public interface CuentaPiscinaRepository extends JpaRepository<CuentaPiscina, Integer>{

    @Query(value = "SELECT * FROM cuentapiscina", nativeQuery = true)
    Collection<CuentaPiscina> darCuentasPiscina();

    @Query(value = "SELECT * FROM cuentapiscina WHERE id = :id", nativeQuery = true)
    CuentaPiscina darCuentaPiscinaPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentapiscina (nombre, precio, hotel_id) VALUES (:nombre, :precio, :hotel_id)", nativeQuery = true)
    void insertarCuentaPiscina(@Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentapiscina SET nombre = :nombre, precio = :precio, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarCuentaPiscina(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentapiscina WHERE id = :id", nativeQuery = true)
    void eliminarCuentaPiscina(@Param("id") Integer id);
    

}