package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ReservaSpa;

public interface ReservaSpaRepository extends JpaRepository<ReservaSpa, Integer>{

    @Query(value = "SELECT * FROM reservaspa", nativeQuery = true)
    Collection<ReservaSpa> darReservasSpa();

    @Query(value = "SELECT * FROM reservaspa WHERE id = :id", nativeQuery = true)
    ReservaSpa darReservaSpaPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservaspa (id, fecha, hora, spa_id) VALUES (:id, :fecha, :hora, :spa_id)", nativeQuery = true)
    void insertarReservaSpa(@Param("id") Integer id, @Param("fecha") String fecha, @Param("hora") Integer hora, @Param("spa_id") Integer spa_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservaspa SET id = :id, fecha = :fecha, hora = :hora, spa_id = :spa_id WHERE id = :id", nativeQuery = true)
    void actualizarReservaSpa(@Param("id") Integer id, @Param("fecha") String fecha, @Param("hora") Integer hora, @Param("spa_id") Integer spa_id);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservaspa WHERE id = :id", nativeQuery = true)
    void eliminarReservaSpa(@Param("id") Integer id);
    

}