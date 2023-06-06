package ups.edu.ec.sistemacitasmedicas.servicio;

<<<<<<< HEAD
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
=======
>>>>>>> 20e85044dbc0ef11ad551d494dae68775706fb28
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;
import ups.edu.ec.sistemacitasmedicas.modelo.UsuarioRol;

import java.util.Set;

public interface UsuarioServicio {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
<<<<<<< HEAD
    //public Usuario guardarPersona(Persona persona, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);
    //public Persona obtenerPersona(String nombre);
=======

    public Usuario obtenerUsuario(String username);
>>>>>>> 20e85044dbc0ef11ad551d494dae68775706fb28

    public void eliminarUsuario(Long id);

}
