package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.CuentaSalon;

import java.util.Collection;

public interface CuentaSalonRepository extends JpaRepository<CuentaSalon, Integer> {

    @Query(value = "SELECT * FROM cuentasalon", nativeQuery = true)
    Collection<CuentaSalon> findAllCuentaSalon();

    @Query(value = "SELECT * FROM cuentasalon WHERE idCuenta = :idcuenta and idSalon = :idsalon", nativeQuery = true)
    CuentaSalon findCuentaSalonById(@Param("idcuenta") Integer idcuenta, @Param("idsalon") Integer idsalon);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentasalon (idCuenta, idSalon) VALUES (:idcuenta, :idsalon)", nativeQuery = true)
    void insertCuentaSalon(@Param("idcuenta") Integer idcuenta, @Param("idsalon") Integer idsalon);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentasalon SET idCuenta = :idcuenta, idSalon = :idsalon WHERE idCuenta = :oldIdCuenta and idSalon = :oldIdSalon", nativeQuery = true)
    void updateCuentaSalon(@Param("oldIdCuenta") Integer oldIdCuenta, @Param("oldIdSalon") Integer oldIdSalon,
            @Param("idcuenta") Integer idcuenta, @Param("idsalon") Integer idsalon);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentasalon WHERE idCuenta = :idcuenta and idSalon = :idsalon", nativeQuery = true)
    void deleteCuentaSalon(@Param("idcuenta") Integer idcuenta, @Param("idsalon") Integer idsalon);
}
