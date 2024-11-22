package CRUD.CRUD.Controlador;

import CRUD.CRUD.ENTIDAD.Cliente;
import CRUD.CRUD.ENTIDAD.Producto;
import CRUD.CRUD.ENTIDAD.Venta;
import CRUD.CRUD.Servicio.ClienteServicio;
import CRUD.CRUD.Servicio.ProductoServicio;
import CRUD.CRUD.Servicio.VentaServicio;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ventaControlador {

    @Autowired
    private ClienteServicio servicioC;
    @Autowired
    private ProductoServicio servicioP;
    @Autowired
    private VentaServicio servicioV;

    @GetMapping("/nueva_venta")
    public String mostrarFormularioDeVenta(Model modelo) {
        try {
            List<Cliente> clientes = servicioC.listarTodosLosEstudiantes();
            List<Producto> productos = servicioP.listarProductos();
            modelo.addAttribute("venta", new Venta());
            modelo.addAttribute("clientes", clientes);
            modelo.addAttribute("productos", productos);
        } catch (Exception e) {
        }
        return "nueva_venta";
    }

    @Transactional
    @PostMapping("/nueva_venta")
    public String procesarVenta(@Valid @ModelAttribute("venta") Venta venta, BindingResult resultado, Model modelo) {
        if (resultado.hasErrors()) {
            modelo.addAttribute("clientes", servicioC.listarTodosLosEstudiantes());
            modelo.addAttribute("productos", servicioP.listarProductos());
            return "nueva_venta";
        }
        //Calcular el total de la venta
        Double total = venta.getProductos().stream()
                            .mapToDouble(Producto::getPrecio_unitario)
                            .sum();
        venta.setTotal(total);
        servicioV.guardarVenta(venta);
        modelo.addAttribute("mensaje", "Venta realizada");
        return "resultado_venta";
    }
}
