package ups.edu.ec.sistemacitasmedicas.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer especialidad_id;
    public String especialidad;

    @OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL)
    List<Medico> medicoEspecialidades = new ArrayList<>();

    public Especialidad() {
    }

    public Integer getEspecialidad_id() {
        return especialidad_id;
    }

    public void setEspecialidad_id(Integer especialidad_id) {
        this.especialidad_id = especialidad_id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Medico> getMedicoEspecialidades() {
        return medicoEspecialidades;
    }

    public void setMedicoEspecialidades(List<Medico> medicoEspecialidades) {
        this.medicoEspecialidades = medicoEspecialidades;
    }
}
