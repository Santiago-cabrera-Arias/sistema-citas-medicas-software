package ups.edu.ec.sistemacitasmedicas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import java.util.Optional;


public interface PersonaRepositorio extends JpaRepository<Persona,Integer> {
    Optional<Persona> findByCedula(String cedula);
    Optional<Persona> findById(Integer persona_id);

}
