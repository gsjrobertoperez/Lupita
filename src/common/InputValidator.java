/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author RVAFOD
 */
public class InputValidator {

    private static final Color RED_COLOR = new java.awt.Color(255, 0, 0);
    private static final String NUMBER_FORMAT_ERROR = "Formato de número incorrecto";
    private static final String EMPTY_FIELD_ERROR = "Todos los campos de entrada son obligatorios";
    private static final String TEXT_FORMAT_ERROR = "Los campos de entrada solo deben contener letras o números";
    public static final String GENERAL_ERROR = "Los campos de entrada marcados con rojo son incorrectos";
    public static final String PASSWORD_ERROR = "Las contraseñas en ambos campos no son las mismas";

    private static void validateNonNull(JTextField text) throws ValidationException {

        String txt = text.getText().trim();


        if (txt.equals("")) {
            text.setForeground(RED_COLOR);
            throw new ValidationException(EMPTY_FIELD_ERROR);
        }

    }

    public static boolean validateFileName(JTextField text) throws ValidationException {

        validateNonNull(text);

        boolean isInvalid = false;

        String txt = text.getText().trim();

        Pattern p = Pattern.compile("[a-zA-Z0-9-. ]*");
        Matcher m = p.matcher(txt);

        if (!m.matches()) {
            text.setForeground(RED_COLOR);
            isInvalid = true;
        }

        return isInvalid;
    }

    public static boolean validateText(JTextField text) throws ValidationException {

        validateNonNull(text);

        boolean isInvalid = false;

        String txt = text.getText().trim();

        Pattern p = Pattern.compile("[a-zA-Z0-9áéíóúÁÉÍÓÚ#-. ]*");
        Matcher m = p.matcher(txt);

        if (!m.matches() || txt.contains("$")) {
            text.setForeground(RED_COLOR);
            isInvalid = true;
        }

        return isInvalid;
    }

    public static boolean validateIntNumber(JTextField number) throws ValidationException {

        validateNonNull(number);



        String numTxt = number.getText();
        boolean isInvalid = false;


        try {
            Integer.parseInt(numTxt);
        } catch (NumberFormatException ex) {
            number.setForeground(RED_COLOR);
            isInvalid = true;

        }

        return isInvalid;
    }

    public static boolean validateDoubleNumber(JTextField number) throws ValidationException {

        validateNonNull(number);
        boolean isInvalid = false;
        String numTxt = number.getText();
        try {
            Double.parseDouble(numTxt);
        } catch (NumberFormatException ex) {
            number.setForeground(RED_COLOR);
            isInvalid = true;
        }

        return isInvalid;
    }


    public static boolean validateText2(JTextField text) throws ValidationException {

        validateNonNull(text);
        boolean isInvalid = false;

        String txt = text.getText().trim();

        int len = txt.length();

        for (int i = 0; i < len; i++) {

            char charAtString = txt.charAt(i);

            if (!((charAtString >= 'a' && charAtString <= 'z') || (charAtString >= 'A'
                    && charAtString <= 'Z') || (charAtString >= '0' && charAtString <= '9')
                    || (charAtString == 'á' || charAtString == 'é' || charAtString == 'í' || charAtString == 'ó'
                    || charAtString == '#' || charAtString == '.' || charAtString == 'ú'|| charAtString == 'ú'
                    || charAtString == 'Á' || charAtString == 'É' || charAtString == 'Í' || charAtString == 'É'
                    || charAtString == 'Í' || charAtString == 'Ó' ||  charAtString == 'Ú' || charAtString == ' ' 
                    || charAtString == '-'))){
                
                text.setForeground(RED_COLOR);
                isInvalid = true;
            }
        }//f

        return isInvalid;
    }//m

      public static boolean validatePassword(JTextField pass, JTextField rPass ){

       String password = pass.getText();
       String rPassword = rPass.getText();
       boolean isInvalid = false;

       if(password.equals(rPassword)){
         isInvalid = true;
       }else{
           isInvalid = false;
       }

       return isInvalid;
    }



}
