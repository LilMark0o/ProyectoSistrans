// CuentaServicio.java
package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "cuentaServicio")
public class CuentaServicio {
    @Id
    private String id;

    @Field("descripcion")
    private String descripcion;

    @Field("fecha")
    private Date fecha;

    @Field("reservaId")
    private String reservaId;

    @Field("servicioId")
    private String servicioId;

    public CuentaServicio() {
    }

    public CuentaServicio(String descripcion, Date fecha, String reservaId, String servicioId) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reservaId = reservaId;
        this.servicioId = servicioId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getReservaId() {
        return reservaId;
    }

    public void setReservaId(String reservaId) {
        this.reservaId = reservaId;
    }

    public String getServicioId() {
        return servicioId;
    }

    public void setServicioId(String servicioId) {
        this.servicioId = servicioId;
    }

    public String getId() {
        return id;
    }
}
