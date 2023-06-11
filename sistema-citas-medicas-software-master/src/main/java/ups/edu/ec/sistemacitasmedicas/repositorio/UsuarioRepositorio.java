package ups.edu.ec.sistemacitasmedicas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {


    //public Usuario findByUsername(String usuario);
    Optional<Usuario> findByUsername(String usuario);



}
