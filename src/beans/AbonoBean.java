package beans;

import java.util.Date;

public class AbonoBean {

    private String idCliente;
    private String idVenta;
    private Double abono;
    private Date fecha;

    public AbonoBean(String idCliente, String idVenta, Double abono, Date fecha) {
        this.idCliente = idCliente;
        this.idVenta = idVenta;
        this.abono = abono;
        this.fecha = fecha;
    }

    
    public Double getAbono() {
        return abono;
    }

    public void setAbono(Double abono) {
        this.abono = abono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }


}//fn

