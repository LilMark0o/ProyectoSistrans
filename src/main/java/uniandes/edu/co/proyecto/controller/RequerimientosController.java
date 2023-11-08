package uniandes.edu.co.proyecto.controller;

import java.sql.Date;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.Service.HabitacionService;
import uniandes.edu.co.proyecto.Service.ServicioService;
import uniandes.edu.co.proyecto.Service.UsuarioService;
import uniandes.edu.co.proyecto.dtos.ServicioResumenDTO;
import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositorio.*;

@Controller
public class RequerimientosController {
    @Autowired
    private HabitacionService habitacionService;

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private UsuarioService usuarioService;

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

    @GetMapping("/req3")
    public String requerimiento3(Model model) {
        // System.out.println(habitacionService.findServicioResumen());
        model.addAttribute("resumen", habitacionService.findReq3());
        return "req3";
    }

    @GetMapping("/req4")
    public String requerimiento4(Model model) {
        return "req4";
    }

    @PostMapping("/req4")
    public String requerimiento4post(
        @RequestParam(value = "precio_min", required = false) Float precio_min,
        @RequestParam(value = "precio_max", required = false) Float precio_max,
        @RequestParam(value = "fecha_inicio", required = false) String fecha_inicio,
        @RequestParam(value = "fecha_fin", required = false) String fecha_fin,
        Model model) {
    model.addAttribute("resumen",
            servicioRepository.findServiciosByFilters(precio_min, precio_max, fecha_inicio, fecha_fin));
    return "req4";
}


    @GetMapping("/req5")
    public String requerimiento5(Model model) {
        return "req5";
    }
    // List<Object[]> findUserResumenData(@Param("given_user_id") Integer
    // given_user_id, @Param("start_date") String start_date, @Param("end_date")
    // String end_date);
 
    @PostMapping("/req5")
    public String requerimiento5post(
            @RequestParam("id_usuario") Integer id_usuario,
            @RequestParam("fecha_inicio") String fecha_inicio,
            @RequestParam("fecha_fin") String fecha_fin,
            Model model) {
        model.addAttribute("resumen", usuarioService.findServicioResumen(id_usuario, fecha_inicio, fecha_fin));
        return "req5";
    }

    @GetMapping("/req6")
    public String requerimiento6(Model model) {
        model.addAttribute("resumen", servicioService.findFechaOcupacion());
        return "req6";
    }

    @GetMapping("/req7")
    public String requerimiento7(Model model) {
        model.addAttribute("resumen", usuarioService.findBuenCliente());
        return "req7";
    }

    @GetMapping("/req8")
    public String requerimiento8(Model model) {
        model.addAttribute("resumen", servicioService.findFechaOcupacion());
        return "req8";
    }

    @GetMapping("/req9")
    public String requerimiento9(Model model) {
        return "req9";
    }

    @PostMapping("/req9")
    public String requerimiento9post(
            @RequestParam("id_servicio") Integer id_servicio,
            @RequestParam("fecha_inicio") String fecha_inicio,
            @RequestParam("fecha_fin") String fecha_fin,
            @RequestParam("agrupamiento") String agrupamiento,
            @RequestParam("ordenamiento") String ordenamiento,
            Model model) {
        model.addAttribute("resumen", usuarioService.findClientesConAgrupamiento(id_servicio, fecha_inicio, fecha_fin,
                agrupamiento, ordenamiento));
        return "req9";
    }

    @GetMapping("/req10")
    public String requerimiento10(Model model) {
        return "req10";
    }

    @PostMapping("/req10")
    public String requerimiento10post(
            @RequestParam("id_servicio") Integer id_servicio,
            @RequestParam("fecha_inicio") Date fecha_inicio,
            @RequestParam("fecha_fin") Date fecha_fin,
            @RequestParam("agrupamiento") String agrupamiento,
            @RequestParam("ordenamiento") String ordenamiento,
            Model model) {
        model.addAttribute("resumen", usuarioService.findClientesSinConsumoDeServicio(id_servicio, fecha_inicio,
                fecha_fin, agrupamiento, ordenamiento));
        return "req10";
    }

    @GetMapping("/req11")
    public String requerimiento11(Model model) {
        return "req11";
    }
    // List<Object[]> findHabitacionPorSemana(@Param("fecha_inicio") String
    // fecha_inicio, @Param("fecha_fin") String fecha_fin);

    @PostMapping("/req11")
    public String requerimiento11post(
            @RequestParam("fecha_inicio") String fecha_inicio,
            @RequestParam("fecha_fin") String fecha_fin,
            Model model) {
        model.addAttribute("resumen", habitacionService.findReq11(fecha_inicio, fecha_fin));
        return "req11";
    }

    @GetMapping("/req12")
    public String requerimiento12(Model model) {
        model.addAttribute("resumen", usuarioService.findBuenClienteAlternativo());
        return "req12";
    }

}