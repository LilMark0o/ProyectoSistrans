package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{

    @Query(value = "SELECT * FROM restaurante", nativeQuery = true)
    Collection<Restaurante> darRestaurantes();

    @Query(value = "SELECT * FROM restaurante WHERE id = :id", nativeQuery = true)
    Restaurante darRestaurantePorId(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO restaurante (nombre, horainicio, horafin, secobra, hotel_id) VALUES (:nombre, :horainicio, :horafin, :secobra, :hotel_id)", nativeQuery = true)
    void insertarRestaurante(@Param("nombre") String nombre, @Param("horainicio") Integer horainicio, @Param("horafin") Integer horafin, @Param("secobra") Boolean secobra, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE restaurante SET nombre = :nombre, horainicio = :horainicio, horafin = :horafin, secobra = :secobra, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarRestaurante(@Param("id") Integer id, @Param("nombre") String nombre, @Param("horainicio") Integer horainicio, @Param("horafin") Integer horafin, @Param("secobra") Boolean secobra, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM restaurante WHERE id = :id", nativeQuery = true)
    void eliminarRestaurante(@Param("id") Integer id);

}