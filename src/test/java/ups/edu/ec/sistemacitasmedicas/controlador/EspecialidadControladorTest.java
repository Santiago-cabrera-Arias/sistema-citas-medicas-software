package ups.edu.ec.sistemacitasmedicas.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidad;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.servicio.EspecialidadServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EspecialidadControlador.class)
public class EspecialidadControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EspecialidadServicio especialidadServicio;

    @Test
    public void testCrearEspecialidad() throws Exception {
        // Arrange
        Especialidad especialidad = new Especialidad();
        given(especialidadServicio.guardarEspecialidad(any(Especialidad.class))).willReturn(especialidad);

        // Act & Assert
        mockMvc.perform(post("/especialidad/crearEspecialidad")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(especialidad)))
                .andExpect(status().isCreated());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
