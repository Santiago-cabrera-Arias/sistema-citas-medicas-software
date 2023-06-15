package ups.edu.ec.sistemacitasmedicas.modelo;


import jakarta.persistence.*;

@Entity
@Table(name = "medico")
public class Medico extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MedicoId;
    private String telenoConsultorio;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidades especialidad;

    public Medico(Long id, String cedula, String nombre, String apellido, String direccion, String telefono, String correo, String estado, String fechaNacimiento, String sexo, String tipo, boolean esCliente, boolean esMedico, boolean esEmpleado) {
        super(Math.toIntExact(id), cedula, nombre, apellido, direccion, telefono, correo, estado, fechaNacimiento, sexo, tipo, esCliente, esMedico, esEmpleado);
    }



    public Medico() {
        super();
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
