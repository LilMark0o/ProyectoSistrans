package uniandes.edu.co.proyecto.modelo; // Ajusta el paquete según tu estructura de paquetes

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel") // Ajusta el esquema y el nombre de la tabla
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Hotel() {
        ;// Constructor vacío requerido por JPA
    }

    public Hotel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
