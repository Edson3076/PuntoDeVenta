package CRUD.CRUD.Controlador;

import CRUD.CRUD.ENTIDAD.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import CRUD.CRUD.Servicio.ClienteServicio;

@Controller
public class ClienteControlador {

    @Autowired
    private ClienteServicio servicio;
    
    @GetMapping({"", "/"})
    public String listarEstudiantes(Model modelo) {
        modelo.addAttribute("estudiante",servicio.listarTodosLosEstudiantes());
        return "home";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistrarEstudiante(Model modelo) {
        Cliente estudiante = new Cliente();
        modelo.addAttribute("estudiante", estudiante);
        return "crear_cliente";
    }
    
    @GetMapping("/producto")
    public String mostrarFormularioDeIngresarProducto(){
        return "ingresar_producto";
    }

    @PostMapping("/estudiante")
    public String guardarEstudiante(@ModelAttribute("estudiante") Cliente estudiante) {
        servicio.guardarEstudiante(estudiante);
        return "redirect:/";
    }

    @GetMapping("/estudiante/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
        return "editar_cliente";
    }

    @PostMapping("/estudiante/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Cliente estudiante, Model modelo) {
        Cliente estudianteExistente = servicio.obtenerEstudiantePorId(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNit_dpi(estudiante.getNit_dpi());
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setDireccion(estudiante.getDireccion());
        estudianteExistente.setEmail(estudiante.getEmail());
        estudianteExistente.setNotas(estudiante.getNotas());
        estudianteExistente.setFecha_ingreso(estudiante.getFecha_ingreso());
        estudianteExistente.setEstado(estudiante.getEstado());
        servicio.actualizarEstudiante(estudianteExistente);
        return "redirect:/";
    }

    @GetMapping("/estudiante/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        servicio.eliminarEstudiante(id);
        return "redirect:/";
    }

}
