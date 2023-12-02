// Reserva.java
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "reserva")
public class Reserva {

    @Id
    private String id;
    private Date checkin;
    private Date checkout;
    private double precio;
    private String habitacionId; // ID de la habitación
    private String usuarioId; // ID del usuario

    // Constructores, getters y setters
}