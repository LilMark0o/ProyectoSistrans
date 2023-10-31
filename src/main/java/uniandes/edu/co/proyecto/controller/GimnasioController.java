// package uniandes.edu.co.proyecto.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import uniandes.edu.co.proyecto.modelo.Gimnasio;
// import uniandes.edu.co.proyecto.repositorio.GimnasioRepository;

// import java.util.Collection;

// @RestController
// @RequestMapping("/api/gimnasios")
// public class GimnasioController {

//     @Autowired
//     private GimnasioRepository gimnasioRepository;

//     @GetMapping
//     public ResponseEntity<Collection<Gimnasio>> listarGimnasios() {
//         return ResponseEntity.ok(gimnasioRepository.darGimnasios());
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Gimnasio> obtenerGimnasioPorId(@PathVariable Integer id) {
//         Gimnasio gimnasio = gimnasioRepository.darGimnasioPorId(id);
//         if (gimnasio != null) {
//             return ResponseEntity.ok(gimnasio);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @PostMapping
//     public ResponseEntity<Gimnasio> crearGimnasio(@RequestBody Gimnasio gimnasio) {
//         gimnasioRepository.insertarGimnasio(gimnasio.getId(), gimnasio.getHorainicio(), gimnasio.getHorafin(),
//                 gimnasio.getSecobra(), gimnasio.getHotel().getId());
//         return ResponseEntity.ok(gimnasio);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Gimnasio> actualizarGimnasio(@PathVariable Integer id, @RequestBody Gimnasio gimnasio) {
//         Gimnasio gimnasioExistente = gimnasioRepository.darGimnasioPorId(id);
//         if (gimnasioExistente != null) {
//             gimnasioRepository.actualizarGimnasio(id, gimnasio.getHorainicio(), gimnasio.getHorafin(),
//                     gimnasio.getSecobra(), gimnasio.getHotel().getId());
//             return ResponseEntity.ok(gimnasio);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @DeleteMapping("/{id}/delete")
//     public ResponseEntity<Void> eliminarGimnasio(@PathVariable Integer id) {
//         Gimnasio gimnasioExistente = gimnasioRepository.darGimnasioPorId(id);
//         if (gimnasioExistente != null) {
//             gimnasioRepository.eliminarGimnasio(id);
//             return ResponseEntity.noContent().build();
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }
// }
