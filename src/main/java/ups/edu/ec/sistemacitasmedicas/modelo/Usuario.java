package ups.edu.ec.sistemacitasmedicas.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuario_id;
    private String encargo;
    private String username;
    private String password;

    private boolean estado = true;
    //roles
    private boolean General;
    private boolean Administrador;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Persona persona;

    public Usuario() {
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getEncargo() {
        return encargo;
    }

    public void setEncargo(String encargo) {
        this.encargo = encargo;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isGeneral() {
        return General;
    }

    public void setGeneral(boolean general) {
        General = general;
    }

    public boolean isAdministrador() {
        return Administrador;
    }

    public void setAdministrador(boolean administrador) {
        Administrador = administrador;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void asignarRolesPorEncargo() {
        switch (encargo) {
            case "General":
                General = true;
                Administrador = false;
                break;
            case "Administrador":
                General = false;
                Administrador = true;
                break;
            default:
                General = false;
                Administrador = false;
                break;
        }
    }

}
