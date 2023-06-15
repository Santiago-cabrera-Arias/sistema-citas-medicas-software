package ups.edu.ec.sistemacitasmedicas.controlador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.Cita;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
import ups.edu.ec.sistemacitasmedicas.repositorio.CitaRepositorio;
import ups.edu.ec.sistemacitasmedicas.repositorio.MedicoRepositorio;
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
    private final MedicoControlador citaControlador=null;
    private final MedicoServicio iMedicoServices=null;

    private final MedicoRepositorio medicoRepositorio=null;


    @PostMapping("/saveMedico")
    public ResponseEntity<?> saveMedico(@Valid @RequestBody Medico medico, BindingResult result){
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()){
            List<String> errors=result.getFieldErrors().stream()
                    .map(error -> "'Field"+error.getField()+"'"+error.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try{
            Medico registerMedico=iMedicoServices.guardarMedico(medico);
            response.put("message", "Medico creado");
            response.put("result", registerMedico);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("messege", "Error en el servidor");
            response.put("result", e.getMessage()+" : " + e.getCause());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);


        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicoById(@PathVariable Long id) {
        try {
            Optional<Medico> optionalDoctor = Optional.ofNullable(iMedicoServices.obtenerMedicoPorId(id).getMedico());
            if (optionalDoctor.isPresent()) {
                iMedicoServices.eliminarMedico(id);
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
            Optional<Medico> optionalMedico = Optional.ofNullable(iMedicoServices.obtenerMedicoPorId(id).getMedico());
            if (optionalMedico.isPresent()) {
                Medico medico = optionalMedico.get();
                medico.setNombre(updatedMedico.getNombre());
                medico.setCorreo(updatedMedico.getCorreo());
                // Actualizar otros campos según sea necesario

                medicoRepositorio.save(medico);

                return ResponseEntity.ok("Doctor actualizado exitosamente");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el doctor: " + e.getMessage());
        }
    }
}

