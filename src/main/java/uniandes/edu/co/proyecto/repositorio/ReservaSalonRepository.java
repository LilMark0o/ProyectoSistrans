package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ReservaSalon;

public interface ReservaSalonRepository extends JpaRepository<ReservaSalon, Integer>{

    @Query(value = "SELECT * FROM reservasalon", nativeQuery = true)
    Collection<ReservaSalon> darReservasSalon();

    @Query(value = "SELECT * FROM reservasalon WHERE id = :id", nativeQuery = true)
    ReservaSalon darReservaSalonPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservasalon (fecha, hora, cliente_id, salon_id) VALUES (:fecha, :hora, :cliente_id, :salon_id)", nativeQuery = true)
    void insertarReservaSalon(@Param("fecha") String fecha, @Param("hora") Integer hora, @Param("cliente_id") Integer cliente_id, @Param("salon_id") Integer salon_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasalon SET fecha = :fecha, hora = :hora, cliente_id = :cliente_id, salon_id = :salon_id WHERE id = :id", nativeQuery = true)
    void actualizarReservaSalon(@Param("id") Integer id, @Param("fecha") String fecha, @Param("hora") Integer hora, @Param("cliente_id") Integer cliente_id, @Param("salon_id") Integer salon_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasalon WHERE id = :id", nativeQuery = true)
    void eliminarReservaSalon(@Param("id") Integer id);
    

}