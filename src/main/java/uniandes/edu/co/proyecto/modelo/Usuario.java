// Usuario.java
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "usuario")
public class Usuario {
    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("username")
    private String username;

    @Field("password")
    private String password;

    @Field("tipoUsuario")
    private String tipoUsuario;

    @Field("hotel_id")
    private String hotelId; // Cambié a String, ya que el campo hotel_id es un objectId pero lo almacenamos
                            // como String

    public Usuario() {
    }

    public Usuario(String nombre, String username, String password, String tipoUsuario, String hotelId) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.hotelId = hotelId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getId() {
        return id;
    }
}