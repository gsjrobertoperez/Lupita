package model;

import bussiness.Article;
import bussiness.Customer;
import bussiness.Sale;
import dao.SalesInfoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RVAFOD
 */
public class SalesModel {

    private ArrayList<Sale> sales = new ArrayList();
    private Customer selectedCustomer;
    private Article selectedArticle;
    private Integer selectedIndex;
    private static int saleCount;

    public SalesModel(){
        
    }
    public void removeSale(){
        this.sales.remove(selectedIndex.intValue());
    }

    public void adjustSale(Double adjustedQty){
        Sale tmp = sales.get(selectedIndex.intValue());
        tmp.setDescuento(adjustedQty);
    }

    public Integer getSelectedIndex() {
        return selectedIndex;
    }

    public Sale getSelectedSale(){
        return sales.get(selectedIndex);
    }

    public void setSelectedIndex(Integer selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Sale> sales) {
        this.sales = sales;
    }

    public void addSale(Sale s) {
        this.sales.add(s);
    }

    public Article getSelectedArticle() {
        return selectedArticle;
    }

    public void setSelectedArticle(Article selectedArticle) {
        this.selectedArticle = selectedArticle;
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public void insertSales(String saleId,boolean credit) throws SQLException {

        for (int i = 0; i < sales.size(); i++) {
            SalesInfoDAO.insertSaleInfo(sales.get(i), credit, saleId);
 
        }
    }
    


}
