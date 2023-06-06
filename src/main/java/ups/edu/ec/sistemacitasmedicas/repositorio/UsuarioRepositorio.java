package ups.edu.ec.sistemacitasmedicas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
=======
>>>>>>> 20e85044dbc0ef11ad551d494dae68775706fb28
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {


    public Usuario findByUsername(String usuario);


<<<<<<< HEAD
=======

>>>>>>> 20e85044dbc0ef11ad551d494dae68775706fb28
}
