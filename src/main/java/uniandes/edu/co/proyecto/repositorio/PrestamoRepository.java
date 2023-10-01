package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    @Query(value = "SELECT * FROM prestamo", nativeQuery = true)
    Collection<Prestamo> darPrestamos();

    @Query(value = "SELECT * FROM prestamo WHERE id = :id", nativeQuery = true)
    Prestamo darPrestamoPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamo (id, hotel_id, utensilio_id, devuelto) VALUES (:id, :hotel_id, :utensilio_id, :devuelto)", nativeQuery = true)
    void insertarPrestamo(@Param("id") Integer id, @Param("hotel_id") Integer hotel_id,
    @Param("utensilio_id") Integer utensilio_id, @Param("devuelto") Boolean devuelto);
    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamo SET id = :id, hotel_id = :hotel_id, utensilio_id = :utensilio_id, devuelto = :devuelto WHERE id = :id", nativeQuery = true)
    void actualizarPrestamo(@Param("id") Integer id, @Param("hotel_id") Integer hotel_id, @Param("utensilio_id") Integer utensilio_id, @Param("devuelto") Integer devuelto);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamo WHERE id = :id", nativeQuery = true)
    void eliminarPrestamo(@Param("id") Integer id);

}