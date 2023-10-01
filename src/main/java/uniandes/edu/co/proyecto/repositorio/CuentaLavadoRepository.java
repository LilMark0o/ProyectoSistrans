package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaLavado;

import java.util.Collection;

public interface CuentaLavadoRepository extends JpaRepository<CuentaLavado, Integer> {

    @Query(value = "SELECT * FROM cuentalavado", nativeQuery = true)
    Collection<CuentaLavado> findAllCuentaLavado();

    @Query(value = "SELECT * FROM cuentalavado WHERE idCuenta = :idcuenta and idLavado = :idlavado", nativeQuery = true)
    CuentaLavado findCuentaLavadoById(@Param("idcuenta") Integer idcuenta, @Param("idlavado") Integer idlavado);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentalavado (idCuenta, idLavado) VALUES (:idcuenta, :idlavado)", nativeQuery = true)
    void insertCuentaLavado(@Param("idcuenta") Integer idcuenta, @Param("idlavado") Integer idlavado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentalavado SET idCuenta = :idcuenta, idLavado = :idlavado WHERE idCuenta = :oldIdCuenta and idLavado = :oldIdLavado", nativeQuery = true)
    void updateCuentaLavado(@Param("oldIdCuenta") Integer oldIdCuenta, @Param("oldIdLavado") Integer oldIdLavado,
            @Param("idcuenta") Integer idcuenta, @Param("idlavado") Integer idlavado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentalavado WHERE idCuenta = :idcuenta and idLavado = :idlavado", nativeQuery = true)
    void deleteCuentaLavado(@Param("idcuenta") Integer idcuenta, @Param("idlavado") Integer idlavado);
}
