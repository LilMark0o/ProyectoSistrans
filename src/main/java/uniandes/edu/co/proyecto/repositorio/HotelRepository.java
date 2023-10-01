package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

    @Query(value = "SELECT * FROM hotel", nativeQuery = true)
    Collection<Hotel> darHoteles();

    @Query(value = "SELECT * FROM hotel WHERE id = :id", nativeQuery = true)
    Hotel darHotelPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO hotel (id) VALUES ( :id)", nativeQuery = true)
    void insertarHotel(@Param("id") Integer id, @Param("nombre") String nombre);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hotel WHERE id = :id", nativeQuery = true)
    void eliminarHotel(@Param("id") Integer id);
    

}
