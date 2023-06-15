package ups.edu.ec.sistemacitasmedicas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;
import ups.edu.ec.sistemacitasmedicas.repositorio.PersonaRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.UsuarioServicio;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private PersonaRepositorio personaRepositorio;

    @PostMapping("/registrar")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
//        if (usuario.getUsuario_id() == null) {
//            throw new Exception("El id del usuario no puede ser nulo");
//        }
        // Obtener la Persona por su ID
        Persona persona = personaRepositorio.findById(usuario.getPersona().getPersona_id())
                .orElseThrow(() -> new Exception("Persona no encontrada"));

        // Asignar la Persona al Usuario
        usuario.setPersona(persona);

        // Guardar el Usuario en la base de datos
        return usuarioServicio.guardarUsuario(usuario);
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




}