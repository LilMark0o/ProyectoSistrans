package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tipousuario")
public class TipoUsuario {
    
    @Id
    @Column(name = "nombre", nullable = false, length = 4000)
    private String nombre;

    @OneToMany(mappedBy = "tipoUsuario")
    private List<Usuario> usuarios;

    public TipoUsuario() {
        // Empty constructor required by Jakarta Persistence
    }

    public TipoUsuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" +
                "nombre='" + nombre + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}
