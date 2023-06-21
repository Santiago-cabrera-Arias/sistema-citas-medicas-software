package ups.edu.ec.sistemacitasmedicas.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ups.edu.ec.sistemacitasmedicas.modelo.*;
import ups.edu.ec.sistemacitasmedicas.servicio.CitaServicio;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import ups.edu.ec.sistemacitasmedicas.servicio.MedicioServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;


@WebMvcTest(CitaControlador.class)
public class CitaControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonaServicio personaServicio;
    @MockBean
    private MedicioServicio medicoServicio;
    @MockBean
    private CitaServicio citaServicio;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testGuardarCita() throws Exception {
        // Datos de prueba
        Cita cita = new Cita();
        cita.setCita_id(1);
        Integer medico_id = 1;
        Integer persona_id = 1;
        cita.setFechaCita(LocalDate.parse("2023-05-20"));
        cita.setHora(LocalTime.parse("19:00"));
        cita.setEstado(false);



        // Simula el comportamiento del servicio de persona
        // Simular el comportamiento del servicio
        given(personaServicio.get(persona_id)).willReturn(Optional.of(new Persona()));
        given(medicoServicio.get(medico_id)).willReturn(Optional.of(new Medico()));
        given(citaServicio.guardarCitaMedico(any(Cita.class), anyList())).willReturn(cita);


        // Realiza la solicitud POST con el cuerpo de la cita en formato JSON
        ResultActions response= mockMvc.perform(post("/cita/crear/{medico_id}/{persona_id}", medico_id, persona_id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cita))); // Proporcionar el contenido JSON completo de la clínica
        response.andDo(print());
    }

    /*@Test
    public void testGuardarClinica() throws Exception {
        // Datos de prueba
        Cita cita = new Cita();
        cita.setCita_id(1);
        cita.setFechaCita(LocalDate.parse("2023-05-20"));
        cita.setHora(LocalTime.parse("19:00"));
        cita.setEstado(false);
        // ... Establecer otras propiedades de la clínica

        // Simular el comportamiento del servicio
        given(personaServicio.get(personaId)).willReturn(Optional.of(new Persona()));
        given(medicoServicio.get(medicoId)).willReturn(Optional.of(new Medico()));
        given(clinicaServicio.guardarprescripcion(any(Clinica.class), anyList())).willReturn(clinica);

        // Realizar la solicitud POST con el cuerpo de la clínica en formato JSON crear/{medico_id}/{persona_id}
        ResultActions response= mockMvc.perform(post("/clinica/crear/{medico_id}/{persona_id}", medicoId, personaId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(clinica))); // Proporcionar el contenido JSON completo de la clínica
        response.andDo(print());

    }*/




}
