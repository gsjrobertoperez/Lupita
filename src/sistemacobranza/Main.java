/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacobranza;

import gui.users.UserValidationForm;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author RVAFOD
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        } 

        UserValidationForm form = new UserValidationForm();
        form.setVisible(true);
        //MainForm form = new MainForm(fo,"ADMIN");
        
    }
}
