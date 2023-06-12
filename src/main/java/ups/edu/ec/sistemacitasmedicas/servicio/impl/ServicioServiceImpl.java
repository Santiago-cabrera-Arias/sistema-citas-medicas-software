package ups.edu.ec.sistemacitasmedicas.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Servicio;
import ups.edu.ec.sistemacitasmedicas.repositorio.ServicioRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.ServicioService;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService {


    @Autowired
    ServicioRepositorio servicioRepositorio;

    @Override
    public Servicio save(Servicio servicio) {
        return servicioRepositorio.save(servicio);
    }

    @Override
    public Optional<Servicio> get(Integer id) {
        return servicioRepositorio.findById(id);
    }

    @Override
    public void update(Servicio servicio) {
        servicioRepositorio.save(servicio);
    }


    @Override
    public void delete(Integer id) {
        servicioRepositorio.deleteById(id);
    }

    @Override
    public List<Servicio> findAll() {
        return null;
    }
}
