package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.repositorio.GimnasioRepository;

import java.util.Collection;

@RestController
@RequestMapping("/api/gimnasios")
public class GimnasioController {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @GetMapping
    public ResponseEntity<Collection<Gimnasio>> listarGimnasios() {
        return ResponseEntity.ok(gimnasioRepository.darGimnasios());
    }

    @GetMapping("/{servicio_id}")
    public ResponseEntity<Gimnasio> obtenerGimnasioPorId(@PathVariable Integer servicio_id) {
        Gimnasio gimnasio = gimnasioRepository.darGimnasioPorId(servicio_id);
        if (gimnasio != null) {
            return ResponseEntity.ok(gimnasio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Gimnasio> crearGimnasio(@RequestBody Gimnasio gimnasio) {
        gimnasioRepository.insertarGimnasio(gimnasio.getPk().getServicio().getId(), gimnasio.getHorainicio(),
                gimnasio.getHorafin());
        return ResponseEntity.ok(gimnasio);
    }

    @PutMapping("/{servicio_id}")
    public ResponseEntity<Gimnasio> actualizarGimnasio(@PathVariable Integer servicio_id,
            @RequestBody Gimnasio gimnasio) {
        Gimnasio gimnasioExistente = gimnasioRepository.darGimnasioPorId(servicio_id);
        if (gimnasioExistente != null) {
            gimnasioRepository.actualizarGimnasio(servicio_id, gimnasio.getHorainicio(), gimnasio.getHorafin());
            return ResponseEntity.ok(gimnasio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> eliminarGimnasio(@PathVariable Integer id) {
        Gimnasio gimnasioExistente = gimnasioRepository.darGimnasioPorId(id);
        if (gimnasioExistente != null) {
            gimnasioRepository.eliminarGimnasio(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}