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
    @Query(value = "INSERT INTO prestamo (id, fecha, valor, cliente_id, habitacion_id) VALUES (:id, :fecha, :valor, :cliente_id, :habitacion_id)", nativeQuery = true)
    void insertarPrestamo(@Param("id") Integer id, @Param("fecha") String fecha, @Param("valor") Integer valor,
            @Param("cliente_id") Integer cliente_id, @Param("habitacion_id") Integer habitacion_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamo SET fecha = :fecha, valor = :valor, cliente_id = :cliente_id, habitacion_id = :habitacion_id WHERE id = :id", nativeQuery = true)
    void actualizarPrestamo(@Param("id") Integer id, @Param("fecha") String fecha, @Param("valor") Integer valor,
            @Param("cliente_id") Integer cliente_id, @Param("habitacion_id") Integer habitacion_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamo WHERE id = :id", nativeQuery = true)
    void eliminarPrestamo(@Param("id") Integer id);

}