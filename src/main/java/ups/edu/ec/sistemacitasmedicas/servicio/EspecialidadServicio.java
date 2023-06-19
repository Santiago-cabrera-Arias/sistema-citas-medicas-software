package ups.edu.ec.sistemacitasmedicas.servicio;

<<<<<<< HEAD
import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidades;

import java.util.List;
import java.util.Optional;
@Service

public interface EspecialidadServicio {
    Especialidades guardarEspecialidad(Especialidades especialidades);
    List<Especialidades> listarEspecialidades();
    Optional<Especialidades> obtenerEspecialidadesPorId(Long id);
=======
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidad;

import java.util.List;
import java.util.Optional;

public interface EspecialidadServicio {

    Especialidad guardarEspecialidad(Especialidad especialidades);
    List<Especialidad> listarEspecialidades();
    Optional<Especialidad> obtenerEspecialidadPorId(Integer id);
    Optional<Especialidad> get(Integer id);

>>>>>>> main

}
