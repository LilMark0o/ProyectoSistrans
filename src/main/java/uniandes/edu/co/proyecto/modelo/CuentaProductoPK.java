package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CuentaProductoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idcuenta", referencedColumnName = "id")
    private CuentaTotal cuentaTotal;

    @ManyToOne
    @JoinColumn(name = "idproducto", referencedColumnName = "id")
    private Producto producto;

    public CuentaProductoPK() {
        super();
    }

    public CuentaProductoPK(CuentaTotal cuentaTotal, Producto producto) {
        super();
        this.cuentaTotal = cuentaTotal;
        this.producto = producto;
    }

    public CuentaTotal getCuentaTotal() {
        return cuentaTotal;
    }

    public void setCuentaTotal(CuentaTotal cuentaTotal) {
        this.cuentaTotal = cuentaTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
