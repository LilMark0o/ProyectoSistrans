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

    @Column(name = "nombre") // Asegúrate de que el nombre coincida con la base de datos
    private String nombre;
    @Column(name = "descripcion") // Asegúrate de que el nombre coincida con la base de datos
    private String descripcion;
    @Column(name = "precio") // Asegúrate de que el nombre coincida con la base de datos
    private Float precio;
    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Servicio() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Servicio(String nombre, String descripcion, Float precio, Hotel hotel) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
