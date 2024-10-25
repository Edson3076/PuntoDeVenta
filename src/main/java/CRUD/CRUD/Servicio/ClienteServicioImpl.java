package CRUD.CRUD.Servicio;

import CRUD.CRUD.ENTIDAD.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import CRUD.CRUD.Repositorio.ClienteRepositorio;
import java.util.Optional;
import org.aspectj.bridge.MessageUtil;

@Service
public class ClienteServicioImpl implements ClienteServicio{
    @Autowired
    private ClienteRepositorio repositorio;
    
    @Override
    public List<Cliente> listarTodosLosEstudiantes() {        
        return repositorio.findAll();
    }

    @Override
    public Cliente guardarEstudiante(Cliente estudiante) {
        Optional<Cliente> nitDpiExistente = repositorio.findByNitDpi(estudiante.getNitDpi());
        if (nitDpiExistente.isPresent()) {
            
            return estudiante=null;
        }else{
        return repositorio.save(estudiante);
        }
        
    }

    @Override
    public Cliente obtenerEstudiantePorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Cliente actualizarEstudiante(Cliente estudiante) {
        return repositorio.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        repositorio.deleteById(id);
    }
    
}

