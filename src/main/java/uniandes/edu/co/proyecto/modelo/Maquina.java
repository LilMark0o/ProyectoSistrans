package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "maquina") // Ajusta el nombre de la tabla si es necesario
public class Maquina {
    @Id
    private Integer id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "gimnasio_id", referencedColumnName = "id")
    private Gimnasio gimnasio;

    public Maquina() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Maquina(String nombre, Gimnasio gimnasio) {
        this.nombre = nombre;
        this.gimnasio = gimnasio;
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

    public Gimnasio getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    @Override
    public String toString() {
        return "Maquina{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", gimnasio=" + gimnasio +
                '}';
    }
}
