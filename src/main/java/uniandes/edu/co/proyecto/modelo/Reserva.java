package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "checkin")
    private Date checkin;

    @Temporal(TemporalType.DATE)
    @Column(name = "checkout")
    private Date checkout;

    @Column(name = "precio")
    private Float precio;

    @ManyToOne
    @JoinColumn(name = "habitacion_id", referencedColumnName = "id")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public Reserva() {
        // Constructor vacío requerido por Jakarta Persistence
    }

    public Reserva(Date checkin, Date checkout, Float precio, Habitacion habitacion, Usuario usuario) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.precio = precio;
        this.habitacion = habitacion;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
