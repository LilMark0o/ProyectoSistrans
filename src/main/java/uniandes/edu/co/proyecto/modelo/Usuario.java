package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)  
    private TipoUsuario tipousuario;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Usuario() {
        // Constructor vacío requerido por Jakarta Persistence
    }

    public Usuario(String nombre, String username, String password, TipoUsuario tipousuario, Hotel hotel) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.tipousuario = tipousuario;
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public TipoUsuario getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(TipoUsuario tipousuario) {
        this.tipousuario = tipousuario;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", tipousuario='" + tipousuario + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}
