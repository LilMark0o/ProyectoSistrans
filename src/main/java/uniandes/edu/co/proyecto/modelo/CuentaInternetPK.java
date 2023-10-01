package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CuentaInternetPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idCuenta", referencedColumnName = "id")
    private CuentaTotal cuentaTotal;

    @ManyToOne
    @JoinColumn(name = "idInternet", referencedColumnName = "id")
    private Internet internet;

    public CuentaInternetPK(CuentaTotal cuentaTotal, Internet internet) {
        super();
        this.cuentaTotal = cuentaTotal;
        this.internet = internet;
    }

    public CuentaInternetPK() {
        super();
    }
    public CuentaTotal getCuentaTotal() {
        return cuentaTotal;
    }

    public void setCuentaTotal(CuentaTotal cuentaTotal) {
        this.cuentaTotal = cuentaTotal;
    }

    public Internet getInternet() {
        return internet;
    }

    public void setInternet(Internet internet) {
        this.internet = internet;
    }
}
