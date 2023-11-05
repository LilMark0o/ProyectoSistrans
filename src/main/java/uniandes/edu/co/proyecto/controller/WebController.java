package uniandes.edu.co.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/release1")
    public String release1() {
        return "indexRelease1";
    }

}
