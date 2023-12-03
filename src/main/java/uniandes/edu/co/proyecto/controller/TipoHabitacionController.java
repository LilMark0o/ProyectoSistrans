package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

@Controller
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/tiposHabitacion")
    public String getTiposHabitacion(Model model) {
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAll());
        return "tiposHabitacion";
    }

    @GetMapping("/tipoHabitacionForm")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nuevoTipoHabitacion", new TipoHabitacion());
        return "tiposHabitacionForm";
    }

    @PostMapping("/crearTipoHabitacion")
    public String crearTipoHabitacion(@ModelAttribute("nuevoTipoHabitacion") TipoHabitacion nuevoTipoHabitacion) {
        tipoHabitacionRepository.save(nuevoTipoHabitacion);
        return "redirect:/tiposHabitacion";
    }
}
