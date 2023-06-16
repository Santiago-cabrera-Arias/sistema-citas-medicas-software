package ups.edu.ec.sistemacitasmedicas.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "clinica")
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clinica_id;
    private String prescripciones;
    private String ordenes;
    private String certificados;
    @ManyToOne(fetch = FetchType.EAGER)
    private Persona persona;

    @ManyToOne
    private Medico medico;

    public Clinica() {
    }


    public Integer getClinica_id() {
        return clinica_id;
    }

    public void setClinica_id(Integer clinica_id) {
        this.clinica_id = clinica_id;
    }

    public String getPrescripciones() {
        return prescripciones;
    }

    public void setPrescripciones(String prescripciones) {
        this.prescripciones = prescripciones;
    }

    public String getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(String ordenes) {
        this.ordenes = ordenes;
    }

    public String getCertificados() {
        return certificados;
    }

    public void setCertificados(String certificados) {
        this.certificados = certificados;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}
