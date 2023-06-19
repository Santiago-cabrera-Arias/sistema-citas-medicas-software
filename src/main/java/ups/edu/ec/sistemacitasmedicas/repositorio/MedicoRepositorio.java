package ups.edu.ec.sistemacitasmedicas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;

public interface MedicoRepositorio extends JpaRepository<Medico,Integer> {
}
