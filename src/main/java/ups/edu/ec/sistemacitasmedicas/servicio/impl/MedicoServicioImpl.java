package ups.edu.ec.sistemacitasmedicas.servicio.impl;

import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;

import ups.edu.ec.sistemacitasmedicas.repositorio.MedicoRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.MedicoServicio;

import java.util.List;


@Service
public class MedicoServicioImpl implements MedicoServicio {

    private final MedicoRepositorio medicoRepositorio=null;

    @Override
    public Medico guardarMedico(Medico medico) {
        return medicoRepositorio.save(medico);
    }

    @Override
    public List<Medico> listarmedico() {

        return medicoRepositorio.findAll();
    }

    @Override
    public Medico obtenerMedicoPorId(Long id) {
        return medicoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarMedico(Long id) {
        medicoRepositorio.deleteById(id);
    }

    @Override
    public Medico actualizarMedico(Medico medico) {
        return null;
    }
}