package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "gimnasio")
public class Gimnasio {

    @EmbeddedId
    private ServicioPK pk;

    @Column(name = "horainicio")
    private Integer horainicio;

    @Column(name = "horafin")
    private Integer horafin;

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

    public Gimnasio() {
        ;
    }

    public Gimnasio(Servicio servicio, Integer horainicio, Integer horafin) {
        this.pk = new ServicioPK(servicio);
        this.horainicio = horainicio;
        this.horafin = horafin;
    }

    public ServicioPK getPk() {
        return pk;
    }

    public void setPk(ServicioPK pk) {
        this.pk = pk;
    }

}