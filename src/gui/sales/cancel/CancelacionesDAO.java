/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.sales.cancel;

import common.SQLBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RVAFOD
 */
public class CancelacionesDAO {

    public static DefaultTableModel obtenProductosVendidos(String idVenta) throws SQLException {

        String select = "SELECT v.cantidad_art,c.descripcion, v.total_venta FROM venta v, catalogo_articulos c "
                + " where c.id_articulo = v.id_a "
                + " and v.id_venta = ? and v.estado_venta NOT LIKE ('%X%')";

        String[] params = {idVenta};
        
        ResultSet rs = SQLBuilder.executeQuery(select, params);
        
        DefaultTableModel tableModel = new DefaultTableModel();
        
        tableModel.addColumn("Cantidad");
        tableModel.addColumn("Concepto");
        tableModel.addColumn("Precio");
        
                while (rs.next()) {

            String cantidad = rs.getString(1);
            String concepto = rs.getString(2);
            String precio = rs.getString(3);

            tableModel.addRow(new Object[]{cantidad, concepto, precio});

            
        }
        rs.close();
        
        return tableModel;
    }
    
    public static void cancelarVenta(String idVenta) throws SQLException{
        
        String update = "UPDATE VENTA SET ESTADO_VENTA = 'X' where id_venta = ?";
        String[] params = {idVenta};
        
        SQLBuilder.executeUpdate(update, params);
    }
}
