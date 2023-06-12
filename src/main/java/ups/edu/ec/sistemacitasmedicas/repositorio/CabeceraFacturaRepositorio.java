package ups.edu.ec.sistemacitasmedicas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.edu.ec.sistemacitasmedicas.modelo.CabeceraFactura;
import ups.edu.ec.sistemacitasmedicas.modelo.Persona;

import java.util.List;

public interface CabeceraFacturaRepositorio extends JpaRepository<CabeceraFactura, Integer> {

    List<CabeceraFactura> findByPersona(Persona persona);


}
