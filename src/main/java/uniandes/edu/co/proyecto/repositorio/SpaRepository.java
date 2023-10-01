package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Spa;

public interface SpaRepository extends JpaRepository<Spa, Integer>{

    @Query(value = "SELECT * FROM spa", nativeQuery = true)
    Collection<Spa> darSpas();

    @Query(value = "SELECT * FROM spa WHERE id = :id", nativeQuery = true)
    Spa darSpaPorId(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO spa (horainicio, horafin, secobra, hotel_id) VALUES (:horainicio, :horafin, :secobra, :hotel_id)", nativeQuery = true)
    void insertarSpa(@Param("horainicio") Integer horainicio, @Param("horafin") Integer horafin, @Param("secobra") Boolean secobra, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE spa SET horainicio = :horainicio, horafin = :horafin, secobra = :secobra, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarSpa(@Param("id") Integer id, @Param("horainicio") Integer horainicio, @Param("horafin") Integer horafin, @Param("secobra") Boolean secobra, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM spa WHERE id = :id", nativeQuery = true)
    void eliminarSpa(@Param("id") Integer id);

}