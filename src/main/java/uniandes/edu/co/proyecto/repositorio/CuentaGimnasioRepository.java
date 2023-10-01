package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaGimnasio;

import java.util.Collection;

public interface CuentaGimnasioRepository extends JpaRepository<CuentaGimnasio, Integer> {

    @Query(value = "SELECT * FROM cuentagimnasio", nativeQuery = true)
    Collection<CuentaGimnasio> findAllCuentaGimnasio();

    @Query(value = "SELECT * FROM cuentagimnasio WHERE idCuenta = :idcuenta and idGimnasio = :idgimnasio", nativeQuery = true)
    CuentaGimnasio findCuentaGimnasioById(@Param("idcuenta") Integer idcuenta, @Param("idgimnasio") Integer idgimnasio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentagimnasio (idCuenta, idGimnasio) VALUES (:idcuenta, :idgimnasio)", nativeQuery = true)
    void insertCuentaGimnasio(@Param("idcuenta") Integer idcuenta, @Param("idgimnasio") Integer idgimnasio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentagimnasio SET idCuenta = :idcuenta, idGimnasio = :idgimnasio WHERE idCuenta = :oldIdCuenta and idGimnasio = :oldIdGimnasio", nativeQuery = true)
    void updateCuentaGimnasio(@Param("oldIdCuenta") Integer oldIdCuenta, @Param("oldIdGimnasio") Integer oldIdGimnasio,
            @Param("idcuenta") Integer idcuenta, @Param("idgimnasio") Integer idgimnasio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentagimnasio WHERE idCuenta = :idcuenta and idGimnasio = :idgimnasio", nativeQuery = true)
    void deleteCuentaGimnasio(@Param("idcuenta") Integer idcuenta, @Param("idgimnasio") Integer idgimnasio);
}
