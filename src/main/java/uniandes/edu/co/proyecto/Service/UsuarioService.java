package uniandes.edu.co.proyecto.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.dtos.Req3DTO;
import uniandes.edu.co.proyecto.dtos.Req5DTO;
import uniandes.edu.co.proyecto.dtos.Req7DTO;
import uniandes.edu.co.proyecto.dtos.ServicioResumenDTO;
import uniandes.edu.co.proyecto.modelo.ServicioResumen;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

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

}
