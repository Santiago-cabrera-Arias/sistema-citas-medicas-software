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

    public Integer getDetalleFactura_id() {
        return detalleFactura_id;
    }

    public void setDetalleFactura_id(Integer detalleFactura_id) {
        this.detalleFactura_id = detalleFactura_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getValorIva() {
        return valorIva;
    }

    public void setValorIva(double valorIva) {
        this.valorIva = valorIva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public CabeceraFactura getCabeceraFactura() {
        return cabeceraFactura;
    }

    public void setCabeceraFactura(CabeceraFactura cabeceraFactura) {
        this.cabeceraFactura = cabeceraFactura;
    }
}
