package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CuentaSalonPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idcuenta", referencedColumnName = "id")
    private CuentaTotal cuentaTotal;

    @ManyToOne
    @JoinColumn(name = "idreservasalon", referencedColumnName = "id")
    private ReservaSalon reservaSalon;

    public CuentaSalonPK() {
        super();
    }

    public CuentaSalonPK(CuentaTotal cuentaTotal, ReservaSalon reservaSalon) {
        super();
        this.cuentaTotal = cuentaTotal;
        this.reservaSalon = reservaSalon;
    }

    public CuentaTotal getCuentaTotal() {
        return cuentaTotal;
    }

    public void setCuentaTotal(CuentaTotal cuentaTotal) {
        this.cuentaTotal = cuentaTotal;
    }

    public ReservaSalon getReservaSalon() {
        return reservaSalon;
    }

    public void setReservaSalon(ReservaSalon reservaSalon) {
        this.reservaSalon = reservaSalon;
    }
}
