package ups.edu.ec.sistemacitasmedicas.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.Servicio;
import ups.edu.ec.sistemacitasmedicas.servicio.ServicioService;

import java.util.Optional;

@RestController
@RequestMapping("/servicio")
@CrossOrigin("*")
public class ServicioControlador {

    @Autowired
    ServicioService servicioService;

    @PostMapping("/guardarServicio")
    public Servicio guardarServicio(@RequestBody Servicio servicio){
        return servicioService.save(servicio);
    }

    public Servicio editarServicio(Servicio servicio){

        return null;
    }





}
