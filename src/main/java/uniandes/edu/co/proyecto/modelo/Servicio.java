// Servicio.java
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "servicio")
public class Servicio {

    @Id
    private String id;
    private String nombre;
    private boolean esProducto;
    private Integer duracion; // Opcional

    // Constructores, getters y setters
}
