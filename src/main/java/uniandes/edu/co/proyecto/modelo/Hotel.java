// Hotel.java
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "hotel")
public class Hotel {

    @Id
    private String id;
    private String nombre;
    private List<Habitacion> habitaciones; // Habitaciones como subdocumentos
    private List<String> servicios; // IDs de servicios

    // Constructores, getters y setters...
}
