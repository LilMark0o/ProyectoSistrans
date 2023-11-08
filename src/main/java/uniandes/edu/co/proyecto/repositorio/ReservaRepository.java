package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Reserva;
import java.util.Date;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

        @Query(value = "SELECT * FROM reserva", nativeQuery = true)
        Collection<Reserva> darReservas();

        @Query(value = "SELECT * FROM reserva WHERE id = :id", nativeQuery = true)
        Reserva darReservaPorId(@Param("id") Integer id);

        // Ajusta la sentencia SQL de inserción de acuerdo a la estructura de tu tabla
        // de reservas
        @Query(value = "INSERT INTO reserva (id, checkin, checkout, precio, habitacion_id, usuario_id) " +
                        "VALUES (:id, :checkin, :checkout, :precio, :habitacion.id, :usuario.id)", nativeQuery = true)
        void insertarReserva(@Param("id") Integer id, @Param("checkin") Date checkin,
                        @Param("checkout") Date checkout, @Param("precio") Float precio,
                        @Param("habitacion") Integer habitacion, @Param("usuario") Integer usuario);

        // Ajusta la sentencia SQL de actualización de acuerdo a la estructura de tu
        // tabla de reservas
        @Query(value = "UPDATE reserva SET checkin = :checkin, checkout = :checkout, precio = :precio, habitacion_id = :habitacion.id, usuario_id = :usuario.id "
                        +
                        "WHERE id = :id", nativeQuery = true)
        void actualizarReserva(@Param("id") Integer id, @Param("checkin") Date checkin,
                        @Param("checkout") Date checkout, @Param("precio") Float precio,
                        @Param("habitacion") Integer habitacion, @Param("usuario") Integer usuario);

        @Query(value = "DELETE FROM reserva WHERE id = :id", nativeQuery = true)
        void eliminarReserva(@Param("id") Integer id);
}
