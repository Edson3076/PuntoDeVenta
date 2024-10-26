package CRUD.CRUD.Servicio;

import CRUD.CRUD.ENTIDAD.Producto;
import CRUD.CRUD.Repositorio.ProductoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicioImpl implements ProductoServicio{
    @Autowired
    private ProductoRepositorio repositorio;
    
    @Override
    public List<Producto> listarProductos() {
        return repositorio.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Integer generarNuevoCodigo() {
        Integer codigoMaximo = repositorio.obtenerCodigoMaximo();
        return (codigoMaximo !=null ? codigoMaximo:0)+1;
    }

    
}
