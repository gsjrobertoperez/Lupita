package bussiness;



public class Sale {

    String idSale;
    String date;
    String description;
    int amount;
    double totalSale;
    String idCustomer;
    String idArticle;
    double pendingPayment;
    String saleStatus;
    Double descuento;
    String idTabla;

    public Sale(){}
    
    public Sale(String date, String description, int amount, double totalSale, String idCustomer, String idArticle) {

        this.date = date;
        this.description = description;
        this.amount = amount;
        this.totalSale = totalSale;
        this.idCustomer = idCustomer;
        this.idArticle = idArticle;
        this.descuento = new Double(0);
    }

   public Sale(String idSale, String date, String description, int amount, double totalSale, double pendingPayment, String saleStatus, String idTabla) {

       this.idSale = idSale;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.totalSale = totalSale;
        this.pendingPayment = pendingPayment;
        this.saleStatus = saleStatus;
        this.idTabla = idTabla;

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdSale() {
        return idSale;
    }

    public void setIdSale(String idSale) {
        this.idSale = idSale;
    }

    public String getIdTabla() {
        return idTabla;
    }

    public void setIdTabla(String idTabla) {
        this.idTabla = idTabla;
    }

    public double getPendingPayment() {
        return pendingPayment;
    }

    public void setPendingPayment(double pendingPayment) {
        this.pendingPayment = pendingPayment;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }




    
}
