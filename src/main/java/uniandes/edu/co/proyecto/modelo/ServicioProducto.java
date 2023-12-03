// Servicio.java
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "servicioProducto")
public class ServicioProducto {
    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("precio")
    private double precio;

    @Field("esProducto")
    private boolean esProducto;

    @Field("duracion")
    private Double duracion; // Cambiado a Double para manejar valores nulos (opcional)

    public ServicioProducto() {
    }

    public ServicioProducto(String nombre, double precio, boolean esProducto, Double duracion) {
        this.nombre = nombre;
        this.precio = precio;
        this.esProducto = esProducto;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEsProducto() {
        return esProducto;
    }

    public void setEsProducto(boolean esProducto) {
        this.esProducto = esProducto;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public String getId() {
        return id;
    }
}
