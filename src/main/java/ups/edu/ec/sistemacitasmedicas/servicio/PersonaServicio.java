package ups.edu.ec.sistemacitasmedicas.servicio;

import ups.edu.ec.sistemacitasmedicas.modelo.Persona;

public interface PersonaServicio {

    Persona obtenerPersonaPorId(Integer id);

    Persona crearPersona(Persona persona);

    void eliminarPersona(Integer id);



}
