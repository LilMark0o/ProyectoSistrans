package uniandes.edu.co.proyecto.dtos;
// SELECT
//     s.id AS servicio_id,
//     s.nombre AS servicio_nombre,
//     COUNT(cs.id) AS cantidad_consumos
// FROM
//     servicio s
//     JOIN cuentaservicio cs ON s.id = cs.servicio_id
// WHERE
//     cs.fecha >= TO_DATE('2022-01-01', 'YYYY-MM-DD') -- Fecha de inicio
//     AND cs.fecha <= TO_DATE('2023-12-31', 'YYYY-MM-DD') -- Fecha de fin
// GROUP BY
//     s.id, s.nombre
// ORDER BY
//     cantidad_consumos DESC
// FETCH FIRST 20 ROWS ONLY;
public class Req2DTO {
    
    Integer servicio_id;
    String servicio_nombre;
    Integer cantidad_consumos;

    public Req2DTO(Integer servicio_id, String servicio_nombre, Integer cantidad_consumos) {
        this.servicio_id = servicio_id;
        this.servicio_nombre = servicio_nombre;
        this.cantidad_consumos = cantidad_consumos;
    }

    public Integer getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(Integer servicio_id) {
        this.servicio_id = servicio_id;
    }

    public String getServicio_nombre() {
        return servicio_nombre;
    }

    public void setServicio_nombre(String servicio_nombre) {
        this.servicio_nombre = servicio_nombre;
    }

    public Integer getCantidad_consumos() {
        return cantidad_consumos;
    }

    public void setCantidad_consumos(Integer cantidad_consumos) {
        this.cantidad_consumos = cantidad_consumos;
    }

}
