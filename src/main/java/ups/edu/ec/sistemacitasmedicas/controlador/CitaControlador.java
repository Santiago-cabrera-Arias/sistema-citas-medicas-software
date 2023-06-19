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
import ups.edu.ec.sistemacitasmedicas.repositorio.CitaRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.CitaServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/citas")
public class CitaControlador {
    @Autowired
    private final CitaControlador citaControlador=null;
    private final CitaServicio iCitaServices=null;
    private final Cita cita=null;
    private final CitaRepositorio citaRepositorio=null;


    @PostMapping("/saveCita")
    public ResponseEntity<?> savaeCita(@Valid @RequestBody Cita cita, BindingResult result){
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()){
            List<String> errors=result.getFieldErrors().stream()
                    .map(error -> "'Field"+error.getField()+"'"+error.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try{
            Cita registerCita=iCitaServices.guardarCita(cita);
            response.put("message", "cita creado");
            response.put("result", registerCita);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("messege", "Error en el servidor");
            response.put("result", e.getMessage()+" : " + e.getCause());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);


        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicorById(@PathVariable Long id) {
        try {
            Optional<Medico> optionalDoctor = Optional.ofNullable(iCitaServices.obtenerCitaPorId(id).getMedico());
            if (optionalDoctor.isPresent()) {
                iCitaServices.eliminarCita(id);
                //medicoRepositorio.deleteById(id);
                return ResponseEntity.ok("Doctor eliminado exitosamente");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el doctor: " + e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMedicoById(@PathVariable Long id, @RequestBody Medico updatedMedico) {
        try {
            Optional<Medico> optionalMedico = Optional.ofNullable(iCitaServices.obtenerCitaPorId(id).getMedico());
            if (optionalMedico.isPresent()) {
                Medico medico = optionalMedico.get();
                medico.setNombre(updatedMedico.getNombre());
                medico.setCorreo(updatedMedico.getCorreo());
                // Actualizar otros campos según sea necesario

                citaRepositorio.save(cita);

                return ResponseEntity.ok("Doctor actualizado exitosamente");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el doctor: " + e.getMessage());
        }
    }
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.Cita;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.servicio.CitaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.MedicioServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cita")
@CrossOrigin("*")
public class CitaControlador {

    @Autowired
    CitaServicio citaServicio;
    @Autowired
    MedicioServicio medicioServicio;
    @Autowired
    PersonaServicio personaServicio;

    @PostMapping("/crear/{medico_id}/{persona_id}")
    public Cita guardarCita(@PathVariable("medico_id") Integer medico_id,
                            @PathVariable("persona_id") Integer persona_id,
                            @RequestBody Cita cita) throws Exception{

        List<Cita> citaMedico = new ArrayList<>();
        Persona persona = new Persona();
        Optional<Persona> personaOptional = personaServicio.get(persona_id);
        Medico medico = new Medico();
        Optional<Medico> medicoOptional = medicioServicio.get(medico_id);

        persona.setPersona_id(personaOptional.get().getPersona_id());
        medico.setMedico_id(medicoOptional.get().getMedico_id());

        if (!personaOptional.isPresent()) {
            throw new Exception("La persona no existe");
        }

        if (!medicoOptional.isPresent()) {
            throw new Exception("El medico no existe");
        }

        cita.setPersona(persona);
        cita.setMedico(medico);

        citaMedico.add(cita);

        return citaServicio.guardarCitaMedico(cita, citaMedico);

    }

>>>>>>> main
}

