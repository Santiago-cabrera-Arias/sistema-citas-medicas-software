package ups.edu.ec.sistemacitasmedicas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.edu.ec.sistemacitasmedicas.modelo.DetalleFactura;

public interface DetalleFacturaRepositorio extends JpaRepository<DetalleFactura, Integer> {
}
