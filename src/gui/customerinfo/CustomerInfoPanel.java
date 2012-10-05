/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CustomerInfoPanel.java
 *
 * Created on 17/07/2010, 02:53:31 PM
 */
package gui.customerinfo;

import bussiness.Article;
import bussiness.Customer;
import common.Constants;
import common.InputValidator;
import common.MainPanelInterface;
import common.ValidationException;

import dao.CustomerInfoDAO;
import model.CustomerInfoModel;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Luc3
 */
public class CustomerInfoPanel extends javax.swing.JPanel implements MainPanelInterface {

    CustomerInfoModel model;
    String selectedId;
    private final String[] customerType = {"L", "F"};


    /** Creates new form CustomerInfoPanel */
    public CustomerInfoPanel() {
        initComponents();
       
    }

    public void setModel(CustomerInfoModel model) {

        this.model = model;
    }

    public void reset() {
        nameText.setText("");
        lNameText.setText("");
        addressText.setText("");
        phoneText.setText("");
        lPaymentText.setText("");
 
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        l_NameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        lNameText = new javax.swing.JTextField();
        addressText = new javax.swing.JTextField();
        phoneText = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        lPaymentLabel = new javax.swing.JLabel();
        customerTypeLabel = new javax.swing.JLabel();
        itemCustomerType = new javax.swing.JComboBox();
        lPaymentText = new javax.swing.JTextField();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        nameLabel.setText("Nombre:");

        l_NameLabel.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        l_NameLabel.setText("Apellidos:");

        addressLabel.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        addressLabel.setText("Dirección:");

        phoneLabel.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        phoneLabel.setText("Teléfono:");

        nameText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameTextMouseClicked(evt);
            }
        });
        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });
        nameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameTextFocusLost(evt);
            }
        });

        lNameText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lNameTextMouseClicked(evt);
            }
        });
        lNameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lNameTextFocusLost(evt);
            }
        });

        addressText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addressTextMouseClicked(evt);
            }
        });
        addressText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                addressTextFocusLost(evt);
            }
        });

        phoneText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phoneTextMouseClicked(evt);
            }
        });
        phoneText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                phoneTextFocusLost(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        saveButton.setText("GUARDAR");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        lPaymentLabel.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        lPaymentLabel.setText("Ultimo Saldo:");

        customerTypeLabel.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        customerTypeLabel.setText("Tipo de Cliente:");

        itemCustomerType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Local", "Foraneo" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addressLabel)
                            .addComponent(phoneLabel)
                            .addComponent(customerTypeLabel)
                            .addComponent(lPaymentLabel)
                            .addComponent(nameLabel)
                            .addComponent(l_NameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                    .addComponent(addressText)
                                    .addComponent(lNameText)
                                    .addComponent(lPaymentText, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                    .addComponent(itemCustomerType, 0, 207, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(saveButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_NameLabel))
                        .addGap(11, 11, 11)
                        .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(41, 41, 41)
                        .addComponent(addressLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel)
                            .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPaymentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPaymentText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerTypeLabel)
                    .addComponent(itemCustomerType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(saveButton)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    public Customer getCustomerInfo() {

        String name = nameText.getText();
        String l_name = lNameText.getText();
        String address = addressText.getText();
        String phone = phoneText.getText();
        String type = customerType[itemCustomerType.getSelectedIndex()];

        Integer lPayment = Integer.parseInt(lPaymentText.getText());
        
        return new Customer(selectedId, name, l_name, address, phone,type, lPayment);
    }

    public void setCustomerData(Customer selected, String selectedId) {

        this.selectedId = selectedId;
        nameText.setText(selected.getName());
        lNameText.setText(selected.getl_Name());
        addressText.setText(selected.getAddress());
        phoneText.setText(selected.getPhone());
        lPaymentText.setText(Integer.toString(selected.getLastPayment()));

        if(selected.getType().equals("F")){
             itemCustomerType.setSelectedItem("Foraneo");
        }else{
             itemCustomerType.setSelectedItem("Local");
        }

    }

    public void setTextField(boolean b) {

        nameText.setEnabled(b);
        lNameText.setEnabled(b);
        addressText.setEnabled(b);
        phoneText.setEnabled(b);
        lPaymentText.setEnabled(b);
        itemCustomerType.setEnabled(b);
    }

   

    public void successfulMessage(String message) {

        JOptionPane.showMessageDialog(this.getParent(), message);

    }

    public void validateInput() throws ValidationException {


        boolean isValidname = InputValidator.validateText2(nameText);
        boolean isValidlName = InputValidator.validateText2(lNameText);
        boolean isValidaddress = InputValidator.validateText2(addressText);
        boolean isValidphone = InputValidator.validateText2(phoneText);

        if (isValidname || isValidlName || isValidaddress || isValidphone) {

            throw new ValidationException(InputValidator.GENERAL_ERROR);
        }


    }

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        try {
            validateInput();
            Customer customInfo = getCustomerInfo();
            if (model.getAction().equals("AGREGAR")) {

                if (Constants.confirmDialog(this.getParent(), "¿Está seguro de que desea agregar a " + customInfo.getName() + " " + customInfo.getl_Name())) {
                    CustomerInfoDAO.insertCustomerInfo(customInfo);
                    String message = customInfo.getName() + " " + customInfo.getl_Name() + " ha sido agregado existosamente";
                    successfulMessage(message);
                }
        
            } else if (model.getAction().equals("EDITAR")) {

               
                if (Constants.confirmDialog(this.getParent(), "¿Está seguro de que desea editar a " + customInfo.getName() + " " + customInfo.getl_Name())) {
                    CustomerInfoDAO.updateCustomerInfo(customInfo);
                    String message = customInfo.getName() + " " + customInfo.getl_Name() + " ha sido editado existosamente";
                    successfulMessage(message);
                }


            } else if (model.getAction().equals("ELIMINAR")){

                if (Constants.confirmDialog(this.getParent(), "¿Estas seguro de que desea eliminar a " + customInfo.getName() + " " + customInfo.getl_Name())) {
                    CustomerInfoDAO.deleteCustomerInfo(customInfo);
                    String message = customInfo.getName() + " " + customInfo.getl_Name() + " ha sido eliminado existosamente";
                    successfulMessage(message);
                }


               setTextField(false);
               

                
            }
             reset();

        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this.getParent(), ex.getMessage());
        } 




    }//GEN-LAST:event_saveButtonActionPerformed

    private void nameTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameTextMouseClicked

        nameText.setForeground(Color.black);
    }//GEN-LAST:event_nameTextMouseClicked

    private void lNameTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lNameTextMouseClicked
        lNameText.setForeground(Color.black);
    }//GEN-LAST:event_lNameTextMouseClicked

    private void addressTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addressTextMouseClicked
        addressText.setForeground(Color.black);
    }//GEN-LAST:event_addressTextMouseClicked

    private void phoneTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phoneTextMouseClicked
        phoneText.setForeground(Color.black);
        int large = phoneText.getComponentCount();


    }//GEN-LAST:event_phoneTextMouseClicked

    private void nameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFocusLost

        String name = nameText.getText().toUpperCase();
        nameText.setText(name);
    }//GEN-LAST:event_nameTextFocusLost

    private void lNameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lNameTextFocusLost
        String l_name = lNameText.getText().toUpperCase();
        lNameText.setText(l_name);
    }//GEN-LAST:event_lNameTextFocusLost

    private void addressTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressTextFocusLost
        String address = addressText.getText().toUpperCase();
        addressText.setText(address);
    }//GEN-LAST:event_addressTextFocusLost

    private void phoneTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneTextFocusLost
    }//GEN-LAST:event_phoneTextFocusLost

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
       
        this.saveButton.setText(model.getAction());
        if(model.getAction().equals("ELIMINAR")){
            
            setTextField(false);
        }else if(model.getAction().equals("AGREGAR")){
            reset();
            
            setTextField(true);
           
        }else{
           
            setTextField(true);
        }
   
    }//GEN-LAST:event_formComponentShown

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressText;
    private javax.swing.JLabel customerTypeLabel;
    private javax.swing.JComboBox itemCustomerType;
    private javax.swing.JTextField lNameText;
    private javax.swing.JLabel lPaymentLabel;
    private javax.swing.JTextField lPaymentText;
    private javax.swing.JLabel l_NameLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneText;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables

    public void updateMainComponent(Customer c) {

         setTextField(false);
         reset();
         
    }

    public void updateMainComponent(Article c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateMainComponent() {
      
    }
}