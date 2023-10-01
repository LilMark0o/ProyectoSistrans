package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Piscina;
import uniandes.edu.co.proyecto.repositorio.PiscinaRepository;

import java.util.Collection;

@RestController
@RequestMapping("/api/piscinas")
public class PiscinaController {

    @Autowired
    private PiscinaRepository piscinaRepository;

    @GetMapping
    public Collection<Piscina> listarPiscinas() {
        return piscinaRepository.darPiscinas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Piscina> obtenerPiscinaPorId(@PathVariable Integer id) {
        Piscina piscina = piscinaRepository.darPiscinaPorId(id);
        if (piscina != null) {
            return new ResponseEntity<>(piscina, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Piscina> crearPiscina(@RequestBody Piscina piscina) {
        piscinaRepository.insertarPiscina(piscina.getId(), piscina.getProfundidad(), piscina.getHoraInicio(), piscina.getHoraFin(), piscina.getSecobra(), piscina.getHotel().getId());
        return new ResponseEntity<>(piscina, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Piscina> actualizarPiscina(@PathVariable Integer id, @RequestBody Piscina piscina) {
        if (piscinaRepository.darPiscinaPorId(id) != null) {
            piscinaRepository.actualizarPiscina(piscina.getId(), piscina.getProfundidad(), piscina.getHoraInicio(), piscina.getHoraFin(), piscina.getSecobra(), piscina.getHotel().getId());
            return new ResponseEntity<>(piscina, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPiscina(@PathVariable Integer id) {
        if (piscinaRepository.darPiscinaPorId(id) != null) {
            piscinaRepository.eliminarPiscina(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}