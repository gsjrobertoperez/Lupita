/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import bussiness.User;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luc3
 */
public class UsersModel {

  private ArrayList<User> users;
    //Externos (Despliegue en la tabla)

  private DefaultTableModel usersTableModel;
  User selectedUser;
  String action;


  
    public DefaultTableModel getUsersTableModel() {
        return usersTableModel;
    }

    public void setUsersTableModel(DefaultTableModel salesTableModel) {
        this.usersTableModel = salesTableModel;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

  public String getAction(){
      return this.action;
  }

  public void setAction(String action){
    this.action = action;
  }

  public User getSelectedUser(){
      return this.selectedUser;
  }

  public void setSelectedUser(Integer selectedIndex){

      if(selectedIndex == null){
    selectedUser = null; 
}else{
      this.selectedUser = users.get(selectedIndex.intValue());
      }
  }









}
