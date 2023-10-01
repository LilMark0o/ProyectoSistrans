package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Piscina;

public interface PiscinaRepository extends JpaRepository<Piscina, Integer> {

        @Query(value = "SELECT * FROM piscina", nativeQuery = true)
        Collection<Piscina> darPiscinas();

        @Query(value = "SELECT * FROM piscina WHERE id = :id", nativeQuery = true)
        Piscina darPiscinaPorId(@Param("id") int id);

        /*
         * @Override
         * public String toString() {
         * return "Piscina{" +
         * "id=" + id +
         * ", profundidad=" + profundidad +
         * ", horaInicio=" + horaInicio +
         * ", horaFin=" + horaFin +
         * ", secobra=" + secobra +
         * ", hotel=" + hotel +
         * '}';
         * }
         */
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO piscina (id, profundidad, horainicio, horafin, secobra, hotel_id) VALUES (:id, :profundidad, :horainicio, :horafin, :secobra, :hotel_id)", nativeQuery = true)
        void insertarPiscina(@Param("id") Integer id, @Param("profundidad") Float profundidad,
                        @Param("horainicio") Integer horainicio,
                        @Param("horafin") Integer horafin, @Param("secobra") int secobra,
                        @Param("hotel_id") Integer hotel_id);

        @Modifying
        @Transactional
        @Query(value = "UPDATE piscina SET profundidad = :profundidad, horainicio = :horainicio, horafin = :horafin, secobra = :secobra, hotel_id = :hotel_id WHERE id = :id", nativeQuery = true)
        void actualizarPiscina(@Param("id") Integer id, @Param("profundidad") Float profundidad,
                        @Param("horainicio") Integer horainicio, @Param("horafin") Integer horafin,
                        @Param("secobra") int secobra,
                        @Param("hotel_id") Integer hotel_id);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM piscina WHERE id = :id", nativeQuery = true)
        void eliminarPiscina(@Param("id") Integer id);

}
