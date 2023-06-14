package ups.edu.ec.sistemacitasmedicas.controlador;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.Exceptions.PersonaNoEncontradaException;
import ups.edu.ec.sistemacitasmedicas.Exceptions.ServicioNoEncontradoException;
import ups.edu.ec.sistemacitasmedicas.modelo.CabeceraFactura;
import ups.edu.ec.sistemacitasmedicas.modelo.DetalleFactura;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.modelo.Servicio;
import ups.edu.ec.sistemacitasmedicas.servicio.CabeceraFacturaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.DetalleFacturaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.ServicioService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/facturaControlador")
@CrossOrigin("*")
public class FacturaControlador {

    @Autowired
    private CabeceraFacturaServicio cabeceraFacturaServicio;

    @Autowired
    private DetalleFacturaServicio detalleFacturaServicio;

    @Autowired
    private PersonaServicio personaServicio;

    @Autowired
    private ServicioService servicioService;

//    @PostMapping("/crear")
//    public void crearFactura(@RequestParam("persona_id") Integer persona_id, @RequestBody List<DetalleFactura> detallesFactura) throws Exception{
//        // Obtener la persona de la base de datos
//        Optional<Persona> personaOptional = personaServicio.get(persona_id);
//        Persona persona = personaOptional.orElseThrow(() -> new PersonaNoEncontradaException("La persona no existe"));
//
//        // Crear la cabecera de la factura
//        CabeceraFactura cabeceraFactura = new CabeceraFactura();
//        cabeceraFactura.setFecha("22-12-2002");
//        cabeceraFactura.setSubtotal(0.0);
//        cabeceraFactura.setTotalIva(0.0);
//        cabeceraFactura.setTotalFactura(0.0);
//        cabeceraFactura.setEstado(true);
//        cabeceraFactura.setPersona(persona);
//
//        // Guardar la cabecera de la factura en la base de datos
//        cabeceraFactura = cabeceraFacturaServicio.save(cabeceraFactura);
//
//        // Calcular los montos de la factura
//        double subtotal = 0.0;
//        double totalIva = 0.0;
//        double totalFactura = 0.0;
//
//        for (DetalleFactura detalle : detallesFactura) {
//            // Obtener el servicio de la base de datos
//            Optional<Servicio> servicioOptional = servicioService.get(detalle.getServicio().getServicio_id());
//            Servicio servicio = servicioOptional.orElseThrow(() -> new ServicioNoEncontradoException("El servicio no existe"));
//
//            // Calcular el total del detalle de la factura
//            double total = detalle.getCantidad() * servicio.getPrecio();
//            subtotal += total;
//
//            // Crear el detalle de la factura
//            DetalleFactura detalleFactura = new DetalleFactura();
//            detalleFactura.setNombre(servicio.getNombreServicio());
//            detalleFactura.setCantidad(detalle.getCantidad());
//            detalleFactura.setPrecioUnitario(servicio.getPrecio());
//            detalleFactura.setTotal(total);
//            detalleFactura.setCabeceraFactura(cabeceraFactura);
//
//            // Guardar el detalle de la factura en la base de datos
//            detalleFacturaServicio.save(detalleFactura);
//        }
//
//        // Calcular los montos de la factura
//        totalIva = subtotal * 0.15; // Suponiendo un IVA del 15%
//        totalFactura = subtotal + totalIva;
//
//        // Actualizar los montos en la cabecera de la factura
//        cabeceraFactura.setSubtotal(subtotal);
//        cabeceraFactura.setTotalIva(totalIva);
//        cabeceraFactura.setTotalFactura(totalFactura);
//        cabeceraFacturaServicio.save(cabeceraFactura);
//    }


    @PostMapping("/crear/{persona_id}/{servicio_id}/{cantidad}")
    public ResponseEntity<?> crearFactura(@PathVariable Integer persona_id,
                                          @PathVariable Integer servicio_id,
                                          @PathVariable int cantidad) {
        try {
            // Verificar si la persona y el servicio existen en la base de datos
            Persona personaOptional = personaServicio.obtenerPersonaPorId(persona_id);
            Optional<Servicio> servicioOptional = servicioService.get(servicio_id);

            if (personaOptional == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("La persona con el ID " + persona_id + " no existe.");
            }

            if (!servicioOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El servicio con el ID " + servicio_id + " no existe.");
            }

            // Crear la cabecera de la factura
            CabeceraFactura cabeceraFactura = new CabeceraFactura();
            cabeceraFactura.setFecha("17-02-2002");
            cabeceraFactura.setEstado(true);

            cabeceraFactura.setPersona(personaOptional);

            // Crear el detalle de la factura
            DetalleFactura detalleFactura = new DetalleFactura();
            detalleFactura.setCantidad(cantidad);
            detalleFactura.setPrecioUnitario(servicioOptional.get().getPrecio());
            detalleFactura.setTotal(cantidad * servicioOptional.get().getPrecio());
            detalleFactura.setServicio(servicioOptional.get());
            detalleFactura.setCabeceraFactura(cabeceraFactura);

            // Calcular los totales de la factura
            double subtotal = detalleFactura.getTotal();
            double totalIva = subtotal * servicioOptional.get().getIva();
            double totalFactura = subtotal + totalIva;

            cabeceraFactura.setSubtotal(subtotal);
            cabeceraFactura.setTotalIva(totalIva);
            cabeceraFactura.setTotalFactura(totalFactura);

            // Guardar la factura en la base de datos
            cabeceraFacturaServicio.save(cabeceraFactura);
            detalleFacturaServicio.save(detalleFactura);

            return ResponseEntity.ok("La factura se ha creado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al crear la factura: " + e.getMessage());
        }
    }

}
