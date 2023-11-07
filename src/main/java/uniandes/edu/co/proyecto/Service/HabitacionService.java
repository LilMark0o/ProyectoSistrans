package uniandes.edu.co.proyecto.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
