package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.CuentaPiscina;
import uniandes.edu.co.proyecto.repositorio.CuentaPiscinaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cuentapiscina")
public class CuentaPiscinaController {

    @Autowired
    private CuentaPiscinaRepository CuentaPiscinaRepository;

    @PostMapping("/")
    public CuentaPiscina crearCuentaPiscina(@RequestBody CuentaPiscina CuentaPiscina) {
        return CuentaPiscinaRepository.save(CuentaPiscina);
    }

    @GetMapping("/")
    public List<CuentaPiscina> consultarCuentaPiscinas() {
        return (List<CuentaPiscina>) CuentaPiscinaRepository.findAllCuentaPiscina();
    }

    @GetMapping("/{idcuenta}/{idpiscina}")
    public ResponseEntity<CuentaPiscina> consultarCuentaPiscinaPorId(@PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idpiscina") Integer idpiscina) {
        CuentaPiscina CuentaPiscina = CuentaPiscinaRepository.findCuentaPiscinaById(idcuenta, idpiscina);
        if (CuentaPiscina != null) {
            return ResponseEntity.ok(CuentaPiscina);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentaPiscina> actualizarCuentaPiscina(@PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idpiscina") Integer idpiscina,
            @RequestBody CuentaPiscina CuentaPiscinaDetalles) {
        CuentaPiscina CuentaPiscina = CuentaPiscinaRepository.findCuentaPiscinaById(idcuenta, idpiscina);
        if (CuentaPiscina != null) {
            CuentaPiscina.setPk(CuentaPiscinaDetalles.getPk());
            CuentaPiscina CuentaPiscinaActualizado = CuentaPiscinaRepository.save(CuentaPiscina);
            return ResponseEntity.ok(CuentaPiscinaActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarCuentaPiscina(@PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idpiscina") Integer idpiscina) {
        CuentaPiscina CuentaPiscina = CuentaPiscinaRepository.findCuentaPiscinaById(idcuenta, idpiscina);
        if (CuentaPiscina != null) {
            CuentaPiscinaRepository.delete(CuentaPiscina);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
