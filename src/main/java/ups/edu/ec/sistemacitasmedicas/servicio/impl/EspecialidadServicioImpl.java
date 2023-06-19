package ups.edu.ec.sistemacitasmedicas.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidad;
import ups.edu.ec.sistemacitasmedicas.repositorio.EspecialidadRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServicioImpl implements EspecialidadServicio {

    @Autowired
    EspecialidadRepositorio especialidadRepositorio;

    @Override
    public Especialidad guardarEspecialidad(Especialidad especialidades) {
        return especialidadRepositorio.save(especialidades);
    }

    @Override
    public List<Especialidad> listarEspecialidades() {
        return especialidadRepositorio.findAll();
    }

    @Override
    public Optional<Especialidad> obtenerEspecialidadPorId(Integer id) {
        return especialidadRepositorio.findById(id);
    }

    @Override
    public Optional<Especialidad> get(Integer id) {
        return especialidadRepositorio.findById(id);
    }
}
