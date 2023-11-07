package uniandes.edu.co.proyecto.dtos;



public class Req6DTO {
    
    String tipo;
    String fecha;
    Integer valor;

    public Req6DTO(String tipo, String fecha, Integer valor) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public Integer getValor() {
        return valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
