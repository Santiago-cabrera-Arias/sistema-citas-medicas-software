package ups.edu.ec.sistemacitasmedicas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.edu.ec.sistemacitasmedicas.modelo.clinica;

import java.util.Optional;

public interface ClinicaRepositorio extends JpaRepository<clinica, Integer> {

    Optional<clinica> findById(Integer clinica_id);


}
