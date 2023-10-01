package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CuentaLavadoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idcuenta", referencedColumnName = "id")
    private CuentaTotal cuentaTotal;

    @ManyToOne
    @JoinColumn(name = "idlavado", referencedColumnName = "id")
    private Lavado lavado;

    public CuentaLavadoPK() {
        super();
    }

    public CuentaLavadoPK(CuentaTotal cuentaTotal, Lavado lavado) {
        super();
        this.cuentaTotal = cuentaTotal;
        this.lavado = lavado;
    }

    public CuentaTotal getCuentaTotal() {
        return cuentaTotal;
    }

    public void setCuentaTotal(CuentaTotal cuentaTotal) {
        this.cuentaTotal = cuentaTotal;
    }

    public Lavado getLavado() {
        return lavado;
    }

    public void setLavado(Lavado lavado) {
        this.lavado = lavado;
    }
}
