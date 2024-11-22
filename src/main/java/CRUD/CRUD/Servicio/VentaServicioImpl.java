package CRUD.CRUD.Servicio;

import CRUD.CRUD.ENTIDAD.Producto;
import CRUD.CRUD.ENTIDAD.Venta;
import CRUD.CRUD.Repositorio.VentaRepositorio;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VentaServicioImpl implements VentaServicio{
    private VentaRepositorio repositorio;
    
    @Override
    public List<Venta> listarTodasLasVentas() {
        return repositorio.findAll();
    }

    @Override
    public Venta guardarVenta(Venta venta) {
        return repositorio.save(venta);
    }

    @Override
    public Venta obtenerVentaPorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Venta actualizarVenta(Venta venta) {
        return repositorio.save(venta);
    }

    @Override
    public void eliminarVenta(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Venta realizarVenta(Venta venta) {
        //Calcular el total sumando los precios de los productos
        double total = venta.getProductos().stream().mapToDouble(Producto::getPrecio_unitario).sum();
        venta.setTotal(total);
        return repositorio.save(venta);
    }
    
}
