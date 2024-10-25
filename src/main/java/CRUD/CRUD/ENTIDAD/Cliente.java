package CRUD.CRUD.ENTIDAD;

import CRUD.CRUD.Servicio.ValidarNitDpi;
import CRUD.CRUD.Servicio.ValidarNitDpiUnico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import org.aspectj.bridge.Message;

@Entity
@Table(name = "Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nit_dpi", nullable = false, unique = true)
    //@Pattern(regexp = "(\\d{13}|\\d{8})",message = "Debe ingresar un DPI (13 dígitos) o un NIT válido (8 dígitos sin guion)")
    //@NotEmpty(message = "El nit no debe estar vacio") 
    @ValidarNitDpi // validacion personalizada NIT o DPI
    private String nitDpi;
    
    @Column(name = "nombre")
    @NotBlank(message = "El nombre no debe estar vacio") 
    @Size(min=5,message = "Nombre debe tener minimo 2 palabras")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚñÑ]+)+$", 
            message = "El nombre debe ser solo letras y al menos 2 palabras")
    private String nombre;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "email")
    @NotBlank(message = "El Correo no debe estar vacio") 
    @Email(message = "El correo electronico debe ser valido")
    private String email;
    
    @Column(name = "notas")
    private String notas;
    @Column(name = "fecha_ingreso")
    private LocalDate fecha_ingreso;
    @Column(name = "estado")
    private String estado;

    public Cliente() {
    }

    public Cliente(Long id, String nitDpi, String nombre, String direccion, String email, String notas, LocalDate fecha_ingreso, String estado) {
        this.id = id;
        this.nitDpi = nitDpi;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.notas = notas;
        this.fecha_ingreso = fecha_ingreso;
        this.estado = estado;
    }

    public Cliente(String nitDpi, String nombre, String direccion, String email, String notas, LocalDate fecha_ingreso, String estado) {
        this.nitDpi = nitDpi;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.notas = notas;
        this.fecha_ingreso = fecha_ingreso;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNitDpi() {
        return nitDpi;
    }

    public void setNitDpi(String nitDpi) {
        this.nitDpi = nitDpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nitDpi=" + nitDpi + ", nombre=" + nombre + ", direccion=" + direccion + ", email=" + email + ", notas=" + notas + ", fecha_ingreso=" + fecha_ingreso + ", estado=" + estado + '}';
    }

}
