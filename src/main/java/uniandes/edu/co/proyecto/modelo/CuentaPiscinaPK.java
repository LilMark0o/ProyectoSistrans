package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CuentaPiscinaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idCuenta", referencedColumnName = "id")
    private CuentaTotal cuentaTotal;

    @ManyToOne
    @JoinColumn(name = "idPiscina", referencedColumnName = "id")
    private Piscina piscina;

    public CuentaPiscinaPK() {
        ;
    }

    public CuentaPiscinaPK(CuentaTotal cuentaTotal, Piscina piscina) {
        super();
        this.cuentaTotal = cuentaTotal;
        this.piscina = piscina;
    }

    public CuentaTotal getCuentaTotal() {
        return cuentaTotal;
    }

    public void setCuentaTotal(CuentaTotal cuentaTotal) {
        this.cuentaTotal = cuentaTotal;
    }

    public Piscina getPiscina() {
        return piscina;
    }

    public void setPiscina(Piscina piscina) {
        this.piscina = piscina;
    }
}
