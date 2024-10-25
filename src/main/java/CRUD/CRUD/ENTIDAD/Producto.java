package CRUD.CRUD.ENTIDAD;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "producto")
public class Producto{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "codigo")
    @NotNull(message = "El codigo no debe estar vacio")
    @Min(value = 0, message = "El valor debe ser mayor a 0")
    private Integer codigo;
    
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "precio_unitario")
    private float precio_unitario;
    @Column(name = "costo_unitario")
    private float costo_unitario;
    
    //sirve para hacer relacionn de un cliente a muchos productos
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    public Producto() {
    }

    public Producto(Long id, Integer codigo, int cantidad, String descripcion, String categoria, float precio_unitario, float costo_unitario) {
        this.id = id;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio_unitario = precio_unitario;
        this.costo_unitario = costo_unitario;
    }

    public Producto(Integer codigo, int cantidad, String descripcion, String categoria, float precio_unitario, float costo_unitario) {
        this.codigo = codigo;
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

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
        return "Producto{" + "id=" + id + ", codigo=" + codigo + ", cantidad=" + cantidad + ", descripcion=" + descripcion + ", categoria=" + categoria + ", precio_unitario=" + precio_unitario + ", costo_unitario=" + costo_unitario + ", cliente=" + cliente + '}';
    }

}
