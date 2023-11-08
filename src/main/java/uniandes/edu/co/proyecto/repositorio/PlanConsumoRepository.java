package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.PlanConsumo;

public interface PlanConsumoRepository extends JpaRepository<PlanConsumo, Integer> {

    @Query(value = "SELECT * FROM planconsumo", nativeQuery = true)
    Collection<PlanConsumo> darPlanesConsumo();

    @Query(value = "SELECT * FROM planconsumo WHERE id = :id", nativeQuery = true)
    PlanConsumo darPlanConsumoPorId(@Param("id") int id);

    /*
     * @Override
     * public String toString() {
     * return "PlanConsumo{" +
     * "id=" + id +
     * ", descripcion='" + descripcion + '\'' +
     * ", descuento=" + descuento +
     * ", hotel=" + hotel +
     * '}';
     * }
     */
    @Modifying
    @Transactional
    /*
     * @Override
     * public String toString() {
     * return "PlanConsumo{" +
     * "id=" + id +
     * ", descripcion='" + descripcion + '\'' +
     * ", descuento=" + descuento +
     * ", hotel=" + hotel +
     * '}';
     * }
     */
    @Query(value = "INSERT INTO planconsumo (id, descripcion, descuento, hotel_id) VALUES (:id, :descripcion, :descuento, :hotel_id)", nativeQuery = true)
    void insertarPlanConsumo(@Param("id") Integer id, @Param("descripcion") String descripcion,
            @Param("descuento") Integer descuento, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE planconsumo SET descripcion = :descripcion, descuento = :descuento, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
    void actualizarPlanConsumo(@Param("id") Integer id, @Param("descripcion") String descripcion,
            @Param("descuento") Integer descuento, @Param("hotel_id") Integer hotel_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planconsumo WHERE id = :id", nativeQuery = true)
    void eliminarPlanConsumo(@Param("id") Integer id);

}

