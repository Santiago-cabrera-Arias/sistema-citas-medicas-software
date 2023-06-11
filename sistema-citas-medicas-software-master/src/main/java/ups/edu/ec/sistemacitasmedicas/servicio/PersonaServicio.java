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

    public void eliminarPersona(Long id) {
        Optional<Persona> personaOptional = personaRepositorio.findById(id);
        personaOptional.ifPresent(personaRepositorio::delete);
    }


    public Persona actualizarPersona(Persona persona) {
        // Verificar si la persona existe en la base de datos
        Optional<Persona> personaExistente = personaRepositorio.findById(persona.getId_Persona());
        if (!personaExistente.isPresent()) {
            throw new PersonaNoEncontradaException("No se encontró la persona a actualizar.");
        }

        // Actualizar los datos de la persona existente con los nuevos datos
        Persona personaActualizada = personaExistente.get();
        personaActualizada.setCedula(persona.getCedula());
        personaActualizada.setNombre(persona.getNombre());
        personaActualizada.setApellido(persona.getApellido());
        personaActualizada.setDireccion(persona.getDireccion());
        personaActualizada.setTelefono(persona.getTelefono());
        personaActualizada.setCorreo(persona.getCorreo());
        personaActualizada.setEstado(persona.getEstado());
        personaActualizada.setFechaNacimiento(persona.getFechaNacimiento());
        personaActualizada.setSexo(persona.getSexo());
        personaActualizada.setTipo(persona.getTipo());
        personaActualizada.setEsCliente(persona.isEsCliente());
        personaActualizada.setEsMedico(persona.isEsMedico());
        personaActualizada.setEsEmpleado(persona.isEsEmpleado());
        // Actualiza otros atributos según tu modelo de datos

        // Guardar los cambios en la base de datos
        return personaRepositorio.save(personaActualizada);
    }


}


