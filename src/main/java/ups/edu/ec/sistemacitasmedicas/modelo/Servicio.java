package ups.edu.ec.sistemacitasmedicas.modelo;

import jakarta.persistence.*;



@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer servicio_id;
    private String nombreServicio;
    private double precio;
    private double iva;
    private String estado;


    public Servicio() {
    }

    public Integer getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(Integer servicio_id) {
        this.servicio_id = servicio_id;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
