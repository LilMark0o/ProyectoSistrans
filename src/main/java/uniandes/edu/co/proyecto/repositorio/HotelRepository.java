package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.HabitacionConHotel;
import uniandes.edu.co.proyecto.modelo.Hotel;

import java.util.List;

public interface HotelRepository extends MongoRepository<Hotel, String> {

    List<Hotel> findByNombre(String nombre);

    @Aggregation(pipeline = {
        "{ $unwind: '$habitaciones' }",
        "{ $project: { idHabitacion: '$habitaciones.id', descripcionHabitacion: '$habitaciones.descripcion', tipoHabitacionId: '$habitaciones.tipoHabitacionId', idHotel: '$_id', nombreHotel: '$nombre' } }"
    })
    List<HabitacionConHotel> findAllHabitacionesConInfoHotel();

    @Query(value = "{ 'habitaciones._id': ?0 }", fields = "{ 'nombre': 1, 'habitaciones.$': 1 }")
    Hotel findHotelByHabitacionId(String habitacionId);
}
