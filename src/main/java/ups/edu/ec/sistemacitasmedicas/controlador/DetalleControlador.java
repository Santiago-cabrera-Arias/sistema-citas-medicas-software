package ups.edu.ec.sistemacitasmedicas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.DetalleFactura;
import ups.edu.ec.sistemacitasmedicas.servicio.DetalleFacturaServicio;

@RestController
@RequestMapping("/detalleFactura")
@CrossOrigin("*")
public class DetalleControlador {

    @Autowired
    DetalleFacturaServicio detalleFacturaServicio;

    @PostMapping("/crearDetalleFactura")
    public DetalleFactura crearDetallaFactura(@RequestBody DetalleFactura detalleFactura){
        return detalleFacturaServicio.save(detalleFactura);
    }

}
