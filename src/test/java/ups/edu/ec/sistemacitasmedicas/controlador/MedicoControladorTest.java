package ups.edu.ec.sistemacitasmedicas.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ups.edu.ec.sistemacitasmedicas.modelo.*;
import ups.edu.ec.sistemacitasmedicas.servicio.EspecialidadServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.MedicioServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.UsuarioServicio;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MedicoControladorTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicioServicio medicioServicio;

    @MockBean
    private PersonaServicio personaServicio;

    @MockBean
    private EspecialidadServicio especialidadServicio;



   /* @Test
    public void testGuardarMedico() throws Exception {
        // Datos de prueba
        Integer especialidad_id = 1;
        Integer persona_id = 1;
        Medico medico = new Medico();
        medico.setMedico_id(1);
        // ... Establecer otras propiedades de Medico

        // Simular el comportamiento del servicio
        given(personaServicio.get(persona_id)).willReturn(Optional.of(new Persona()));
        given(especialidadServicio.get(especialidad_id)).willReturn(Optional.of(new Especialidad()));
        given(medicioServicio.guardarMedicoEspecialidad(any(Medico.class), anyList())).willReturn(medico);

        // Realizar la solicitud POST con el cuerpo de la clínica en formato JSON crear/{medico_id}/{persona_id}
        ResultActions response= mockMvc.perform(post("/medicoControlador/guardarMedicoEspecialidad/{persona_id}/{especialidad_id}",  persona_id,especialidad_id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(medico))); // Proporcionar el contenido JSON completo de la clínica
        response.andDo(print());

    }*/
}
