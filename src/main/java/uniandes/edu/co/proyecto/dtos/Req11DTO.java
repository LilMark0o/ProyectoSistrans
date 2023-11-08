package uniandes.edu.co.proyecto.dtos;


public class Req11DTO {
    
    private String semana;
    private String servicio_mas_consumido;
    private String servicio_menos_consumido;
    private String habitacion_mas_solicitada;
    private String habitacion_menos_solicitada;

    public Req11DTO(String semana, String servicio_mas_consumido, String servicio_menos_consumido, String habitacion_mas_solicitada, String habitacion_menos_solicitada) {
        this.semana = semana;
        this.servicio_mas_consumido = servicio_mas_consumido;
        this.servicio_menos_consumido = servicio_menos_consumido;
        this.habitacion_mas_solicitada = habitacion_mas_solicitada;
        this.habitacion_menos_solicitada = habitacion_menos_solicitada;
    }

    public Req11DTO() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public String getSemana() {
        return semana;
    }

    public String getServicio_mas_consumido() {
        return servicio_mas_consumido;
    }

    public String getServicio_menos_consumido() {
        return servicio_menos_consumido;
    }

    public String getHabitacion_mas_solicitada() {
        return habitacion_mas_solicitada;
    }

    public String getHabitacion_menos_solicitada() {
        return habitacion_menos_solicitada;
    }
}
