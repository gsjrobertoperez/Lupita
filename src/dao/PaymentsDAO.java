/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import common.Constants;
import common.SQLBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Luc3
 */
public class PaymentsDAO {


    public static double getTotalPayments(String idCustomer) throws SQLException {

        String query = "SELECT SUM(a.ABONO) FROM ABONOS a, VENTA v WHERE a.ID_C = ? AND v.ID_C = a.ID_C AND v.ESTADO_VENTA = 'A' AND v.ID_VENTA = a.ID_VENTA";

        String[] data = {idCustomer};
        ResultSet rs = (ResultSet) SQLBuilder.executeQuery(query, data);

        rs.next();

        return rs.getDouble(1);
    }

    public static void doPayment(String idCustomer, double qty, String fecha, String idV) throws SQLException{

        String insert = "INSERT INTO ABONOS (ID_C, ABONO, FECHA, ID_VENTA) VALUES (?,?,NOW(),?)";

        String[] parameters = {idCustomer, Double.toString(qty), idV};

        SQLBuilder.executeUpdate(insert, parameters);

    }

      public static boolean hasSales(String idCliente) throws SQLException{

        boolean customerHasPayments = false;


         String  query = "SELECT COUNT(*) FROM VENTA WHERE ID_C = ?";
           String data3[] = {idCliente};


       ResultSet sr = (ResultSet) SQLBuilder.executeQuery(query, data3);

        while (sr.next()) {

            if (sr.getInt(1) > 0) {
                customerHasPayments = true;
            }
        }

       return customerHasPayments;

    }



    public static boolean hasPayments(String idCliente) throws SQLException{

        boolean customerHasPayments = false;


         String  query = "SELECT COUNT(*) FROM ABONOS WHERE ID_C = ?";
           String data3[] = {idCliente};


       ResultSet sr = (ResultSet) SQLBuilder.executeQuery(query, data3);

        while (sr.next()) {

            if (sr.getInt(1) > 0) {
                customerHasPayments = true;
            }
        }

       return customerHasPayments;

    }

    public static boolean getPaymentsDate(String idCliente) throws SQLException {


        boolean customerPaid = false;
        

        String query = "SELECT FECHA FROM ABONOS WHERE ID_C = ? AND FECHA BETWEEN ? AND ?";
        String data[] = {idCliente, Constants.getpreviousDate(), Constants.getCurrentDate()};


         ResultSet sr = (ResultSet) SQLBuilder.executeQuery(query, data);

        while (sr.next()) {

            if (sr.getInt(1) > 0) {
                customerPaid = true;
            }
        }

        return customerPaid;

    }


    public static void updateSaleStatus(String statusSale, double pendingPayment, String idSale) throws SQLException{

     String update = "UPDATE VENTA SET ESTADO_VENTA = ?, SALDO_PENDIENTE = ? WHERE ID_TABLA = ?";
     String data[] = {statusSale, Double.toString(pendingPayment), idSale};
     SQLBuilder.executeUpdate(update, data);

    }

}
