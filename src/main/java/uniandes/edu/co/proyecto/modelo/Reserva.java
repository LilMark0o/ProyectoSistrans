// Reserva.java
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "reserva")
public class Reserva {
    @Id
    private String id;

    @Field("checkin")
    private Date checkin;

    @Field("checkout")
    private Date checkout;

    @Field("precio")
    private int precio;

    @Field("habitacion_id")
    private String habitacionId;

    @Field("usuario_id")
    private String usuarioId;

    public Reserva() {
    }

    public Reserva(Date checkin, Date checkout, int precio, String habitacionId, String usuarioId) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.precio = precio;
        this.habitacionId = habitacionId;
        this.usuarioId = usuarioId;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(String habitacionId) {
        this.habitacionId = habitacionId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getId() {
        return id;
    }
}
