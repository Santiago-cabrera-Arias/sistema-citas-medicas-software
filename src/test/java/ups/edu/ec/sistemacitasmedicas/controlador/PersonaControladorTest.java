package ups.edu.ec.sistemacitasmedicas.controlador;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PersonaControlador.class)
public class PersonaControladorTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonaServicio personaServicio;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGuardarPersona() throws Exception {

        Persona persona = new Persona("0100897687", "santiago", "cabrera", "Gualaceo", "0998087966", "ssc@gmail.com",
                "activo", "17-02-2002", "masculino", "Empleado");

        given(personaServicio.crearPersona(any(Persona.class))).willReturn(persona);

        ResultActions response = mockMvc.perform(post("/personas/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(persona)));

        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre", is(persona.getNombre())))
                .andExpect(jsonPath("$.apellido", is(persona.getApellido())))
                .andExpect(jsonPath("$.correo", is(persona.getCorreo())));
    }


}
