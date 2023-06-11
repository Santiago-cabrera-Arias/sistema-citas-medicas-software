package ups.edu.ec.sistemacitasmedicas.servicio;

import ups.edu.ec.sistemacitasmedicas.modelo.Persona;

public interface PersonaServicio1 {



    public Persona obtenerPersonaPorId(Long id);

    public Persona  crearPersona(Persona persona);

    public Persona eliminarPersona(Long id);

}
