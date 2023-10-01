package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaInternet;

import java.util.Collection;

public interface CuentaInternetRepository extends JpaRepository<CuentaInternet, Integer> {

    @Query(value = "SELECT * FROM cuentainternet", nativeQuery = true)
    Collection<CuentaInternet> findAllCuentaInternet();

    @Query(value = "SELECT * FROM cuentainternet WHERE idCuenta = :idcuenta and idInternet = :idinternet", nativeQuery = true)
    CuentaInternet findCuentaInternetById(@Param("idcuenta") Integer idcuenta, @Param("idinternet") Integer idinternet);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentainternet (idCuenta, idInternet) VALUES (:idcuenta, :idinternet)", nativeQuery = true)
    void insertCuentaInternet(@Param("idcuenta") Integer idcuenta, @Param("idinternet") Integer idinternet);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentainternet SET idCuenta = :idcuenta, idInternet = :idinternet WHERE idCuenta = :oldIdCuenta and idInternet = :oldIdInternet", nativeQuery = true)
    void updateCuentaInternet(@Param("oldIdCuenta") Integer oldIdCuenta, @Param("oldIdInternet") Integer oldIdInternet,
            @Param("idcuenta") Integer idcuenta, @Param("idinternet") Integer idinternet);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentainternet WHERE idCuenta = :idcuenta and idInternet = :idinternet", nativeQuery = true)
    void deleteCuentaInternet(@Param("idcuenta") Integer idcuenta, @Param("idinternet") Integer idinternet);
}
