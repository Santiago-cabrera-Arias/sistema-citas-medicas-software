package ups.edu.ec.sistemacitasmedicas.modelo;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "medico")
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MedicoId;
    private String telenoConsultorio;

    @ManyToOne
    @JoinColumn(name = "MedicoId")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidades especialidad;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Medico() {

    }

    public Long getMedicoId() {
        return MedicoId;
    }

    public void setMedicoId(Long medicoId) {
        MedicoId = medicoId;
    }

    public String getTelenoConsultorio(String correo) {
        return telenoConsultorio;
    }

    public void setTelenoConsultorio(String telenoConsultorio) {
        this.telenoConsultorio = telenoConsultorio;
    }

    public String getTelenoConsultorio() {
        return telenoConsultorio;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidades getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidades especialidad) {
        this.especialidad = especialidad;
    }
}
