package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cuentaservicio") // Ajusta el nombre de la tabla si es necesario
public class CuentaServicio {

    @Id
    private Integer id;

    @Column(name = "tiposervicio") // Asegúrate de que el nombre coincida con la base de datos
    private String tiposervicio;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "habitacion_id", referencedColumnName = "id")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicio;

    public CuentaServicio() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public CuentaServicio(Date fecha, String tiposervicio, Habitacion habitacion, Servicio servicio) {
        this.fecha = fecha;
        this.habitacion = habitacion;
        this.tiposervicio = tiposervicio;
        this.servicio = servicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public String toString() {
        return "CuentaServicio{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", habitacion=" + habitacion +
                '}';
    }
}