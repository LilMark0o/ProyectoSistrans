package uniandes.edu.co.proyecto.dtos;

public class Req3DTO {

    Integer habitacion_id;
    Integer total_dias_ocupados;
    Integer total_reservas;
    Float indice_ocupacion;

    public Req3DTO(Integer habitacion_id, Integer total_dias_ocupados, Integer total_reservas,
            Float indice_ocupacion) {
        this.habitacion_id = habitacion_id;
        this.total_dias_ocupados = total_dias_ocupados;
        this.total_reservas = total_reservas;
        this.indice_ocupacion = indice_ocupacion;
    }

    public Integer getHabitacion_id() {
        return habitacion_id;
    }

    public void setHabitacion_id(Integer habitacion_id) {
        this.habitacion_id = habitacion_id;
    }

    public Integer getTotal_dias_ocupados() {
        return total_dias_ocupados;
    }

    public void setTotal_dias_ocupados(Integer total_dias_ocupados) {
        this.total_dias_ocupados = total_dias_ocupados;
    }

    public Integer getTotal_reservas() {
        return total_reservas;
    }

    public void setTotal_reservas(Integer total_reservas) {
        this.total_reservas = total_reservas;
    }

    public Float getIndice_ocupacion() {
        return indice_ocupacion;
    }

    public void setIndice_ocupacion(Float indice_ocupacion) {
        this.indice_ocupacion = indice_ocupacion;
    }
    
}
