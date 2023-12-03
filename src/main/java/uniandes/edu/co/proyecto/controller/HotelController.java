package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.HabitacionEmbedded;
import uniandes.edu.co.proyecto.modelo.Hotel;
import uniandes.edu.co.proyecto.repositorio.HotelRepository;

@Controller
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/hoteles")
    public String getHoteles(Model model) {
        model.addAttribute("hoteles", hotelRepository.findAll());
        return "hoteles";
    }

    @GetMapping("/mostrarResultadosAgregacionHotel")
    public String mostrarResultados(Model model) {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("habitacion")
                .localField("habitaciones")
                .foreignField("_id")
                .as("Lista_habitaciones_hotel");

        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);

        // Cambié "tipo_bebidas" a "hotel" en el siguiente código para que coincida con
        // tu entidad Hotel
        model.addAttribute("hoteles", mongoTemplate.aggregate(aggregation, "hotel", Hotel.class).getMappedResults());

        return "resultadosHotel";
    }

    @GetMapping("/hotelForm")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nuevoHotel", new Hotel());
        return "hotelesForm";
    }

    @PostMapping("/crearHotel")
    public String crearHotel(@ModelAttribute("nuevoHotel") Hotel nuevoHotel) {
        hotelRepository.save(nuevoHotel);
        return "redirect:/hoteles";
    }
}
