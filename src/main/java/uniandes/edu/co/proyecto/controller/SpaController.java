// package uniandes.edu.co.proyecto.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import uniandes.edu.co.proyecto.modelo.Spa;
// import uniandes.edu.co.proyecto.repositorio.SpaRepository;

// import java.util.Collection;

// @RestController
// @RequestMapping("/api/spas")
// public class SpaController {

// @Autowired
// private SpaRepository spaRepository;

// @GetMapping
// public Collection<Spa> listarSpas() {
// return spaRepository.darSpas();
// }

// @GetMapping("/{id}")
// public ResponseEntity<Spa> obtenerSpaPorId(@PathVariable Integer id) {
// Spa spa = spaRepository.darSpaPorId(id);
// if (spa != null) {
// return new ResponseEntity<>(spa, HttpStatus.OK);
// } else {
// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// }
// }

// @PostMapping
// public ResponseEntity<Spa> crearSpa(@RequestBody Spa spa) {
// spaRepository.insertarSpa(spa.getId(), spa.getHotel().getId());
// return new ResponseEntity<>(spa, HttpStatus.CREATED);
// }

// @PutMapping("/{id}")
// public ResponseEntity<Spa> actualizarSpa(@PathVariable Integer id,
// @RequestBody Spa spa) {
// if (spaRepository.darSpaPorId(id) != null) {
// spaRepository.actualizarSpa(spa.getId(), spa.getHotel().getId());
// return new ResponseEntity<>(spa, HttpStatus.OK);
// } else {
// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// }
// }

// @DeleteMapping("/{id}/delete")
// public ResponseEntity<Void> eliminarSpa(@PathVariable Integer id) {
// if (spaRepository.darSpaPorId(id) != null) {
// spaRepository.eliminarSpa(id);
// return new ResponseEntity<>(HttpStatus.OK);
// } else {
// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// }
// }
// }