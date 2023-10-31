package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 4000)
    private String nombre;

    @Column(name = "username", nullable = false, length = 4000)
    private String username;

    @Column(name = "password", nullable = false, length = 4000)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipousuario_nombre", referencedColumnName = "nombre", nullable = false)
    private TipoUsuario tipoUsuario;

    // Default constructor required by Jakarta Persistence
    public Usuario() {}

    public Usuario(Integer id, String nombre, String username, String password, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String nombre, String username, String password, TipoUsuario tipoUsuario) {
        this(null, nombre, username, password, tipoUsuario);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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



    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }

}
