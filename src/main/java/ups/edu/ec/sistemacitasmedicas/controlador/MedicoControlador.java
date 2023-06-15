package ups.edu.ec.sistemacitasmedicas.controlador;

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

