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
    @Query(value = "INSERT INTO productotienda (id, id_tienda) VALUES (:id, :id_tienda)", nativeQuery = true)
    void insertarProductoTienda(@Param("id") Integer id, @Param("id_tienda") Integer id_tienda);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productotienda SET id = :id, id_tienda = :id_tienda WHERE id = :id", nativeQuery = true)
    void actualizarProductoTienda(@Param("id") Integer id, @Param("id_tienda") Integer id_tienda);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productotienda WHERE id = :id", nativeQuery = true)
    void eliminarProductoTienda(@Param("id") Integer id);
    

}