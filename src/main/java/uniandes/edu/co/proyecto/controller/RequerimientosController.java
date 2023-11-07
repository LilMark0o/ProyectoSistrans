package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.Service.HabitacionService;
import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositorio.*;


@Controller
public class RequerimientosController {
    @Autowired
    private HabitacionService habitacionService;
    
    @GetMapping("/req1")
    public String requerimiento1(Model model) {
        // System.out.println(habitacionService.findServicioResumen());
        model.addAttribute("resumen", habitacionService.findServicioResumen());
        return "req1";
    }

    @GetMapping("/req2")
    public String requerimiento2(Model model) {
        // System.out.println(habitacionService.findServicioResumen());
        model.addAttribute("resumen", habitacionService.findServicioResumen());
        return "req1";
    }
    
   
}