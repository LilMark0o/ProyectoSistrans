package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.CuentaSalon;
import uniandes.edu.co.proyecto.repositorio.CuentaSalonRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cuentasalon")
public class CuentaSalonController {

    @Autowired
    private CuentaSalonRepository CuentaSalonRepository;

    @PostMapping("/")
    public CuentaSalon crearCuentaSalon(@RequestBody CuentaSalon CuentaSalon) {
        return CuentaSalonRepository.save(CuentaSalon);
    }

    @GetMapping("/")
    public List<CuentaSalon> consultarCuentaSalons() {
        return (List<CuentaSalon>) CuentaSalonRepository.findAllCuentaSalon();
    }

    @GetMapping("/{idcuenta}/{idsalon}")
    public ResponseEntity<CuentaSalon> consultarCuentaSalonPorId(
            @PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idsalon") Integer idsalon) {
        CuentaSalon CuentaSalon = CuentaSalonRepository.findCuentaSalonById(idcuenta, idsalon);
        if (CuentaSalon != null) {
            return ResponseEntity.ok(CuentaSalon);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentaSalon> actualizarCuentaSalon(@PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idsalon") Integer idsalon,
            @RequestBody CuentaSalon CuentaSalonDetalles) {
        CuentaSalon CuentaSalon = CuentaSalonRepository.findCuentaSalonById(idcuenta, idsalon);
        if (CuentaSalon != null) {
            CuentaSalon.setPk(CuentaSalonDetalles.getPk());
            CuentaSalon CuentaSalonActualizado = CuentaSalonRepository.save(CuentaSalon);
            return ResponseEntity.ok(CuentaSalonActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarCuentaSalon(@PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idsalon") Integer idsalon) {
        CuentaSalon CuentaSalon = CuentaSalonRepository.findCuentaSalonById(idcuenta, idsalon);
        if (CuentaSalon != null) {
            CuentaSalonRepository.delete(CuentaSalon);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
