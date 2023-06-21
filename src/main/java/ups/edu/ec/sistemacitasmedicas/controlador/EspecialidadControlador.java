package ups.edu.ec.sistemacitasmedicas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.Exceptions.PersonaNoEncontradaException;
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidad;
import ups.edu.ec.sistemacitasmedicas.servicio.EspecialidadServicio;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/especialidad")
@CrossOrigin("*")
public class EspecialidadControlador {

    @Autowired
    EspecialidadServicio especialidadServicio;

    @PostMapping("/crearEspecialidad")
    public ResponseEntity<Especialidad> crearEspecialidad(@RequestBody Especialidad especialidad){
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadServicio.guardarEspecialidad(especialidad));
    }

    @GetMapping("/obtenerEspecialidades")
    public List<Especialidad> listarEspecialidades(){
        return especialidadServicio.listarEspecialidades();
    }

    @GetMapping("/obtenerEspecialidadesId/{especialidad_id}")
    public ResponseEntity<Especialidad> listarEspecialidadesId(@PathVariable("especialidad_id") Integer especialidad_id){
        return ResponseEntity.status(HttpStatus.OK).body(especialidadServicio.obtenerEspecialidadPorId(especialidad_id));
    }

    @DeleteMapping("/eliminarEspecialidad/{especialidad_id}")
    public void eliminarEspecialidad(@PathVariable("especialidad_id") Integer especialidad_id){
        especialidadServicio.eliminarEspecialidadPorId(especialidad_id);
    }

    @PutMapping("/actualizarEspecialidad/{especialidad_id}")
    public Especialidad actualizarEspecialidad(@PathVariable("especialidad_id") Integer especialidad_id, @RequestBody Especialidad especialidad) throws Exception{

        Especialidad especialidadExistente = especialidadServicio.obtenerEspecialidadPorId(especialidad_id);

        if (especialidadExistente != null){
            especialidadExistente.setEspecialidad(especialidad.getEspecialidad());

            return especialidadServicio.actualizarEspecialidad(especialidadExistente);
        }else {
            throw new Exception("Especialidad no encontrada");
        }

    }




}
