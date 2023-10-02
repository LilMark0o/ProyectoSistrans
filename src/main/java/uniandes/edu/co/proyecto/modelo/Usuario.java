package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    private Integer id;

    
    private String nombre;
    private String username;
    private String password;
    
    private String tipousuario;
    @Column(name = "tipodedocumento")
    private String tipodedocumento;

    public Usuario() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Usuario(String nombre, String username, String password, String tipodedocumento, String tipousuario) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.tipousuario = tipousuario;
        this.tipodedocumento = tipodedocumento;
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

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getTipodedocumento() {
        return tipodedocumento;
    }

    public void setTipodedocumento(String tipodedocumento) {
        this.tipodedocumento = tipodedocumento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", tipousuario='" + tipousuario +
                '}';
    }
}
