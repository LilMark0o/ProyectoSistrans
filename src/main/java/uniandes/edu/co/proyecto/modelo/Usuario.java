// Usuario.java
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class Usuario {

    @Id
    private String id;
    private String nombre;
    private String username;
    private String password;
    private String tipoUsuario;

    // Constructores, getters y setters
}