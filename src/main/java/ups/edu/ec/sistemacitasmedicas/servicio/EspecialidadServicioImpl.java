package ups.edu.ec.sistemacitasmedicas.servicio;

import ups.edu.ec.sistemacitasmedicas.modelo.Especialidades;
import ups.edu.ec.sistemacitasmedicas.repositorio.EspecialidadRepositorio;

import java.util.List;
import java.util.Optional;

public class EspecialidadServicioImpl implements EspecialidadServicio {
    public EspecialidadRepositorio especialidadRepositorio=null;
    @Override
    public Especialidades guardarEspecialidad(Especialidades especialidades) {
        return especialidadRepositorio.save(especialidades);
    }

    @Override
    public List<Especialidades> listarEspecialidades() {
        return especialidadRepositorio.findAll();
    }

    @Override
    public Optional<Especialidades> obtenerEspecialidadesPorId(Long id) {
        return especialidadRepositorio.findById(id);
    }
}
