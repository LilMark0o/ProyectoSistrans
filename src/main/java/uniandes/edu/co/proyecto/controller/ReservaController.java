package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private HabitacionRepository habitacionRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/reserva")
    public String reservas(Model model) {
        Collection<Reserva> reservas = reservaRepository.darReservas();
        model.addAttribute("reservas", reservas);
        return "reserva";
    }

    @GetMapping("/reserva/new")
    public String reservaForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservaNuevo";
    }

    @PostMapping("/reserva/new/save")
    public String guardarReserva(@ModelAttribute("id") Integer id, @ModelAttribute("checkin") Date checkin,
            @ModelAttribute("checkout") Date checkout, @ModelAttribute("precio") Float precio,
            @ModelAttribute("id_habitacion") Integer id_habitacion, @ModelAttribute("id_usuario") Integer id_usuario) {
        Reserva reserva = new Reserva();
        reserva.setId(id);
        reserva.setCheckin(checkin);
        reserva.setCheckout(checkout);
        reserva.setPrecio(precio);
        Habitacion habitacion = habitacionRepository.darHabitacionPorId(id_habitacion);
        reserva.setHabitacion(habitacion);
        Usuario usuario = usuarioRepository.findUserById(id_usuario);
        reserva.setUsuario(usuario);
        reservaRepository.insertarReserva(reserva.getId(), reserva.getCheckin(), reserva.getCheckout(),
                reserva.getPrecio(), reserva.getHabitacion().getId(), reserva.getUsuario().getId());
        return "redirect:/reserva";
    }

    @GetMapping("/reserva/id")
    public String obtenerReservaPorId(@RequestParam("id") Integer id, Model model) {
        try {
            Reserva reserva = reservaRepository.findById(id).orElse(null);
            model.addAttribute("reservas",
                    reserva != null ? Collections.singletonList(reserva) : Collections.emptyList());
        } catch (Exception e) {
            model.addAttribute("reservas", Collections.emptyList());
            model.addAttribute("searchError", "Please enter a valid ID.");
        }
        return "reserva";
    }

    @GetMapping("/reserva/{id}/edit")
    public String editarReservaForm(@PathVariable("id") Integer id, Model model) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaNuevo"; // Puede que quieras usar una vista diferente para la edición
        } else {
            // Manejo de error, reserva no encontrada
            return "redirect:/reserva";
        }
    }
}
