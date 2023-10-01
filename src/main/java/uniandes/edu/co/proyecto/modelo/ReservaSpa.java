package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "reserva_spa") // Ajusta el nombre de la tabla si es necesario
public class ReservaSpa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date fecha;

    private Integer hora;

    @ManyToOne
    @JoinColumn(name = "spa_id", referencedColumnName = "id")
    private Spa spa;

    public ReservaSpa() {
        // Constructor vacío requerido por Jakarta Persistence
    }

    public ReservaSpa(Date fecha, Integer hora, Spa spa) {
        this.fecha = fecha;
        this.hora = hora;
        this.spa = spa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public Spa getSpa() {
        return spa;
    }

    public void setSpa(Spa spa) {
        this.spa = spa;
    }

    @Override
    public String toString() {
        return "ReservaSpa{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", spa=" + spa +
                '}';
    }
}
