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
    @Query(value = "INSERT INTO restaurante (id, hotel_id) VALUES (:id, :hotel_id)", nativeQuery = true)
    void insertarRestaurante(@Param("id") Integer id, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE restaurante SET id = :id, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarRestaurante(@Param("id") Integer id, @Param("hotel_id") Integer hotel_id);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM restaurante WHERE id = :id", nativeQuery = true)
    void eliminarRestaurante(@Param("id") Integer id);

}