package uniandes.edu.co.proyecto.dtos;

public class Req8DTO {
    private String servicio;
    private String semana;
    private int solicitudesSemanales;

    public Req8DTO(String servicio, String semana, int solicitudesSemanales) {
        this.servicio = servicio;
        this.semana = semana;
        this.solicitudesSemanales = solicitudesSemanales;
    }

    public String getServicio() {
        return this.servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getSemana() {
        return this.semana;
    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

    public int getSolicitudesSemanales() {
        return this.solicitudesSemanales;
    }

    public void setSolicitudesSemanales(int solicitudesSemanales) {
        this.solicitudesSemanales = solicitudesSemanales;
    }

    public Req8DTO servicio(String servicio) {
        this.servicio = servicio;
        return this;
    }

    public Req8DTO semana(String semana) {
        this.semana = semana;
        return this;
    }

    public Req8DTO solicitudesSemanales(int solicitudesSemanales) {
        this.solicitudesSemanales = solicitudesSemanales;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " servicio='" + getServicio() + "'" +
            ", semana='" + getSemana() + "'" +
            ", solicitudesSemanales='" + getSolicitudesSemanales() + "'" +
            "}";
    }
    
}
