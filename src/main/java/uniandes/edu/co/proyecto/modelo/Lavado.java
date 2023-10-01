package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lavado") // Ajusta el nombre de la tabla si es necesario
public class Lavado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Float precio;

    private Integer cantidadalavar;

    public Lavado() {
        // Constructor vacío requerido por Jakarta Persistence
    }

    public Lavado(Float precio, Integer cantidadalavar) {
        this.precio = precio;
        this.cantidadalavar = cantidadalavar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidadalavar() {
        return cantidadalavar;
    }

    public void setCantidadalavar(Integer cantidadalavar) {
        this.cantidadalavar = cantidadalavar;
    }

    @Override
    public String toString() {
        return "Lavado{" +
                "id=" + id +
                ", precio=" + precio +
                ", cantidadalavar=" + cantidadalavar +
                '}';
    }
}
