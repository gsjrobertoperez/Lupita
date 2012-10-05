/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bussiness.Article;
import common.SQLBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author RVAFOD
 */
public class ArticleDAO {


    public static void insertArticleInfo(Article info) throws SQLException {

        String insert = "INSERT INTO CATALOGO_ARTICULOS (Descripcion, Cantidad, Precio_Venta) VALUES (?,?,?)";
        String[] data = {info.getDescripcion(), Integer.toString(info.getCantidad()), Double.toString(info.getpr_Venta())};

        SQLBuilder.executeUpdate(insert, data);
    }//

    public static void deleteArticleInfo(Article info) throws SQLException {

        String insert = "DELETE FROM CATALOGO_ARTICULOS WHERE ID_ARTICULO = ?";
        String[] data = {info.getid_A()};
        SQLBuilder.executeUpdate(insert, data);
    }//

    public static void updateArticleInfo(Article info) throws SQLException {

        String insert = "UPDATE CATALOGO_ARTICULOS SET DESCRIPCION = ?, CANTIDAD = ?, PRECIO_VENTA = ? WHERE ID_ARTICULO = ?";
        String[] data = {info.getDescripcion(), Integer.toString(info.getCantidad()), Double.toString(info.getpr_Venta()), info.getid_A()};
        SQLBuilder.executeUpdate(insert, data);
    }//

   public static void modifyInventory(Article info, int cant) throws SQLException{

       String update = "UPDATE CATALOGO_ARTICULOS SET CANTIDAD = ? WHERE ID_ARTICULO = ? ";
       String[] data = {Integer.toString(cant), info.getid_A()} ;

    SQLBuilder.executeUpdate(update, data);

   }

    public static HashMap getArticleInfo() throws SQLException {

        String query = "SELECT DISTINCT ID_ARTICULO, Descripcion, Cantidad, Precio_Venta FROM CATALOGO_ARTICULOS";
        String[] parameters = new String[0];
        HashMap art = new HashMap();

        ResultSet rs = SQLBuilder.executeQuery(query, parameters);

        while (rs.next()) {
            String id = rs.getString(1);
            String desc = rs.getString(2);
            int cant = rs.getInt(3);
            double precio = rs.getDouble(4);

            art.put(id, new Article(id, desc, cant, precio));
        }

        return art;
    }
}
