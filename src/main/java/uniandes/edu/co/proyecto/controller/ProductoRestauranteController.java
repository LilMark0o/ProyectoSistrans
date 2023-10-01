package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.ProductoRestaurante;
import uniandes.edu.co.proyecto.repositorio.ProductoRestauranteRepository;

import java.util.List;

@RestController
@RequestMapping("/api/productorestaurante")
public class ProductoRestauranteController {

    @Autowired
    private ProductoRestauranteRepository ProductoRestauranteRepository;

    @PostMapping("/")
    public ProductoRestaurante crearProductoRestaurante(@RequestBody ProductoRestaurante ProductoRestaurante) {
        return ProductoRestauranteRepository.save(ProductoRestaurante);
    }

    @GetMapping("/")
    public List<ProductoRestaurante> consultarProductoRestaurantes() {
        return (List<ProductoRestaurante>) ProductoRestauranteRepository.darProductosRestaurante();
    }

    @GetMapping("/{idproducto}/{idRestaurante}")
    public ResponseEntity<ProductoRestaurante> consultarProductoRestaurantePorId(
            @PathVariable(value = "idproducto") Integer idproducto,
            @PathVariable(value = "idRestaurante") Integer idRestaurante) {
        ProductoRestaurante ProductoRestaurante = ProductoRestauranteRepository.findProductoRestauranteByID(idproducto,
                idRestaurante);
        if (ProductoRestaurante != null) {
            return ResponseEntity.ok(ProductoRestaurante);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idproducto}/{idRestaurante}")

    public ResponseEntity<ProductoRestaurante> actualizarProductoRestaurante(
            @PathVariable(value = "idproducto") Integer idproducto,
            @PathVariable(value = "idRestaurante") Integer idRestaurante,
            @RequestBody ProductoRestaurante ProductoRestauranteDetalles) {
        ProductoRestaurante ProductoRestaurante = ProductoRestauranteRepository.findProductoRestauranteByID(idproducto,
                idRestaurante);
        if (ProductoRestaurante != null) {
            ProductoRestaurante.setPk(ProductoRestauranteDetalles.getPk());
            ProductoRestaurante ProductoRestauranteActualizado = ProductoRestauranteRepository
                    .save(ProductoRestaurante);
            return ResponseEntity.ok(ProductoRestauranteActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idproducto}/{idRestaurante}/delete")

    public ResponseEntity<Void> borrarProductoRestaurante(@PathVariable(value = "idproducto") Integer idproducto,
            @PathVariable(value = "idRestaurante") Integer idRestaurante) {
        ProductoRestaurante ProductoRestaurante = ProductoRestauranteRepository.findProductoRestauranteByID(idproducto,
                idRestaurante);
        if (ProductoRestaurante != null) {
            ProductoRestauranteRepository.delete(ProductoRestaurante);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
