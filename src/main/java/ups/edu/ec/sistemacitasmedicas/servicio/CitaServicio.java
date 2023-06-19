package ups.edu.ec.sistemacitasmedicas.servicio;

import ups.edu.ec.sistemacitasmedicas.modelo.Cita;
<<<<<<< HEAD

import java.util.List;

public interface CitaServicio {
    Cita guardarCita(Cita cita);
    List<Cita> listarCitas();
    Cita obtenerCitaPorId(Long id);
    void eliminarCita(Long id);
    Cita actualizarCita(Cita cita);
=======
import ups.edu.ec.sistemacitasmedicas.modelo.Medico;

import java.util.List;
import java.util.Optional;

public interface CitaServicio {

//    Cita guardarCita(Cita cita);
    List<Cita> listarCitas();
    Cita obtenerCitaPorId(Integer id);
    Optional<Cita> get(Integer id);
    Cita guardarCitaMedico(Cita cita, List<Cita> citaMedico) throws Exception;



>>>>>>> main
}
