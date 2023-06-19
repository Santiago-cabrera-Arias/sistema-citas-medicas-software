package ups.edu.ec.sistemacitasmedicas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import ups.edu.ec.sistemacitasmedicas.modelo.Cita;
<<<<<<< HEAD


public interface CitaRepositorio extends JpaRepository<Cita,Long> {
=======
import ups.edu.ec.sistemacitasmedicas.modelo.DetalleFactura;

import java.util.Optional;

public interface CitaRepositorio extends JpaRepository<Cita, Integer> {

    Optional<Cita> findById(Integer cita_id);

>>>>>>> main

}
