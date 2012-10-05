/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Luc3
 */
public class Constants {

    private static final String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private static final String[] DAYS = {"Domingo","Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
    static String sqlDateFormat;
    static String mainMenuDate;
    static String previousDate;

    public static String getMenuDate() {
        return mainMenuDate;
    }

    public static String getCurrentDate() {
        return sqlDateFormat;
    }

    public static String getpreviousDate(){
        return previousDate;
    }

    public static void setDate() {

        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);

        previousDate =  getFormattedDate(-40);

        mainMenuDate = DAYS[dayOfWeek - 1] + " " + day + " de " + MONTHS[month] + " del " + year;

        sqlDateFormat = getFormattedDate(0);

    }

    private static String getFormattedDay(int number) {
        if (number <= 9) {
            return "0" + number;
        } else {
            return Integer.toString(number);
        }
    }

    public static String getFormattedDate(int number){
        String date = "";

        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, number);
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);

        date = year + "-" + getFormattedDay(month + 1) + "-" +  getFormattedDay(day);

        return date;
    }

    public static boolean confirmDialog(Component c, String message) {
        return JOptionPane.showConfirmDialog(c, message) == 0;
    }
}
