
package CRUD.CRUD.Servicio;

import CRUD.CRUD.ENTIDAD.Cliente;
import java.util.List;

public interface ClienteServicio {
    public List<Cliente> listarTodosLosEstudiantes();
    public Cliente guardarEstudiante(Cliente estudiante);
    public Cliente obtenerEstudiantePorId(Long id);
    public Cliente actualizarEstudiante(Cliente estudiante);
    public void eliminarEstudiante (Long id);
}
