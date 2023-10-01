package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

    @Query(value = "SELECT * FROM reserva", nativeQuery = true)
    Collection<Reserva> darReservas();

    @Query(value = "SELECT * FROM reserva WHERE id = :id", nativeQuery = true)
    Reserva darReservaPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reserva (fecha, valor, cliente_id, hotel_id) VALUES (:fecha, :valor, :cliente_id, :hotel_id)", nativeQuery = true)
    void insertarReserva(@Param("fecha") String fecha, @Param("valor") Integer valor, @Param("cliente_id") Integer cliente_id, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reserva SET fecha = :fecha, valor = :valor, cliente_id = :cliente_id, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarReserva(@Param("id") Integer id, @Param("fecha") String fecha, @Param("valor") Integer valor, @Param("cliente_id") Integer cliente_id, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reserva WHERE id = :id", nativeQuery = true)
    void eliminarReserva(@Param("id") Integer id);
    

}