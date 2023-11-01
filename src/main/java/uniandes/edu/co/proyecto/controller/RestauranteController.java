// package uniandes.edu.co.proyecto.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import uniandes.edu.co.proyecto.modelo.Restaurante;
// import uniandes.edu.co.proyecto.repositorio.RestauranteRepository;

// import java.util.Collection;

// @RestController
// @RequestMapping("/api/restaurantes")
// public class RestauranteController {

// @Autowired
// private RestauranteRepository restauranteRepository;

// @GetMapping
// public Collection<Restaurante> listarRestaurantes() {
// return restauranteRepository.darRestaurantes();
// }

// @GetMapping("/{id}")
// public ResponseEntity<Restaurante> obtenerRestaurantePorId(@PathVariable
// Integer id) {
// Restaurante restaurante = restauranteRepository.darRestaurantePorId(id);
// if (restaurante != null) {
// return new ResponseEntity<>(restaurante, HttpStatus.OK);
// } else {
// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// }
// }

// @PostMapping
// public ResponseEntity<Restaurante> crearRestaurante(@RequestBody Restaurante
// restaurante) {
// restauranteRepository.insertarRestaurante(restaurante.getId(),
// restaurante.getHotel().getId());
// return new ResponseEntity<>(restaurante, HttpStatus.CREATED);
// }

// @PutMapping("/{id}")
// public ResponseEntity<Restaurante> actualizarRestaurante(@PathVariable
// Integer id,
// @RequestBody Restaurante restaurante) {
// if (restauranteRepository.darRestaurantePorId(id) != null) {
// restauranteRepository.actualizarRestaurante(restaurante.getId(),
// restaurante.getHotel().getId());
// return new ResponseEntity<>(restaurante, HttpStatus.OK);
// } else {
// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// }
// }

// @DeleteMapping("/{id}/delete")
// public ResponseEntity<Void> eliminarRestaurante(@PathVariable Integer id) {
// if (restauranteRepository.darRestaurantePorId(id) != null) {
// restauranteRepository.eliminarRestaurante(id);
// return new ResponseEntity<>(HttpStatus.OK);
// } else {
// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// }
// }
// }
