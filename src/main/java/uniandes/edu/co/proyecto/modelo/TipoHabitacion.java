package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "tipohabitacion")
public class TipoHabitacion {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "costonoche")
    private Float costonoche;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "nombre", length = 4000)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    // Constructors, Getters, Setters, etc.
    public TipoHabitacion() {}

    // Parameterized constructor
    public TipoHabitacion(Integer id, Float costonoche, Integer capacidad, String nombre, Hotel hotel) {
        this.id = id;
        this.costonoche = costonoche;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.hotel = hotel;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCostonoche() {
        return costonoche;
    }

    public void setCostonoche(Float costonoche) {
        this.costonoche = costonoche;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
