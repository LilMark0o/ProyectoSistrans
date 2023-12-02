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
    private String servicioId; // ID del servicio (opcional)

    // Constructores, getters y setters

    public CuentaServicio() {
    }

    public CuentaServicio(String id, String descripcion, Date fecha, String reservaId, String servicioId) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reservaId = reservaId;
        this.servicioId = servicioId;
    }

    public CuentaServicio(String descripcion, Date fecha, String reservaId, String servicioId) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reservaId = reservaId;
        this.servicioId = servicioId;
    }

    public CuentaServicio(String descripcion, Date fecha, String reservaId) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reservaId = reservaId;
    }

    public CuentaServicio(String descripcion, Date fecha) {
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
    

}
