package ups.edu.ec.sistemacitasmedicas.modelo;

<<<<<<< HEAD

=======
import com.fasterxml.jackson.annotation.JsonFormat;
>>>>>>> main
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
<<<<<<< HEAD
@Table(name = "medico")
=======
@Table(name = "cita")
>>>>>>> main
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @JoinColumn(name = "cita_id")
    private Long citaId;
    @JoinColumn(name = "fecha")
    private Date fecha;
    @JoinColumn(name = "hora")
    private Time hora;
    @JoinColumn(name = "estado")
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    public Cita(Long citaId, Date fecha, Time hora, Boolean estado, Medico medico) {
        this.citaId = citaId;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.medico = medico;
    }

    public Cita(Long citaId) {
        this.citaId = citaId;
    }

    public Cita() {

    }

    public Long getCitaId() {
        return citaId;
    }

    public void setCitaId(Long citaId) {
        this.citaId = citaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
=======
    private Integer cita_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaCita;
    private Time hora;
    private boolean estado = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Persona persona;

    @ManyToOne
    private Medico medico;

    public Cita() {
    }

    public Integer getCita_id() {
        return cita_id;
    }

    public void setCita_id(Integer cita_id) {
        this.cita_id = cita_id;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
>>>>>>> main
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

<<<<<<< HEAD
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

=======
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

>>>>>>> main
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
