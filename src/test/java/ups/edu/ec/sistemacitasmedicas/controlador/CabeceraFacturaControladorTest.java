package ups.edu.ec.sistemacitasmedicas.controlador;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ups.edu.ec.sistemacitasmedicas.modelo.CabeceraFactura;
import ups.edu.ec.sistemacitasmedicas.modelo.DetalleFactura;
import ups.edu.ec.sistemacitasmedicas.servicio.CabeceraFacturaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.DetalleFacturaServicio;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import java.util.ArrayList;
import java.util.List;

@WebMvcTest(CabeceraFacturaControlador.class)
public class CabeceraFacturaControladorTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CabeceraFacturaServicio cabeceraFacturaServicio;

    @MockBean
    private DetalleFacturaServicio detalleFacturaServicio;

    @Test
    public void testObtenerTotalFacturas() throws Exception {
        // Datos de prueba
        List<CabeceraFactura> facturas = new ArrayList<>();
        facturas.add(new CabeceraFactura());
        facturas.add(new CabeceraFactura());

        given(cabeceraFacturaServicio.findAll()).willReturn(facturas);

        // Realizar la solicitud HTTP GET
        ResultActions result = mockMvc.perform(get("/cabeceraFactura/obtenerTotalFacturas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("El total de todas las facturas es de:")));

        // Verificar los resultados
        result.andDo(print());

    }

    @Test
    public void testObtenerTotalServicios() throws Exception {
        // Datos de prueba
        List<DetalleFactura> detallesFactura = new ArrayList<>();
        DetalleFactura detalle1 = new DetalleFactura();
        detalle1.setTotal(50.0);
        detalle1.setCabeceraFactura(new CabeceraFactura());
        DetalleFactura detalle2 = new DetalleFactura();
        detalle2.setTotal(100.0);
        detalle2.setCabeceraFactura(new CabeceraFactura());
        detallesFactura.add(detalle1);
        detallesFactura.add(detalle2);

        given(detalleFacturaServicio.findAll()).willReturn(detallesFactura);

        // Realizar la solicitud HTTP GET
        ResultActions result = mockMvc.perform(get("/cabeceraFactura/obtenerTotalServicios")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("La suma total de servicios contratados es de: 150.0")))
                .andExpect(content().string(containsString("La suma total de los subtotal son de: 0.0")));

        // Verificar los resultados
        result.andDo(print());
    }



}
