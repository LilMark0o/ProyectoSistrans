package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    // Crear una nueva habitación
    @PostMapping("/")
    public Habitacion crearHabitacion(@RequestBody Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    // Consultar todas las habitaciones
    @GetMapping("/")
    public List<Habitacion> consultarHabitaciones() {
        return (List<Habitacion>) habitacionRepository.darHabitaciones();
    }

    // Consultar una habitación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> consultarHabitacionPorId(@PathVariable(value = "id") Integer habitacionId) {
        Habitacion habitacion = habitacionRepository.darHabitacionPorId(habitacionId);
        if (habitacion != null) {
            return ResponseEntity.ok(habitacion);
        }
        return ResponseEntity.notFound().build();
    }

    // Consultar habitaciones por tipo
    @GetMapping("/tipo/{tipoHabitacion}")
    public List<Habitacion> consultarHabitacionesPorTipo(@PathVariable String tipoHabitacion) {
        return (List<Habitacion>) habitacionRepository.darHabitacionesPorTipo(tipoHabitacion);
    }

    // Actualizar una habitación
    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> actualizarHabitacion(@PathVariable(value = "id") Integer habitacionId, @RequestBody Habitacion habitacionDetalles) {
        Habitacion habitacion = habitacionRepository.darHabitacionPorId(habitacionId);
        if (habitacion != null) {
            habitacion.setCapacidad(habitacionDetalles.getCapacidad());
            habitacion.setCostonoche(habitacionDetalles.getCostonoche());
            habitacion.setTipohabitacion(habitacionDetalles.getTipohabitacion());
            habitacion.setHotel(habitacionDetalles.getHotel());
            Habitacion habitacionActualizada = habitacionRepository.save(habitacion);
            return ResponseEntity.ok(habitacionActualizada);
        }
        return ResponseEntity.notFound().build();
    }

    // Borrar una habitación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarHabitacion(@PathVariable(value = "id") Integer habitacionId) {
        Habitacion habitacion = habitacionRepository.darHabitacionPorId(habitacionId);
        if (habitacion != null) {
            habitacionRepository.delete(habitacion);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
