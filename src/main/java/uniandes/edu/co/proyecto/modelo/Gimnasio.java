package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gimnasio")
public class Gimnasio {

    @EmbeddedId
    private ServicioPK pk;
    @JoinColumn(name = "horainicio")
    private Integer horainicio;

    @JoinColumn(name = "horafin")
    private Integer horafin;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Integer getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Integer horainicio) {
        this.horainicio = horainicio;
    }

    public Integer getHorafin() {
        return horafin;
    }

    public void setHorafin(Integer horafin) {
        this.horafin = horafin;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Gimnasio() {
        ;
    }

    public Gimnasio(Servicio servicio, Integer horainicio, Integer horafin, Hotel hotel) {
        this.pk = new ServicioPK(servicio);
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.hotel = hotel;
    }

    public ServicioPK getPk() {
        return pk;
    }

    public void setPk(ServicioPK pk) {
        this.pk = pk;
    }

}