package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cuentatotal") // Ajusta el nombre de la tabla si es necesario
public class CuentaTotal {

    @Id
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "habitacion_id", referencedColumnName = "id")
    private Habitacion habitacion;

    public CuentaTotal() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public CuentaTotal(Date fecha, Habitacion habitacion) {
        this.fecha = fecha;
        this.habitacion = habitacion;
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
        return "CuentaTotal{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", habitacion=" + habitacion +
                '}';
    }
}
