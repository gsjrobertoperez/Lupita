/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author r
 */
public class Formateador {

    public static String formatearObjetos(String formato, Object[] args) {
        return String.format(formato, args);
    }

    public static String formatearTexto(String formato, String args) {
        return String.format(formato, args);
    }
}
