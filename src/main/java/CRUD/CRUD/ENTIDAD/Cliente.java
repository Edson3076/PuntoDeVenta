package CRUD.CRUD.ENTIDAD;

import CRUD.CRUD.Servicio.ValidarNitDpi;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "estudiante")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nit_dpi",nullable = false, unique = true)
    //@Pattern(regexp = "(\\d{13}|\\d{8})",message = "Debe ingresar un DPI (13 dígitos) o un NIT válido (8 dígitos sin guion)")
    //@NotEmpty(message = "El nit no debe estar vacio") 
    @ValidarNitDpi // validacion personalizada NIT o DPI
    private String nit_dpi;
    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "email")
    private String email;
    @Column(name = "notas")
    private String notas;
    @Column(name = "fecha_ingreso")
    private LocalDate fecha_ingreso;
    @Column(name = "estado")
    private String estado;
    
    public Cliente() {
    }
    
    
    
    public Cliente(Long id, String nit_dpi, String nombre, String direccion, String email, String notas, LocalDate fecha_ingreso, String estado) {
        this.id = id;
        this.nit_dpi = nit_dpi;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.notas = notas;
        this.fecha_ingreso = fecha_ingreso;
        this.estado = estado;
    }

    public Cliente(String nit_dpi, String nombre, String direccion, String email, String notas, LocalDate fecha_ingreso, String estado) {
        this.nit_dpi = nit_dpi;
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

    public String getNit_dpi() {
        return nit_dpi;
    }

    public void setNit_dpi(String nit_dpi) {
        this.nit_dpi = nit_dpi;
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
        return "Estudiante{" + "id=" + id + ", nit_dpi=" + nit_dpi + ", nombre=" + nombre + ", direccion=" + direccion + ", email=" + email + ", notas=" + notas + ", fecha_ingreso=" + fecha_ingreso + ", estado=" + estado + '}';
    }

}
