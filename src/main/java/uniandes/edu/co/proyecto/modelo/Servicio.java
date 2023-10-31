package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio") // Ajusta el nombre de la tabla si es necesario
public class Servicio {
    @Id
    private Integer id;

    private String nombre;
    @Column(name = "secobra") // Asegúrate de que el nombre coincida con la base de datos
    private Integer secobra;
    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Servicio() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Servicio(String nombre, Integer seCobra, Hotel hotel) {
        this.nombre = nombre;
        this.secobra = seCobra;
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
