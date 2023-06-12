package ups.edu.ec.sistemacitasmedicas.modelo;

import jakarta.persistence.*;


@Entity
@Table(name = "detalleFactura")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detalleFactura_id;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    private double valorIva;
    private double total;

    @ManyToOne
    @JoinColumn(name = "cabeceraFactura_id")
    private CabeceraFactura cabeceraFactura;

}
