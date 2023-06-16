package ups.edu.ec.sistemacitasmedicas.servicio;

import ups.edu.ec.sistemacitasmedicas.modelo.Cita;
import ups.edu.ec.sistemacitasmedicas.modelo.clinica;

import java.util.List;
import java.util.Optional;

public interface ClinicaServicio {


    List<clinica> listarClinica();
    Optional<clinica> get(Integer id);
    clinica guardarprescripcion(clinica clinica, List<clinica> clinicaPersona) throws Exception;
    clinica obtenerClinicaPorId(Integer clinica_id);



}
