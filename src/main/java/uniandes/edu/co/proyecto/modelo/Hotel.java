package uniandes.edu.co.proyecto.modelo; // Ajusta el paquete según tu estructura de paquetes

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel") // Ajusta el esquema y el nombre de la tabla
public class Hotel {
    @Id
    private Integer id;
    private String nombre;

    public Hotel() {
        ;// Constructor vacío requerido por JPA
    }

    public Hotel(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

}
