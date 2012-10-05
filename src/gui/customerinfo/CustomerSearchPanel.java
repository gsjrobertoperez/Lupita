/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CustomerSearchPanel.java
 *
 * Created on 17/07/2010, 02:23:11 PM
 */
package gui.customerinfo;


import bussiness.Customer;
import common.MainPanelInterface;
import dao.CustomerInfoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luce
 */
public class CustomerSearchPanel extends javax.swing.JPanel {

    ArrayList<Customer> customers;
    Customer selectedCustomer;

    /** Creates new form CustomerSearchPanel */
    public CustomerSearchPanel() {
        initComponents();
        customers = new ArrayList<Customer>();
        setVisibility(false);
        setTableModel();

    }

   public void enabledButtons(boolean b){
     idTextField.setEnabled(b);
     nameTextField.setEnabled(b);
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        notFoundLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customersTable = new common.CustomTable();

        idLabel.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        idLabel.setText("ID:");

        nameLabel.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        nameLabel.setText("Nombre:");

        searchButton.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/search.png"))); // NOI18N
        searchButton.setText("Buscar");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        notFoundLabel.setForeground(new java.awt.Color(255, 0, 0));
        notFoundLabel.setText("No se encontraron resultados para esta búsqueda");

        customersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        customersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customersTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(searchButton))
                            .addComponent(notFoundLabel)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notFoundLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );
    }// </editor-fold>//GEN-END:initComponents



    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        updateCustomerTable();
    }//GEN-LAST:event_searchButtonActionPerformed

    public void updateCustomerTable() {
        try {
            // TODO add your handling code here:
            String id = idTextField.getText();
            String name = nameTextField.getText();
            customers = CustomerInfoDAO.getCustomerModel(id, name);

            if (customers.size() > 0) {
                setVisibility(false);
            } else {
                setVisibility(true);
            }
            setTableModel();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void setVisibility(boolean notFound) {
        this.notFoundLabel.setVisible(notFound);
    }

    public void reset() {
        idTextField.setText("");
        nameTextField.setText("");
    }

    public final void setTableModel() {

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre / Apellido");

        for (int i = 0; i < customers.size(); i++) {
            Customer tmp = customers.get(i);
            tableModel.addRow(new Object[]{tmp.getid_C(), tmp.getName() + " " + tmp.getl_Name()});
        }

        this.customersTable.setModel(tableModel);
    }
    private void customersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customersTableMouseClicked

        Integer index = customersTable.getSelectedIndex();

        if (index != null) {
            selectedCustomer = customers.get(index);
            ((MainPanelInterface) this.getParent()).updateMainComponent(selectedCustomer);
        }
    }//GEN-LAST:event_customersTableMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private common.CustomTable customersTable;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel notFoundLabel;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
