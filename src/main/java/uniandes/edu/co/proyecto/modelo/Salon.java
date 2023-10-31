package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salon") // Ajusta el nombre de la tabla si es necesario
public class Salon {
    @EmbeddedId
    private ServicioPK pk;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "tiposalon")
    private String tipoSalon;

    @Column(name = "horasuso")
    private Integer horasUso;

    @Column(name = "equipocomputacion")
    private Character equipoComputacion;

    @Column(name = "equipoproyeccion")
    private Character equipoProyeccion;

    @Column(name = "equipoamplificacion")
    private Character equipoAmplificacion;

    public Salon() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Salon(Servicio servicio, Integer capacidad, String tipoSalon, Integer horasUso, Character equipoComputacion,
            Character equipoProyeccion, Character equipoAmplificacion) {
        this.pk = new ServicioPK(servicio);
        this.capacidad = capacidad;
        this.tipoSalon = tipoSalon;
        this.horasUso = horasUso;
        this.equipoComputacion = equipoComputacion;
        this.equipoProyeccion = equipoProyeccion;
        this.equipoAmplificacion = equipoAmplificacion;
    }

    public ServicioPK getPk() {
        return pk;
    }

    public void setPk(ServicioPK pk) {
        this.pk = pk;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoSalon() {
        return tipoSalon;
    }

    public void setTipoSalon(String tipoSalon) {
        this.tipoSalon = tipoSalon;
    }

    public Integer getHorasUso() {
        return horasUso;
    }

    public void setHorasUso(Integer horasUso) {
        this.horasUso = horasUso;
    }

    public Character getEquipoComputacion() {
        return equipoComputacion;
    }

    public void setEquipoComputacion(Character equipoComputacion) {
        this.equipoComputacion = equipoComputacion;
    }

    public Character getEquipoProyeccion() {
        return equipoProyeccion;
    }

    public void setEquipoProyeccion(Character equipoProyeccion) {
        this.equipoProyeccion = equipoProyeccion;
    }

    public Character getEquipoAmplificacion() {
        return equipoAmplificacion;
    }

    public void setEquipoAmplificacion(Character equipoAmplificacion) {
        this.equipoAmplificacion = equipoAmplificacion;
    }
}
