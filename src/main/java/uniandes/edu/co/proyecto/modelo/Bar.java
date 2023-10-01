package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bar") // Ajusta el nombre de la tabla si es necesario
public class Bar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String estilo;

    private Integer capacidad;

    public Bar() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Bar(String estilo, Integer capacidad) {
        this.estilo = estilo;
        this.capacidad = capacidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "id=" + id +
                ", estilo='" + estilo + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
