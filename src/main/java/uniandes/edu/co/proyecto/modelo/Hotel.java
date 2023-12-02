// Hotel.java
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "hotel")
public class Hotel {

    @Id
    private String id;
    private String nombre;

    @DBRef
    private List<Habitacion> habitaciones; // Referencia a habitaciones

    @DBRef
    private List<Servicio> servicios; // Referencia a servicios

    // Constructores, getters y setters
}