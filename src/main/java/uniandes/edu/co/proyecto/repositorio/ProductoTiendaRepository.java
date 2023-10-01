package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ProductoTienda;

public interface ProductoTiendaRepository extends JpaRepository<ProductoTienda, Integer>{

    @Query(value = "SELECT * FROM productotienda", nativeQuery = true)
    Collection<ProductoTienda> darProductosTienda();

    @Query(value = "SELECT * FROM productotienda WHERE id = :id", nativeQuery = true)
    ProductoTienda darProductoTiendaPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productotienda (nombre, precio, tienda_id) VALUES (:nombre, :precio, :tienda_id)", nativeQuery = true)
    void insertarProductoTienda(@Param("nombre") String nombre, @Param("precio") Integer precio, @Param("tienda_id") Integer tienda_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productotienda SET nombre = :nombre, precio = :precio, tienda_id = :tienda_id WHERE id = :id", nativeQuery = true)
    void actualizarProductoTienda(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio, @Param("tienda_id") Integer tienda_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productotienda WHERE id = :id", nativeQuery = true)
    void eliminarProductoTienda(@Param("id") Integer id);
    

}