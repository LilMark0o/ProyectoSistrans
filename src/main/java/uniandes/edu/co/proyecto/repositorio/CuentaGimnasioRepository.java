package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaGimnasio;

public interface CuentaGimnasioRepository extends JpaRepository<CuentaGimnasio, Integer>{

    @Query(value = "SELECT * FROM cuentagimnasio", nativeQuery = true)
    Collection<CuentaGimnasio> darCuentasGimnasio();

    @Query(value = "SELECT * FROM cuentagimnasio WHERE id = :id", nativeQuery = true)
    CuentaGimnasio darCuentaGimnasioPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentagimnasio (fecha, valor, cliente_id, gimnasio_id) VALUES (:fecha, :valor, :cliente_id, :gimnasio_id)", nativeQuery = true)
    void insertarCuentaGimnasio(@Param("fecha") String fecha, @Param("valor") Integer valor, @Param("cliente_id") Integer cliente_id, @Param("gimnasio_id") Integer gimnasio_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentagimnasio SET fecha = :fecha, valor = :valor, cliente_id = :cliente_id, gimnasio_id = :gimnasio_id WHERE id = :id", nativeQuery = true)
    void actualizarCuentaGimnasio(@Param("id") Integer id, @Param("fecha") String fecha, @Param("valor") Integer valor, @Param("cliente_id") Integer cliente_id, @Param("gimnasio_id") Integer gimnasio_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentagimnasio WHERE id = :id", nativeQuery = true)
    void eliminarCuentaGimnasio(@Param("id") Integer id);
    

}