package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "productotienda")
public class ProductoTienda {

    @EmbeddedId
    private ProductoTiendaPK pk;

    public ProductoTienda() {
        ;
    }

    public ProductoTienda(Producto producto, Tienda tienda) {
        this.pk = new ProductoTiendaPK(producto, tienda);
    }

    public ProductoTiendaPK getPk() {
        return pk;
    }

    public void setPk(ProductoTiendaPK pk) {
        this.pk = pk;
    }
}
