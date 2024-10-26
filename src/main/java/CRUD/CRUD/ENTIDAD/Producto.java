package CRUD.CRUD.ENTIDAD;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMin;
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
    @NotNull(message = "La cantidad no debe estar vacio")
    @Min(value = 0, message = "El valor debe ser mayor a 0")
    private Integer cantidad;

    @Column(name = "descripcion")
    @NotBlank(message = "La descripcion no debe estar vacia") 
    private String descripcion;
    
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "precio_unitario")
    @NotNull(message = "El precio no puede estar vacio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayo a 0")
    private Double precio_unitario;
    
    @Column(name = "costo_unitario")
    @NotNull(message = "El costo no puede estar vacio")
    @DecimalMin(value = "0.01", message = "El costo debe ser mayo a 0")
    private Double costo_unitario;
    
    //Validacion que el costo no sea mayor al precio
    @AssertTrue(message = "El costo no puede ser mayo al precio")
    public boolean isCostoValido(){
        if (precio_unitario == null || costo_unitario==null) {
            return true;
        }
        return costo_unitario <= precio_unitario;
    }
    
    //sirve para hacer relacionn de un cliente a muchos productos
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    public Producto() {
    }

    public Producto(Long id, Integer codigo, Integer cantidad, String descripcion, String categoria, Double precio_unitario, Double costo_unitario) {
        this.id = id;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio_unitario = precio_unitario;
        this.costo_unitario = costo_unitario;
    }

    public Producto(Integer codigo, Integer cantidad, String descripcion, String categoria, Double precio_unitario, Double costo_unitario) {
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
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

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Double getCosto_unitario() {
        return costo_unitario;
    }

    public void setCosto_unitario(Double costo_unitario) {
        this.costo_unitario = costo_unitario;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", codigo=" + codigo + ", cantidad=" + cantidad + ", descripcion=" + descripcion + ", categoria=" + categoria + ", precio_unitario=" + precio_unitario + ", costo_unitario=" + costo_unitario + ", cliente=" + cliente + '}';
    }

}
