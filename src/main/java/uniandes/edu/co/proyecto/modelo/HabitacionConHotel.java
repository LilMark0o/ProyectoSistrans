package uniandes.edu.co.proyecto.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class HabitacionConHotel {
    private String idHabitacion;
    private String descripcionHabitacion;
    
    private String tipoHabitacionId;
    private String idHotel;
    private String nombreHotel;

    // Getters y setters...

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getDescripcionHabitacion() {
        return descripcionHabitacion;
    }

    public void setDescripcionHabitacion(String descripcionHabitacion) {
        this.descripcionHabitacion = descripcionHabitacion;
    }

    public String getTipoHabitacionId() {
        return tipoHabitacionId;
    }

    public void setTipoHabitacionId(String tipoHabitacionId) {
        this.tipoHabitacionId = tipoHabitacionId;
    }

    public String getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(String idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }
 
    public HabitacionConHotel(String idHabitacion, String descripcionHabitacion, String tipoHabitacionId,
            String idHotel, String nombreHotel) {
        this.idHabitacion = idHabitacion;
        this.descripcionHabitacion = descripcionHabitacion;
        this.tipoHabitacionId = tipoHabitacionId;
        this.idHotel = idHotel;
        this.nombreHotel = nombreHotel;
    }
    
}
