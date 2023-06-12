package ups.edu.ec.sistemacitasmedicas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ups.edu.ec.sistemacitasmedicas.modelo.CabeceraFactura;
import ups.edu.ec.sistemacitasmedicas.modelo.DetalleFactura;
import ups.edu.ec.sistemacitasmedicas.servicio.CabeceraFacturaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.DetalleFacturaServicio;

@RestController
@RequestMapping("/facturas")
@CrossOrigin("*")
public class FacturaControlador {


    @Autowired
    CabeceraFacturaServicio cabeceraFacturaService;
    @Autowired
    DetalleFacturaServicio detalleFacturaServicio;

    public CabeceraFactura crearFactura(@RequestParam Integer id, @RequestParam Integer cantidad){

        DetalleFactura detalleFactura = new DetalleFactura();
        double sumTotal = 0;


        return null;

    }




}
