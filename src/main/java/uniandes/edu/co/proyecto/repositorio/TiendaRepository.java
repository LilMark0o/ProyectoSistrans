package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

    @Query(value = "SELECT * FROM tienda", nativeQuery = true)
    Collection<Tienda> darTiendas();

    @Query(value = "SELECT * FROM tienda WHERE id = :id", nativeQuery = true)
    Tienda darTiendaPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tienda (id, hotel_id) VALUES (:id, :hotel_id)", nativeQuery = true)
    void insertarTienda(@Param("id") int id, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tienda SET id = :id, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarTienda(@Param("id") Integer id, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tienda WHERE id = :id", nativeQuery = true)
    void eliminarTienda(@Param("id") Integer id);

}