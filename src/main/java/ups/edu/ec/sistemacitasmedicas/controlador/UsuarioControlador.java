package ups.edu.ec.sistemacitasmedicas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;
import ups.edu.ec.sistemacitasmedicas.servicio.PersonaServicio;
import ups.edu.ec.sistemacitasmedicas.servicio.UsuarioServicio;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private PersonaServicio personaServicio;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) throws Exception {
        Optional<Persona> persona = personaServicio.get(usuario.getPersona().getPersona_id());

        if (persona.isPresent()) {
            Persona persons = persona.get();
            // Asignar la Persona al Usuario
            usuario.setPersona(persons);

            // Guardar el Usuario en la base de datos
            Usuario nuevoUsuario = usuarioServicio.guardarUsuario(usuario);
            return ResponseEntity.ok(nuevoUsuario);
        }

        return ResponseEntity.badRequest().body(usuario);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username) {
        return usuarioServicio.obtenerUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Integer usuarioId) {
        usuarioServicio.eliminarUsuario(usuarioId);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        // Obtén el usuario de la base de datos por el nombre de usuario
        Usuario usuarioBD = usuarioServicio.obtenerUsuario(usuario.getUsername());

        // Verifica si el usuario existe y si la contraseña coincide
        if (usuarioBD != null && usuarioBD.getPassword().equals(usuario.getPassword())) {
            return "Inicio de sesión exitoso";
        } else {
            return "Credenciales de inicio de sesión inválidas";
        }
    }
    @PutMapping("/{username}")
    public Usuario actualizarUsuario(@PathVariable("username") String username, @RequestBody Usuario usuario) throws Exception {
        // Verificar si el usuario existe en la base de datos
        Usuario usuarioExistente = usuarioServicio.obtenerUsuario(username);
        if (usuarioExistente == null) {
            throw new Exception("Usuario no encontrado");
        }

        // Obtener la Persona por su ID
        Optional<Persona> persona = personaServicio.get(usuario.getPersona().getPersona_id());

        if (!persona.isPresent()){
            throw new Exception("El usuario no esta presente...");
        }

        Persona persoons = persona.get();

        // Actualizar los datos del usuario existente
        usuarioExistente.setEncargo(usuario.getEncargo());
        usuarioExistente.setUsername(usuario.getUsername());
        usuarioExistente.setPassword(usuario.getPassword());
        usuarioExistente.setEstado(usuario.isEstado());
        usuarioExistente.setGeneral(usuario.isGeneral());
        usuarioExistente.setAdministrador(usuario.isAdministrador());
        usuarioExistente.setPersona(persoons);

        // Guardar los cambios en la base de datos
        return usuarioServicio.guardarUsuario(usuarioExistente);
    }



}