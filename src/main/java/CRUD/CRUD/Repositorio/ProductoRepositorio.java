package CRUD.CRUD.Repositorio;

import CRUD.CRUD.ENTIDAD.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long>{
    
    //Consulta para obtener codigo
    @Query("SELECT COALESCE(MAX(p.codigo),0) FROM Producto p")
    Integer obtenerCodigoMaximo();
}
