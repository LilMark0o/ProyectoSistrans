package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CuentaGimnasioPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idCuenta", referencedColumnName = "id")
    private CuentaTotal cuentaTotal;

    @ManyToOne
    @JoinColumn(name = "idGimnasio", referencedColumnName = "id")
    private Gimnasio gimnasio;

    public CuentaGimnasioPK(CuentaTotal cuentaTotal, Gimnasio gimnasio) {
        super();
        this.cuentaTotal = cuentaTotal;
        this.gimnasio = gimnasio;
    }

    public CuentaGimnasioPK() {
        super();
    }

    public CuentaTotal getCuentaTotal() {
        return cuentaTotal;
    }

    public void setCuentaTotal(CuentaTotal cuentaTotal) {
        this.cuentaTotal = cuentaTotal;
    }

    public Gimnasio getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }
}
