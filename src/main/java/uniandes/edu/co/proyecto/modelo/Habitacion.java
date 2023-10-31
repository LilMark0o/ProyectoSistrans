package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion") // Ajusta el nombre de la tabla si es necesario
public class Habitacion {

    @Id
    private Integer id;

    private Integer capacidad;
    private Float costonoche;
    private TipoHabitacion tipohabitacion;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Habitacion() {}

    // Parameterized constructor
    public Habitacion(Integer id, Integer capacidad, Float costonoche, TipoHabitacion tipohabitacion, Hotel hotel) {
        this.id = id;
        this.capacidad = capacidad;
        this.costonoche = costonoche;
        this.tipohabitacion = tipohabitacion;
        this.hotel = hotel;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Float getCostonoche() {
        return costonoche;
    }

    public void setCostonoche(Float costonoche) {
        this.costonoche = costonoche;
    }

    public TipoHabitacion getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(TipoHabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
