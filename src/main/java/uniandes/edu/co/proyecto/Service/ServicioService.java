// package uniandes.edu.co.proyecto.Service;

// import java.math.BigDecimal;
// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import uniandes.edu.co.proyecto.dtos.Req2DTO;
// import uniandes.edu.co.proyecto.dtos.Req6DTO;
// import uniandes.edu.co.proyecto.dtos.Req8DTO;
// import uniandes.edu.co.proyecto.dtos.ServicioResumenDTO;
// import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

// @Service
// public class ServicioService {

// @Autowired
// private ServicioRepository servicioRepository;

// public List<Req2DTO> findServicioResumen(String date1, String date2) {
// List<Object[]> results = servicioRepository.findServicioResumenData(date1,
// date2);
// List<Req2DTO> dtos = new ArrayList<>();
// for (Object[] result : results) {
// Req2DTO dto = new Req2DTO(
// ((Number) result[0]).intValue(),
// (String) result[1],
// ((Number) result[2]).intValue()
// );
// dtos.add(dto);
// }
// return dtos;
// }

// public List<Req6DTO> findFechaOcupacion() {
// List<Object[]> results = servicioRepository.findFechaFilter();
// List<Req6DTO> dtos = new ArrayList<>();
// for (Object[] result : results) {

// Req6DTO dto = new Req6DTO(
// (String) result[0],
// (String) result[1],
// ((BigDecimal) result[2]).intValue()
// );
// dtos.add(dto);
// }
// return dtos;
// }

// public List<Req8DTO> findServiciosSolicitados() {
// List<Object[]> results = servicioRepository.findFechaFilter();
// List<Req8DTO> dtos = new ArrayList<>();
// for (Object[] result : results) {
// Req8DTO dto = new Req8DTO(
// (String) result[0],
// (String) result[1],
// ((Number) result[2]).intValue()
// );
// dtos.add(dto);
// }
// return dtos;
// }

// }