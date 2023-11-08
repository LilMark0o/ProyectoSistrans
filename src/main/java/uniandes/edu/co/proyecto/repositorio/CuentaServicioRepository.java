package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.CuentaServicio;

import java.util.Collection;
import java.util.Date;

public interface CuentaServicioRepository extends JpaRepository<CuentaServicio, Integer> {

        @Query(value = "SELECT * FROM cuentaservicio", nativeQuery = true)
        Collection<CuentaServicio> darCuentaServicios();

        @Query(value = "SELECT * FROM cuentaservicio WHERE producto_id IS NULL", nativeQuery = true)
        Collection<CuentaServicio> darCuentaServiciosConProducto();

        @Query(value = "SELECT * FROM cuentaservicio WHERE producto_id IS NOT NULL and servicio_id IS NOT NULL", nativeQuery = true)
        Collection<CuentaServicio> darCuentaServiciosSinProducto();

        @Query(value = "SELECT * FROM cuentaservicio WHERE id = :id", nativeQuery = true)
        CuentaServicio darCuentaServicioPorId(@Param("id") Integer id);

        @Query(value = "INSERT INTO cuentaservicio (id, descripcion, fecha, reserva_id, producto_id, servicio_id) " +
                        "VALUES (:id, :descripcion, :fecha, :reserva.id, :producto.id, :servicio.id)", nativeQuery = true)
        void insertarCuentaServicio(@Param("id") Integer id, @Param("descripcion") String descripcion,
                        @Param("fecha") Date fecha, @Param("reserva") Integer reserva,
                        @Param("producto") Integer producto, @Param("servicio") Integer servicio);

        @Query(value = "UPDATE cuentaservicio SET descripcion = :descripcion, fecha = :fecha, reserva_id = :reserva.id, "
                        +
                        "producto_id = :producto.id, servicio_id = :servicio.id " +
                        "WHERE id = :id", nativeQuery = true)
        void actualizarCuentaServicio(@Param("id") Integer id, @Param("descripcion") String descripcion,
                        @Param("fecha") Date fecha, @Param("reserva") Integer reserva,
                        @Param("producto") Integer producto, @Param("servicio") Integer servicio);

        @Query(value = "DELETE FROM cuentaservicio WHERE id = :id", nativeQuery = true)
        void eliminarCuentaServicio(@Param("id") Integer id);
}
