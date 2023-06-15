package ups.edu.ec.sistemacitasmedicas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidad;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.servicio.EspecialidadServicio;
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

    @PostMapping("/guardarMedicoEspecialidad/{especialidad_id}/{telefonoConsultorio}")
    public Persona guardarMedicoEspecialidad(@RequestBody Persona persona,
                                             @PathVariable("especialidad_id") Integer especialidad_id,
                                             @PathVariable("telefonoConsultorio") String telefonoConsultorio ) throws Exception {


        List<Medico> personaMedico = new ArrayList<>();
        Especialidad especialidad = new Especialidad();
        Optional<Especialidad> especialidadOptional = especialidadServicio.get(especialidad_id);

        especialidad.setEspecialidad_id(especialidadOptional.get().getEspecialidad_id());
        especialidad.setEspecialidad(especialidadOptional.get().getEspecialidad());

        Medico medico = new Medico();
        medico.setPersona(persona);
        medico.setTelenoConsultorio(telefonoConsultorio);
        medico.setEspecialidad(especialidad);

        personaMedico.add(medico);

        return personaServicio.guardarMedicoEspecialidad(persona,personaMedico);

    }


}
