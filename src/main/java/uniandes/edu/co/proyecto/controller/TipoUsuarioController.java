package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositorio.*;

import java.util.Collection;

@Controller
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/tiposUsuario")
    public String listarTiposUsuario(Model model) {
        model.addAttribute("tiposUsuario", tipoUsuarioRepository.findAll());
        return "tiposUsuario";
    }

    @GetMapping("/tiposUsuario/{id}")
    public String obtenerTipoUsuarioPorId(@PathVariable String id, Model model) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findTipoUsuarioByNombre(id);
        System.out.println(tipoUsuario);
        if (tipoUsuario != null) {
            model.addAttribute("tipoUsuario", tipoUsuario);
            return "tiposUsuarioDetalle";
        } else {
            return "redirect:/tiposUsuario";
        }
    }

    @GetMapping("/tiposUsuario/new")
    public String mostrarFormularioNuevoTipoUsuario(Model model) {
        model.addAttribute("tipoUsuario", new TipoUsuario());
        return "tiposUsuarioNuevo";
    }

    @PostMapping("/tiposUsuario/new/save")
    public String guardarNuevoTipoUsuario(@ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.save(tipoUsuario);
        return "redirect:/tiposUsuario";
    }

    @GetMapping("/tiposUsuario/{id}/edit")
    public String mostrarFormularioEditarTipoUsuario(@PathVariable String id, Model model) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findTipoUsuarioByNombre(id);
        if (tipoUsuario != null) {
            model.addAttribute("tipoUsuario", tipoUsuario);
            return "tiposUsuarioEditar";
        } else {
            return "redirect:/tiposUsuario";
        }
    }

    @PostMapping("/tiposUsuario/{id}/edit/save")
    public String guardarTipoUsuarioEditado(@PathVariable String id, @ModelAttribute TipoUsuario tipoUsuario) {
        TipoUsuario tipoUsuarioExistente = tipoUsuarioRepository.findTipoUsuarioByNombre(id);
        if (tipoUsuarioExistente != null) {
            tipoUsuarioRepository.save(tipoUsuario);
            return "redirect:/tiposUsuario";
        } else {
            return "redirect:/tiposUsuario";
        }
    }

    @GetMapping("/tiposUsuario/{id}/delete")
    public String eliminarTipoUsuario(@PathVariable String id) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findTipoUsuarioByNombre(id);
        if (tipoUsuario != null) {
            tipoUsuarioRepository.delete(tipoUsuario);
            return "redirect:/tiposUsuario";
        } else {
            return "redirect:/tiposUsuario";
        }
    }
}   