package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import uniandes.edu.co.proyecto.Service.AuthenticationService;
import uniandes.edu.co.proyecto.modelo.*;
import uniandes.edu.co.proyecto.repositorio.*;


import java.util.Collection;


@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        try {
            Usuario usuario = authenticationService.authenticate(username, password);
            if (usuario != null) {
                
                session.setAttribute("loggedInUser", usuario);
                return "redirect:/";
            } else {
                model.addAttribute("loginError", "Usuario o contraseña incorrecta");
                return "login"; // Nombre de la vista que contiene el formulario de login
            }
        } catch (Exception e) {
            model.addAttribute("loginError", "Error al procesar el inicio de sesión");
            return "login"; // Nombre de la vista que contiene el formulario de login
        }
    }


}
