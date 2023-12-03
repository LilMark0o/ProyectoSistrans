package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ServicioProducto;
import uniandes.edu.co.proyecto.repositorio.ServicioProductoRepository;

@Controller
public class ServicioProductoController {

    @Autowired
    private ServicioProductoRepository servicioProductoRepository;

    @GetMapping("/serviciosProductos")
    public String getServiciosProductos(Model model) {
        model.addAttribute("serviciosProductos", servicioProductoRepository.findAll());
        return "serviciosProductos";
    }

    @GetMapping("/servicioProductoForm")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nuevoServicioProducto", new ServicioProducto());
        return "serviciosProductosForm";
    }

    @PostMapping("/crearServicioProducto")
    public String crearServicioProducto(
            @ModelAttribute("nuevoServicioProducto") ServicioProducto nuevoServicioProducto) {
        servicioProductoRepository.save(nuevoServicioProducto);
        return "redirect:/serviciosProductos";
    }
}
