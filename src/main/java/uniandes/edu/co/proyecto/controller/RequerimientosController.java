package uniandes.edu.co.proyecto.controller;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.Service.HabitacionService;
import uniandes.edu.co.proyecto.Service.ServicioService;
import uniandes.edu.co.proyecto.dtos.ServicioResumenDTO;
import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositorio.*;


@Controller
public class RequerimientosController {
    @Autowired
    private HabitacionService habitacionService;

    @Autowired
    private ServicioService servicioService;
    
    @GetMapping("/req1")
    public String requerimiento1(Model model) {
        // System.out.println(habitacionService.findServicioResumen());
        model.addAttribute("resumen", habitacionService.findServicioResumen());
        return "req1";
    }

    @GetMapping("/req2")
    public String requerimiento2(
        Model model) {
        // System.out.println(habitacionService.findServicioResumen());
        return "req2";
    }

    @PostMapping("/req2")
    public String requerimiento2post(
        @RequestParam("date1") String date1, 
        @RequestParam("date2") String date2, 
        Model model) {
        model.addAttribute("resumen", servicioService.findServicioResumen(date1, date2));
        return "req2"; // Retornamos el nombre de la vista que queremos mostrar
    }

    
   
}