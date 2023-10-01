package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentaPiscina")
public class CuentaPiscina {

    @EmbeddedId
    private CuentaPiscinaPK pk;

    public CuentaPiscina() {
        ;
    }

    public CuentaPiscina(CuentaTotal cuenta, Piscina piscina) {
        this.pk = new CuentaPiscinaPK(cuenta, piscina);
    }

    public CuentaPiscinaPK getPk() {
        return pk;
    }

    public void setPk(CuentaPiscinaPK pk) {
        this.pk = pk;
    }

}
