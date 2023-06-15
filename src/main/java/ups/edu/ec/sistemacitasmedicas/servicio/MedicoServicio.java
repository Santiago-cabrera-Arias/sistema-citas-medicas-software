package ups.edu.ec.sistemacitasmedicas.servicio;

import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;

import java.util.List;

public interface MedicoServicio {
    public Medico guardarMedico(Medico medico) throws Exception;


    Medico obtenerMedicoPorId(Integer MedicoId);

    public void eliminarMedico(Integer MedicoId);
}
