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
public class ReservaServicioController {

    @Autowired
    private ReservaServicioRepository reservaServicioRepository;
    @Autowired
    private ServicioRepository servicioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/reservaServicios")
    public String reservaServicios(Model model) {
        Collection<ReservaServicio> reservaServicios = reservaServicioRepository.darReservaServicios();
        model.addAttribute("reservaServicios", reservaServicios);
        return "reservaServicios";
    }

    @GetMapping("/reservaServicios/new")
    public String reservaServicioForm(Model model) {
        model.addAttribute("reservaServicio", new ReservaServicio());
        return "reservaServiciosNuevo";
    }

    @PostMapping("/reservaServicios/new/save")
    public String guardarReservaServicio(
            @ModelAttribute("id") Integer id,
            @ModelAttribute("horainicio") Integer horainicio,
            @ModelAttribute("horafin") Integer horafin,
            @ModelAttribute("servicio_id") Integer servicioId,
            @ModelAttribute("usuario_id") Integer usuarioId) {
        ReservaServicio reservaServicio = new ReservaServicio();
        reservaServicio.setId(id);
        reservaServicio.setHorainicio(horainicio); // Cambio en el nombre del método
        reservaServicio.setHorafin(horafin); // Cambio en el nombre del método
        Servicio servicio = servicioRepository.findById(servicioId).orElse(null);
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

        if (servicio == null) {
            // Manejo de error, servicio no encontrado
            return "redirect:/reservaServicios";
        }
        if (usuario == null) {
            // Manejo de error, usuario no encontrado
            return "redirect:/reservaServicios";
        }

        reservaServicio.setServicio(servicio);
        reservaServicio.setUsuario(usuario);
        reservaServicioRepository.insertarReservaServicio(
                reservaServicio.getId(),
                reservaServicio.getHorainicio(),
                reservaServicio.getHorafin(),
                reservaServicio.getServicio().getId(),
                reservaServicio.getUsuario().getId());

        return "redirect:/reservaServicios";
    }

    @GetMapping("/reservaServicios/id")
    public String obtenerReservaServicioPorId(@RequestParam("id") Integer id, Model model) {
        try {
            ReservaServicio reservaServicio = reservaServicioRepository.findById(id).orElse(null);
            model.addAttribute("reservaServicios",
                    reservaServicio != null ? Collections.singletonList(reservaServicio) : Collections.emptyList());
        } catch (Exception e) {
            model.addAttribute("reservaServicios", Collections.emptyList());
            model.addAttribute("searchError", "Please enter a valid ID.");
        }
        return "reservaServicios";
    }

    @GetMapping("/reservaServicios/{id}/edit")
    public String editarReservaServicioForm(@PathVariable("id") Integer id, Model model) {
        ReservaServicio reservaServicio = reservaServicioRepository.findById(id).orElse(null);
        if (reservaServicio != null) {
            model.addAttribute("reservaServicio", reservaServicio);
            return "reservaServiciosNuevo"; // Puede que quieras usar una vista diferente para la edición
        } else {
            // Manejo de error, reservaServicio no encontrado
            return "redirect:/reservaServicios";
        }
    }
}
