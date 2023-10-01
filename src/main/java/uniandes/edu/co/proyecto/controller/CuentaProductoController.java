package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.CuentaProducto;
import uniandes.edu.co.proyecto.repositorio.CuentaProductoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cuentaproducto")
public class CuentaProductoController {

    @Autowired
    private CuentaProductoRepository CuentaProductoRepository;

    @PostMapping("/")
    public CuentaProducto crearCuentaProducto(@RequestBody CuentaProducto CuentaProducto) {
        return CuentaProductoRepository.save(CuentaProducto);
    }

    @GetMapping("/")
    public List<CuentaProducto> consultarCuentaProductos() {
        return (List<CuentaProducto>) CuentaProductoRepository.findAllCuentaProducto();
    }

    @GetMapping("/{idcuenta}/{idproducto}")
    public ResponseEntity<CuentaProducto> consultarCuentaProductoPorId(
            @PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idproducto") Integer idproducto) {
        CuentaProducto CuentaProducto = CuentaProductoRepository.findCuentaProductoById(idcuenta,
                idproducto);
        if (CuentaProducto != null) {
            return ResponseEntity.ok(CuentaProducto);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idcuenta}/{idproducto}")

    public ResponseEntity<CuentaProducto> actualizarCuentaProducto(
            @PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idproducto") Integer idproducto,
            @RequestBody CuentaProducto CuentaProductoDetalles) {
        CuentaProducto CuentaProducto = CuentaProductoRepository.findCuentaProductoById(idcuenta,
                idproducto);
        if (CuentaProducto != null) {
            CuentaProducto.setPk(CuentaProductoDetalles.getPk());
            CuentaProducto CuentaProductoActualizado = CuentaProductoRepository.save(CuentaProducto);
            return ResponseEntity.ok(CuentaProductoActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idcuenta}/{idproducto}/delete")

    public ResponseEntity<Void> borrarCuentaProducto(@PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idproducto") Integer idproducto) {
        CuentaProducto CuentaProducto = CuentaProductoRepository.findCuentaProductoById(idcuenta,
                idproducto);
        if (CuentaProducto != null) {
            CuentaProductoRepository.delete(CuentaProducto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
