/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import beans.ArticuloBean;

/**
 *
 * @author Luc3
 */
public class ArticleInfoModel {

    String action;
    ArticuloBean selectedArticle;

    public String getAction() {
        return this.action;
    }

    public ArticuloBean getSelectedCustomer() {
        return this.selectedArticle;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setCustomer(ArticuloBean selectedCustomer) {
        this.selectedArticle = selectedCustomer;
    }
}
