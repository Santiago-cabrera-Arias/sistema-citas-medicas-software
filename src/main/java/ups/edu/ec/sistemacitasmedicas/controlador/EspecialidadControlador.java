package ups.edu.ec.sistemacitasmedicas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidad;
import ups.edu.ec.sistemacitasmedicas.servicio.EspecialidadServicio;

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

}
