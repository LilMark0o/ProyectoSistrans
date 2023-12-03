package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/reservas")
    public String getReservas(Model model) {
        model.addAttribute("reservas", reservaRepository.findAll());
        return "reservas";
    }

    @GetMapping("/reservaForm")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nuevaReserva", new Reserva());
        return "reservasForm";
    }

    @PostMapping("/crearReserva")
    public String crearReserva(@ModelAttribute("nuevaReserva") Reserva nuevaReserva) {
        reservaRepository.save(nuevaReserva);
        return "redirect:/reservas";
    }
}
