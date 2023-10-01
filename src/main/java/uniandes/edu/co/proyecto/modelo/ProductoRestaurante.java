package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "productoRestaurante")
public class ProductoRestaurante {

    @EmbeddedId
    private ProductoRestaurantePK pk;

    public ProductoRestaurante() {
        ;
    }

    public ProductoRestaurante(Producto producto, Restaurante restaurante) {
        this.pk = new ProductoRestaurantePK(producto, restaurante);
    }

    public ProductoRestaurantePK getPk() {
        return pk;
    }

    public void setPk(ProductoRestaurantePK pk) {
        this.pk = pk;
    }
}
