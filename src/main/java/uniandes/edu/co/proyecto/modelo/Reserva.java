// Reserva.java
package uniandes.edu.co.proyecto.modelo;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "reserva")
public class Reserva {
    @Id
    private String id;

    @Field("checkin")
    private LocalDate checkin;

    @Field("checkout")
    private LocalDate checkout;

    @Field("precio")
    private int precio;

    @Field("habitacion_id")
    private int habitacionId;

    @Field("usuario_id")
    @DBRef
    private Usuario usuarioId;

    public Reserva() {
    }

    public Reserva(LocalDate checkin, LocalDate checkout, int precio, int habitacionId, Usuario usuarioId) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.precio = precio;
        this.habitacionId = habitacionId;
        this.usuarioId = usuarioId;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(int habitacionId) {
        this.habitacionId = habitacionId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getId() {
        return id;
    }
}
