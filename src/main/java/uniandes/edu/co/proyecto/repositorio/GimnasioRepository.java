package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Gimnasio;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer> {

    @Query(value = "SELECT * FROM gimnasio", nativeQuery = true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT * FROM gimnasio WHERE id = :id", nativeQuery = true)
    Gimnasio darGimnasioPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasio (id, horainicio, horafin, secobra, hotel_id) VALUES (:id, :horainicio, :horafin, :secobra, :hotel_id)", nativeQuery = true)
    void insertarGimnasio(@Param("id") Integer id, @Param("horainicio") Integer horainicio,
            @Param("horafin") Integer horafin,
            @Param("secobra") int secobra, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasio SET horainicio = :horainicio, horafin = :horafin, secobra = :secobra, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarGimnasio(@Param("id") Integer id, @Param("horainicio") Integer horainicio,
            @Param("horafin") Integer horafin, @Param("secobra") int secobra, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gimnasio WHERE id = :id", nativeQuery = true)
    void eliminarGimnasio(@Param("id") Integer id);

}
