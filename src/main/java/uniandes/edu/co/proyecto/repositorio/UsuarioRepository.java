package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    


    @Query(value = "SELECT u FROM Usuario u")
    Collection<Usuario> findAllUsers();

    @Query(value = "SELECT DISTINCT u.tipoUsuario FROM Usuario u")
    Collection<TipoUsuario> findAllTipoUsuario();

    @Query(value = "SELECT u FROM Usuario u WHERE u.id = :id")
    Usuario findUserById(@Param("id") int id);

    @Query(value = "SELECT u FROM Usuario u WHERE u.tipoUsuario.nombre = :tipoUsuario")
    Collection<Usuario> findUsersByTipoUsuario(@Param("tipoUsuario") String tipoUsuarioName);

    @Query(value = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    Collection<Usuario> findUsersByNombre(@Param("nombre") String nombre);

    @Query(value = "SELECT u FROM Usuario u WHERE u.username = :username")
    Usuario findUserByUsername(@Param("username") String username) ;

    @Query(value = """
        SELECT
        u.nombre AS Usuario,
        s.nombre AS Servicio,
        cs.descripcion AS DescripcionServicio,
        cs.fecha AS FechaServicio,
        s.precio AS PrecioServicio,
        p.nombre AS Producto,
        p.precio AS PrecioProducto
      FROM
        usuario u
          JOIN reserva r ON u.id = r.usuario_id
        JOIN habitacion hab ON r.habitacion_id = hab.id
        LEFT JOIN cuentaservicio cs ON r.id = cs.reserva_id
        LEFT JOIN servicio s ON cs.servicio_id = s.id
        LEFT JOIN servicioproducto sp ON s.id = sp.servicio_id
        LEFT JOIN producto p ON sp.producto_id = p.id
      WHERE
        u.id = :given_user_id 
        AND (
          (r.checkin BETWEEN TO_DATE(:start_date, 'YYYY-MM-DD')  AND  TO_DATE(:end_date, 'YYYY-MM-DD'))
          OR (r.checkout BETWEEN TO_DATE(:start_date, 'YYYY-MM-DD')  AND  TO_DATE(:end_date, 'YYYY-MM-DD'))
        )
      ORDER BY
        cs.fecha
        FETCH FIRST 50 ROWS ONLY
            """, nativeQuery = true)
    List<Object[]> findUserResumenData(@Param("given_user_id") Integer given_user_id, @Param("start_date") String start_date, @Param("end_date") String end_date);

    @Query(value = """
        WITH BuenClienteCriterio AS (
            SELECT
                r.usuario_id AS usuario_id,
                SUM(
                    CASE
                        WHEN r.checkout >= TRUNC(SYSDATE) - INTERVAL '1' YEAR THEN
                            r.checkout - GREATEST(r.checkin, TRUNC(SYSDATE) - INTERVAL '1' YEAR) + 1
                        ELSE
                            r.checkout - TRUNC(SYSDATE) + 1
                    END
                ) AS total_dias_hospedaje,
                SUM(
                    CASE
                        WHEN cs.fecha >= TRUNC(SYSDATE) - INTERVAL '1' YEAR THEN
                            CASE
                                WHEN cs.producto_id IS NOT NULL THEN p.precio
                                ELSE s.precio
                            END
                        ELSE
                            0
                    END
                ) AS total_consumo_ultimo_anio
            FROM
                reserva r
                LEFT JOIN cuentaservicio cs ON r.id = cs.reserva_id
                LEFT JOIN servicio s ON cs.servicio_id = s.id
                LEFT JOIN producto p ON cs.producto_id = p.id
            GROUP BY
                r.usuario_id
        )
        SELECT
            u.nombre AS Usuario,
            CASE
                WHEN BC.total_dias_hospedaje >= 14 OR BC.total_consumo_ultimo_anio >= 15000000 THEN
                    'Buen Cliente'
                ELSE
                    'Cliente Regular'
            END AS EstadoCliente,
            CASE
                WHEN BC.total_dias_hospedaje >= 14 AND BC.total_consumo_ultimo_anio >= 15000000 THEN
                    'Hospedaje de al menos 2 semanas y consumo superior a $15''000.000'
                WHEN BC.total_dias_hospedaje >= 14 THEN
                    'Hospedaje de al menos 2 semanas'
                WHEN BC.total_consumo_ultimo_anio >= 15000000 THEN
                    'Consumo superior a $15''000.000'
                ELSE
                    'No cumple con los criterios para ser considerado un buen cliente'
            END AS Razon
        FROM
            usuario u
            LEFT JOIN BuenClienteCriterio BC ON u.id = BC.usuario_id
        WHERE
            BC.total_dias_hospedaje >= 14 OR BC.total_consumo_ultimo_anio >= 15000000
            FETCH FIRST 50 ROWS ONLY
            """, nativeQuery = true)
    List<Object[]> findBuenosClientes();

    @Query(value = """
        WITH EstanciasPorTrimestre AS (
    SELECT u.id, u.nombre, COUNT(DISTINCT TRUNC(r.checkin, 'Q')) as NumTrimestres
    FROM usuario u
    INNER JOIN reserva r ON u.id = r.usuario_id
    GROUP BY u.id, u.nombre
    HAVING COUNT(DISTINCT TRUNC(r.checkin, 'Q')) >= 4
),
ServiciosCostosos AS (
    SELECT DISTINCT u.id, u.nombre
    FROM usuario u
    INNER JOIN reserva r ON u.id = r.usuario_id
    INNER JOIN cuentaservicio cs ON r.id = cs.reserva_id
    INNER JOIN servicio s ON cs.servicio_id = s.id
    WHERE s.precio > 300000
),
ServiciosDuraderos AS (
    SELECT DISTINCT u.id, u.nombre
    FROM usuario u
    INNER JOIN reserva r ON u.id = r.usuario_id
    INNER JOIN reservaservicio rs ON u.id = rs.usuario_id
    INNER JOIN servicio s ON rs.servicio_id = s.id
    WHERE (s.descripcion LIKE '%SPA%' OR s.descripcion LIKE '%reuniones%')
    AND (rs.horafin - rs.horainicio) > 4
)
SELECT u.id, u.nombre, u.username, u.hotel_id,'Cumple estancias por trimestre' as Justificacion
FROM usuario u
INNER JOIN EstanciasPorTrimestre ept ON u.id = ept.id
UNION
SELECT u.id, u.nombre, u.username, u.hotel_id, 'Consume servicios costosos' as Justificacion
FROM usuario u
INNER JOIN ServiciosCostosos sc ON u.id = sc.id
UNION
SELECT u.id, u.nombre, u.username, u.hotel_id, 'Consume servicios de SPA o reuniones duraderos' as Justificacion
FROM usuario u
INNER JOIN ServiciosDuraderos sd ON u.id = sd.id
FETCH FIRST 50 ROWS ONLY
            """, nativeQuery = true)
    List<Object[]> findBuenosClientesAlternativo();
    
}
