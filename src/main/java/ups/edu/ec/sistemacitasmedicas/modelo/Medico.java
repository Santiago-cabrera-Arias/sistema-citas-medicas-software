package ups.edu.ec.sistemacitasmedicas.modelo;

<<<<<<< HEAD

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
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medico_id;
    private String telenoConsultorio;

    @ManyToOne(fetch = FetchType.EAGER)
    private Persona persona;

    @ManyToOne
    private Especialidad especialidad;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Cita> medicoCita = new ArrayList<>();

    public Medico() {
    }

    public Integer getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(Integer medico_id) {
        this.medico_id = medico_id;
    }

    public String getTelenoConsultorio() {
        return telenoConsultorio;
    }

    public void setTelenoConsultorio(String telenoConsultorio) {
        this.telenoConsultorio = telenoConsultorio;
    }
>>>>>>> main

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

<<<<<<< HEAD
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
=======
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<Cita> getMedicoCita() {
        return medicoCita;
    }

    public void setMedicoCita(List<Cita> medicoCita) {
        this.medicoCita = medicoCita;
    }
>>>>>>> main
}
