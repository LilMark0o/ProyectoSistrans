package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.ProductoTienda;
import uniandes.edu.co.proyecto.repositorio.ProductoTiendaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/productotienda")
public class ProductoTiendaController {

    @Autowired
    private ProductoTiendaRepository ProductoTiendaRepository;

    @PostMapping("/")
    public ProductoTienda crearProductoTienda(@RequestBody ProductoTienda ProductoTienda) {
        return ProductoTiendaRepository.save(ProductoTienda);
    }

    @GetMapping("/")
    public List<ProductoTienda> consultarProductoTiendas() {
        return (List<ProductoTienda>) ProductoTiendaRepository.darProductosTienda();
    }

    @GetMapping("/{idproducto}/{idTienda}")
    public ResponseEntity<ProductoTienda> consultarProductoTiendaPorId(
            @PathVariable(value = "idproducto") Integer idproducto,
            @PathVariable(value = "idTienda") Integer idTienda) {
        ProductoTienda ProductoTienda = ProductoTiendaRepository.findProductoTiendaByID(idproducto, idTienda);
        if (ProductoTienda != null) {
            return ResponseEntity.ok(ProductoTienda);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idproducto}/{idTienda}")

    public ResponseEntity<ProductoTienda> actualizarProductoTienda(
            @PathVariable(value = "idproducto") Integer idproducto,
            @PathVariable(value = "idTienda") Integer idTienda,
            @RequestBody ProductoTienda ProductoTiendaDetalles) {
        ProductoTienda ProductoTienda = ProductoTiendaRepository.findProductoTiendaByID(idproducto,
                idTienda);
        if (ProductoTienda != null) {
            ProductoTienda.setPk(ProductoTiendaDetalles.getPk());
            ProductoTienda ProductoTiendaActualizado = ProductoTiendaRepository.save(ProductoTienda);
            return ResponseEntity.ok(ProductoTiendaActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idproducto}/{idTienda}/delete")

    public ResponseEntity<Void> borrarProductoTienda(@PathVariable(value = "idproducto") Integer idproducto,
            @PathVariable(value = "idTienda") Integer idTienda) {
        ProductoTienda ProductoTienda = ProductoTiendaRepository.findProductoTiendaByID(idproducto,
                idTienda);
        if (ProductoTienda != null) {
            ProductoTiendaRepository.delete(ProductoTienda);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
