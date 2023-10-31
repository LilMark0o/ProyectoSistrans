package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "internet")
public class Internet {

    @EmbeddedId
    private ServicioPK pk;
    private Float capacidad;
    private Float precio;

    public Float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Float capacidad) {
        this.capacidad = capacidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
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

    public Internet() {
        ;
    }

    public Internet(Servicio servicio, Float capacidad, Float precio, Hotel hotel) {
        this.pk = new ServicioPK(servicio);
        this.capacidad = capacidad;
        this.precio = precio;
        this.hotel = hotel;
    }

    public ServicioPK getPk() {
        return pk;
    }

    public void setPk(ServicioPK pk) {
        this.pk = pk;
    }

}