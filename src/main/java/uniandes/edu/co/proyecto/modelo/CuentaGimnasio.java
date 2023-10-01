package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentagimnasio")
public class CuentaGimnasio {

    @EmbeddedId
    private CuentaGimnasioPK pk;

    public CuentaGimnasio() {
        ;
    }

    public CuentaGimnasio(CuentaTotal cuenta, Gimnasio gimnasio) {
        this.pk = new CuentaGimnasioPK(cuenta, gimnasio);
    }

    public CuentaGimnasioPK getPk() {
        return pk;
    }

    public void setPk(CuentaGimnasioPK pk) {
        this.pk = pk;
    }

}
