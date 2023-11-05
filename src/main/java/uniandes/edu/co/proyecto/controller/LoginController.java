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
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Usuario usuario = authenticationService.authenticate(username, password);
        if (usuario != null) {
            session.setAttribute("loggedInUser", usuario);
            // Redirigir a una página basada en el tipo de usuario
            return "redirect:/dashboard";
        } else {
            return "redirect:/login?error";
        }
    }

}
