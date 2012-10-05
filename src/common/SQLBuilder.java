/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luc3
 */
public class SQLBuilder {

    private static Connection conn;
    private static PreparedStatement statement;
    private static ResultSet result;
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB = "bd_lupita";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static void connect() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (conn == null) {
            conn = DriverManager.getConnection(URL + DB, "root", "");
        }
    }

    public static void disconnect() throws SQLException {

        if (result != null) {
            result.close();
        }

        if (statement != null) {
            statement.close();
        }

        if (conn != null) {
            conn.close();
        }


    }

    public static ResultSet executeQuery(String sql, Object[] parameters) throws SQLException {

        connect();

        statement = conn.prepareStatement(sql);

        for (int i = 0; i < parameters.length; i++) {
            statement.setString(i + 1, (String)parameters[i]);
        }
        result = statement.executeQuery();

        return result;
    }

    public static int executeUpdate(String sql, String[] parameters) throws SQLException {

        connect();

        statement = conn.prepareStatement(sql);

        for (int i = 0; i < parameters.length; i++) {
            statement.setString(i + 1, parameters[i]);
        }
        int val = statement.executeUpdate();

        //disconnect();

        return val;
    }

    public static Connection getConnection(){
        return conn;
    }
}
