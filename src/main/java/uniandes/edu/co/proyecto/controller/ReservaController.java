package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositorio.*;

import java.sql.Date;
import java.util.Collection;

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository ReservasRepository;
    @Autowired
    private HabitacionRepository habitacionRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/reserva")
    public String Reservas(Model model) {
        model.addAttribute("reserva", ReservasRepository.darReservas());
        return "reserva";
    }

    @GetMapping("/reserva/new")
    public String bebidaForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservaNuevo";
    }

    @PostMapping("/reserva/new/save")
    public String ReservasGuardar(@ModelAttribute("id") Integer id, @ModelAttribute("cobro") Float cobro,
            @ModelAttribute("id_habitacion") Integer id_habitacion, @ModelAttribute("id_usuario") Integer id_usuario,
            @ModelAttribute("fechaentrada") Date fechaentrada, @ModelAttribute("fechasalida") Date fechasalida) {
        Reserva Reserva = new Reserva();
        Reserva.setId(id);
        Reserva.setCobro(cobro);
        Reserva.setFechaEntrada(fechaentrada);
        Reserva.setFechaSalida(fechasalida);
        Habitacion habitacion = habitacionRepository.darHabitacionPorId(id_habitacion);
        Reserva.setHabitacion(habitacion);
        Usuario usuario = usuarioRepository.findUserById(id_usuario);
        Reserva.setUsuario(usuario);
        ReservasRepository.insertarReserva(Reserva.getId(),
                Reserva.getCobro(),
                Reserva.getUsuario().getId(),
                Reserva.getHabitacion().getId(),
                Reserva.getFechaEntrada(),
                Reserva.getFechaSalida());
        return "redirect:/reserva";
    }

    @GetMapping("/reserva/{id}/edit")
    public String ReservasEditarForm(@PathVariable("id") Integer id, Model model) {
        // ReservasRepository.eliminarReserva(id);
        model.addAttribute("reserva", new Reserva());
        return "reservaNuevo";
    }
}
