package CRUD.CRUD.ENTIDAD;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "producto")
public class Producto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo",nullable = false, unique = true)
    private int Codigo;
    @Column(name = "cantidad",nullable = false)
    private int cantidad;
    @Column(name = "descripcion",nullable = false)
    private String descripcion;
    @Column(name = "categoria",nullable = false)
    private String categoria;
    @Column(name = "precio_unitario",nullable = false)
    private float precio_unitario;
    @Column(name = "costo_unitario",nullable = false)
    private float costo_unitario;
    
    //sirve para hacer relacionn de un cliente a muchos productos
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    public Producto() {
    }

    public Producto(Long id, int Codigo, int cantidad, String descripcion, String categoria, float precio_unitario, float costo_unitario) {
        this.id = id;
        this.Codigo = Codigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio_unitario = precio_unitario;
        this.costo_unitario = costo_unitario;
    }

    public Producto(int Codigo, int cantidad, String descripcion, String categoria, float precio_unitario, float costo_unitario) {
        this.Codigo = Codigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio_unitario = precio_unitario;
        this.costo_unitario = costo_unitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public float getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(float costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", Codigo=" + Codigo + ", cantidad=" + cantidad + ", descripcion=" + descripcion + ", categoria=" + categoria + ", precio_unitario=" + precio_unitario + ", costo_unitario=" + costo_unitario + '}';
    }
    
    
}
