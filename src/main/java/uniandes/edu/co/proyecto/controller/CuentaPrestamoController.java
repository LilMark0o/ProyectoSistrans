package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.CuentaPrestamo;
import uniandes.edu.co.proyecto.repositorio.CuentaPrestamoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cuentaprestamo")
public class CuentaPrestamoController {

    @Autowired
    private CuentaPrestamoRepository CuentaPrestamoRepository;

    @PostMapping("/")
    public CuentaPrestamo crearCuentaPrestamo(@RequestBody CuentaPrestamo CuentaPrestamo) {
        return CuentaPrestamoRepository.save(CuentaPrestamo);
    }

    @GetMapping("/")
    public List<CuentaPrestamo> consultarCuentaPrestamos() {
        return (List<CuentaPrestamo>) CuentaPrestamoRepository.findAllCuentaPrestamo();
    }

    @GetMapping("/{idcuenta}/{idprestamo}")
    public ResponseEntity<CuentaPrestamo> consultarCuentaPrestamoPorId(
            @PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idprestamo") Integer idprestamo) {
        CuentaPrestamo CuentaPrestamo = CuentaPrestamoRepository.findCuentaPrestamoById(idcuenta, idprestamo);
        if (CuentaPrestamo != null) {
            return ResponseEntity.ok(CuentaPrestamo);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idcuenta}/{idprestamo}")
    public ResponseEntity<CuentaPrestamo> actualizarCuentaPrestamo(@PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idprestamo") Integer idprestamo,
            @RequestBody CuentaPrestamo CuentaPrestamoDetalles) {
        CuentaPrestamo CuentaPrestamo = CuentaPrestamoRepository.findCuentaPrestamoById(idcuenta, idprestamo);
        if (CuentaPrestamo != null) {
            CuentaPrestamo.setPk(CuentaPrestamoDetalles.getPk());
            CuentaPrestamo CuentaPrestamoActualizado = CuentaPrestamoRepository.save(CuentaPrestamo);
            return ResponseEntity.ok(CuentaPrestamoActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idcuenta}/{idprestamo}/delete")
    public ResponseEntity<Void> borrarCuentaPrestamo(@PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idprestamo") Integer idprestamo) {
        CuentaPrestamo CuentaPrestamo = CuentaPrestamoRepository.findCuentaPrestamoById(idcuenta, idprestamo);
        if (CuentaPrestamo != null) {
            CuentaPrestamoRepository.delete(CuentaPrestamo);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
