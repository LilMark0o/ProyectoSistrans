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

import java.util.Collection;

@Controller
public class PlanConsumoController {

    @Autowired
    private PlanConsumoRepository PlanConsumosRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/planConsumo")
    public String PlanConsumos(Model model) {
        model.addAttribute("planConsumo", PlanConsumosRepository.darPlanesConsumo());
        return "planConsumo";
    }

    @GetMapping("/planConsumo/new")
    public String bebidaForm(Model model) {
        model.addAttribute("planConsumo", new PlanConsumo());
        return "planConsumoNuevo";
    }

    @PostMapping("/planConsumo/new/save")
    public String PlanConsumosGuardar(@ModelAttribute("tipodedocumento") String tipodedocumento,
            @ModelAttribute("id") Integer id, @ModelAttribute("descripcion") String descripcion,
            @ModelAttribute("descuento") Integer descuento, @ModelAttribute("hotel_id") Integer hotel_id) {
        PlanConsumo PlanConsumo = new PlanConsumo();
        PlanConsumo.setId(id);
        PlanConsumo.setDescripcion(descripcion);
        PlanConsumo.setDescuento(descuento);
        Hotel hotel = hotelRepository.darHotelPorId(hotel_id);
        PlanConsumo.setHotel(hotel);
        PlanConsumosRepository.insertarPlanConsumo(PlanConsumo.getId(),
                PlanConsumo.getDescripcion(),
                PlanConsumo.getDescuento(),
                PlanConsumo.getHotel().getId());
        return "redirect:/planConsumo";
    }

    @GetMapping("/planConsumo/{id}/edit")
    public String PlanConsumosEditarForm(@PathVariable("id") Integer id, Model model) {
        // PlanConsumosRepository.eliminarPlanConsumo(id);
        model.addAttribute("planConsumo", new PlanConsumo());
        return "planConsumoNuevo";
    }
}
