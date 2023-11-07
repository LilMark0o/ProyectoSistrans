package uniandes.edu.co.proyecto.dtos;

public class Req5DTO {
    String usuario;
    String servicio;
    String descripcionServicio;
    String fechaServicio;
    Float precioServicio;
    String producto;
    Float precioProducto;

    public Req5DTO(String usuario, String servicio, String descripcionServicio, String fechaServicio,
            Float precioServicio, String producto, Float precioProducto) {
        this.usuario = usuario;
        this.servicio = servicio;
        this.descripcionServicio = descripcionServicio;
        this.fechaServicio = fechaServicio;
        this.precioServicio = precioServicio;
        this.producto = producto;
        this.precioProducto = precioProducto;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getServicio() {
        return servicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public String getFechaServicio() {
        return fechaServicio;
    }

    public Float getPrecioServicio() {
        return precioServicio;
    }

    public String getProducto() {
        return producto;
    }

    public Float getPrecioProducto() {
        return precioProducto;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public void setFechaServicio(String fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public void setPrecioServicio(Float precioServicio) {
        this.precioServicio = precioServicio;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setPrecioProducto(Float precioProducto) {
        this.precioProducto = precioProducto;
    }
    
}
