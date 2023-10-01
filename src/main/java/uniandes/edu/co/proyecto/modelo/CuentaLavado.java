package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentalavado")
public class CuentaLavado {

    @EmbeddedId
    private CuentaLavadoPK pk;

    public CuentaLavado() {
        ;
    }

    public CuentaLavado(CuentaTotal cuenta, Lavado lavado) {
        this.pk = new CuentaLavadoPK(cuenta, lavado);
    }

    public CuentaLavadoPK getPk() {
        return pk;
    }

    public void setPk(CuentaLavadoPK pk) {
        this.pk = pk;
    }

}
