package ups.edu.ec.sistemacitasmedicas.servicio.impl;

import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Cita;
import ups.edu.ec.sistemacitasmedicas.repositorio.CitaRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.CitaServicio;

import java.util.List;

@Service
public class CitaServiceImpl implements CitaServicio {

    private final CitaRepositorio citaRepositorio=null;

    @Override
    public Cita guardarCita(Cita cita) {

        return citaRepositorio.save(cita);
    }

    @Override
    public List<Cita> listarCitas() {

        return citaRepositorio.findAll();
    }

    @Override
    public Cita obtenerCitaPorId(Long id) {
        return citaRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarCita(Long id) {
        citaRepositorio.deleteById(id);
    }

    @Override
    public Cita actualizarCita(Cita cita) {

        return null;
    }
}