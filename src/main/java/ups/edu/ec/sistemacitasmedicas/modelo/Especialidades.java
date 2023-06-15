package ups.edu.ec.sistemacitasmedicas.modelo;


import jakarta.persistence.*;

@Entity
@Table(name = "especialidades")
public class Especialidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "especialidad_id")
    public long especialidad_id;
    @JoinColumn(name = "especialidad")
    public String especialidad;

    public Especialidades(long especialidad_id, String especialidad) {
        this.especialidad_id = especialidad_id;
        this.especialidad = especialidad;
    }

    public Especialidades() {

    }

    public long getEspecialidad_id() {
        return especialidad_id;
    }

    public void setEspecialidad_id(long especialidad_id) {
        this.especialidad_id = especialidad_id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
