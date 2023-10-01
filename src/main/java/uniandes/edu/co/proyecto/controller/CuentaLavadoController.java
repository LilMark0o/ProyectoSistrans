package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.CuentaLavado;
import uniandes.edu.co.proyecto.repositorio.CuentaLavadoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cuentalavado")
public class CuentaLavadoController {

    @Autowired
    private CuentaLavadoRepository CuentaLavadoRepository;

    @PostMapping("/")
    public CuentaLavado crearCuentaLavado(@RequestBody CuentaLavado CuentaLavado) {
        return CuentaLavadoRepository.save(CuentaLavado);
    }

    @GetMapping("/")
    public List<CuentaLavado> consultarCuentaLavados() {
        return (List<CuentaLavado>) CuentaLavadoRepository.findAllCuentaLavado();
    }

    @GetMapping("/{idcuenta}/{idlavado}")
    public ResponseEntity<CuentaLavado> consultarCuentaLavadoPorId(
            @PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idlavado") Integer idlavado) {
        CuentaLavado CuentaLavado = CuentaLavadoRepository.findCuentaLavadoById(idcuenta,
                idlavado);
        if (CuentaLavado != null) {
            return ResponseEntity.ok(CuentaLavado);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idcuenta}/{idlavado}")

    public ResponseEntity<CuentaLavado> actualizarCuentaLavado(
            @PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idlavado") Integer idlavado,
            @RequestBody CuentaLavado CuentaLavadoDetalles) {
        CuentaLavado CuentaLavado = CuentaLavadoRepository.findCuentaLavadoById(idcuenta,
                idlavado);
        if (CuentaLavado != null) {
            CuentaLavado.setPk(CuentaLavadoDetalles.getPk());
            CuentaLavado CuentaLavadoActualizado = CuentaLavadoRepository.save(CuentaLavado);
            return ResponseEntity.ok(CuentaLavadoActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idcuenta}/{idlavado}/delete")

    public ResponseEntity<Void> borrarCuentaLavado(@PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idlavado") Integer idlavado) {
        CuentaLavado CuentaLavado = CuentaLavadoRepository.findCuentaLavadoById(idcuenta,
                idlavado);
        if (CuentaLavado != null) {
            CuentaLavadoRepository.delete(CuentaLavado);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
