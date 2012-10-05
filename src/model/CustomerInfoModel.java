/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import beans.ClienteBean;


public class CustomerInfoModel {

  String action;
  ClienteBean selectedCustomer;


  public String getAction(){
      return this.action;
  }

  public ClienteBean getSelectedCustomer(){
      return this.selectedCustomer;
  }

  public void setAction(String action){
    this.action = action;
  }

  public void setCustomer(ClienteBean selectedCustomer){
      this.selectedCustomer = selectedCustomer;
  }






}
