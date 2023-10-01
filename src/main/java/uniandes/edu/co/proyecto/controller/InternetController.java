package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Internet;
import uniandes.edu.co.proyecto.repositorio.InternetRepository;

import java.util.Collection;

@RestController
@RequestMapping("/api/internet")
public class InternetController {

    @Autowired
    private InternetRepository internetRepository;

    @GetMapping
    public ResponseEntity<Collection<Internet>> listarServiciosInternet() {
        return ResponseEntity.ok(internetRepository.darServiciosInternet());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Internet> obtenerInternetPorId(@PathVariable Integer id) {
        Internet internet = internetRepository.darInternetPorId(id);
        if (internet != null) {
            return ResponseEntity.ok(internet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Internet> crearInternet(@RequestBody Internet internet) {
        internetRepository.insertarInternet(internet.getId(), internet.getCapacidad(), internet.getPrecio(),
                internet.getSecobra(), internet.getHotel().getId());
        return ResponseEntity.ok(internet); // Similarmente, podrías querer devolver el objeto completo con el ID
                                            // asignado.
    }

    @PutMapping("/{id}")
    public ResponseEntity<Internet> actualizarInternet(@PathVariable Integer id, @RequestBody Internet internet) {
        Internet internetExistente = internetRepository.darInternetPorId(id);
        if (internetExistente != null) {
            internetRepository.actualizarInternet(id, internet.getCapacidad(), internet.getPrecio(),
                    internet.getSecobra(), internet.getHotel().getId());
            return ResponseEntity.ok(internet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInternet(@PathVariable Integer id) {
        Internet internetExistente = internetRepository.darInternetPorId(id);
        if (internetExistente != null) {
            internetRepository.eliminarInternet(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
