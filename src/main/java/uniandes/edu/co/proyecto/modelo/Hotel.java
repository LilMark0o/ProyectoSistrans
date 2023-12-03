// Hotel.java
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "hotel")
public class Hotel {

    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("habitaciones")
    private List<HabitacionEmbedded> habitaciones;

    @Field("serviciosProductos")
    private List<ServicioProducto> serviciosProductos;

    public Hotel() {
    }

    public Hotel(String nombre, List<HabitacionEmbedded> habitaciones, List<ServicioProducto> serviciosProductos) {
        this.nombre = nombre;
        this.habitaciones = habitaciones;
        this.serviciosProductos = serviciosProductos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<HabitacionEmbedded> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<HabitacionEmbedded> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<ServicioProducto> getServiciosProductos() {
        return serviciosProductos;
    }

    public void setServiciosProductos(List<ServicioProducto> serviciosProductos) {
        this.serviciosProductos = serviciosProductos;
    }
}
