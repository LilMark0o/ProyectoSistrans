package uniandes.edu.co.proyecto.dtos;

import java.math.BigDecimal;

public class ServicioResumenDTO {
    private Integer habitacionId;
    private String servicioNombre;
    private BigDecimal dineroRecolectado;

    
    public ServicioResumenDTO() {
    }

    public ServicioResumenDTO(Integer habitacionId, String servicioNombre, BigDecimal dineroRecolectado) {
        this.habitacionId = habitacionId;
        this.servicioNombre = servicioNombre;
        this.dineroRecolectado = dineroRecolectado;
    }

    public Integer getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(Integer habitacionId) {
        this.habitacionId = habitacionId;
    }

    public String getServicioNombre() {
        return servicioNombre;
    }

    public void setServicioNombre(String servicioNombre) {
        this.servicioNombre = servicioNombre;
    }

    public BigDecimal getDineroRecolectado() {
        return dineroRecolectado;
    }

    public void setDineroRecolectado(BigDecimal dineroRecolectado) {
        this.dineroRecolectado = dineroRecolectado;
    }


    

}
