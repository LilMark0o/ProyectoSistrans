package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamo") // Ajusta el nombre de la tabla si es necesario
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int devuelto;

    @ManyToOne
    @JoinColumn(name = "utensilio_id", referencedColumnName = "id")
    private Utensilio utensilio;

    public Prestamo() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Prestamo(int devuelto, Utensilio utensilio) {
        this.devuelto = devuelto;
        this.utensilio = utensilio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(int devuelto) {
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
