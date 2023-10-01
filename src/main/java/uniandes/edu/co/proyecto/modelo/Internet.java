package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "internet") // Ajusta el nombre de la tabla si es necesario
public class Internet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Float capacidad;
    private Float precio;
    private Boolean secobra;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Internet() {
        // Constructor vacío requerido por Jakarta Persistence
    }

    public Internet(Float capacidad, Float precio, Boolean secobra, Hotel hotel) {
        this.capacidad = capacidad;
        this.precio = precio;
        this.secobra = secobra;
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return "Internet{" +
                "id=" + id +
                ", capacidad=" + capacidad +
                ", precio=" + precio +
                ", secobra=" + secobra +
                ", hotel=" + hotel +
                '}';
    }
}
