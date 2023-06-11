package ups.edu.ec.sistemacitasmedicas.servicio;

public class PersonaExistenteException extends RuntimeException {
    public PersonaExistenteException(String message) {
        super(message);
    }
}