package ups.edu.ec.sistemacitasmedicas.modelo;

import jakarta.persistence.*;

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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}
