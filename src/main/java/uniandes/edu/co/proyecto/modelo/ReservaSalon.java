package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "reservasalon") // Ajusta el nombre de la tabla si es necesario
public class ReservaSalon {
    @Id
    private Integer id;

    private Date fecha;

    @Column(name = "tiempoespera")
    private Integer tiempoEspera;

    @ManyToOne
    @JoinColumn(name = "salon_id", referencedColumnName = "id")
    private Salon salon;

    public ReservaSalon() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public ReservaSalon(Date fecha, Integer tiempoEspera, Salon salon) {
        this.fecha = fecha;
        this.tiempoEspera = tiempoEspera;
        this.salon = salon;
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

    public Integer getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(Integer tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    @Override
    public String toString() {
        return "ReservaSalon{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", tiempoEspera=" + tiempoEspera +
                ", salon=" + salon +
                '}';
    }
}
