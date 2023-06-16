package ups.edu.ec.sistemacitasmedicas.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
import ups.edu.ec.sistemacitasmedicas.repositorio.MedicoRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.MedicioServicio;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServicioImpl implements MedicioServicio {

    @Autowired
    MedicoRepositorio medicoRepositorio;

    @Override
    public Medico guardarMedico(Medico medico) {
        return medicoRepositorio.save(medico);
    }

    @Override
    public List<Medico> listarMedicos() {
        return medicoRepositorio.findAll();
    }

    @Override
    public Medico obtenerMedicoPorId(Integer id) {
        Optional<Medico> medicoOptional = medicoRepositorio.findById(id);
        return medicoOptional.orElse(null);
    }

    @Override
    public Optional<Medico> get(Integer id) {
        return medicoRepositorio.findById(id);
    }
}
