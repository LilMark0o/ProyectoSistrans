package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Lavado;
import uniandes.edu.co.proyecto.repositorio.LavadoRepository;

import java.util.List;

@RestController
@RequestMapping("/lavados")
public class LavadoController {

    @Autowired
    private LavadoRepository lavadoRepository;

    @GetMapping
    public ResponseEntity<List<Lavado>> getAllLavados() {
        List<Lavado> lavados = lavadoRepository.findAll();
        return new ResponseEntity<>(lavados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lavado> getLavadoById(@PathVariable Long id) {
        Lavado lavado = lavadoRepository.findById(id).orElse(null);
        if (lavado != null) {
            return new ResponseEntity<>(lavado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Lavado> createLavado(@RequestBody Lavado lavado) {
        Lavado createdLavado = lavadoRepository.save(lavado);
        return new ResponseEntity<>(createdLavado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lavado> updateLavado(@PathVariable Long id, @RequestBody Lavado lavado) {
        Lavado existingLavado = lavadoRepository.findById(id).orElse(null);
        if (existingLavado != null) {
            existingLavado.setTipo(lavado.getTipo());
            existingLavado.setPrecio(lavado.getPrecio());
            Lavado updatedLavado = lavadoRepository.save(existingLavado);
            return new ResponseEntity<>(updatedLavado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLavado(@PathVariable Long id) {
        Lavado existingLavado = lavadoRepository.findById(id).orElse(null);
        if (existingLavado != null) {
            lavadoRepository.delete(existingLavado);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}