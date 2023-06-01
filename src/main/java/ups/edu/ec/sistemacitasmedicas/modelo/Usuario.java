package ups.edu.ec.sistemacitasmedicas.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UsuarioId;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    private boolean enabled = true;
    private String perfil;
    private String telefono;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "usuario")
    @JsonIgnore //deseliarizando.
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    public Usuario() {
    }

    public Long getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        UsuarioId = usuarioId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }
}
