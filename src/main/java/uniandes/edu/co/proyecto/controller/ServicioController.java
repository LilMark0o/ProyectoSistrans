package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositorio.*;

import java.util.Collection;
import java.util.Collections;

@Controller
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/servicios")
    public String servicios(Model model) {
        Collection<Servicio> servicios = servicioRepository.darServicios();
        model.addAttribute("servicios", servicios);
        return "servicios";
    }

    @GetMapping("/servicios/new")
    public String servicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "serviciosNuevo";
    }

    @PostMapping("/servicios/new/save")
    public String guardarServicio(@ModelAttribute("id") Integer id, @ModelAttribute("nombre") String nombre,
            @ModelAttribute("descripcion") String descripcion, @ModelAttribute("precio") Float precio,
            @ModelAttribute("hotel_id") Integer hotel_id) {
        Servicio servicio = new Servicio();
        servicio.setId(id);
        servicio.setNombre(nombre);
        servicio.setDescripcion(descripcion);
        servicio.setPrecio(precio);
        Hotel hotel = hotelRepository.darHotelPorId(hotel_id);
        servicio.setHotel(hotel);
        servicioRepository.insertarServicio(servicio.getId(), servicio.getNombre(), servicio.getDescripcion(),
                servicio.getPrecio(), servicio.getHotel().getId());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/id")
    public String obtenerServicioPorId(@RequestParam("id") Integer id, Model model) {
        try {
            Servicio servicio = servicioRepository.findById(id).orElse(null);
            model.addAttribute("servicios",
                    servicio != null ? Collections.singletonList(servicio) : Collections.emptyList());
        } catch (Exception e) {
            model.addAttribute("servicios", Collections.emptyList());
            model.addAttribute("searchError", "Please enter a valid ID.");
        }
        return "servicios";
    }

    @GetMapping("/servicios/{id}/edit")
    public String editarServicioForm(@PathVariable("id") Integer id, Model model) {
        Servicio servicio = servicioRepository.findById(id).orElse(null);
        if (servicio != null) {
            model.addAttribute("servicio", servicio);
            return "serviciosNuevo"; // Puede que quieras usar una vista diferente para la edición
        } else {
            // Manejo de error, servicio no encontrado
            return "redirect:/servicios";
        }
    }
}
