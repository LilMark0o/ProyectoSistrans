package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "productoBar")
public class ProductoBar {

    @EmbeddedId
    private ProductoBarPK pk;

    public ProductoBar() {
        ;
    }

    public ProductoBar(Producto producto, Bar bar) {
        this.pk = new ProductoBarPK(producto, bar);
    }

    public ProductoBarPK getPk() {
        return pk;
    }

    public void setPk(ProductoBarPK pk) {
        this.pk = pk;
    }
}
