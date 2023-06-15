package ups.edu.ec.sistemacitasmedicas.servicio;

import ups.edu.ec.sistemacitasmedicas.modelo.Cita;

import java.util.List;

public interface CitaServicio {
    Cita guardarCita(Cita cita);
    List<Cita> listarCitas();
    Cita obtenerCitaPorId(Long id);
    void eliminarCita(Long id);
    Cita actualizarCita(Cita cita);
}
