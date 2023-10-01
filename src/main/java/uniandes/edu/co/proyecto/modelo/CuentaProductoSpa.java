package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentaProductoSpa")
public class CuentaProductoSpa {

    @EmbeddedId
    private CuentaProductoSpaPK pk;

    public CuentaProductoSpa() {
        ;
    }

    public CuentaProductoSpa(CuentaTotal cuenta, ProductoSpa productoSpa) {
        this.pk = new CuentaProductoSpaPK(cuenta, productoSpa);
    }

    public CuentaProductoSpaPK getPk() {
        return pk;
    }

    public void setPk(CuentaProductoSpaPK pk) {
        this.pk = pk;
    }

}
