package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Lavado;

public interface LavadoRepository extends JpaRepository<Lavado, Integer>{

    @Query(value = "SELECT * FROM lavado", nativeQuery = true)
    Collection<Lavado> darServiciosLavado();

    @Query(value = "SELECT * FROM lavado WHERE id = :id", nativeQuery = true)
    Lavado darLavadoPorId(@Param("id") int id);

    /*
     * @Override
    public String toString() {
        return "Lavado{" +
                "id=" + id +
                ", precio=" + precio +
                ", cantidadalavar=" + cantidadalavar +
                '}';
    }
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO lavado (precio, cantidadalavar) VALUES (:precio, :cantidadalavar)", nativeQuery = true)
    void insertarLavado(@Param("precio") Float precio, @Param("cantidadalavar") Integer cantidadalavar);

    @Modifying
    @Transactional
    @Query(value = "UPDATE lavado SET precio = :precio, cantidadalavar = :cantidadalavar WHERE id = :id", nativeQuery = true)
    void actualizarLavado(@Param("id") Integer id, @Param("precio") Float precio, @Param("cantidadalavar") Integer cantidadalavar);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM lavado WHERE id = :id", nativeQuery = true)
    void eliminarLavado(@Param("id") Integer id);
    

}
