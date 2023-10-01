package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaPiscina;

import java.util.Collection;

public interface CuentaPiscinaRepository extends JpaRepository<CuentaPiscina, Integer> {

    @Query(value = "SELECT * FROM cuentapiscina", nativeQuery = true)
    Collection<CuentaPiscina> findAllCuentaPiscina();

    @Query(value = "SELECT * FROM cuentapiscina WHERE idCuenta = :idcuenta and idPiscina = :idpiscina", nativeQuery = true)
    CuentaPiscina findCuentaPiscinaById(@Param("idcuenta") Integer idcuenta, @Param("idpiscina") Integer idpiscina);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentapiscina (idCuenta, idPiscina) VALUES (:idcuenta, :idpiscina)", nativeQuery = true)
    void insertCuentaPiscina(@Param("idcuenta") Integer idcuenta, @Param("idpiscina") Integer idpiscina);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentapiscina SET idCuenta = :idcuenta, idPiscina = :idpiscina WHERE idCuenta = :oldIdCuenta and idPiscina = :oldIdPiscina", nativeQuery = true)
    void updateCuentaPiscina(@Param("oldIdCuenta") Integer oldIdCuenta, @Param("oldIdPiscina") Integer oldIdPiscina,
            @Param("idcuenta") Integer idcuenta, @Param("idpiscina") Integer idpiscina);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentapiscina WHERE idCuenta = :idcuenta and idPiscina = :idpiscina", nativeQuery = true)
    void deleteCuentaPiscina(@Param("idcuenta") Integer idcuenta, @Param("idpiscina") Integer idpiscina);
}
