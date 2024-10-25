package CRUD.CRUD.Servicio;

import CRUD.CRUD.ENTIDAD.Producto;
import java.util.List;

public interface ProductoServicio {

    public List<Producto> listarProductos();

    public Producto guardarProducto(Producto producto);

    public Producto obtenerProductoPorId(Long id);

    public Producto actualizarProducto(Producto producto);

    public void eliminarProducto(Long id);
}
