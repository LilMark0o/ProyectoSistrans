package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.CuentaProductoSpa;
import uniandes.edu.co.proyecto.repositorio.CuentaProductoSpaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cuentaproductospa")
public class CuentaProductoSpaController {

    @Autowired
    private CuentaProductoSpaRepository CuentaProductoSpaRepository;

    @PostMapping("/")
    public CuentaProductoSpa crearCuentaProductoSpa(@RequestBody CuentaProductoSpa CuentaProductoSpa) {
        return CuentaProductoSpaRepository.save(CuentaProductoSpa);
    }

    @GetMapping("/")
    public List<CuentaProductoSpa> consultarCuentaProductoSpas() {
        return (List<CuentaProductoSpa>) CuentaProductoSpaRepository.findAllCuentaProductoSpa();
    }

    @GetMapping("/{idcuenta}/{idproductospa}")
    public ResponseEntity<CuentaProductoSpa> consultarCuentaProductoSpaPorId(
            @PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idproductospa") Integer idproductospa) {
        CuentaProductoSpa CuentaProductoSpa = CuentaProductoSpaRepository.findCuentaProductoSpaById(idcuenta,
                idproductospa);
        if (CuentaProductoSpa != null) {
            return ResponseEntity.ok(CuentaProductoSpa);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idcuenta}/{idproductospa}")

    public ResponseEntity<CuentaProductoSpa> actualizarCuentaProductoSpa(
            @PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idproductospa") Integer idproductospa,
            @RequestBody CuentaProductoSpa CuentaProductoSpaDetalles) {
        CuentaProductoSpa CuentaProductoSpa = CuentaProductoSpaRepository.findCuentaProductoSpaById(idcuenta,
                idproductospa);
        if (CuentaProductoSpa != null) {
            CuentaProductoSpa.setPk(CuentaProductoSpaDetalles.getPk());
            CuentaProductoSpa CuentaProductoSpaActualizado = CuentaProductoSpaRepository.save(CuentaProductoSpa);
            return ResponseEntity.ok(CuentaProductoSpaActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idcuenta}/{idproductospa}/delete")

    public ResponseEntity<Void> borrarCuentaProductoSpa(@PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idproductospa") Integer idproductospa) {
        CuentaProductoSpa CuentaProductoSpa = CuentaProductoSpaRepository.findCuentaProductoSpaById(idcuenta,
                idproductospa);
        if (CuentaProductoSpa != null) {
            CuentaProductoSpaRepository.delete(CuentaProductoSpa);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
