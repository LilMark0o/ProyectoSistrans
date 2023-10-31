package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "internet")
public class Internet {

    @EmbeddedId
    private ServicioPK pk;
    private Float capacidad;
    private Float precio;

    public Float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Float capacidad) {
        this.capacidad = capacidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Internet() {
        ;
    }

    public Internet(Servicio servicio, Float capacidad, Float precio) {
        this.pk = new ServicioPK(servicio);
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public ServicioPK getPk() {
        return pk;
    }

    public void setPk(ServicioPK pk) {
        this.pk = pk;
    }

}