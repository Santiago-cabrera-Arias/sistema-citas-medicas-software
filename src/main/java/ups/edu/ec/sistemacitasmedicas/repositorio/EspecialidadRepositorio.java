package ups.edu.ec.sistemacitasmedicas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidad;

public interface EspecialidadRepositorio extends JpaRepository<Especialidad, Integer> {
}
