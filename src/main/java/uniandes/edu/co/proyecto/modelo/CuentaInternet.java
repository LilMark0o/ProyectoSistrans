package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentaInternet")
public class CuentaInternet {

    @EmbeddedId
    private CuentaInternetPK pk;

    public CuentaInternet() {
        ;
    }

    public CuentaInternet(CuentaTotal cuentaTotal, Internet internet) {
        this.pk = new CuentaInternetPK(cuentaTotal, internet);
    }

    public CuentaInternetPK getPk() {
        return pk;
    }

    public void setPk(CuentaInternetPK pk) {
        this.pk = pk;
    }
}
