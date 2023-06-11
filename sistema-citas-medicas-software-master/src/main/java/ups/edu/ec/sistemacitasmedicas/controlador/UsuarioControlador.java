package ups.edu.ec.sistemacitasmedicas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;

import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;

import ups.edu.ec.sistemacitasmedicas.repositorio.PersonaRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.UsuarioServicio;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    private PersonaRepositorio personaRepositorio;


    @PostMapping("/registrar")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
        // Obtener la Persona por su ID
        Persona persona = personaRepositorio.findById(usuario.getUsuarioId()).orElseThrow(() -> new Exception("Persona no encontrada"));

        // Asignar la Persona al Usuario
        usuario.setPersona(persona);

        // Guardar el Usuario en la base de datos
        return usuarioServicio.guardarUsuario(usuario);
    }



    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username")String username){
        return usuarioServicio.obtenerUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioServicio.eliminarUsuario(usuarioId);
    }





}
