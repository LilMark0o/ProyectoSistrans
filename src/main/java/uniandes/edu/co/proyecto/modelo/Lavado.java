package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lavado")
public class Lavado {

    @EmbeddedId
    private ServicioPK pk;
    private Float capacidad;
    private Integer cantidadalavar;

    public Float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Float capacidad) {
        this.capacidad = capacidad;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Lavado() {
        ;
    }

    public Lavado(Servicio servicio, Float capacidad, Integer cantidadalavar, Hotel hotel) {
        this.pk = new ServicioPK(servicio);
        this.capacidad = capacidad;
        this.cantidadalavar = cantidadalavar;
        this.hotel = hotel;
    }

    public ServicioPK getPk() {
        return pk;
    }

    public void setPk(ServicioPK pk) {
        this.pk = pk;
    }

    public Integer getCantidadalavar() {
        return cantidadalavar;
    }

    public void setCantidadalavar(Integer cantidadalavar) {
        this.cantidadalavar = cantidadalavar;
    }

}