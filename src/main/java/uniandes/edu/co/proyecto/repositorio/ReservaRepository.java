package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

        @Query(value = "SELECT * FROM reserva", nativeQuery = true)
        Collection<Reserva> darReservas();

        @Query(value = "SELECT * FROM reserva WHERE id = :id", nativeQuery = true)
        Reserva darReservaPorId(@Param("id") int id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO reserva (id, cobro, usuario_id, habitacion_id, fechaentrada, fechasalida) VALUES (:id, :cobro, :usuario.id, :habitacion.id, :fechaEntrada, :fechaSalida)", nativeQuery = true)
        void insertarReserva(@Param("id") Integer id, @Param("cobro") Float cobro,
                        @Param("usuario") Integer usuario, @Param("habitacion") Integer habitacion,
                        @Param("fechaEntrada") java.util.Date date, @Param("fechaSalida") java.util.Date date2);

        @Modifying
        @Transactional
        @Query(value = "UPDATE reserva SET fecha = :fecha, valor = :valor, cliente_id = :cliente_id, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
        void actualizarReserva(@Param("id") Integer id, @Param("fecha") String fecha, @Param("valor") Integer valor,
                        @Param("cliente_id") Integer cliente_id, @Param("hotel_id") Integer hotel_id);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM reserva WHERE id = :id", nativeQuery = true)
        void eliminarReserva(@Param("id") Integer id);

}