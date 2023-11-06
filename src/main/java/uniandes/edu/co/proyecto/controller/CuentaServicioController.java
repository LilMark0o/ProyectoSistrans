package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.CuentaServicio;
import uniandes.edu.co.proyecto.repositorio.CuentaServicioRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Controller
public class CuentaServicioController {

    @Autowired
    private CuentaServicioRepository cuentaServicioRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/cuentaservicios")
    public String cuentaServicios(Model model) {
        Collection<CuentaServicio> cuentaServicios = cuentaServicioRepository.darCuentaServiciosConProducto();
        model.addAttribute("cuentaServiciosSinProducto", cuentaServicios);
        Collection<CuentaServicio> cuentaServiciosConProducto = cuentaServicioRepository
                .darCuentaServiciosSinProducto();
        model.addAttribute("cuentaServiciosConProducto", cuentaServiciosConProducto);
        return "cuentaservicios";
    }

    @GetMapping("/cuentaservicios/new")
    public String cuentaServicioForm(Model model) {
        model.addAttribute("cuentaServicio", new CuentaServicio());
        return "cuentaserviciosNuevo";
    }

    @PostMapping("/cuentaservicios/new/save")
    public String guardarCuentaServicio(@ModelAttribute("id") Integer id,
            @ModelAttribute("descripcion") String descripcion, @ModelAttribute("fecha") Date fecha,
            @ModelAttribute("reserva_id") Integer reserva_id, @ModelAttribute("producto_id") Integer producto_id,
            @ModelAttribute("servicio_id") Integer servicio_id) {
        CuentaServicio cuentaServicio = new CuentaServicio();
        cuentaServicio.setId(id);
        cuentaServicio.setDescripcion(descripcion);
        cuentaServicio.setFecha(fecha);
        cuentaServicio.setReserva(reservaRepository.darReservaPorId(reserva_id));
        cuentaServicio.setProducto(productoRepository.darProductoPorId(producto_id));
        cuentaServicio.setServicio(servicioRepository.darServicioPorId(servicio_id));

        cuentaServicioRepository.insertarCuentaServicio(cuentaServicio.getId(), cuentaServicio.getDescripcion(),
                cuentaServicio.getFecha(), cuentaServicio.getReserva().getId(), cuentaServicio.getProducto().getId(),
                cuentaServicio.getServicio().getId());

        return "redirect:/cuentaservicios";
    }

    @GetMapping("/cuentaservicios/id")
    public String obtenerCuentaServicioPorId(@RequestParam("id") Integer id, Model model) {
        try {
            CuentaServicio cuentaServicio = cuentaServicioRepository.findById(id).orElse(null);
            if (cuentaServicio.getProducto() == null) {
                model.addAttribute("cuentaServiciosSinProducto",
                        cuentaServicio != null ? Collections.singletonList(cuentaServicio) : Collections.emptyList());
            } else {
                model.addAttribute("cuentaServiciosConProducto",
                        cuentaServicio != null ? Collections.singletonList(cuentaServicio) : Collections.emptyList());
            }
        } catch (Exception e) {
            model.addAttribute("cuentaServicios", Collections.emptyList());
            model.addAttribute("searchError", "Please enter a valid ID.");
        }
        return "cuentaservicios";
    }

    @GetMapping("/cuentaservicios/{id}/edit")
    public String editarCuentaServicioForm(@PathVariable("id") Integer id, Model model) {
        CuentaServicio cuentaServicio = cuentaServicioRepository.findById(id).orElse(null);
        if (cuentaServicio != null) {
            model.addAttribute("cuentaServicio", cuentaServicio);
            return "cuentaserviciosNuevo"; // Puede que quieras usar una vista diferente para la edición
        } else {
            // Manejo de error, cuentaServicio no encontrado
            return "redirect:/cuentaservicios";
        }
    }
}
