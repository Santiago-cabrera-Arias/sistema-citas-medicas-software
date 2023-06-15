package ups.edu.ec.sistemacitasmedicas.modelo;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "medico")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
