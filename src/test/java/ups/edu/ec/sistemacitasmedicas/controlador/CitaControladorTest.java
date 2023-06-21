package ups.edu.ec.sistemacitasmedicas.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ups.edu.ec.sistemacitasmedicas.modelo.Clinica;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.servicio.ClinicaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.MedicioServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CitaControlador.class)
public class CitaControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonaServicio personaServicio;
    @MockBean
    private MedicioServicio medicoServicio;
    @MockBean
    private ClinicaServicio clinicaServicio;


    @Autowired
    private ObjectMapper objectMapper;
    /*@Test
    public void testCrearCitaMedica() throws Exception {
        // Datos de prueba
        Integer medicoId = 1;
        Integer personaId = 2;
        Clinica clinica = new Clinica();
        // Configurar los datos de la clínica según tus necesidades

        // Simula el comportamiento del servicio de persona
        given(personaServicio.get(personaId)).willReturn(Optional.of(new Persona()));

        // Simula el comportamiento del servicio de médico
        given(medicoServicio.get(medicoId)).willReturn(Optional.of(new Medico()));

        // Simula el comportamiento del servicio de clínica
        given(clinicaServicio.guardarprescripcion(any(Clinica.class), anyList())).willReturn(clinica);

        // Realiza la solicitud POST con el cuerpo de la clínica en formato JSON
        mockMvc.perform(post("/crear/{medico_id}/{persona_id}", medicoId, personaId)
                        .contentType(MediaType.APPLICATION_JSON);
                        //.content("{}")) // Puedes configurar el cuerpo de la clínica según tus necesidades
                //.andExpect(status().isOk());
    }*/
}
