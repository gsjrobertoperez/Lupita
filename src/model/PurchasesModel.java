/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import bussiness.Article;
import bussiness.Purchase;
import common.CustomTable;
import dao.PurchasesDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luc3
 */
public class PurchasesModel {

    private ArrayList<Purchase> purchases = new ArrayList();
    private Article selectedArticle;
    private Integer selectedIndex;

   

  public void removePurchase(){
      this.purchases.remove(selectedIndex.intValue());
  }

     public Integer getSelectedIndex(){
     return selectedIndex;
    }
     
     public void setSelectedIndex(Integer selectedIndex){
         this.selectedIndex = selectedIndex;
     }
    
    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void addPurchase(Purchase s) {
        this.purchases.add(s);
    }

    public Article getSelectedArticle() {
        return selectedArticle;
    }

      public int getPurchasesSize(){
          return purchases.size(); 
        }

    public void setSelectedArticle(Article selectedArticle) {
        this.selectedArticle = selectedArticle;
    }

    public void insertPuchases() throws SQLException {

        for (int i = 0; i < purchases.size(); i++) {
            PurchasesDAO.insertPurchasesInfo(purchases.get(i));

        }




    }


}
