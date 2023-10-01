package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaSalon;

public interface CuentaSalonRepository extends JpaRepository<CuentaSalon, Integer>{

    @Query(value = "SELECT * FROM cuentasalon", nativeQuery = true)
    Collection<CuentaSalon> darCuentasSalon();

    @Query(value = "SELECT * FROM cuentasalon WHERE id = :id", nativeQuery = true)
    CuentaSalon darCuentaSalonPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentasalon (nombre, precio, hotel_id) VALUES (:nombre, :precio, :hotel_id)", nativeQuery = true)
    void insertarCuentaSalon(@Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentasalon SET nombre = :nombre, precio = :precio, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarCuentaSalon(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentasalon WHERE id = :id", nativeQuery = true)
    void eliminarCuentaSalon(@Param("id") Integer id);
    

}