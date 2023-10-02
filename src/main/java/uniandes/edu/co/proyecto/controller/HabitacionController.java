package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;

import java.util.List;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    // Mostrar la lista de habitaciones
    @GetMapping
    public String listaHabitaciones(Model model) {
        List<Habitacion> habitaciones = (List<Habitacion>) habitacionRepository.darHabitaciones();
        model.addAttribute("habitaciones", habitaciones);
        return "habitaciones";
    }

    // Mostrar el formulario para añadir una nueva habitación
    @GetMapping("/new")
    public String nuevaHabitacionForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "habitacionNuevo";
    }

    // Guardar nueva habitación
    @PostMapping("/new")
    public String guardarHabitacion(@ModelAttribute Habitacion habitacion) {
        habitacionRepository.save(habitacion);
        return "redirect:/habitaciones";
    }

    // Mostrar el formulario para editar una habitación
    @GetMapping("/{id}/edit")
    public String editarHabitacionForm(@PathVariable Integer id, Model model) {
        Habitacion habitacion = habitacionRepository.darHabitacionPorId(id);
        if (habitacion == null) {
            return "redirect:/habitaciones";
        }
        model.addAttribute("habitacion", habitacion);
        return "habitacionEditar";
    }

    // Actualizar habitación
    @PostMapping("/{id}/edit")
    public String actualizarHabitacion(@PathVariable Integer id, @ModelAttribute Habitacion habitacion) {
        Habitacion habitacionExistente = habitacionRepository.darHabitacionPorId(id);
        if (habitacionExistente != null) {
            habitacionExistente.setCapacidad(habitacion.getCapacidad());
            habitacionExistente.setCostonoche(habitacion.getCostonoche());
            habitacionExistente.setTipohabitacion(habitacion.getTipohabitacion());
            habitacionExistente.setHotel(habitacion.getHotel());
            habitacionRepository.save(habitacionExistente);
        }
        return "redirect:/habitaciones";
    }

    // Borrar una habitación
    @GetMapping("/{id}/delete")
    public String borrarHabitacion(@PathVariable Integer id) {
        habitacionRepository.deleteById(id);
        return "redirect:/habitaciones";
    }
}
