package bussiness;

public class Article {

    String id_A;
    String descripcion;
    int cantidad;
    double pr_Venta;

    public Article(String descripcion, int cantidad, double pr_Venta){

        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.pr_Venta = pr_Venta;
    }

    public Article(String id_A, String descripcion, int cantidad, double pr_Venta) {

        this.id_A = id_A;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.pr_Venta = pr_Venta;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public int getCantidad() {

        return cantidad;
    }

    public double getpr_Venta() {

        return pr_Venta;
    }

    public String getid_A() {

        return id_A;
    }
}
