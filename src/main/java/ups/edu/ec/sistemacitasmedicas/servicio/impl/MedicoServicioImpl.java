package ups.edu.ec.sistemacitasmedicas.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
<<<<<<< HEAD

import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;
import ups.edu.ec.sistemacitasmedicas.repositorio.MedicoRepositorio;
import ups.edu.ec.sistemacitasmedicas.repositorio.PersonaRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.MedicoServicio;
=======
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.repositorio.MedicoRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.MedicioServicio;
>>>>>>> main

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD

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
=======
@Service
public class MedicoServicioImpl implements MedicioServicio {

    @Autowired
    MedicoRepositorio medicoRepositorio;

    @Override
    public Medico guardarMedicoEspecialidad(Medico medico, List<Medico> medicoEspecialidades) throws Exception {

        return medicoRepositorio.save(medico);

//        Optional<Medico> medicoLocal = medicoRepositorio.findById(medico.getMedico_id());
//
//        if (medicoLocal.isPresent()){
//            throw new Exception("El usuario ya esta presente...");
//        }else {
//
//            for (Medico medicoEspecialidad:medicoEspecialidades){
//                especialidadRepositorio.save(medicoEspecialidad.getEspecialidad());
//            }
//            persona.getMedicoEspecialidades().addAll(medicoEspecialidades);
//            personaLocal = personaRepositorio.save(persona);
//
//        }
//        return  personaLocal;
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
>>>>>>> main
