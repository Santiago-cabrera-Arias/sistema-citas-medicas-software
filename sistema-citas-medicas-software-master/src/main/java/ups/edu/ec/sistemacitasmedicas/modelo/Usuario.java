package ups.edu.ec.sistemacitasmedicas.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long UsuarioId;
    private String encargo;
    private String username;
    private String password;

    private boolean estado = true;
    //roles
    private boolean G;
    private boolean A;


    @ManyToOne
    @JoinColumn(name = "id_Persona")
    private Persona persona;


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

    public String getEncargo() {
        return encargo;
    }

    public void setEncargo(String encargo) {
        this.encargo = encargo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }



    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void asignarRolesPorEncargo() {
        switch (encargo) {
            case "G":
                G = true;
                A = false;
                break;
            case "A":
                G = false;
                A = true;

                break;

            default:
                G = false;
                A = false;
                break;
        }
    }

}
