package ups.edu.ec.sistemacitasmedicas.servicio;

import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidades;

import java.util.List;
import java.util.Optional;
@Service

public interface EspecialidadServicio {
    Especialidades guardarEspecialidad(Especialidades especialidades);
    List<Especialidades> listarEspecialidades();
    Optional<Especialidades> obtenerEspecialidadesPorId(Long id);

}
