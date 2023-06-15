package ups.edu.ec.sistemacitasmedicas.servicio;

import ups.edu.ec.sistemacitasmedicas.modelo.Medico;

import java.util.List;

public interface MedicoServicio {
    Medico guardarMedico(Medico medido);
    List<Medico> listarmedico();

    //Medico obtenerMedicoPorId(Long id);

    Medico obtenerMedicoPorId(Long id);

    void eliminarMedico(Long id);
    Medico actualizarMedico(Medico medico);
}
