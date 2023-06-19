package ups.edu.ec.sistemacitasmedicas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;
<<<<<<< HEAD
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.modelo.Usuario;

import java.util.Optional;


public interface MedicoRepositorio extends JpaRepository<Medico,Integer> {
    Optional<Medico> findById(Integer MedicoId);



=======

public interface MedicoRepositorio extends JpaRepository<Medico,Integer> {
>>>>>>> main
}
