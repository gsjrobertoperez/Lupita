/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import bussiness.Customer;
import bussiness.Sale;
import common.Constants;
import dao.PaymentsDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RVAFOD
 */
public class PaymentsModel {

    private ArrayList<Sale> sales;
    private DefaultTableModel salesTableModel;
    private double pendingPayments;
    private Customer selectedCustomer;
    private double currentPayment;

    public double getCurrentPayment() {
        return currentPayment;
    }

    public void setCurrentPayment(int currentPayment) {
        this.currentPayment = currentPayment;
    }

    public Customer getSelectedCustomer() {

        return this.selectedCustomer;
    }

    public void setSelectedCustomer(Customer c) {
        this.selectedCustomer = c;
    }

    public DefaultTableModel getSalesTableModel() {
        return salesTableModel;
    }

    public void setSalesTableModel(DefaultTableModel salesTableModel) {
        this.salesTableModel = salesTableModel;
    }

    public String getTotalPrice() {
        double total = 0;

        for (int i = 0; i < sales.size(); i++) {
            Sale sale = sales.get(i);
            total += sale.getTotalSale();
        }

        return Double.toString(total);
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Sale> sales) {
        this.sales = sales;
    }

    public void setPendingPayments(Double pending) {
        this.pendingPayments = pending;
    }

    public double getPendingPayments() {
        return this.pendingPayments;
    }

    public void updateSales() throws SQLException {
        int index = 0;
        String statusSale = "";

        while (currentPayment > 0) {
            Sale sale = (Sale) sales.get(index);

            if (currentPayment >= sale.getPendingPayment()) {
                statusSale = "C";
                currentPayment = currentPayment - sale.getPendingPayment();
                PaymentsDAO.doPayment(selectedCustomer.getid_C(), sale.getPendingPayment(), Constants.getCurrentDate(), sale.getIdSale());
                sale.setPendingPayment(0);

            } else {
                statusSale = "A";
                sale.setPendingPayment((sale.getPendingPayment() - currentPayment));
                PaymentsDAO.doPayment(selectedCustomer.getid_C(), currentPayment, Constants.getCurrentDate(), sale.getIdSale());
                currentPayment = 0;
            }

            PaymentsDAO.updateSaleStatus(statusSale, sale.getPendingPayment(), sale.getIdTabla());

            index++;
        }//while
    }
}
