package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "tipoHabitacion")
public class TipoHabitacion {
    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("costoNoche")
    private int costoNoche; // Cambiado a Double para permitir valores decimales

    @Field("capacidad")
    private int capacidad;

    public TipoHabitacion() {
    }

    public TipoHabitacion(String nombre, int costoNoche, int capacidad) {
        this.nombre = nombre;
        this.costoNoche = costoNoche;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCostoNoche() {
        return costoNoche;
    }

    public void setCostoNoche(int costoNoche) {
        this.costoNoche = costoNoche;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getId() {
        return id;
    }
}
