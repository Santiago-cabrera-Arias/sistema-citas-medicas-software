package ups.edu.ec.sistemacitasmedicas.servicio;

public class PersonaNoEncontradaException extends RuntimeException {
    public PersonaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}