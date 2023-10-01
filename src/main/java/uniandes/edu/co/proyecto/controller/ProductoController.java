package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

import java.util.Collection;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository ProductoRepository;

    @GetMapping
    public Collection<Producto> listarProductos() {
        return ProductoRepository.darProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Integer id) {
        Producto Producto = ProductoRepository.darProductoPorId(id);
        if (Producto != null) {
            return new ResponseEntity<>(Producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto Producto) {
        ProductoRepository.insertarProducto(Producto.getId(), Producto.getprecio(), Producto.getNombre());
        return new ResponseEntity<>(Producto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto Producto) {
        if (ProductoRepository.darProductoPorId(id) != null) {
            ProductoRepository.actualizarProducto(Producto.getId(), Producto.getprecio(), Producto.getNombre());
            return new ResponseEntity<>(Producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        if (ProductoRepository.darProductoPorId(id) != null) {
            ProductoRepository.eliminarProducto(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}