package uniandes.edu.co.proyecto.dtos;

// WITH EstanciasPorTrimestre AS (
//     SELECT u.id, u.nombre, COUNT(DISTINCT TRUNC(r.checkin, 'Q')) as NumTrimestres
//     FROM usuario u
//     INNER JOIN reserva r ON u.id = r.usuario_id
//     GROUP BY u.id, u.nombre
//     HAVING COUNT(DISTINCT TRUNC(r.checkin, 'Q')) >= 4
// ),
// ServiciosCostosos AS (
//     SELECT DISTINCT u.id, u.nombre
//     FROM usuario u
//     INNER JOIN reserva r ON u.id = r.usuario_id
//     INNER JOIN cuentaservicio cs ON r.id = cs.reserva_id
//     INNER JOIN servicio s ON cs.servicio_id = s.id
//     WHERE s.precio > 300000
// ),
// ServiciosDuraderos AS (
//     SELECT DISTINCT u.id, u.nombre
//     FROM usuario u
//     INNER JOIN reserva r ON u.id = r.usuario_id
//     INNER JOIN reservaservicio rs ON u.id = rs.usuario_id
//     INNER JOIN servicio s ON rs.servicio_id = s.id
//     WHERE (s.descripcion LIKE '%SPA%' OR s.descripcion LIKE '%reuniones%')
//     AND (rs.horafin - rs.horainicio) > 4
// )
// SELECT u.id, u.nombre, u.username, u.hotel_id,'Cumple estancias por trimestre' as Justificacion
// FROM usuario u
// INNER JOIN EstanciasPorTrimestre ept ON u.id = ept.id
// UNION
// SELECT u.id, u.nombre, u.username, u.hotel_id, 'Consume servicios costosos' as Justificacion
// FROM usuario u
// INNER JOIN ServiciosCostosos sc ON u.id = sc.id
// UNION
// SELECT u.id, u.nombre, u.username, u.hotel_id, 'Consume servicios de SPA o reuniones duraderos' as Justificacion
// FROM usuario u
// INNER JOIN ServiciosDuraderos sd ON u.id = sd.id;


public class Req12DTO {
    
    private Integer id;
    private String nombre;
    private String username;
    private Integer hotel_id;
    private String justificacion;

    public Req12DTO(Integer id, String nombre, String username, Integer hotel_id, String justificacion) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.hotel_id = hotel_id;
        this.justificacion = justificacion;
    }

    public Req12DTO() {
        ;// Constructor vacío requerido por Jakarta Persistence
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre= nombre;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }
}
