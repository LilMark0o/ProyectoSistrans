package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.CuentaGimnasio;
import uniandes.edu.co.proyecto.repositorio.CuentaGimnasioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cuentagimnasio")
public class CuentaGimnasioController {

    @Autowired
    private CuentaGimnasioRepository CuentaGimnasioRepository;

    @PostMapping("/")
    public CuentaGimnasio crearCuentaGimnasio(@RequestBody CuentaGimnasio CuentaGimnasio) {
        return CuentaGimnasioRepository.save(CuentaGimnasio);
    }

    @GetMapping("/")
    public List<CuentaGimnasio> consultarCuentaGimnasios() {
        return (List<CuentaGimnasio>) CuentaGimnasioRepository.findAllCuentaGimnasio();
    }

    @GetMapping("/{idcuenta}/{idgimnasio}")
    public ResponseEntity<CuentaGimnasio> consultarCuentaGimnasioPorId(
            @PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idgimnasio") Integer idgimnasio) {
        CuentaGimnasio CuentaGimnasio = CuentaGimnasioRepository.findCuentaGimnasioById(idcuenta, idgimnasio);
        if (CuentaGimnasio != null) {
            return ResponseEntity.ok(CuentaGimnasio);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idcuenta}/{idgimnasio}")
    public ResponseEntity<CuentaGimnasio> actualizarCuentaGimnasio(@PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idgimnasio") Integer idgimnasio,
            @RequestBody CuentaGimnasio CuentaGimnasioDetalles) {
        CuentaGimnasio CuentaGimnasio = CuentaGimnasioRepository.findCuentaGimnasioById(idcuenta, idgimnasio);
        if (CuentaGimnasio != null) {
            CuentaGimnasio.setPk(CuentaGimnasioDetalles.getPk());
            CuentaGimnasio CuentaGimnasioActualizado = CuentaGimnasioRepository.save(CuentaGimnasio);
            return ResponseEntity.ok(CuentaGimnasioActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idcuenta}/{idgimnasio}/delete")
    public ResponseEntity<Void> borrarCuentaGimnasio(@PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idgimnasio") Integer idgimnasio) {
        CuentaGimnasio CuentaGimnasio = CuentaGimnasioRepository.findCuentaGimnasioById(idcuenta, idgimnasio);
        if (CuentaGimnasio != null) {
            CuentaGimnasioRepository.delete(CuentaGimnasio);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
