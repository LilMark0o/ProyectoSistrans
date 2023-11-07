package uniandes.edu.co.proyecto.dtos;

public class Req7DTO {
    private String usuario;
    private String estadoCliente;
    private String razon;

    public Req7DTO(String usuario, String estadoCliente, String razon) {
        this.usuario = usuario;
        this.estadoCliente = estadoCliente;
        this.razon = razon;
    }

    public Req7DTO() {
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getEstadoCliente() {
        return this.estadoCliente;
    }

    public String getRazon() {
        return this.razon;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    



    
}
