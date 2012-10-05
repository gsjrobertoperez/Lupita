package beans;

public class ArticuloBean {

    private String id;
    private String descripcion;
    private Integer cantidad;
    private Double precioVenta;

    public ArticuloBean(String id, String descripcion, Integer cantidad, Double precioVenta) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    

}
