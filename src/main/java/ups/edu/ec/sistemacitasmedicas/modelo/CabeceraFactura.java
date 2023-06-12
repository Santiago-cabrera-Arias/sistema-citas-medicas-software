package ups.edu.ec.sistemacitasmedicas.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "cabeceraFactura")
public class CabeceraFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cabeceraFactura_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String fecha;
    private double subtotal;
    private double totalIva;
    private double totalFactura;
    private String estado;
//
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabeceraFactura")
    private Set<DetalleFactura> detallesFacturas = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona persona;

}
