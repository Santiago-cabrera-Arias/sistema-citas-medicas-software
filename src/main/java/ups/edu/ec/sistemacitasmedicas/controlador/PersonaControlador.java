package ups.edu.ec.sistemacitasmedicas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio1;



@RestController
@RequestMapping("/personas")
@CrossOrigin("*")

public class PersonaControlador  {
    @Autowired
    PersonaServicio1 personaServicio;

    @PostMapping("/registrar")
    public Persona guardarPersona(@RequestBody Persona persona) throws Exception{
        return personaServicio.crearPersona(persona);
    }

    @GetMapping("/{id}")
    public Persona obtenerPersona(@PathVariable("id")Long id){
        return personaServicio.obtenerPersonaPorId(id);
    }

    @DeleteMapping("/{personaid}")
    public void eliminarUsuario(@PathVariable("personaid") Long id){
        personaServicio.eliminarPersona(id);
    }
}
    /*private final PersonaRepositorio personaRepositorio;

    @Autowired
    public PersonaControlador(PersonaRepositorio personaRepositorio) {
        this.personaRepositorio = personaRepositorio;
    }

    // Obtener todas las personas
    @GetMapping("/")
    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepositorio.findAll();
    }

    // Obtener una persona por ID
    @GetMapping("/{id}")
    public Persona obtenerPersonaPorId(@PathVariable Long id) {
        return personaRepositorio.findById(id).orElse(null);
    }

    // Crear una nueva persona
    @PostMapping("/")
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaRepositorio.save(persona);
    }

    // Actualizar una persona existente
    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable Long id, @RequestBody Persona personaActualizada) {
        Persona personaExistente = personaRepositorio.findById(id).orElse(null);

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

            return personaRepositorio.save(personaExistente);
        } else {
            return null;
        }
    }

    // Eliminar una persona por ID
    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaRepositorio.deleteById(id);
    }
}*/

