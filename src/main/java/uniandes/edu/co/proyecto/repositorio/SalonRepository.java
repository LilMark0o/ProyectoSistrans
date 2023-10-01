package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Salon;

public interface SalonRepository extends JpaRepository<Salon, Integer>{

    @Query(value = "SELECT * FROM salon", nativeQuery = true)
    Collection<Salon> darSalones();

    @Query(value = "SELECT * FROM salon WHERE id = :id", nativeQuery = true)
    Salon darSalonPorId(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO salon (capacidad, hotel_id) VALUES (:capacidad, :hotel_id)", nativeQuery = true)
    void insertarSalon(@Param("capacidad") Integer capacidad, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE salon SET capacidad = :capacidad, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarSalon(@Param("id") Integer id, @Param("capacidad") Integer capacidad, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM salon WHERE id = :id", nativeQuery = true)
    void eliminarSalon(@Param("id") Integer id);

}
