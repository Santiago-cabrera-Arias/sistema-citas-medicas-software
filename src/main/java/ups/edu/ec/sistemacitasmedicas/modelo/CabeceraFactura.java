package ups.edu.ec.sistemacitasmedicas.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "cabeceraFactura")
public class CabeceraFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cabeceraFactura_id;
//    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fecha;
    private double subtotal;
    private double totalIva;
    private double totalFactura;
    private boolean estado;
//
    @OneToMany(mappedBy = "cabeceraFactura")
    private Set<DetalleFactura> detallesFacturas = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public CabeceraFactura() {
    }

    public Integer getCabeceraFactura_id() {
        return cabeceraFactura_id;
    }

    public void setCabeceraFactura_id(Integer cabeceraFactura_id) {
        this.cabeceraFactura_id = cabeceraFactura_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
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
