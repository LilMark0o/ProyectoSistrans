package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Maquina;

public interface MaquinaRepository extends JpaRepository<Maquina, Integer> {

    @Query(value = "SELECT * FROM maquina", nativeQuery = true)
    Collection<Maquina> darMaquinas();

    @Query(value = "SELECT * FROM maquina WHERE id = :id", nativeQuery = true)
    Maquina darMaquinaPorId(@Param("id") int id);

    /*
     * @Override
     * public String toString() {
     * return "Maquina{" +
     * "id=" + id +
     * ", nombre='" + nombre + '\'' +
     * ", gimnasio=" + gimnasio +
     * '}';
     * }
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO maquina (id, nombre, gimnasio_id) VALUES (:id, :nombre, :gimnasio_id)", nativeQuery = true)
    void insertarMaquina(@Param("id") Integer id, @Param("nombre") String nombre,
            @Param("gimnasio_id") Integer gimnasio_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE maquina SET nombre = :nombre, gimnasio_id = :gimnasio_id WHERE id = :id", nativeQuery = true)
    void actualizarMaquina(@Param("id") Integer id, @Param("nombre") String nombre,
            @Param("gimnasio_id") Integer gimnasio_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM maquina WHERE id = :id", nativeQuery = true)
    void eliminarMaquina(@Param("id") Integer id);

}
