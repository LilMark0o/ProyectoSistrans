// package uniandes.edu.co.proyecto.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import uniandes.edu.co.proyecto.modelo.Lavado;
// import uniandes.edu.co.proyecto.repositorio.LavadoRepository;

// import java.util.Collection;

// @RestController
// @RequestMapping("/api/lavado")
// public class LavadoController {

//     @Autowired
//     private LavadoRepository lavadoRepository;

//     @GetMapping
//     public ResponseEntity<Collection<Lavado>> listarServiciosLavado() {
//         return ResponseEntity.ok(lavadoRepository.darServiciosLavado());
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Lavado> obtenerLavadoPorId(@PathVariable Integer id) {
//         Lavado lavado = lavadoRepository.darLavadoPorId(id);
//         if (lavado != null) {
//             return ResponseEntity.ok(lavado);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @PostMapping
//     public ResponseEntity<Lavado> crearLavado(@RequestBody Lavado lavado) {
//         lavadoRepository.insertarLavado(lavado.getId(), lavado.getPrecio(), lavado.getCantidadalavar());
//         return ResponseEntity.ok(lavado); // Similarmente, podrías querer devolver el objeto completo con el ID
//                                           // asignado.
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Lavado> actualizarLavado(@PathVariable Integer id, @RequestBody Lavado lavado) {
//         Lavado lavadoExistente = lavadoRepository.darLavadoPorId(id);
//         if (lavadoExistente != null) {
//             lavadoRepository.actualizarLavado(id, lavado.getPrecio(), lavado.getCantidadalavar());
//             return ResponseEntity.ok(lavado);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @DeleteMapping("/{id}/delete")
//     public ResponseEntity<Void> eliminarLavado(@PathVariable Integer id) {
//         Lavado lavadoExistente = lavadoRepository.darLavadoPorId(id);
//         if (lavadoExistente != null) {
//             lavadoRepository.eliminarLavado(id);
//             return ResponseEntity.noContent().build();
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }
// }
