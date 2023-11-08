package uniandes.edu.co.proyecto.dtos;

import java.sql.Date;


public class ReqDTO9 {
    private Integer id;
    private String nombre;
    private Integer numero_de_veces;
    private Date ultima_fecha_uso;

    public ReqDTO9(Integer id, String nombre, Integer numero_de_veces, Date ultima_fecha_uso) {
        this.id = id;
        this.nombre = nombre;
        this.numero_de_veces = numero_de_veces;
        this.ultima_fecha_uso = ultima_fecha_uso;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNumero_de_veces() {
        return numero_de_veces;
    }

    public Date getUltima_fecha_uso() {
        return ultima_fecha_uso;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero_de_veces(Integer numero_de_veces) {
        this.numero_de_veces = numero_de_veces;
    }

    public void setUltima_fecha_uso(Date ultima_fecha_uso) {
        this.ultima_fecha_uso = ultima_fecha_uso;
    }

    
    
}
