package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @PostMapping("/")
    public Reserva crearReserva(@RequestBody Reserva Reserva) {
        return reservaRepository.save(Reserva);
    }

    @GetMapping("/")
    public List<Reserva> consultarReservas() {
        return (List<Reserva>) reservaRepository.darReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> consultarReservaPorId(@PathVariable(value = "id") Integer ReservaId) {
        Reserva Reserva = reservaRepository.darReservaPorId(ReservaId);
        if (Reserva != null) {
            return ResponseEntity.ok(Reserva);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable(value = "id") Integer ReservaId,
            @RequestBody Reserva ReservaDetalles) {
        Reserva Reserva = reservaRepository.darReservaPorId(ReservaId);
        if (Reserva != null) {
            Reserva.setCobro(ReservaDetalles.getCobro());
            Reserva.setFechaEntrada(ReservaDetalles.getFechaEntrada());
            Reserva.setFechaSalida(ReservaDetalles.getFechaSalida());
            Reserva.setUsuario(ReservaDetalles.getUsuario());
            Reserva.setHabitacion(ReservaDetalles.getHabitacion());
            Reserva ReservaActualizado = reservaRepository.save(Reserva);
            return ResponseEntity.ok(ReservaActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> borrarReserva(@PathVariable(value = "id") Integer ReservaId) {
        Reserva Reserva = reservaRepository.darReservaPorId(ReservaId);
        if (Reserva != null) {
            reservaRepository.delete(Reserva);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
