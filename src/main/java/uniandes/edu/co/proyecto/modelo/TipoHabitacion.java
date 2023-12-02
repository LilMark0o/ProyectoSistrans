// Servicio.java
// TipoHabitacion.java
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tipoHabitacion")
public class TipoHabitacion {

    @Id
    private String id;
    private String nombre;
    private double costoNoche;
    private int capacidad;

    // Constructores, getters y setters
}