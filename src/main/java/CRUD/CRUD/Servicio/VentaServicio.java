package CRUD.CRUD.Servicio;

import CRUD.CRUD.ENTIDAD.Venta;
import java.util.List;

public interface VentaServicio {

    public List<Venta> listarTodasLasVentas();

    public Venta guardarVenta(Venta venta);

    public Venta obtenerVentaPorId(Long id);

    public Venta actualizarVenta(Venta venta);

    public void eliminarVenta(Long id);

    public Venta realizarVenta(Venta venta);
}
