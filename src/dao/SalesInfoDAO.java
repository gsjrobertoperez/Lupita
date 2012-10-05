/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import bussiness.Sale;
import common.Constants;
import common.SQLBuilder;
import java.sql.ResultSet;
import model.PaymentsModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RVAFOD
 */
public class SalesInfoDAO {


     public static void getSalesModel(PaymentsModel custModel, String idCustomer) throws SQLException {

        ArrayList sales = new ArrayList();

        DefaultTableModel tableModel = new DefaultTableModel();
        ResultSet rs = getSales(idCustomer);

        tableModel.addColumn("ID Venta");
        tableModel.addColumn("Fecha");
        tableModel.addColumn("Articulo");
        tableModel.addColumn("Cantidad");
        tableModel.addColumn("Total");

        while (rs.next()) {

            String idv = rs.getString(1);
            String date = new SimpleDateFormat("dd-MMM-yy").format(rs.getDate(2)) ;
            String article = rs.getString(3);
            int amount = rs.getInt(4);
            double total = rs.getDouble(5);
            double pendingPayment = rs.getDouble(6);
            String saleStatus = rs.getString(7);
            String idTabla = rs.getString(8);

            
          tableModel.addRow(new Object[]{idv, date, article, amount,total, saleStatus, pendingPayment });
          sales.add(new Sale(idv, date, article, amount, total, pendingPayment, saleStatus, idTabla));
        }
        rs.close();

        custModel.setSalesTableModel(tableModel);
        custModel.setSales(sales);

    }

    



    private static ResultSet getSales(String idCliente) throws SQLException {

        String query = "SELECT DISTINCT "
                + " v.ID_VENTA, v.FECHA, a.DESCRIPCION, v.CANTIDAD_ART, (v.TOTAL_VENTA - v.DESCUENTO), v.Saldo_Pendiente, v.Estado_Venta, v.ID_TABLA"
                + " FROM VENTA v, CATALOGO_ARTICULOS a"
                + " WHERE "
                + " v.ID_C = ?"
                + " AND v.ID_A = a.ID_ARTICULO AND v.Estado_Venta = 'A'";


        String[] data = {idCliente};
        ResultSet rs = (ResultSet) SQLBuilder.executeQuery(query, data);
        return rs;

    }

    public static int getSaleCount() throws SQLException {

        int count = 0;
        String query = "SELECT MAX(ID_VENTA) FROM VENTA";
        String data3[] = {};

        ResultSet sr = (ResultSet) SQLBuilder.executeQuery(query, data3);

        while (sr.next()) {
            count = sr.getInt(1);
        }

        return count + 1;

    }

    public static void insertSaleInfo(Sale info, boolean isCredit, String saleId) throws SQLException{
   
        String insert = "INSERT INTO VENTA (ID_VENTA, FECHA, ID_C , TOTAL_VENTA, CANTIDAD_ART, ID_A, ESTADO_VENTA, SALDO_PENDIENTE,DESCUENTO) VALUES (?,NOW(),?,?,?,?,?,?,?)";

        String status = "A";
        String pending = Double.toString(info.getTotalSale()-info.getDescuento());

        if(!isCredit){
            status = "C";
            pending = "0.0";
            PaymentsDAO.doPayment(info.getIdCustomer(), info.getTotalSale(), Constants.getCurrentDate(), saleId);
        }

        String[] data = {saleId,
                         //Constants.getCurrentDate(),
                         info.getIdCustomer(),
                         Double.toString(info.getTotalSale()),
                         Integer.toString(info.getAmount()),
                         info.getIdArticle(), status, pending, info.getDescuento().toString()};
        
        SQLBuilder.executeUpdate(insert, data);
    
    }

    public static double getTotalPendings(String idCustomer) throws SQLException{

        String query = "SELECT SUM(SALDO_PENDIENTE) FROM VENTA WHERE ID_C = ? AND ESTADO_VENTA = 'A'";
        String[] data = {idCustomer};

        ResultSet sr = SQLBuilder.executeQuery(query, data);
        sr.next();

        return sr.getDouble(1);

    }
    
   
}
