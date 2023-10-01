package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion") // Ajusta el nombre de la tabla si es necesario
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer capacidad;
    private Float costonoche;
    private String tipohabitacion;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Habitacion() {
        // Constructor vacío requerido por Jakarta Persistence
    }

    public Habitacion(Integer capacidad, Float costonoche, String tipohabitacion, Hotel hotel) {
        this.capacidad = capacidad;
        this.costonoche = costonoche;
        this.tipohabitacion = tipohabitacion;
        this.hotel = hotel;
    }

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

    public String getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", capacidad=" + capacidad +
                ", costonoche=" + costonoche +
                ", tipohabitacion='" + tipohabitacion + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}
