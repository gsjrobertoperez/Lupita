/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bussiness.User;
import common.SQLBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.UsersModel;

/**
 *
 * @author Luc3
 */
public class UsersDAO {

    public static void getUsersModel(UsersModel model) throws SQLException {

        ArrayList users = new ArrayList();

        DefaultTableModel tableModel = new DefaultTableModel();
        ResultSet rs = getUsers();

        tableModel.addColumn("ID_Usuario");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Usuario");
        tableModel.addColumn("Tipo de Perfil");

        while (rs.next()) {

            String id_U = rs.getString(1);
            String nombre = rs.getString(2);
            String usuario = rs.getString(3);
            String pass = rs.getString(4);
            String tipo_P = rs.getString(5);

            tableModel.addRow(new Object[]{id_U, nombre, usuario, tipo_P});

            users.add(new User(id_U, usuario, pass, nombre, tipo_P));
        }
        rs.close();

        model.setUsersTableModel(tableModel);
        model.setUsers(users);

    }

    private static ResultSet getSpecificUser(String name, String user, String password) throws SQLException {

        String query = "SELECT (usuario, Password, Nombre) FROM USUARIOS WHERE User = ? , Password = ? ";


        String[] data = {user, password, name};
        ResultSet rs = (ResultSet) SQLBuilder.executeQuery(query, data);
        return rs;

    }

    public static ResultSet getUsers() throws SQLException {

        String query = "SELECT ID_Usuario, Nombre, usuario, SHA1(password), Tipo_Perfil FROM CATALOGO_USUARIOS";
        String[] data = new String[0];

        ResultSet rs = (ResultSet) SQLBuilder.executeQuery(query, data);

        return rs;
    }

    public static void insertUsersInfo(User info) throws SQLException {

        String query = "INSERT INTO CATALOGO_USUARIOS (USUARIO, PASSWORD, Nombre, Tipo_Perfil) VALUES (?,?,?,?)";
        String[] data = {info.getUser(), info.getpassword(), info.getName(), info.getProfileType()};

        SQLBuilder.executeUpdate(query, data);

    }

    public static void updateUsers(User info) throws SQLException {

        String edit = "UPDATE CATALOGO_USUARIOS SET USUARIO = ?, PASSWORD = ?, NOMBRE = ?, TIPO_PERFIL = ? WHERE ID_U = ?";
        String[] data = {info.getUser(), info.getpassword(), info.getName(), info.getProfileType(), info.getIdUser()};
        System.out.println(info.getIdUser());
        SQLBuilder.executeUpdate(edit, data);
    }

    public static void deleteUsers(User info) throws SQLException {

        String delete = "DELETE FROM CATALOGO_USUARIOS WHERE ID_USUARIO = ?";
        String[] data = {info.getIdUser()};

        SQLBuilder.executeUpdate(delete, data);

    }

    public static String isValidUser(String user, String password) throws SQLException{
        String query = "SELECT TIPO_PERFIL FROM CATALOGO_USUARIOS WHERE USUARIO = ? AND PASSWORD = ? ";
        String[] data = {user, password};

        ResultSet rs = SQLBuilder.executeQuery(query, data);

        String profile = "";

        while(rs.next()){
            profile = rs.getString(1);
        }

        return profile;

    }
}
