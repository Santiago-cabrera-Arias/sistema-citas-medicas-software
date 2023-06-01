package ups.edu.ec.sistemacitasmedicas.servicio;

import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;
import ups.edu.ec.sistemacitasmedicas.modelo.UsuarioRol;

import java.util.Set;

public interface UsuarioServicio {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long id);

}
