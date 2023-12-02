// CuentaServicio.java
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "cuentaServicio")
public class CuentaServicio {

    @Id
    private String id;
    private String descripcion;
    private Date fecha;
    private String reservaId; // ID de la reserva
    private String productoId; // ID del producto (opcional)
    private String servicioId; // ID del servicio (opcional)

    // Constructores, getters y setters

    public CuentaServicio() {
    }

    public CuentaServicio(String id, String descripcion, Date fecha, String reservaId, String productoId, String servicioId) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reservaId = reservaId;
        this.productoId = productoId;
        this.servicioId = servicioId;
    }

    public CuentaServicio(String descripcion, Date fecha, String reservaId, String productoId, String servicioId) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reservaId = reservaId;
        this.productoId = productoId;
        this.servicioId = servicioId;
    }

    public CuentaServicio(String descripcion, Date fecha, String reservaId) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reservaId = reservaId;
    }

    public CuentaServicio(String descripcion, Date fecha, String reservaId, String productoId) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reservaId = reservaId;
        this.productoId = productoId;
    }

    public CuentaServicio(String descripcion, Date fecha, String reservaId, String productoId, String servicioId, String id) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reservaId = reservaId;
        this.productoId = productoId;
        this.servicioId = servicioId;
        this.id = id;
    }

}
