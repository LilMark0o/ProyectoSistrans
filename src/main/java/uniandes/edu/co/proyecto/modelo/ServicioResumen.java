package uniandes.edu.co.proyecto.modelo;

import java.math.BigDecimal;

public class ServicioResumen {
    Integer habitacion_id;
    String servicio_nombre;
    BigDecimal dinero_recolectado;

    public ServicioResumen(Integer habitacion_id, String servicio_nombre, BigDecimal dinero_recolectado) {
        this.habitacion_id = habitacion_id;
        this.servicio_nombre = servicio_nombre;
        this.dinero_recolectado = dinero_recolectado;
    }

    public Integer getHabitacion_id() {
        return habitacion_id;
    }

    public void setHabitacion_id(Integer habitacion_id) {
        this.habitacion_id = habitacion_id;
    }

    public String getServicio_nombre() {
        return servicio_nombre;
    }

    public void setServicio_nombre(String servicio_nombre) {
        this.servicio_nombre = servicio_nombre;
    }

    public BigDecimal getDinero_recolectado() {
        return dinero_recolectado;
    }

    public void setDinero_recolectado(BigDecimal dinero_recolectado) {
        this.dinero_recolectado = dinero_recolectado;
    }

    
}
