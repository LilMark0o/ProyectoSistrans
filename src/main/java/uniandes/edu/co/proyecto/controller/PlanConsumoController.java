package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.repositorio.PlanConsumoRepository;

import java.util.Collection;

@RestController
@RequestMapping("/api/planesconsumo")
public class PlanConsumoController {

    @Autowired
    private PlanConsumoRepository planConsumoRepository;

    @GetMapping
    public Collection<PlanConsumo> listarPlanesConsumo() {
        return planConsumoRepository.darPlanesConsumo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanConsumo> obtenerPlanConsumoPorId(@PathVariable Integer id) {
        PlanConsumo planConsumo = planConsumoRepository.darPlanConsumoPorId(id);
        if (planConsumo != null) {
            return new ResponseEntity<>(planConsumo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PlanConsumo> crearPlanConsumo(@RequestBody PlanConsumo planConsumo) {
        planConsumoRepository.insertarPlanConsumo(planConsumo.getId(), planConsumo.getDescripcion(), planConsumo.getDescuento(), planConsumo.getHotel().getId());
        return new ResponseEntity<>(planConsumo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanConsumo> actualizarPlanConsumo(@PathVariable Integer id, @RequestBody PlanConsumo planConsumo) {
        if (planConsumoRepository.darPlanConsumoPorId(id) != null) {
            planConsumoRepository.actualizarPlanConsumo(planConsumo.getId(), planConsumo.getDescripcion(), planConsumo.getDescuento(), planConsumo.getHotel().getId());
            return new ResponseEntity<>(planConsumo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPlanConsumo(@PathVariable Integer id) {
        if (planConsumoRepository.darPlanConsumoPorId(id) != null) {
            planConsumoRepository.eliminarPlanConsumo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
