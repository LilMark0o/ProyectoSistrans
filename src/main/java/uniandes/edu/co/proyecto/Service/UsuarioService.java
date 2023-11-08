package uniandes.edu.co.proyecto.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import uniandes.edu.co.proyecto.dtos.Req5DTO;
import uniandes.edu.co.proyecto.dtos.Req7DTO;
import uniandes.edu.co.proyecto.dtos.ReqDTO9;

import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Req5DTO> findServicioResumen(Integer id, String date1, String date2) {
        List<Object[]> results = usuarioRepository.findUserResumenData(id, date1, date2);
        List<Req5DTO> dtos = new ArrayList<>();
        for (Object[] result : results) {
            Req5DTO dto = new Req5DTO(
                    (String) result[0],
                    (String) result[1],
                    (String) result[2],
                    (String) result[3],
                    ((BigDecimal) result[4]).floatValue(),
                    (String) result[5],
                    ((BigDecimal) result[6]).floatValue()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    public List<Req7DTO> findBuenCliente() {
        List<Object[]> results = usuarioRepository.findBuenosClientes();
        List<Req7DTO> dtos = new ArrayList<>();
        for (Object[] result : results) {

            Req7DTO dto = new Req7DTO(
                    (String) result[0],
                    (String) result[1],
                    (String) result[2]
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public List<Object[]> findClientesConAgrupamientoYOrdenamientoDinamico(
            Integer servicioId,
            Date fechaInicio,
            Date fechaFin,
            String agrupamiento, 
            String ordenamiento
    ) {
        // Aquí puedes armar tu consulta como la necesites usando el EntityManager
        String sql = "SELECT u.id, u.nombre, COUNT(cs.id) AS numero_de_veces, MAX(cs.fecha) AS ultima_fecha_uso " +
                     "FROM usuario u " +
                     "JOIN reserva r ON u.id = r.usuario_id " +
                     "JOIN cuentaservicio cs ON cs.reserva_id = r.id " +
                     "JOIN servicio s ON cs.servicio_id = s.id " +
                     "WHERE s.id = :servicioId " +
                     "AND cs.fecha BETWEEN :fechaInicio AND :fechaFin " +
                     "GROUP BY " + agrupamiento + " " +
                     "ORDER BY " + agrupamiento + " " + ordenamiento;

        // Ejecuta la consulta
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("servicioId", servicioId);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);

        return query.getResultList();
    }

    public List<ReqDTO9> findClientesConAgrupamiento(Integer id, String date1, String date2, String agrupamiento, String ordenamiento) {
        List<Object[]> results = this.findClientesConAgrupamientoYOrdenamientoDinamico(id, Date.valueOf(date1), Date.valueOf(date2), agrupamiento, ordenamiento);
        List<ReqDTO9> dtos = new ArrayList<>();
        for (Object[] result : results) {
            ReqDTO9 dto = new ReqDTO9(
                    ((String) result[0]),
                    (String) result[1],
                    ((Number) result[2]).intValue()
                                );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public List<Object[]> findClientesSinConsumoDeServicio(
            Integer servicioId,
            Date fechaInicio,
            Date fechaFin,
            String agrupamiento, 
            String ordenamiento
    ) {
        // Seleccionamos clientes que NO consumieron el servicio específico
        String sql = "SELECT DISTINCT u.id, u.nombre " +
                     "FROM usuario u " +
                     "WHERE u.id NOT IN (" +
                     "    SELECT DISTINCT u.id " +
                     "    FROM usuario u " +
                     "    JOIN reserva r ON u.id = r.usuario_id " +
                     "    JOIN cuentaservicio cs ON r.id = cs.reserva_id " +
                     "    WHERE cs.servicio_id = :servicioId " +
                     "    AND cs.fecha BETWEEN :fechaInicio AND :fechaFin" +
                     ") ";

        // Agregar el agrupamiento y ordenamiento
        if (agrupamiento != null && !agrupamiento.isEmpty()) {
            sql += "GROUP BY " + agrupamiento + " ";
        }
        if (ordenamiento != null && !ordenamiento.isEmpty()) {
            sql += "ORDER BY " + (agrupamiento != null ? agrupamiento : "u.id") + " " + ordenamiento;
        }

        // Ejecuta la consulta
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("servicioId", servicioId);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);

        return query.getResultList();
    }

    
}