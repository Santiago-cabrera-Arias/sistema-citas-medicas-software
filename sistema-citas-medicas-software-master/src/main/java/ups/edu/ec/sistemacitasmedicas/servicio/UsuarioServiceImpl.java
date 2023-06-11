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
    private PersonaRepositorio rolRepositorio1;



    public Usuario guardarUsuario(Usuario usuario) throws Exception {
        // Obtener la Persona por su ID
        Usuario persona = usuarioRepositorio.findByUsername(usuario.getUsername())
                .orElseThrow(() -> new Exception("Usuario no encontrada"));

        // Asignar la Persona al Usuario
        usuario.setPersona(usuario.getPersona());

        // Guardar el Usuario en la base de datos
        return usuarioRepositorio.save(usuario);
    }




    @Override
    public Usuario obtenerUsuario(String username) {

        Optional<Usuario>usuario = usuarioRepositorio.findByUsername(username);

        if (usuario == null){
            System.out.println("El usuario no existe");
        }

        return usuario.orElse(null);

    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepositorio.deleteById(id);
    }
}
