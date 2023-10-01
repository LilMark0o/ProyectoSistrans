package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentasalon")
public class CuentaSalon {

    @EmbeddedId
    private CuentaSalonPK pk;

    public CuentaSalon() {
        ;
    }

    public CuentaSalon(CuentaTotal cuentaTotal, Salon salon) {
        this.pk = new CuentaSalonPK(cuentaTotal, salon);
    }

    public CuentaSalonPK getPk() {
        return pk;
    }

    public void setPk(CuentaSalonPK pk) {
        this.pk = pk;
    }

}
