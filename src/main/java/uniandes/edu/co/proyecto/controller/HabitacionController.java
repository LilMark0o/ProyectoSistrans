package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

import java.util.List;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    // Assuming you also have a repository for TipoHabitacion if it is a separate entity
    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/habitaciones")
    public String listarHabitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        return "habitaciones"; // Replace with the actual name of the list view
    }

    @GetMapping("/habitaciones/new")
    public String mostrarFormularioNuevaHabitacion(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        // Assuming 'tiposHabitacion' is needed for a dropdown or similar
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAll());
        return "habitacionesNuevo"; // Replace with the actual name of the create view
    }

    @GetMapping("/habitaciones/id")
    public String obtenerHabitacionPorId(@RequestParam("id")  Integer id, Model model) {
        Habitacion habitacion = habitacionRepository.findById(id).orElse(null);
        if (habitacion != null) {
            model.addAttribute("habitaciones", habitacion);
            return "habitaciones"; // Replace with the actual name of the view
        } else {
            return "redirect:/habitaciones";
        }
    }


    @PostMapping("/habitaciones/new/save")
    public String guardarNuevaHabitacion(@ModelAttribute Habitacion habitacion) {
        habitacionRepository.save(habitacion); // Assuming the save method is defined in the repository
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/edit")
    public String mostrarFormularioEditarHabitacion(@PathVariable("id") Integer id, Model model) {
        Habitacion habitacion = habitacionRepository.findById(id).orElse(null);
        if (habitacion != null) {
            model.addAttribute("habitacion", habitacion);
            // Assuming 'tiposHabitacion' is needed for a dropdown or similar
            model.addAttribute("tiposHabitacion", tipoHabitacionRepository.findAll());
            return "habitacionesEditar"; // Replace with the actual name of the edit view
        } else {
            return "redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{id}/update")
    public String actualizarHabitacion(@PathVariable("id") Integer id, @ModelAttribute Habitacion habitacion) {
        Habitacion existingHabitacion = habitacionRepository.findById(id).orElse(null);
        if (existingHabitacion != null) {
            // Update properties of the existing habitacion with that of the form's
            existingHabitacion.setCapacidad(habitacion.getCapacidad());
            existingHabitacion.setCostonoche(habitacion.getCostonoche());
            existingHabitacion.setTipohabitacion(habitacion.getTipohabitacion());
            habitacionRepository.save(existingHabitacion);
        }
        return "redirect:/habitaciones";
    }

    // Include a delete method if necessary
    @GetMapping("/habitaciones/{id}/delete")
    public String eliminarHabitacion(@PathVariable("id") Integer id) {
        habitacionRepository.deleteById(id);
        return "redirect:/habitaciones";
    }
}