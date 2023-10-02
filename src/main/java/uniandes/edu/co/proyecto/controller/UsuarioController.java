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
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuariosRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuariosRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String bebidaForm(Model model) {
        model.addAttribute("usuarios", new Usuario());
        model.addAttribute("tiposUsuario", usuariosRepository.darTipoUsuario());
        return "usuariosNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuariosGuardar(@ModelAttribute("tipodedocumento") String tipodedocumento,
            @ModelAttribute("id") Integer id, @ModelAttribute("nombre") String nombre,
            @ModelAttribute("username") String username, @ModelAttribute("password") String password,
            @ModelAttribute("tipousuario") String tipousuario) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setTipodedocumento(tipodedocumento);
        usuario.setTipousuario(tipousuario);
        usuariosRepository.insertarUsuario(usuario.getId(),
                usuario.getNombre(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getTipousuario(),
                usuario.getTipodedocumento());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/edit")
    public String usuariosEditarForm(@PathVariable("id") Integer id, Model model) {
        Usuario usuario = usuariosRepository.findById(id).orElse(null);
        if (usuario == null) {
            return "redirect:/usuarios";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("tiposUsuario", usuariosRepository.darTipoUsuario());
        return "usuarioEditar";
    }
    
}
