package ups.edu.ec.sistemacitasmedicas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Factura {

    @Id
    private int id;
    private String f;
}
