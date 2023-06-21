package ups.edu.ec.sistemacitasmedicas.controlador;


import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ups.edu.ec.sistemacitasmedicas.modelo.CabeceraFactura;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.modelo.Servicio;
import ups.edu.ec.sistemacitasmedicas.servicio.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import static org.hamcrest.Matchers.*;


@WebMvcTest(FacturaControlador.class)
public class FacturaControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CabeceraFacturaServicio cabeceraFacturaServicio;

    @MockBean
    private DetalleFacturaServicio detalleFacturaServicio;

    @MockBean
    private PersonaServicio personaServicio;

    @MockBean
    private ServicioService servicioService;

    @MockBean
    private EmailSenderServicio emailSenderServicio;


    @Test
    public void crearFactura_Existente_Success() throws Exception {
        // Datos de prueba
        Integer personaId = 2;
        Integer servicioId = 2;
        int cantidad = 2;

        Persona persona = new Persona();
        persona.setPersona_id(personaId);
        persona.setNombre("John");
        persona.setApellido("Doe");
        persona.setCorreo("john.doe@example.com");

        Servicio servicio = new Servicio();
        servicio.setServicio_id(servicioId);
        servicio.setNombreServicio("Servicio A");
        servicio.setPrecio(10.0);
        servicio.setIva(0.12);
        servicio.setCantidad(5);

        given(personaServicio.obtenerPersonaPorId(personaId)).willReturn(persona);
        given(servicioService.get(servicioId)).willReturn(Optional.of(servicio));

        // Realizar la solicitud HTTP POST
        ResultActions result = mockMvc.perform(post("/facturaControlador/crear/{persona_id}/{servicio_id}/{cantidad}", personaId, servicioId, cantidad)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(is("La factura se ha creado correctamente.")));

        // Verificar los resultados
        result.andDo(print());

        // Aquí puedes agregar más verificaciones según tus necesidades
    }


    @Test
    public void testObtenerFacturas() throws Exception {
        // Datos de prueba
        List<CabeceraFactura> facturas = new ArrayList<>();
        facturas.add(new CabeceraFactura());
        facturas.add(new CabeceraFactura());

        given(cabeceraFacturaServicio.findAll()).willReturn(facturas);

        // Realizar la solicitud HTTP GET
        ResultActions result = mockMvc.perform(get("/facturaControlador/obtenerFacturas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

        // Verificar los resultados
        result.andDo(print());

        // Aquí puedes agregar más verificaciones según tus necesidades
    }




}
