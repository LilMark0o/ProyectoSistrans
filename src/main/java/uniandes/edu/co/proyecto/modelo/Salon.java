package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salon") // Ajusta el nombre de la tabla si es necesario
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer capacidad;

    private String tipoSalon;

    private Integer horasUso;

    private Character equipoComputacion;

    private Character equipoProyeccion;

    private Character equipoAmplificacion;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Salon() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Salon(Integer capacidad, String tipoSalon, Integer horasUso, Character equipoComputacion,
            Character equipoProyeccion, Character equipoAmplificacion, Hotel hotel) {
        this.capacidad = capacidad;
        this.tipoSalon = tipoSalon;
        this.horasUso = horasUso;
        this.equipoComputacion = equipoComputacion;
        this.equipoProyeccion = equipoProyeccion;
        this.equipoAmplificacion = equipoAmplificacion;
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

    public String getTipoSalon() {
        return tipoSalon;
    }

    public void setTipoSalon(String tipoSalon) {
        this.tipoSalon = tipoSalon;
    }

    public Integer getHorasUso() {
        return horasUso;
    }

    public void setHorasUso(Integer horasUso) {
        this.horasUso = horasUso;
    }

    public Character getEquipoComputacion() {
        return equipoComputacion;
    }

    public void setEquipoComputacion(Character equipoComputacion) {
        this.equipoComputacion = equipoComputacion;
    }

    public Character getEquipoProyeccion() {
        return equipoProyeccion;
    }

    public void setEquipoProyeccion(Character equipoProyeccion) {
        this.equipoProyeccion = equipoProyeccion;
    }

    public Character getEquipoAmplificacion() {
        return equipoAmplificacion;
    }

    public void setEquipoAmplificacion(Character equipoAmplificacion) {
        this.equipoAmplificacion = equipoAmplificacion;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Salon{" +
                "id=" + id +
                ", capacidad=" + capacidad +
                ", tipoSalon='" + tipoSalon + '\'' +
                ", horasUso=" + horasUso +
                ", equipoComputacion=" + equipoComputacion +
                ", equipoProyeccion=" + equipoProyeccion +
                ", equipoAmplificacion=" + equipoAmplificacion +
                ", hotel=" + hotel +
                '}';
    }
}
