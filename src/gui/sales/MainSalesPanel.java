/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainSalesPanel.java
 *
 * Created on 17/07/2010, 04:35:03 PM
 */
package gui.sales;

import bussiness.Article;
import bussiness.Customer;
import bussiness.Sale;
import common.Constants;
import common.ImpresoraTicket;
import common.InputValidator;
import common.MainPanelInterface;
import common.Ticket;
import common.ValidationException;
import common.LeerDatos;
import dao.PaymentsDAO;
import dao.SalesInfoDAO;
import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.SalesModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luc3
 */
public class MainSalesPanel extends javax.swing.JPanel implements MainPanelInterface {

    SalesModel model = new SalesModel();

    /** Creates new form MainSalesPanel */
    public MainSalesPanel() {
        initComponents();
        this.deleteButton.setEnabled(false);
        //this.ajustarBoton.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    public void setButtons(boolean b) {

        addButton.setEnabled(b);
        registerButton.setEnabled(b);
        deleteButton.setEnabled(b);
        //ajustarBoton.setEnabled(!model.getSales().isEmpty());
    }

    public void validateQty() throws ValidationException {


        boolean isValidname = InputValidator.validateIntNumber(qtyText);


        if (isValidname) {

            throw new ValidationException(InputValidator.GENERAL_ERROR);
        }

    }

    public void infoLabel() {
        model.setSelectedCustomer(model.getSelectedCustomer());

        infoLabel.setText("Las siguientes ventas serán registradas a " + model.getSelectedCustomer().getName()
                + " " + model.getSelectedCustomer().getl_Name());
    }

    public void validateCustomer() {


        try {

            String message = "";
            String id = model.getSelectedCustomer().getid_C();


            if ((PaymentsDAO.hasPayments(id))) {
                if (!PaymentsDAO.getPaymentsDate(id)) {
                    message = "El cliente no ha abonado en los últimos 45 días, ¿desea registrar la venta?";
                }
            } else if (PaymentsDAO.hasSales(id)) {
                message = "El cliente no ha abonado nada a su saldo pendiente, ¿desea registrar la venta?";
            }

            if (!message.equals("")) {
                if (Constants.confirmDialog(this, message)) {
                    setButtons(true);
                } else {
                    setButtons(false);
                }
            } else {
                setButtons(true);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customerSearchPanel1 = new gui.customerinfo.CustomerSearchPanel();
        articleSearchPanel1 = new gui.article.ArticleSearchPanel();
        qtyText = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesTable = new common.CustomTable();
        registerButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        credit = new javax.swing.JCheckBox();
        ajustarBoton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        imprTicket = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(663, 452));

        customerSearchPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerSearchPanel1MouseClicked(evt);
            }
        });

        articleSearchPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                articleSearchPanel1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                articleSearchPanel1KeyReleased(evt);
            }
        });

        qtyText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qtyTextMouseClicked(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        addButton.setText("AGREGAR");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        salesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Descripción", "Total", "Descuento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        salesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(salesTable);

        registerButton.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        registerButton.setText("REGISTRAR");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        deleteButton.setText("ELIMINAR");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 1, 10));
        jLabel1.setText("Introduzca cantidad:");

        infoLabel.setFont(new java.awt.Font("Arial Unicode MS", 1, 10));

        credit.setFont(new java.awt.Font("Tahoma", 1, 12));
        credit.setText("Otorgar crédito para esta venta");

        ajustarBoton.setFont(new java.awt.Font("Arial Unicode MS", 1, 14));
        ajustarBoton.setText("DESCUENTO");
        ajustarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajustarBotonActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial Unicode MS", 1, 10));
        jButton1.setText("CANCELAR VENTAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        imprTicket.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        imprTicket.setSelected(true);
        imprTicket.setText("Imprimir Ticket");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(customerSearchPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(articleSearchPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addButton)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                            .addComponent(qtyText, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(credit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ajustarBoton))
                            .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(imprTicket)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(registerButton)
                                .addGap(34, 34, 34)
                                .addComponent(jButton1)))
                        .addGap(595, 595, 595)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerSearchPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton))
                    .addComponent(articleSearchPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(credit)
                            .addComponent(deleteButton))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(registerButton)
                                    .addComponent(jButton1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(imprTicket))))
                    .addComponent(ajustarBoton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        if (model.getSelectedCustomer() != null) {
            try {

                validateQty();
                int quantity = Integer.parseInt(qtyText.getText());

                Sale sale = new Sale(Constants.getCurrentDate(), model.getSelectedArticle().getDescripcion(),
                        quantity, (model.getSelectedArticle().getpr_Venta() * quantity), model.getSelectedCustomer().getid_C(), model.getSelectedArticle().getid_A());


                model.addSale(sale);

                updateTableModel();
            } catch (ValidationException ex) {

                JOptionPane.showMessageDialog(this.getParent(), ex.getMessage());

            }
        } else {
            JOptionPane.showMessageDialog(this.getParent(), "No se ha seleccionado ningún cliente");
        }

    }//GEN-LAST:event_addButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed

        try {

            boolean isCredit = this.credit.isSelected();

            String message = "";

            if (isCredit) {
                message = "Estas ventas son a crédito, ¿Desea continuar?";
            } else {
                message = "¿Está seguro de que desea registrar estas ventas?";
            }

            if (Constants.confirmDialog(this, message)) {
                String saleId = Integer.toString(SalesInfoDAO.getSaleCount());
                model.insertSales(saleId, isCredit);
                JOptionPane.showMessageDialog(this, "Las ventas fueron insertadas exitosamente");
                qtyText.setText("");

                Ticket ticket = new Ticket();
                LeerDatos leer = new LeerDatos();
                leer.leeDatos();


                for (int i = 0; i < leer.getHeader().size(); i++) {
                    ticket.agregaLinea((String) leer.getHeader().get(i));
                }

                String[] datos = new String[3];
                datos[0] = "Cant";
                datos[1] = "Descripcion";
                datos[2] = "Precio";

                Customer c = model.getSelectedCustomer();
                ticket.agregaLinea("# Venta: " + saleId);
                ticket.agregaLineaGeneral("Cliente: " + c.getName() + " " + c.getl_Name());
                ticket.agregaLineaGeneral("Fecha: " + new SimpleDateFormat("dd-MMMM-yy").format(Calendar.getInstance().getTime()));
                ticket.agregaLinea("");
                ticket.agregaVenta(datos);

                Double subtotal = new Double(0);
                Double descuento = new Double(0);

                for (int i = 0; i < model.getSales().size(); i++) {
                    Sale temp = model.getSales().get(i);

                    datos[0] = Integer.toString(temp.getAmount());
                    datos[1] = temp.getDescription();
                    datos[2] = Double.toString(temp.getTotalSale());

                    ticket.agregaVenta(datos);

                    subtotal += temp.getTotalSale();
                    descuento += temp.getDescuento();
                }

                ticket.agregaLinea("");

                datos[0] = " ";
                datos[1] = "Subtotal:";
                datos[2] = subtotal.toString();
                ticket.agregaDinero(datos);
                datos[1] = "Descuento:";
                datos[2] = descuento.toString();
                ticket.agregaDinero(datos);
                datos[1] = "Total:";
                datos[2] = Double.toString(subtotal - descuento);
                ticket.agregaDinero(datos);

                for (int i = 0; i < leer.getFooter().size(); i++) {
                    ticket.agregaLinea((String) leer.getFooter().get(i));
                }

                if (imprTicket.isSelected()) {
                ImpresoraTicket impresora = new ImpresoraTicket(ticket);

                
                    impresora.imprimir();
                }

                model.getSales().clear();
                updateTableModel();

            }
        } catch (IOException ex) {
            Logger.getLogger(MainSalesPanel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "No se pudo establecer comunicación con la impresora");
        } catch (Exception ex) {
            Logger.getLogger(MainSalesPanel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Las ventas no fueron insertadas exitosamente");
        }

    }//GEN-LAST:event_registerButtonActionPerformed

    private void salesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesTableMouseClicked

        model.setSelectedIndex(new Integer(salesTable.getSelectedIndex()));

        this.deleteButton.setEnabled(!model.getSales().isEmpty());
        //this.ajustarBoton.setEnabled(!model.getSales().isEmpty());

    }//GEN-LAST:event_salesTableMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed



        if (model.getSelectedIndex() == null) {
            JOptionPane.showMessageDialog(this, "No hay ninguna venta seleccionada");
        } else {
            if (Constants.confirmDialog(this, "¿Esta seguro que desea remover la venta " + model.getSelectedSale().getDescription() + "?")) {
                model.removeSale();


                this.deleteButton.setEnabled(!model.getSales().isEmpty());
                //this.ajustarBoton.setEnabled(!model.getSales().isEmpty());

                updateTableModel();

                model.setSelectedIndex(null);

            }
        }

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void articleSearchPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_articleSearchPanel1KeyPressed
    }//GEN-LAST:event_articleSearchPanel1KeyPressed

    private void qtyTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qtyTextMouseClicked
        qtyText.setForeground(Color.BLACK);
    }//GEN-LAST:event_qtyTextMouseClicked

    private void customerSearchPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerSearchPanel1MouseClicked
    }//GEN-LAST:event_customerSearchPanel1MouseClicked

    private void articleSearchPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_articleSearchPanel1KeyReleased
    }//GEN-LAST:event_articleSearchPanel1KeyReleased

    private void ajustarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajustarBotonActionPerformed

        if (model.getSelectedIndex() == null) {
            JOptionPane.showMessageDialog(this, "No hay ninguna venta seleccionada");
        } else {
            if (Constants.confirmDialog(this, "¿Esta seguro que desea aplicar descuento a la venta " + model.getSelectedSale().getDescription() + "?")) {

                String desc = JOptionPane.showInputDialog(this, "Aplica un descuento para " + model.getSelectedSale().getDescription(), "Descuento", 1);


                if (!desc.isEmpty()) {
                    model.adjustSale(Double.parseDouble(desc));

                    //this.deleteButton.setEnabled(!model.getSales().isEmpty());
                    //this.ajustarBoton.setEnabled(!model.getSales().isEmpty());

                    updateTableModel();

                    model.setSelectedIndex(null);
                } else {
                    JOptionPane.showMessageDialog(this, "No se aplicó el descuento");
                }
            }
        }

    }//GEN-LAST:event_ajustarBotonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        CancelarForm cancelar = new CancelarForm();
        cancelar.setLocationRelativeTo(this);
        cancelar.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void updateTableModel() {


        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Cantidad");
        tableModel.addColumn("Descripción");
        tableModel.addColumn("Total");
        tableModel.addColumn("Descuento");

        for (int i = 0; i < model.getSales().size(); i++) {
            Sale tmp = model.getSales().get(i);
            tableModel.addRow(new String[]{Integer.toString(tmp.getAmount()),
                        tmp.getDescription(),
                        Double.toString(tmp.getTotalSale()),
                        tmp.getDescuento().toString()});
        }


        this.salesTable.setModel(tableModel);


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton ajustarBoton;
    private gui.article.ArticleSearchPanel articleSearchPanel1;
    private javax.swing.JCheckBox credit;
    private gui.customerinfo.CustomerSearchPanel customerSearchPanel1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JCheckBox imprTicket;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField qtyText;
    private javax.swing.JButton registerButton;
    private common.CustomTable salesTable;
    // End of variables declaration//GEN-END:variables

    public void updateMainComponent(Customer c) {


        model.setSelectedCustomer(c);
        infoLabel();
        validateCustomer();



    }

    public void updateMainComponent(Article c) {
        model.setSelectedArticle(c);




    }

    public void updateMainComponent() {
    }

    public void reset() {
    }
}