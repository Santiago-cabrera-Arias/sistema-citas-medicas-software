package ups.edu.ec.sistemacitasmedicas.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ups.edu.ec.sistemacitasmedicas.modelo.Cita;
import ups.edu.ec.sistemacitasmedicas.repositorio.CitaRepositorio;
import ups.edu.ec.sistemacitasmedicas.repositorio.ClinicaRepositorio;
import ups.edu.ec.sistemacitasmedicas.modelo.clinica;
import ups.edu.ec.sistemacitasmedicas.servicio.ClinicaServicio;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicaServicioImpl implements ClinicaServicio {

    @Autowired
    ClinicaRepositorio clinicaRepositorio;


    @Override
    public clinica guardarprescripcion(clinica clinica, List<clinica> clinicaPersona) {
        return clinicaRepositorio.save(clinica);
    }

    @Override
    public List<clinica> listarClinica() {
        return clinicaRepositorio.findAll();
    }

    @Override
    public clinica obtenerClinicaPorId(Integer clinica_id) {
        Optional<clinica> citaOptional = clinicaRepositorio.findById(clinica_id);
        return citaOptional.orElse(null);
    }


    @Override
    public Optional<clinica> get(Integer clinica_id) {
        return clinicaRepositorio.findById(clinica_id);
    }




}
