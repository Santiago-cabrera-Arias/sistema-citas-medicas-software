package ups.edu.ec.sistemacitasmedicas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;

import ups.edu.ec.sistemacitasmedicas.repositorio.PersonaRepositorio;

import ups.edu.ec.sistemacitasmedicas.repositorio.UsuarioRepositorio;

import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioServicio{
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PersonaRepositorio personaRepositorio;

    public Usuario guardarUsuario(Usuario usuario) throws Exception {
        // Obtener la Persona por su ID
        Persona persona = personaRepositorio.findById(usuario.getUsuarioId())
                .orElseThrow(() -> new Exception("Persona no encontrada"));

        // Asignar la Persona al Usuario
        usuario.setPersona(persona);

        // Guardar el Usuario en la base de datos
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        Optional<Usuario> usuario = usuarioRepositorio.findByUsername(username);
        return usuario.orElse(null);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepositorio.deleteById(id);
    }
}