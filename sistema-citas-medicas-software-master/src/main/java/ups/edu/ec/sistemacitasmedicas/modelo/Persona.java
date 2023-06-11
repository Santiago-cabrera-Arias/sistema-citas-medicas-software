package ups.edu.ec.sistemacitasmedicas.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "personas")

public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Persona;
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;
    private String estado;
    private String fechaNacimiento;
    private String sexo;
    private String tipo;

    // Roles
    private boolean esCliente;
    private boolean esMedico;
    private boolean esEmpleado;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "persona")
    private Set<Usuario> usuarioRoles = new HashSet<>();


    private Usuario usuario;
    // Constructores
    public Persona() {
        // Constructor sin argumentos
    }
    public Persona(Long id_Persona, String cedula, String nombre, String apellido, String direccion, String telefono,
                   String correo, String estado, String fechaNacimiento, String sexo, String tipo, boolean esCliente,
                   boolean esMedico, boolean esEmpleado) {
        this.id_Persona = id_Persona;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.tipo = tipo;
        this.esCliente = esCliente;
        this.esMedico = esMedico;
        this.esEmpleado = esEmpleado;
    }

    // Métodos getter y setter


    public Long getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(Long id_Persona) {
        this.id_Persona = id_Persona;
    }



    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEsCliente() {
        return esCliente;
    }

    public void setEsCliente(boolean esCliente) {
        this.esCliente = esCliente;
    }

    public boolean isEsMedico() {
        return esMedico;
    }

    public void setEsMedico(boolean esMedico) {
        this.esMedico = esMedico;
    }

    public boolean isEsEmpleado() {
        return esEmpleado;
    }

    public void setEsEmpleado(boolean esEmpleado) {
        this.esEmpleado = esEmpleado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    // Método para asignar roles por tipo

    public void asignarRolesPorTipo() {
        switch (tipo) {
            case "Cliente":
                esCliente = true;
                esMedico = false;
                esEmpleado = false;
                break;
            case "Medico":
                esCliente = false;
                esMedico = true;
                esEmpleado = false;
                break;
            case "Empleado":
                esCliente = false;
                esMedico = false;
                esEmpleado = true;
                break;
            default:
                esCliente = false;
                esMedico = false;
                esEmpleado = false;
                break;
        }
    }
}
