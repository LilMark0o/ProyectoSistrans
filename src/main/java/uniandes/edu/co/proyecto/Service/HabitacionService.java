package uniandes.edu.co.proyecto.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.dtos.Req3DTO;
import uniandes.edu.co.proyecto.dtos.ServicioResumenDTO;
import uniandes.edu.co.proyecto.modelo.ServicioResumen;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    public List<ServicioResumenDTO> findServicioResumen() {
        List<Object[]> results = habitacionRepository.findServicioResumenData();
        List<ServicioResumenDTO> dtos = new ArrayList<>();
        for (Object[] result : results) {
            ServicioResumenDTO dto = new ServicioResumenDTO(
                    ((Number) result[0]).intValue(),
                    (String) result[1],
                    (BigDecimal) result[2]
            );
            dtos.add(dto);
        }
        return dtos;
    }

    public List<Req3DTO> findReq3() {
        List<Object[]> results = habitacionRepository.findHabitacionResumenData();
        List<Req3DTO> dtos = new ArrayList<>();
        for (Object[] result : results) {
            Req3DTO dto = new Req3DTO(
                ((Number) result[0]).intValue(),
                ((Number) result[1]).intValue(),
                ((Number) result[2]).intValue(),
                ((Number) result[3]).floatValue());
            dtos.add(dto);

             }
        return dtos;
    }

                    
}
