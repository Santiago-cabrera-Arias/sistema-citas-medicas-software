package ups.edu.ec.sistemacitasmedicas.controlador;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.CabeceraFactura;
import ups.edu.ec.sistemacitasmedicas.servicio.CabeceraFacturaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.DetalleFacturaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.ServicioService;

import java.util.logging.Logger;

@RestController
@RequestMapping("/cabeceraFactura")
@CrossOrigin("*")
public class CabeceraControlador {

    @Autowired
    CabeceraFacturaServicio cabeceraFacturaService;

    //@RequestParam Integer id, @RequestParam Integer cantidad
    @PostMapping("/crearFactura")
    public CabeceraFactura crearCabeceraFactura(@RequestBody CabeceraFactura cabeceraFactura) throws Exception {
        CabeceraFactura cabeceraFactura1 = cabeceraFacturaService.save(cabeceraFactura);
        return cabeceraFactura1;
    }
}

