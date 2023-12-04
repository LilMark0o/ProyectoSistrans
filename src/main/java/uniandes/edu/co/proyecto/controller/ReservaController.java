package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

@Controller
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/reserva")
    public String getreserva(Model model) {
        model.addAttribute("reserva", reservaRepository.findAll());
        return "reserva";
    }

    @GetMapping("/reservaForm")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nuevaReserva", new Reserva());
        return "reservaForm";
    }

    @PostMapping("/crearReserva")
    public String crearReserva(
            @ModelAttribute("nuevaReserva") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Reserva nuevaReserva) {
        // Tu lógica para crear la reserva
        return "redirect:/reservas";
    }

}
