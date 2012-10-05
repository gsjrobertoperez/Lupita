/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import bussiness.Purchase;
import common.SQLBuilder;
import java.sql.SQLException;

/**
 *
 * @author RVAFOD
 */
public class PurchasesDAO {


  public static void insertPurchasesInfo( Purchase info) throws SQLException{

  String insert = "INSERT INTO COMPRA (FECHA, CANTIDAD_ARTICULO, PRECIO_COMPRA, ID_A) VALUES(NOW(), ?, ?, ?) ";
  String[] data = {
                  Integer.toString(info.getcantidad_Art()),
                  Double.toString(info.getprecio_C()), 
                  info.getid_A()};

     SQLBuilder.executeUpdate(insert, data);
  }
  
  public static void searchPurchasesInfo(String id_articulo) throws SQLException{
      
      String search = "SELECT FECHA, CANTIDAD_ART, PRECIO_C, ID_A FROM COMPRA WHERE ID_A = ? "; 
      String[] data = {id_articulo}; 
      
     SQLBuilder.executeQuery(search, data); 
  }

}
