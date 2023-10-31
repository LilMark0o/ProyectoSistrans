package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamo") // Ajusta el nombre de la tabla si es necesario
public class Prestamo {
    @EmbeddedId
    private ServicioPK pk;

    @Column(name = "devuelto")
    private Integer devuelto;

    @ManyToOne
    @JoinColumn(name = "utensilio_id", referencedColumnName = "id")
    private Utensilio utensilio;

    public Prestamo() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Prestamo(ServicioPK pk, Integer devuelto, Utensilio utensilio) {
        this.pk = pk;
        this.devuelto = devuelto;
        this.utensilio = utensilio;
    }

    public Integer getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Integer devuelto) {
        this.devuelto = devuelto;
    }

    public Utensilio getUtensilio() {
        return utensilio;
    }

    public void setUtensilio(Utensilio utensilio) {
        this.utensilio = utensilio;
    }

    public ServicioPK getPk() {
        return pk;
    }

    public void setPk(ServicioPK pk) {
        this.pk = pk;
    }
}