package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CuentaProductoSpaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idcuenta", referencedColumnName = "id")
    private CuentaTotal cuentaTotal;

    @ManyToOne
    @JoinColumn(name = "idproductospa", referencedColumnName = "id")
    private ProductoSpa productoSpa;

    public CuentaProductoSpaPK() {
        super();
    }

    public CuentaProductoSpaPK(CuentaTotal cuentaTotal, ProductoSpa productoSpa) {
        super();
        this.cuentaTotal = cuentaTotal;
        this.productoSpa = productoSpa;
    }

    public CuentaTotal getCuentaTotal() {
        return cuentaTotal;
    }

    public void setCuentaTotal(CuentaTotal cuentaTotal) {
        this.cuentaTotal = cuentaTotal;
    }

    public ProductoSpa getProductoSpa() {
        return productoSpa;
    }

    public void setProductoSpa(ProductoSpa productoSpa) {
        this.productoSpa = productoSpa;
    }
}
