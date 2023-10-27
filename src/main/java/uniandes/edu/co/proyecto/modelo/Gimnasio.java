package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gimnasio") // Ajusta el nombre de la tabla si es necesario
public class Gimnasio {

    // TODO PONER COMO TOCA XD
    @Id
    private Integer id;

    @JoinColumn(name = "horainicio")
    private Integer horainicio;

    @JoinColumn(name = "horafin")
    private Integer horafin;
    private Integer secobra;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Gimnasio() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Gimnasio(Integer horainicio, Integer horafin, Integer secobra, Hotel hotel) {
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

    public Integer getSecobra() {
        return secobra;
    }

    public void setSecobra(Integer secobra) {
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
