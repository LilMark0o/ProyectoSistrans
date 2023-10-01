package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaPrestamo;

import java.util.Collection;

public interface CuentaPrestamoRepository extends JpaRepository<CuentaPrestamo, Integer> {

    @Query(value = "SELECT * FROM cuentaprestamo", nativeQuery = true)
    Collection<CuentaPrestamo> findAllCuentaPrestamo();

    @Query(value = "SELECT * FROM cuentaprestamo WHERE idCuenta = :idcuenta and idPrestamo = :idprestamo", nativeQuery = true)
    CuentaPrestamo findCuentaPrestamoById(@Param("idcuenta") Integer idcuenta, @Param("idprestamo") Integer idprestamo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentaprestamo (idCuenta, idPrestamo) VALUES (:idcuenta, :idprestamo)", nativeQuery = true)
    void insertCuentaPrestamo(@Param("idcuenta") Integer idcuenta, @Param("idprestamo") Integer idprestamo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentaprestamo SET idCuenta = :idcuenta, idPrestamo = :idprestamo WHERE idCuenta = :oldIdCuenta and idPrestamo = :oldIdPrestamo", nativeQuery = true)
    void updateCuentaPrestamo(@Param("oldIdCuenta") Integer oldIdCuenta, @Param("oldIdPrestamo") Integer oldIdPrestamo,
            @Param("idcuenta") Integer idcuenta, @Param("idprestamo") Integer idprestamo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentaprestamo WHERE idCuenta = :idcuenta and idPrestamo = :idprestamo", nativeQuery = true)
    void deleteCuentaPrestamo(@Param("idcuenta") Integer idcuenta, @Param("idprestamo") Integer idprestamo);
}
