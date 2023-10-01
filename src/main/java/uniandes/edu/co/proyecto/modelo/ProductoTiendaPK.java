package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ProductoTiendaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idproducto", referencedColumnName = "id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idtienda", referencedColumnName = "id")
    private Tienda tienda;

    public ProductoTiendaPK() {
        super();
    }

    public ProductoTiendaPK(Producto producto, Tienda tienda) {
        super();
        this.producto = producto;
        this.tienda = tienda;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
