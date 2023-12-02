// Ti// Habitacion.java
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "habitacion")
public class Habitacion {

    @Id
    private String id;
    private String descripcion;

    @DBRef
    private TipoHabitacion tipoHabitacion; // Referencia al tipo de habitación

    // Constructores, getters y setters
}