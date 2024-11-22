package CRUD.CRUD.Repositorio;

import CRUD.CRUD.ENTIDAD.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepositorio extends JpaRepository<Venta, Long>{
}
