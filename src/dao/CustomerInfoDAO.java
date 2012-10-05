/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bussiness.Customer;
import bussiness.Sale;
import common.SQLBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author RVAFOD
 */
public class CustomerInfoDAO {

    private static ResultSet getCustomer(String id, String nombre) throws SQLException {

        String query = "SELECT DISTINCT c.ID_CLIENTE, c.NOMBRE, c.APELLIDOS, c.DIRECCION, c.TELEFONO, c.TIPO_CLIENTE, c.SALDO_INICIAL FROM "
                + "CATALOGO_CLIENTES c WHERE (c.ID_CLIENTE = ? ";


        ArrayList array = new ArrayList();
        array.add(id);

        if (!nombre.isEmpty()) {
            query += "OR concat(c.nombre,' ',c.apellidos) LIKE (?) ";
            array.add("%" + nombre + "%" );
        }

        query += ") AND c.ELIMINADO = 'N'";

        Object[] data = array.toArray();

        ResultSet rs = (ResultSet) SQLBuilder.executeQuery(query, data);

        return rs;
    }

    public static ArrayList getCustomerModel(String id, String nombre) throws SQLException {

        ArrayList customers = new ArrayList();

        ResultSet rs = getCustomer(id, nombre);

        while (rs.next()) {

            String idc = rs.getString(1);
            String name = rs.getString(2);
            String last = rs.getString(3);
            String address = rs.getString(4);
            String phone = rs.getString(5);
            String type = rs.getString(6);
            int lPayment = rs.getInt(7);

            customers.add(new Customer(idc, name, last, address, phone, type, lPayment));
        }
        rs.close();

        return customers;
    }

    public static void insertCustomerInfo(Customer info) throws SQLException {


        String insert = "INSERT INTO CATALOGO_CLIENTES (Nombre, Apellidos, Direccion, Telefono, Tipo_Cliente, SALDO_INICIAL) VALUES (?,?,?,?,?,?)";
        String[] data = {info.getName(), info.getl_Name(), info.getAddress(), info.getPhone(), info.getType(), info.getLastPayment().toString()};

        SQLBuilder.executeUpdate(insert, data);

        
        String ultimoID = "SELECT LAST_INSERT_ID()";
        String[] params = new String[0];
        
        ResultSet rs = SQLBuilder.executeQuery(ultimoID, params);       
        rs.next();
        String idCliente = rs.getString(1);       
        rs.close();
        
        
        Sale venta = new Sale();
        venta.setAmount(0);
        venta.setDescuento(0.0);
        venta.setPendingPayment(info.getLastPayment());
        venta.setTotalSale(info.getLastPayment());
        venta.setIdArticle("99999");
        venta.setIdCustomer(idCliente);
        String saleId = Integer.toString(SalesInfoDAO.getSaleCount());
        
        SalesInfoDAO.insertSaleInfo(venta, true, saleId);
    }//

    public static void updateCustomerInfo(Customer info) throws SQLException {

        String update = "UPDATE CATALOGO_CLIENTES SET NOMBRE = ?, APELLIDOS = ?, DIRECCION = ?, TELEFONO = ?, TIPO_CLIENTE = ?, SALDO_INICIAL = ?"
                + "WHERE ID_CLIENTE = ? ";
        String[] data = {info.getName(), info.getl_Name(), info.getAddress(), info.getPhone(), info.getType(), info.getLastPayment().toString(), info.getid_C()};

        SQLBuilder.executeUpdate(update, data);

    }

    public static void deleteCustomerInfo(Customer info) throws SQLException {

        String delete = "UPDATE CATALOGO_CLIENTES SET ELIMINADO = 'S' WHERE ID_CLIENTE = ? ";
        String[] data = {info.getid_C()};

        SQLBuilder.executeUpdate(delete, data);
    }
}//
