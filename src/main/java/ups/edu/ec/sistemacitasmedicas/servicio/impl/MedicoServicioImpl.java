package ups.edu.ec.sistemacitasmedicas.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;

import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;
import ups.edu.ec.sistemacitasmedicas.repositorio.MedicoRepositorio;
import ups.edu.ec.sistemacitasmedicas.repositorio.PersonaRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.MedicoServicio;

import java.util.List;
import java.util.Optional;


@Service
public class MedicoServicioImpl implements MedicoServicio {
    @Autowired
    private PersonaRepositorio personaRepositorio;
    @Autowired
    private MedicoRepositorio medicoRepositorio;

    public Medico guardarMedico(Medico medico) throws Exception {
        // Obtener la Persona por su ID
        Persona persona = personaRepositorio.findById(medico.getPersona().getPersona_id())
                .orElseThrow(() -> new Exception("Persona no encontrada"));

        // Asignar la Persona al Usuario
        medico.setPersona(persona);

        // Guardar el Usuario en la base de datos
        return medicoRepositorio.save(medico);
    }

    public Medico obtenerMedicoPorId(Integer MedicoId) {
        Optional<Medico> personaOptional = medicoRepositorio.findById(MedicoId);
        return personaOptional.orElse(null);
    }

    @Override
    public void eliminarMedico(Integer MedicoId) {
        medicoRepositorio.deleteById(MedicoId);
    }
}