package ups.edu.ec.sistemacitasmedicas.controlador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidades;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
import ups.edu.ec.sistemacitasmedicas.repositorio.EspecialidadRepositorio;
import ups.edu.ec.sistemacitasmedicas.repositorio.MedicoRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.EspecialidadServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.MedicoServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/especialidades")
public class EspecialidadControlador {

    @Autowired
    private final EspecialidadServicio iEspecialidadServicio=null;
    private final Especialidades especialidades=null;
    private final EspecialidadRepositorio especialidadRepositorio=null;

    @PostMapping("/saveEspecialidad")
    public ResponseEntity<?> saveEspecialidad(@Valid @RequestBody Especialidades especialidades, BindingResult result){
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()){
            List<String> errors=result.getFieldErrors().stream()
                    .map(error -> "'Field"+error.getField()+"'"+error.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try{
            Especialidades especialidades1=iEspecialidadServicio.guardarEspecialidad(especialidades);
            response.put("message", "Especialidad creado");
            response.put("result", especialidades1);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("messege", "Error en el servidor");
            response.put("result", e.getMessage()+" : " + e.getCause());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);


        }
    }

    @GetMapping("/listarEspecialidades")
    public ResponseEntity<?> listarEspecialidades() {
        Map<String, Object> response = new HashMap<>();

        try {
            List<Especialidades> especialidades = iEspecialidadServicio.listarEspecialidades();
            response.put("message", "Especialidades encontradas");
            response.put("result", especialidades);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error en el servidor");
            response.put("result", e.getMessage() + " : " + e.getCause());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/especialidades/{id}")
    public ResponseEntity<?> buscarEspecialidadPorId(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Optional<Especialidades> especialidad = iEspecialidadServicio.obtenerEspecialidadesPorId(id);

            if (especialidad != null) {
                response.put("message", "Especialidad encontrada");
                response.put("result", especialidad);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("message", "Especialidad no encontrada");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("message", "Error en el servidor");
            response.put("result", e.getMessage() + " : " + e.getCause());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }







}
