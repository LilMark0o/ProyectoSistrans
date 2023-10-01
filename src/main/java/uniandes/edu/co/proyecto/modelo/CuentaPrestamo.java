package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentaPrestamo")
public class CuentaPrestamo {

    @EmbeddedId
    private CuentaPrestamoPK pk;

    public CuentaPrestamo() {
        ;
    }

    public CuentaPrestamo(CuentaTotal cuenta, Prestamo prestamo) {
        this.pk = new CuentaPrestamoPK(cuenta, prestamo);
    }

    public CuentaPrestamoPK getPk() {
        return pk;
    }

    public void setPk(CuentaPrestamoPK pk) {
        this.pk = pk;
    }

}
