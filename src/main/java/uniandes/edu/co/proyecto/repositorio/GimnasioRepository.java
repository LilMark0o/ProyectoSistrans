package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Gimnasio;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer> {

        @Query(value = "SELECT * FROM gimnasio", nativeQuery = true)
        Collection<Gimnasio> darGimnasios();

        @Query(value = "SELECT * FROM gimnasio WHERE id = :servicio_id", nativeQuery = true)
        Gimnasio darGimnasioPorId(@Param("servicio_id") int servicio_id);

        @Modifying
        @Transactional
        @Query(value = "INSERT INTO gimnasio (id, horainicio, horafin) VALUES (:servicio_id, :horainicio, :horafin)", nativeQuery = true)
        void insertarGimnasio(@Param("servicio_id") Integer servicio_id, @Param("horainicio") Integer horainicio,
                        @Param("horafin") Integer horafin);

        @Modifying
        @Transactional
        @Query(value = "UPDATE gimnasio SET horainicio = :horainicio, horafin = :horafin WHERE id = :servicio_id", nativeQuery = true)
        void actualizarGimnasio(@Param("servicio_id") Integer servicio_id, @Param("horainicio") Integer horainicio,
                        @Param("horafin") Integer horafin);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM gimnasio WHERE id = :servicio_id", nativeQuery = true)
        void eliminarGimnasio(@Param("servicio_id") Integer servicio_id);

}