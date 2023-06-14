package ups.edu.ec.sistemacitasmedicas.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.CabeceraFactura;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.repositorio.CabeceraFacturaRepositorio;
import ups.edu.ec.sistemacitasmedicas.servicio.CabeceraFacturaServicio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CabeceraFacturaServicioImpl implements CabeceraFacturaServicio {

    @Autowired
    CabeceraFacturaRepositorio cabeceraFacturaRepositorio;

    @Override
    public List<CabeceraFactura> findAll() {
        return cabeceraFacturaRepositorio.findAll();
    }

    @Override
    public Optional<CabeceraFactura> findById(Integer id) {
        return cabeceraFacturaRepositorio.findById(id);
    }

    @Override
    public CabeceraFactura save(CabeceraFactura cabeceraFactura) {
        return cabeceraFacturaRepositorio.save(cabeceraFactura);
    }

    @Override
    public List<CabeceraFactura> findByPersona(Persona persona) {
        return cabeceraFacturaRepositorio.findByPersona(persona);
    }

    @Override
    public CabeceraFactura obtenerCabeceraFacturaPorId(Integer cabeceraFactura_id) {
        Optional<CabeceraFactura> cabeceraFacturaOptional = cabeceraFacturaRepositorio.findById(cabeceraFactura_id);
        return cabeceraFacturaOptional.orElse(null);

    }
}
