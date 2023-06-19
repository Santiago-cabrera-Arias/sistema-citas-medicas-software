package ups.edu.ec.sistemacitasmedicas.servicio.impl;

<<<<<<< HEAD
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidades;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Especialidad;
>>>>>>> main
import ups.edu.ec.sistemacitasmedicas.repositorio.EspecialidadRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.EspecialidadServicio;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
public class EspecialidadServicioImpl implements EspecialidadServicio {
    public EspecialidadRepositorio especialidadRepositorio=null;
    @Override
    public Especialidades guardarEspecialidad(Especialidades especialidades) {
=======
@Service
public class EspecialidadServicioImpl implements EspecialidadServicio {

    @Autowired
    EspecialidadRepositorio especialidadRepositorio;

    @Override
    public Especialidad guardarEspecialidad(Especialidad especialidades) {
>>>>>>> main
        return especialidadRepositorio.save(especialidades);
    }

    @Override
<<<<<<< HEAD
    public List<Especialidades> listarEspecialidades() {
=======
    public List<Especialidad> listarEspecialidades() {
>>>>>>> main
        return especialidadRepositorio.findAll();
    }

    @Override
<<<<<<< HEAD
    public Optional<Especialidades> obtenerEspecialidadesPorId(Long id) {
        return especialidadRepositorio.findById(id);
    }
}

=======
    public Optional<Especialidad> obtenerEspecialidadPorId(Integer id) {
        return especialidadRepositorio.findById(id);
    }

    @Override
    public Optional<Especialidad> get(Integer id) {
        return especialidadRepositorio.findById(id);
    }
}
>>>>>>> main
