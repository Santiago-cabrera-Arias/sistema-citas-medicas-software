package ups.edu.ec.sistemacitasmedicas.servicio;

import ups.edu.ec.sistemacitasmedicas.modelo.Cita;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;

import java.util.List;
import java.util.Optional;

public interface MedicioServicio {

    Medico guardarMedico(Medico medico);
    List<Medico> listarMedicos();
    Medico obtenerMedicoPorId(Integer id);
    Optional<Medico> get(Integer id);



}
