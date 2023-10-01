package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Bar;
import uniandes.edu.co.proyecto.repositorio.BarRepository;

import java.util.Collection;

@RestController
@RequestMapping("/api/bares")
public class BarController {

    @Autowired
    private BarRepository barRepository;

    @GetMapping
    public ResponseEntity<Collection<Bar>> listarBares() {
        return ResponseEntity.ok(barRepository.darBares());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bar> obtenerBarPorId(@PathVariable Integer id) {
        Bar bar = barRepository.darBarPorId(id);
        if (bar != null) {
            return ResponseEntity.ok(bar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Bar> crearBar(@RequestBody Bar bar) {
        barRepository.insertarBar(bar.getId(), bar.getEstilo(), bar.getCapacidad());
        return ResponseEntity.ok(bar); // Aquí, podrías querer devolver el objeto completo con el ID asignado, pero por
                                       // simplicidad, estamos devolviendo el objeto proporcionado.
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bar> actualizarBar(@PathVariable Integer id, @RequestBody Bar bar) {
        Bar barExistente = barRepository.darBarPorId(id);
        if (barExistente != null) {
            barRepository.actualizarBar(id, bar.getEstilo(), bar.getCapacidad());
            return ResponseEntity.ok(bar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBar(@PathVariable Integer id) {
        Bar barExistente = barRepository.darBarPorId(id);
        if (barExistente != null) {
            barRepository.eliminarBar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
