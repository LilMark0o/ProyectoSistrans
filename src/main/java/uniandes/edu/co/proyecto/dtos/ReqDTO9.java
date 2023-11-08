package uniandes.edu.co.proyecto.dtos;


public class ReqDTO9 {
    private String tipo;
    private String fecha;
    private Integer valor;

    public ReqDTO9(String tipo, String fecha, Integer valor) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.valor = valor;
    }

    public ReqDTO9() {
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getFecha() {
        return this.fecha;
    }

    public Integer getValor() {
        return this.valor;
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
