package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "piscina")
public class Piscina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Float profundidad;
    private int horaInicio;
    private int horaFin;
    private int secobra;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Piscina() {
        // Constructor vacío requerido por Jakarta Persistence
    }

    public Piscina(Float profundidad, int horaInicio, int horaFin, int secobra, Hotel hotel) {
        this.profundidad = profundidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.secobra = secobra;
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public int getSecobra() {
        return secobra;
    }

    public void setSecobra(int secobra) {
        this.secobra = secobra;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Piscina{" +
                "id=" + id +
                ", profundidad=" + profundidad +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", secobra=" + secobra +
                ", hotel=" + hotel +
                '}';
    }
}
