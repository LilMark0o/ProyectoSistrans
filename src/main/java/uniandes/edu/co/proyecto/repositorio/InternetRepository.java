package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Internet;

public interface InternetRepository extends JpaRepository<Internet, Integer> {

    @Query(value = "SELECT * FROM internet", nativeQuery = true)
    Collection<Internet> darServiciosInternet();

    @Query(value = "SELECT * FROM internet WHERE id = :id", nativeQuery = true)
    Internet darInternetPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO internet (capacidad, precio, secobra, hotel_id) VALUES (:capacidad, :precio, :secobra, :hotel_id)", nativeQuery = true)
    void insertarInternet(@Param("capacidad") Float capacidad, @Param("precio") Float precio,
            @Param("secobra") int secobra, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE internet SET capacidad = :capacidad, precio = :precio, secobra = :secobra, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarInternet(@Param("id") Integer id, @Param("capacidad") Float capacidad, @Param("precio") Float precio,
            @Param("secobra") int secobra, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM internet WHERE id = :id", nativeQuery = true)
    void eliminarInternet(@Param("id") Integer id);

}
