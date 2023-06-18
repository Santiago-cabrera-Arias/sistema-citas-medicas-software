package ups.edu.ec.sistemacitasmedicas.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;
import ups.edu.ec.sistemacitasmedicas.repositorio.PersonaRepositorio;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonaRepositoryTest {

    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Test
    void testGuardarPersona(){

        Persona persona1 = new Persona("0100324534", "santiago", "cabrera", "Gualaceo", "0998087966", "ssc@gmail.com","activo",
                "17-02-2002", "masculino", "Empleado");

        Persona personaGuardado = personaRepositorio.save(persona1);

        Assertions.assertNotNull(personaGuardado);

    }


}
