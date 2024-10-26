package CRUD.CRUD.Controlador;

import CRUD.CRUD.ENTIDAD.Cliente;
import CRUD.CRUD.ENTIDAD.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import CRUD.CRUD.Servicio.ClienteServicio;
import CRUD.CRUD.Servicio.ProductoServicio;
import CRUD.CRUD.Servicio.ValidadorNitDpiImpl;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Controlador {

    @Autowired
    private ClienteServicio servicio;
    @Autowired
    private ProductoServicio serviciop;
    
    @GetMapping({"", "/"})
    public String listarEstudiantes(Model modelo) {
        modelo.addAttribute("estudiante", servicio.listarTodosLosEstudiantes());
        modelo.addAttribute("producto", serviciop.listarProductos());
        return "home";
    }

    @GetMapping("/nuevo_cliente")
    public String mostrarFormularioDeRegistrarEstudiante(Model modelo) {
        Cliente cliente = new Cliente();
        modelo.addAttribute("estudiante", cliente);
        return "crear_cliente";
    }

    @PostMapping("/nuevo_cliente")
    public String guardarEstudiante(@Valid @ModelAttribute("estudiante") Cliente cliente, BindingResult result,
            Model modelo, RedirectAttributes attribute) {
        //servicio.guardarEstudiante(cliente);
        if (result.hasErrors()) {
            modelo.addAttribute("error", result.getFieldError().getDefaultMessage());
            return "crear_cliente";
        }
        if (servicio.guardarEstudiante(cliente) != null) {
            modelo.addAttribute("Mensaje", "usuario registrado");
            attribute.addFlashAttribute("success", "Guardado con exito");
            return "redirect:/";
        } else {
            //attribute.addFlashAttribute("error", "Nit o DPI Existente");
            return "crear_cliente";
        }

    }

        //Endpoint para obtener el proximo codigo
    @GetMapping("/producto/obtenerNuevoCodigo")
    @ResponseBody
    public Integer obtenerNuevoCodigo(){
        return serviciop.generarNuevoCodigo();
    }
    
    @GetMapping("/nuevo_producto")
    public String mostrarFormularioDeIngresarProducto(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);
        return "ingresar_producto";
    }

    @PostMapping("/nuevo_producto")
    public String guardarProducto(@Valid @ModelAttribute("producto") Producto producto, BindingResult result,
            Model modelo, RedirectAttributes attribute) {
        //servicio.guardarEstudiante(cliente);
        if (result.hasErrors()) {
            modelo.addAttribute("error", result.getFieldError().getDefaultMessage());
            return "ingresar_producto";
        }
        serviciop.guardarProducto(producto);
        modelo.addAttribute("Mensaje", "usuario registrado");
        attribute.addFlashAttribute("success", "Guardado con exito");
        return "redirect:/";
        //attribute.addFlashAttribute("error", "Nit o DPI Existente");
        //return "ingresar_producto";

    }

    @GetMapping("/nueva_venta")
    public String mostrarFormularioDeVenta() {
        return "nueva_venta";
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
        estudianteExistente.setNitDpi(estudiante.getNitDpi());
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

    @GetMapping("/producto/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        serviciop.eliminarProducto(id);
        return "redirect:/";
    }
}
