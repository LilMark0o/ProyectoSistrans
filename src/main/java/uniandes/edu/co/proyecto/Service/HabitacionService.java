// package uniandes.edu.co.proyecto.Service;

// import java.math.BigDecimal;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import uniandes.edu.co.proyecto.dtos.Req11DTO;
// import uniandes.edu.co.proyecto.dtos.Req3DTO;
// import uniandes.edu.co.proyecto.dtos.ServicioResumenDTO;
// import uniandes.edu.co.proyecto.modelo.ServicioResumen;
// import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;

// @Service
// public class HabitacionService {

// @Autowired
// private HabitacionRepository habitacionRepository;

// public List<ServicioResumenDTO> findServicioResumen() {
// List<Object[]> results = habitacionRepository.findServicioResumenData();
// List<ServicioResumenDTO> dtos = new ArrayList<>();
// for (Object[] result : results) {
// ServicioResumenDTO dto = new ServicioResumenDTO(
// ((Number) result[0]).intValue(),
// (String) result[1],
// (BigDecimal) result[2]
// );
// dtos.add(dto);
// }
// return dtos;
// }

// public List<Req3DTO> findReq3() {
// List<Object[]> results = habitacionRepository.findHabitacionResumenData();
// List<Req3DTO> dtos = new ArrayList<>();
// for (Object[] result : results) {
// Req3DTO dto = new Req3DTO(
// ((Number) result[0]).intValue(),
// ((Number) result[1]).intValue(),
// ((Number) result[2]).intValue(),
// ((Number) result[3]).floatValue());
// dtos.add(dto);

// }
// return dtos;
// }

// public List<Req11DTO> findReq11(String date1, String date2) {
// List<Object[]> results = habitacionRepository.findHabitacionPorSemana(date1,
// date2);
// List<Req11DTO> dtos = new ArrayList<>();
// for (Object[] result : results) {
// Req11DTO dto = new Req11DTO(
// ((String) result[0]),
// ((String) result[1]),
// ((String) result[2]),
// ((String) result[3]),
// ((String) result[4]));
// dtos.add(dto);

// }
// return dtos;
// }

// }
