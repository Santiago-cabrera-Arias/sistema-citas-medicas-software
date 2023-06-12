package ups.edu.ec.sistemacitasmedicas.servicio;

import ups.edu.ec.sistemacitasmedicas.modelo.Servicio;

import java.util.List;
import java.util.Optional;

public interface ServicioService {

    public Servicio save(Servicio servicio);
    public Optional<Servicio> get(Integer id);
    public void update(Servicio servicio);
    public void delete(Integer id);
    public List<Servicio> findAll();

}
