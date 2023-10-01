package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamo") // Ajusta el nombre de la tabla si es necesario
public class Prestamo {
    @Id
    private Integer id;

    @Column(name = "devuelto")
    private Integer devuelto;

    @ManyToOne
    @JoinColumn(name = "utensilio_id", referencedColumnName = "id")
    private Utensilio utensilio;

    public Prestamo() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Prestamo(Integer devuelto, Utensilio utensilio) {
        this.devuelto = devuelto;
        this.utensilio = utensilio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", devuelto=" + devuelto +
                ", utensilio=" + utensilio +
                '}';
    }
}
