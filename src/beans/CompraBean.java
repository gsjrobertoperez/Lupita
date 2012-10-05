package beans;

import java.util.Date;

public class CompraBean {

    private Date fecha;
    private Integer cantidadArticulos;
    private Double precioCompra;
    private String idArticulo;

    public CompraBean(Date fecha, Integer cantidadArticulos, Double precioCompra, String idArticulo) {
        this.fecha = fecha;
        this.cantidadArticulos = cantidadArticulos;
        this.precioCompra = precioCompra;
        this.idArticulo = idArticulo;
    }

    public Integer getCantidadArticulos() {
        return cantidadArticulos;
    }

    public void setCantidadArticulos(Integer cantidadArticulos) {
        this.cantidadArticulos = cantidadArticulos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }
}
