package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gimnasio") // Ajusta el nombre de la tabla si es necesario
public class Gimnasio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer horainicio;
    private Integer horafin;
    private Boolean secobra;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Gimnasio() {
        // Constructor vacío requerido por Jakarta Persistence
    }

    public Gimnasio(Integer horainicio, Integer horafin, Boolean secobra, Hotel hotel) {
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.secobra = secobra;
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Integer horainicio) {
        this.horainicio = horainicio;
    }

    public Integer getHorafin() {
        return horafin;
    }

    public void setHorafin(Integer horafin) {
        this.horafin = horafin;
    }

    public Boolean getSecobra() {
        return secobra;
    }

    public void setSecobra(Boolean secobra) {
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
        return "Gimnasio{" +
                "id=" + id +
                ", horainicio=" + horainicio +
                ", horafin=" + horafin +
                ", secobra=" + secobra +
                ", hotel=" + hotel +
                '}';
    }
}
