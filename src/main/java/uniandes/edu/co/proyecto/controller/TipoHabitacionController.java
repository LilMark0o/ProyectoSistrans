package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositorio.*;

@Controller
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/tiposHabitacion")
    public String listarTiposHabitacion(Model model) {
        System.out.println(tipoHabitacionRepository.findAll());
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAll());
        return "tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/id")
    public String obtenerTipoHabitacionPorId(@RequestParam("id") Integer id, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.findTipoHabitacionById(id);
        System.out.println(tipoHabitacion);
        if (tipoHabitacion != null) {
            model.addAttribute("tiposHabitacion", tipoHabitacion);
            return "tiposHabitacion";
        } else {
            return "redirect:/tiposHabitacion";
        }

    }

    @GetMapping("/tiposHabitacion/new")
    public String mostrarFormularioNuevoTipoHabitacion(Model model) {
        model.addAttribute("tipoHabitacion", new TipoHabitacion());
        return "tiposHabitacionNuevo";
    }

    @PostMapping("/tiposHabitacion/new/save")
    public String guardarNuevoTipoHabitacion(@ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.save(tipoHabitacion);
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{id}/edit")
    public String mostrarFormularioEditarTipoHabitacion(@PathVariable Integer id, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.findTipoHabitacionById(id);
        if (tipoHabitacion != null) {
            model.addAttribute("tipoHabitacion", tipoHabitacion);
            return "tiposHabitacionEditar";
        } else {
            return "redirect:/tiposHabitacion";
        }
    }

    @PostMapping("/tiposHabitacion/{id}/edit/save")
    public String guardarEdicionTipoHabitacion(@PathVariable Integer id,
            @ModelAttribute TipoHabitacion tipoHabitacion) {
        TipoHabitacion tipoHabitacionActual = tipoHabitacionRepository.findTipoHabitacionById(id);
        if (tipoHabitacionActual != null) {
            tipoHabitacionRepository.save(tipoHabitacion);
        }
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/{id}/delete")
    public String eliminarTipoHabitacion(@PathVariable Integer id) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.findTipoHabitacionById(id);
        if (tipoHabitacion != null) {
            tipoHabitacionRepository.delete(tipoHabitacion);
        }
        return "redirect:/tiposHabitacion";
    }
}