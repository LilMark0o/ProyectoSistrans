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
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository; // Assuming you have a repository for TipoUsuario

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAllUsers());
        return "Usuarios";
    }

    @GetMapping("/usuarios/id")
    public String obtenerUsuarioPorId(@RequestParam("id") Integer id, Model model) {
        try {
            Usuario usuario = usuarioRepository.findById(id).orElse(null);
            model.addAttribute("usuarios", usuario != null ? Collections.singletonList(usuario) : Collections.emptyList());
        } catch (Exception e) {
            model.addAttribute("usuarios", Collections.emptyList());
            model.addAttribute("searchError", "Please enter a valid ID.");
        }
        return "Usuarios";
    }

    @GetMapping("/usuarios/new")
    public String mostrarFormularioNuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("tiposUsuario", tipoUsuarioRepository.findAll()); // Adjust if using a custom method
        return "usuariosNuevo";
    }
 
    @PostMapping("/usuarios/new/save")
    public String guardarNuevoUsuario(@ModelAttribute Usuario usuario, @RequestParam("tipoUsuarioNombre") String tipoUsuarioNombre) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findTipoUsuarioByNombre(tipoUsuarioNombre);
        if (tipoUsuario != null) {
            usuario.setTipoUsuario(tipoUsuario);
            usuarioRepository.save(usuario); // Assuming save method in the repository
        } else {
            // Handle the case where the tipoUsuario is not found, maybe redirect with an error message
        }
        return "redirect:/usuarios";
    }


    @GetMapping("/usuarios/{id}/edit")
    public String mostrarFormularioEditarUsuario(@PathVariable("id") Integer id, Model model) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("tiposUsuario", tipoUsuarioRepository.findAll()); // Adjust if using a custom method
            return "usuariosEditar";
        } else {
            // Handle the case where the usuario is not found
            return "redirect:/usuarios";
        }
    }
    @PostMapping("/usuarios/{id}/update")
    public String actualizarUsuario(@PathVariable("id") Integer id, @ModelAttribute Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findById(id).orElse(null);
        if (existingUsuario != null) {
            // Update the existing user with the values from `usuario`
            // Note: You might need to handle TipoUsuario again like in the save method
            usuarioRepository.save(existingUsuario);
        } else {
            // Handle the case where the usuario is not found
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/delete")
    public String eliminarUsuario(@PathVariable("id") Integer id) {
        usuarioRepository.deleteById(id); // Assumes this method exists in your repository
        return "redirect:/usuarios";
    }


    // Add more methods for update and delete operations
}
