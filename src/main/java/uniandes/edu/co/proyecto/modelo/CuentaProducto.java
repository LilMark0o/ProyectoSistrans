package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentaProducto")
public class CuentaProducto {

    @EmbeddedId
    private CuentaProductoPK pk;

    public CuentaProducto() {
        ;
    }

    public CuentaProducto(CuentaTotal cuenta, Producto producto) {
        this.pk = new CuentaProductoPK(cuenta, producto);
    }

    public CuentaProductoPK getPk() {
        return pk;
    }

    public void setPk(CuentaProductoPK pk) {
        this.pk = pk;
    }

}
