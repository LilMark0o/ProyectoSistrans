package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.CuentaInternet;
import uniandes.edu.co.proyecto.repositorio.CuentaInternetRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cuentainternet")
public class CuentaInternetController {

    @Autowired
    private CuentaInternetRepository CuentaInternetRepository;

    @PostMapping("/")
    public CuentaInternet crearCuentaInternet(@RequestBody CuentaInternet CuentaInternet) {
        return CuentaInternetRepository.save(CuentaInternet);
    }

    @GetMapping("/")
    public List<CuentaInternet> consultarCuentaInternets() {
        return (List<CuentaInternet>) CuentaInternetRepository.findAllCuentaInternet();
    }

    @GetMapping("/{idcuenta}/{idinternet}")
    public ResponseEntity<CuentaInternet> consultarCuentaInternetPorId(
            @PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idinternet") Integer idinternet) {
        CuentaInternet CuentaInternet = CuentaInternetRepository.findCuentaInternetById(idcuenta,
                idinternet);
        if (CuentaInternet != null) {
            return ResponseEntity.ok(CuentaInternet);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idcuenta}/{idinternet}")

    public ResponseEntity<CuentaInternet> actualizarCuentaInternet(
            @PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idinternet") Integer idinternet,
            @RequestBody CuentaInternet CuentaInternetDetalles) {
        CuentaInternet CuentaInternet = CuentaInternetRepository.findCuentaInternetById(idcuenta,
                idinternet);
        if (CuentaInternet != null) {
            CuentaInternet.setPk(CuentaInternetDetalles.getPk());
            CuentaInternet CuentaInternetActualizado = CuentaInternetRepository.save(CuentaInternet);
            return ResponseEntity.ok(CuentaInternetActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idcuenta}/{idinternet}/delete")

    public ResponseEntity<Void> borrarCuentaInternet(@PathVariable(value = "idcuenta") Integer idcuenta,
            @PathVariable(value = "idinternet") Integer idinternet) {
        CuentaInternet CuentaInternet = CuentaInternetRepository.findCuentaInternetById(idcuenta,
                idinternet);
        if (CuentaInternet != null) {
            CuentaInternetRepository.delete(CuentaInternet);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
