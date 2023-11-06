package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservaservicio") // Ajusta el nombre de la tabla si es necesario
public class ReservaServicio {
    @Id
    private Integer id;

    @Column(name = "horainicio")
    private Integer horainicio;

    @Column(name = "horafin")
    private Integer horafin;

    @ManyToOne
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicio;

    public ReservaServicio() {
        // Constructor vacío requerido por Jakarta Persistence
    }

    public ReservaServicio(Integer horainicio, Integer horafin, Servicio servicio) {
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.servicio = servicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
