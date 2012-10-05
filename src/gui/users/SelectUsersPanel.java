/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SelectUsersPanel.java
 *
 * Created on 13/08/2010, 01:46:02 PM
 */

package gui.users;

import bussiness.User;
import common.MainPanelInterface;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.UsersModel;

/**
 *
 * @author Luc3
 */
public class SelectUsersPanel extends javax.swing.JPanel {

    /** Creates new form SelectUsersPanel */
    UsersModel model;
    ArrayList<User> users;
    User us;

    public void setUsersModel(UsersModel model){
        this.model = model;
    }
    
    public SelectUsersPanel() {
        initComponents();

    }

    public void setModel(DefaultTableModel mod){
        customTable1.setModel(mod);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        customTable1 = new common.CustomTable();

        customTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        customTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void customTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customTable1MouseClicked


        Integer index = customTable1.getSelectedIndex();
        model.setSelectedUser(index);
        ((MainPanelInterface)this.getParent()).updateMainComponent();

    }//GEN-LAST:event_customTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.CustomTable customTable1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
