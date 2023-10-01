package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Tienda;
import uniandes.edu.co.proyecto.repositorio.TiendaRepository;

import java.util.Collection;

@RestController
@RequestMapping("/api/tiendas")
public class TiendaController {

    @Autowired
    private TiendaRepository tiendaRepository;

    @GetMapping
    public Collection<Tienda> listarTiendas() {
        return tiendaRepository.darTiendas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tienda> obtenerTiendaPorId(@PathVariable Integer id) {
        Tienda tienda = tiendaRepository.darTiendaPorId(id);
        if (tienda != null) {
            return new ResponseEntity<>(tienda, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Tienda> crearTienda(@RequestBody Tienda tienda) {
        tiendaRepository.insertarTienda(tienda.getId(), tienda.getHotel().getId());
        return new ResponseEntity<>(tienda, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tienda> actualizarTienda(@PathVariable Integer id, @RequestBody Tienda tienda) {
        if (tiendaRepository.darTiendaPorId(id) != null) {
            tiendaRepository.actualizarTienda(tienda.getId(), tienda.getHotel().getId());
            return new ResponseEntity<>(tienda, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> eliminarTienda(@PathVariable Integer id) {
        if (tiendaRepository.darTiendaPorId(id) != null) {
            tiendaRepository.eliminarTienda(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}