package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dotacion") // Ajusta el nombre de la tabla si es necesario
public class Dotacion {
    @Id
    private Integer id;

    private String nombre;
    private Float costo;
    private Boolean cobro;

    @ManyToOne
    @JoinColumn(name = "habitacion_id", referencedColumnName = "id")
    private Habitacion habitacion;

    public Dotacion() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Dotacion(String nombre, Float costo, Boolean cobro, Habitacion habitacion) {
        this.nombre = nombre;
        this.costo = costo;
        this.cobro = cobro;
        this.habitacion = habitacion;
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

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Boolean getCobro() {
        return cobro;
    }

    public void setCobro(Boolean cobro) {
        this.cobro = cobro;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public String toString() {
        return "Dotacion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", costo=" + costo +
                ", cobro=" + cobro +
                ", habitacion=" + habitacion +
                '}';
    }
}
