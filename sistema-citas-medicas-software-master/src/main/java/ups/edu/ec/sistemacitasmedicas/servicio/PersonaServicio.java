package ups.edu.ec.sistemacitasmedicas.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;

import ups.edu.ec.sistemacitasmedicas.repositorio.PersonaRepositorio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonaServicio implements PersonaServicio1{

    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Autowired
    public PersonaServicio(PersonaRepositorio personaRepositorio) {
        this.personaRepositorio = personaRepositorio;
    }



    public Persona obtenerPersonaPorId(Long id) {
        Optional<Persona> personaOptional = personaRepositorio.findById(id);
        return personaOptional.orElse(null);
    }

    public Persona crearPersona(Persona persona) {
        // Verificar si ya existe una persona con la misma cédula
        Optional<Persona> personaExistente = personaRepositorio.findByCedula(persona.getCedula());
        if (personaExistente.isPresent()) {
            throw new PersonaExistenteException("Ya existe una persona con la misma cédula.");
        }
        // Asignar roles por tipo
        persona.asignarRolesPorTipo();

        return personaRepositorio.save(persona);
    }


    @Override
    public Persona eliminarPersona(Long id) {
        personaRepositorio.deleteById(id);
        return null;
    }

}


