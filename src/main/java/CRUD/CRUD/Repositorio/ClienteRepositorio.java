package CRUD.CRUD.Repositorio;

import CRUD.CRUD.ENTIDAD.Cliente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
    
    Optional<Cliente> findByNitDpi(String NitDpi);   
}
