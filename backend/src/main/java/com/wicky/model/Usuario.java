package com.wicky.model;

// The Usuario class represents a user entity in the system. 
// It is annotated with JPA annotations to map it to a database table named "usuarios". 
// Each field in the class corresponds to a column in the table, and the class includes getter and setter methods for each field.
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_usuario")
    private Long id;

    @NotBlank(message = "El documento es obligatorio")
    @Size(min = 6, max = 15, message = "El documento debe tener entre 6 y 15 caracteres")
    @Pattern(regexp = "\\d+", message = "El documento solo puede contener números")
    @Column(name = "documento", unique = true)
    private String documento;

    @Column(name = "nombre_usuario")
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+$", message = "El nombre solo puede contener letras y espacios")
    private String nombre;

    @Column(name = "telefono")
    @Size(max = 20, message = "El teléfono no puede exceder los 20 caracteres")
    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\+?\\d+", message = "El teléfono solo puede contener números y un signo '+' al inicio")
    private String telefono;

    @Column(name = "email")
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no tiene un formato válido")
    private String correo;

    @Column(name = "direccion")
    @Size(max = 200, message = "La dirección no puede exceder los 200 caracteres")
    private String direccion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}