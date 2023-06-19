package ups.edu.ec.sistemacitasmedicas.controlador;

<<<<<<< HEAD
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.Cita;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;
import ups.edu.ec.sistemacitasmedicas.repositorio.CitaRepositorio;
import ups.edu.ec.sistemacitasmedicas.repositorio.MedicoRepositorio;
import ups.edu.ec.sistemacitasmedicas.repositorio.PersonaRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.CitaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.MedicoServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/medico")
public class MedicoControlador {
    @Autowired
    private PersonaRepositorio personaRepositorio;
    private MedicoServicio medicoServicio;


    @PostMapping("/registrar")
    public Medico guardarMedico(@RequestBody Medico medico) throws Exception {
        // Obtener la Persona por su ID
        Persona persona = personaRepositorio.findById(medico.getPersona().getPersona_id())
                .orElseThrow(() -> new Exception("Persona no encontrada"));

        // Asignar la Persona al Usuario
        medico.setPersona(persona);

        // Guardar el Usuario en la base de datos
        return medicoServicio.guardarMedico(medico);
    }

    @GetMapping("/{MedicoId}")
    public Medico obtenerMedico(@PathVariable("MedicoId")Integer MedicoId){
        return medicoServicio.obtenerMedicoPorId(MedicoId);
    }


    @DeleteMapping("/{MedicoId}")
    public void eliminarMedico(@PathVariable Integer MedicoId) {
        medicoServicio.eliminarMedico(MedicoId);
    }
}

=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidad;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.servicio.EspecialidadServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.MedicioServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicoControlador")
@CrossOrigin("*")
public class MedicoControlador {

    @Autowired
    PersonaServicio personaServicio;

    @Autowired
    EspecialidadServicio especialidadServicio;

    @Autowired
    MedicioServicio medicioServicio;

    @PostMapping("/guardarMedicoEspecialidad/{persona_id}/{especialidad_id}")
    public Medico guardarMedicoEspecialidad(@PathVariable("persona_id") Integer persona_id,
                                            @PathVariable("especialidad_id") Integer especialidad_id,
                                            @RequestBody Medico medico) throws Exception {


        List<Medico> medicoEspecialidad = new ArrayList<>();
        Especialidad especialidad = new Especialidad();
        Optional<Especialidad> especialidadOptional = especialidadServicio.get(especialidad_id);
        Persona persona = new Persona();
        Optional<Persona> personaOptional = personaServicio.get(persona_id);

        persona.setPersona_id(personaOptional.get().getPersona_id());
        especialidad.setEspecialidad_id(especialidadOptional.get().getEspecialidad_id());

        if (!personaOptional.isPresent()) {
            throw new Exception("La persona no existe");
        }

        if (!especialidadOptional.isPresent()) {
            throw new Exception("La especialidad no existe");
        }

        medico.setPersona(persona);
        medico.setEspecialidad(especialidad);

        medicoEspecialidad.add(medico);

        return medicioServicio.guardarMedicoEspecialidad(medico,medicoEspecialidad);

    }


}
>>>>>>> main
