package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ProductoRestaurantePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idproducto", referencedColumnName = "id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idrestaurante", referencedColumnName = "id")
    private Restaurante restaurante;

    public ProductoRestaurantePK() {
        super();
    }

    public ProductoRestaurantePK(Producto producto, Restaurante restaurante) {
        super();
        this.producto = producto;
        this.restaurante = restaurante;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
