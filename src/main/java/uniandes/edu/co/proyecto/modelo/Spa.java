package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "spa") // Ajusta el nombre de la tabla si es necesario
public class Spa {
    @Id // TODO PONER COMO TOCA XD

    private Integer id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Spa() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Spa(Hotel hotel) {
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Spa{" +
                "id=" + id +
                ", hotel=" + hotel +
                '}';
    }
}
