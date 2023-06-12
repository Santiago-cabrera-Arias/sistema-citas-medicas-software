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

    public Integer getCabeceraFactura_id() {
        return cabeceraFactura_id;
    }

    public void setCabeceraFactura_id(Integer cabeceraFactura_id) {
        this.cabeceraFactura_id = cabeceraFactura_id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(double totalIva) {
        this.totalIva = totalIva;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<DetalleFactura> getDetallesFacturas() {
        return detallesFacturas;
    }

    public void setDetallesFacturas(Set<DetalleFactura> detallesFacturas) {
        this.detallesFacturas = detallesFacturas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
