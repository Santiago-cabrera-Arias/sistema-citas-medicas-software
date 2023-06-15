package ups.edu.ec.sistemacitasmedicas.servicio;

import ups.edu.ec.sistemacitasmedicas.modelo.Especialidades;

import java.util.List;
import java.util.Optional;

public interface EspecialidadServicio {
    Especialidades guardarEspecialidad(Especialidades especialidades);
    List<Especialidades> listarEspecialidades();
    Optional<Especialidades> obtenerEspecialidadesPorId(Long id);

}
