package ups.edu.ec.sistemacitasmedicas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;
import ups.edu.ec.sistemacitasmedicas.modelo.UsuarioRol;
import ups.edu.ec.sistemacitasmedicas.repositorio.RolRepositorio;
import ups.edu.ec.sistemacitasmedicas.repositorio.UsuarioRepositorio;

import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;


    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {

        Usuario nuevoUsuario = usuarioRepositorio.findByUsername(usuario.getUsername());
        if (nuevoUsuario != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya existe");
        }else{

            //recorro los roles
            for (UsuarioRol usuarioRol: usuarioRoles){
                //guardo los roles
                rolRepositorio.save(usuarioRol.getRol());
            }
            //agrego todos los roles que se guardo en la anterior linea.
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            //se crea el nuevo usuario
            nuevoUsuario  = usuarioRepositorio.save(usuario);

        }

        return nuevoUsuario;

    }

    @Override
    public Usuario obtenerUsuario(String username) {

        Usuario usuario = usuarioRepositorio.findByUsername(username);

        if (usuario == null){
            System.out.println("El usuario no existe");
        }

        return usuario;

    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepositorio.deleteById(id);
    }
}
