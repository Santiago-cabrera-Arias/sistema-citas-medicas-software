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
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.servicio.EspecialidadServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio;

import java.util.ArrayList;
import java.util.List;

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
        // Datos de prueba
        Especialidad especialidad = new Especialidad();
        especialidad.setEspecialidad_id(1);
        especialidad.setEspecialidad("Cardiología");
        List<Medico> medicos = new ArrayList<>();
        Medico med1 = new Medico(1);
        Medico med2 = new Medico(2);
        medicos.add(med1);
        medicos.add(med2);
        especialidad.setMedicoEspecialidades(medicos);

        // Simula el comportamiento del servicio de especialidad
        given(especialidadServicio.guardarEspecialidad(any(Especialidad.class))).willReturn(especialidad);

        // Realiza la solicitud POST con el cuerpo de la especialidad en formato JSON
        mockMvc.perform(post("/especialidad/crearEspecialidad")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"especialidad_id\":1,\"especialidad\":\"Cardiología\",\"medicoEspecialidades\":[]}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.especialidad_id").value(1))
                .andExpect(jsonPath("$.especialidad").value("Cardiología"))
                .andExpect(jsonPath("$.medicoEspecialidades").isArray());
    }


}
