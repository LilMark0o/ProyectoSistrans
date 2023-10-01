package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ProductoBarPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idproducto", referencedColumnName = "id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idbar", referencedColumnName = "id")
    private Bar bar;

    public ProductoBarPK() {
        super();
    }

    public ProductoBarPK(Producto producto, Bar bar) {
        super();
        this.producto = producto;
        this.bar = bar;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }
}
