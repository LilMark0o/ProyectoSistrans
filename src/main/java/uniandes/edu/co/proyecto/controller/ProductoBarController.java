package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.ProductoBar;
import uniandes.edu.co.proyecto.repositorio.ProductoBarRepository;

import java.util.List;

@RestController
@RequestMapping("/api/productobar")
public class ProductoBarController {

    @Autowired
    private ProductoBarRepository ProductoBarRepository;

    @PostMapping("/")
    public ProductoBar crearProductoBar(@RequestBody ProductoBar ProductoBar) {
        return ProductoBarRepository.save(ProductoBar);
    }

    @GetMapping("/")
    public List<ProductoBar> consultarProductoBars() {
        return (List<ProductoBar>) ProductoBarRepository.darProductosBar();
    }

    @GetMapping("/{idproducto}/{idBar}")
    public ResponseEntity<ProductoBar> consultarProductoBarPorId(
            @PathVariable(value = "idproducto") Integer idproducto,
            @PathVariable(value = "idBar") Integer idBar) {
        ProductoBar ProductoBar = ProductoBarRepository.findProductoBarByID(idproducto, idBar);
        if (ProductoBar != null) {
            return ResponseEntity.ok(ProductoBar);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idproducto}/{idBar}")

    public ResponseEntity<ProductoBar> actualizarProductoBar(
            @PathVariable(value = "idproducto") Integer idproducto,
            @PathVariable(value = "idBar") Integer idBar,
            @RequestBody ProductoBar ProductoBarDetalles) {
        ProductoBar ProductoBar = ProductoBarRepository.findProductoBarByID(idproducto,
                idBar);
        if (ProductoBar != null) {
            ProductoBar.setPk(ProductoBarDetalles.getPk());
            ProductoBar ProductoBarActualizado = ProductoBarRepository.save(ProductoBar);
            return ResponseEntity.ok(ProductoBarActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idproducto}/{idBar}/delete")

    public ResponseEntity<Void> borrarProductoBar(@PathVariable(value = "idproducto") Integer idproducto,
            @PathVariable(value = "idBar") Integer idBar) {
        ProductoBar ProductoBar = ProductoBarRepository.findProductoBarByID(idproducto,
                idBar);
        if (ProductoBar != null) {
            ProductoBarRepository.delete(ProductoBar);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
