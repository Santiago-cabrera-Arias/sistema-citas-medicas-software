package ups.edu.ec.sistemacitasmedicas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidad;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.Exceptions.PersonaNoEncontradaException;
import ups.edu.ec.sistemacitasmedicas.servicio.EspecialidadServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/personas")
@CrossOrigin("*")
public class PersonaControlador  {

    @Autowired
    PersonaServicio personaServicio;

    @Autowired
    EspecialidadServicio especialidadServicio;


    @PostMapping("/registrar")
    public Persona guardarPersona(@RequestBody Persona persona) throws Exception{
        return personaServicio.crearPersona(persona);
    }

    @GetMapping("/{persona_id}")
    public Persona obtenerPersona(@PathVariable("persona_id")Integer persona_id){
        return personaServicio.obtenerPersonaPorId(persona_id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Integer id) {
        personaServicio.eliminarPersona(id);
    }

    // Actualizar una persona existente
    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable Integer id, @RequestBody Persona personaActualizada) {
        Persona personaExistente = personaServicio.obtenerPersonaPorId(id);

        if (personaExistente != null) {
            personaExistente.setCedula(personaActualizada.getCedula());
            personaExistente.setNombre(personaActualizada.getNombre());
            personaExistente.setApellido(personaActualizada.getApellido());
            personaExistente.setDireccion(personaActualizada.getDireccion());
            personaExistente.setTelefono(personaActualizada.getTelefono());
            personaExistente.setCorreo(personaActualizada.getCorreo());
            personaExistente.setEstado(personaActualizada.getEstado());
            personaExistente.setFechaNacimiento(personaActualizada.getFechaNacimiento());
            personaExistente.setSexo(personaActualizada.getSexo());
            personaExistente.setTipo(personaActualizada.getTipo());

            // Actualiza otros atributos según tu modelo de datos

            return personaServicio.crearPersona(personaExistente);
        } else {
            throw new PersonaNoEncontradaException("No se encontró la persona a actualizar.");
        }
    }

}

