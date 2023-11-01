package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipohabitacion")
public class TipoHabitacion {
    @Id
    private Integer id;

    @Column(name = "costonoche")
    private Float costonoche;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "nombre")
    private String nombre;

    public TipoHabitacion() {
        // Default constructor required by Jakarta Persistence
    }

    public TipoHabitacion(Float costonoche, Integer capacidad, String nombre) {
        this.costonoche = costonoche;
        this.capacidad = capacidad;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCostonoche() {
        return costonoche;
    }

    public void setCostonoche(Float costonoche) {
        this.costonoche = costonoche;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
