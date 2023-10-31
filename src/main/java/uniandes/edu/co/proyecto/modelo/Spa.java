package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "spa") // Ajusta el nombre de la tabla si es necesario
public class Spa {
    @EmbeddedId
    private ServicioPK pk;

    public Spa() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Spa(Servicio servicio) {
        this.pk = new ServicioPK(servicio);
    }

    public ServicioPK getPk() {
        return pk;
    }

    public void setPk(ServicioPK pk) {
        this.pk = pk;
    }
}
