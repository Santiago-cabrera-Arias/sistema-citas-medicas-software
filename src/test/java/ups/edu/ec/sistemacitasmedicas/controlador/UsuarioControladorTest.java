package ups.edu.ec.sistemacitasmedicas.controlador;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.UsuarioServicio;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UsuarioControlador.class)
public class UsuarioControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioServicio usuarioServicio;

    @MockBean
    private PersonaServicio personaServicio;

    @Test
    public void testGuardarUsuario() throws Exception {
        // Datos de prueba
        Usuario usuario = new Usuario();
        usuario.setUsuario_id(5);
        usuario.setEncargo("General");
        usuario.setUsername("sss");
        usuario.setPassword("234");
        usuario.setEstado(true);

        Persona persona = new Persona();
        persona.setPersona_id(7);
        // Asigna la persona al usuario
        usuario.setPersona(persona);

        // Simula el comportamiento del servicio de persona
        given(personaServicio.get(7)).willReturn(Optional.of(persona));

        // Simula el comportamiento del servicio de usuario
        given(usuarioServicio.guardarUsuario(any(Usuario.class))).willReturn(usuario);

        // Realiza la solicitud POST con el cuerpo del usuario en formato JSON
        mockMvc.perform(post("/usuarios/registrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"usuario_id\":5,\"encargo\":\"General\",\"username\":\"sss\",\"password\":\"234\",\"estado\":true,\"persona\":{\"persona_id\":7}}"))
                .andExpect(status().isOk());
    }

}
