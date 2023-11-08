package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion") // Ajusta el nombre de la tabla si es necesario
public class Habitacion {

    @Id
    private Integer id;

    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "tipohabitacion_id", referencedColumnName = "id")
    private TipoHabitacion tipohabitacion;

    public Habitacion() {
    }

    // Parameterized constructor
    public Habitacion(Integer id, String descripcion, TipoHabitacion tipohabitacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipohabitacion = tipohabitacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoHabitacion getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(TipoHabitacion tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    // Getters and Setters

}
