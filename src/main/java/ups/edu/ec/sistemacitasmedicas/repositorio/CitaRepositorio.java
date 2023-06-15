package ups.edu.ec.sistemacitasmedicas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.edu.ec.sistemacitasmedicas.modelo.Cita;


public interface CitaRepositorio extends JpaRepository<Cita,Long> {

}
