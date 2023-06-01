package ups.edu.ec.sistemacitasmedicas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {


    public Usuario findByUsername(String usuario);



}
