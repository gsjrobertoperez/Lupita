/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainReportsPanel.java
 *
 * Created on 11/08/2010, 04:56:14 PM
 */
package gui.report;

import bussiness.Article;
import bussiness.Customer;
import common.InputValidator;
import common.MainPanelInterface;
import common.ValidationException;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Luc3
 */
public class MainReportsPanel extends javax.swing.JPanel implements MainPanelInterface {

    private static final String REPORT_PATH = "C:\\SistemaCobranza\\Reportes\\";
    private static final String DESIGN_PATH = "C:\\SistemaCobranza\\jrxml\\";
    private final String[] fillCustomer = {"Saldos Pendientes", "Ventas y abonos"};
    private String selectedReport = "";
    private JasperReporter reporter;
    private Customer selectedCustomer;

    public MainReportsPanel() {
        initComponents();
        fillItem(fillCustomer);
    }

    public final void fillItem(String[] info) {

        item.removeAllItems();
        for (int i = 0; i < info.length; i++) {
            item.addItem(info[i]);
        }
    }

    public void getSelectedReport() throws ValidationException{

        selectedReport = DESIGN_PATH;
        HashMap parameters = new HashMap();
        
        switch (item.getSelectedIndex()) {

            case 0:
                selectedReport += "reporteSaldosPendientes.jrxml";
                break;
            case 1:
                if(selectedCustomer == null){
                    throw new ValidationException("Este reporte requiere seleccionar un cliente");
                } else {
                    parameters.put("idCliente", selectedCustomer.getid_C());
                }
                selectedReport += "reporteDetalladoSaldoPendiente.jrxml";
                break;
            case 2:
                System.out.println("Seleccionó \"De Cliente\" " + fillCustomer[item.getSelectedIndex()]);
                break;
        }//switch

        reporter = new JasperReporter(selectedReport, parameters);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeReportLabel = new javax.swing.JLabel();
        item = new javax.swing.JComboBox();
        customerSearchPanel1 = new gui.customerinfo.CustomerSearchPanel();
        viewReportButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        reportNameText = new javax.swing.JTextField();
        saveReportButton = new javax.swing.JButton();
        openFolderButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        typeReportLabel.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        typeReportLabel.setText("Tipo de Reporte:");

        viewReportButton.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        viewReportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/pen_paper.gif"))); // NOI18N
        viewReportButton.setText("VISUALIZAR");
        viewReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewReportButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 1, 14)); // NOI18N
        jLabel2.setText("Nombre de Reporte:");

        reportNameText.setMaximumSize(new java.awt.Dimension(20, 20));

        saveReportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/save.gif"))); // NOI18N
        saveReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveReportButtonActionPerformed(evt);
            }
        });

        openFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/open_folder.png"))); // NOI18N
        openFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFolderButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(591, 591, 591)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reportNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveReportButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(openFolderButton))
                            .addComponent(customerSearchPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(typeReportLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(viewReportButton)))))
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeReportLabel)
                    .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewReportButton))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(customerSearchPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(reportNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saveReportButton)
                            .addComponent(openFolderButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReportButtonActionPerformed


        try {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            getSelectedReport();
            reporter.viewReport();
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }

    }//GEN-LAST:event_viewReportButtonActionPerformed

    private void saveReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveReportButtonActionPerformed
        
        try {

            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            getSelectedReport();
            boolean isInvalid = InputValidator.validateFileName(reportNameText);

            if(isInvalid){
                throw new ValidationException("El nombre de archivo es inválido.");
            }
            
            reporter.saveReport(REPORT_PATH + this.reportNameText.getText() + ".pdf");
            JOptionPane.showMessageDialog(this, "El reporte se guardó exitosamente");
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_saveReportButtonActionPerformed

    private void openFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFolderButtonActionPerformed


        Desktop desktop = Desktop.getDesktop();

        try {
            desktop.open(new File(REPORT_PATH));
        } catch (IOException ex) {
            Logger.getLogger(MainReportsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_openFolderButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.customerinfo.CustomerSearchPanel customerSearchPanel1;
    private javax.swing.JComboBox item;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton openFolderButton;
    private javax.swing.JTextField reportNameText;
    private javax.swing.JButton saveReportButton;
    private javax.swing.JLabel typeReportLabel;
    private javax.swing.JButton viewReportButton;
    // End of variables declaration//GEN-END:variables

    public void updateMainComponent(Customer c) {
        this.selectedCustomer = c;
    }

    public void updateMainComponent(Article c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateMainComponent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void reset() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
