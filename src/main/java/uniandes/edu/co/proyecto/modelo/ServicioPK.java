package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ServicioPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idservicio", referencedColumnName = "id")
    private Servicio servicio;

    public ServicioPK(Servicio servicio) {
        super();
        this.servicio = servicio;
    }

    public ServicioPK() {
        super();
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}