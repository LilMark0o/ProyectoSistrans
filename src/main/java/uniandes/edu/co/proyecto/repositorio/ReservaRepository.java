package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.proyecto.modelo.Reserva;

import java.util.Date;
import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

        List<Reserva> findByCheckinAndCheckout(Date checkin, Date checkout);
}
