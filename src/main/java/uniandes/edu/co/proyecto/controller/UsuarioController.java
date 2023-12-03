package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String getUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuarios";
    }

    @GetMapping("/usuarioForm")
    public String mostrarFormulario(Model model) {
        model.addAttribute("nuevoUsuario", new Usuario());
        return "usuariosForm";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario) {
        usuarioRepository.save(nuevoUsuario);
        return "redirect:/usuarios";
    }
}
