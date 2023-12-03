// Habitacion.java
package uniandes.edu.co.proyecto.modelo;

public class HabitacionEmbedded {

    private String id;
    private String descripcion;
    private String tipoHabitacionId;

    public HabitacionEmbedded() {
    }

    public HabitacionEmbedded(String descripcion, String tipoHabitacionId) {
        this.descripcion = descripcion;
        this.tipoHabitacionId = tipoHabitacionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoHabitacionId() {
        return tipoHabitacionId;
    }

    public void setTipoHabitacionId(String tipoHabitacionId) {
        this.tipoHabitacionId = tipoHabitacionId;
    }
}