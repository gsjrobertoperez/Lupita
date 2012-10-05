/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.ArrayList;

/**
 *
 * @author RVAFOD
 */
public final class Ticket {

    private static final String FORMATO_GENERAL = "%1$-40.40s";
    private static final String FORMATO_VENTA = "%1$-5.5s%2$-28.28s%3$-7.7s";
    private static final String FORMATO_ABONO = "%1$-6.6s%2$-4.4s%3$-24.24s%4$-6.6s";
    private static final String FORMATO_DINERO = "%1$-22.22s%2$-11.11s%3$-7.7s";
    
    private ArrayList<String> datosTicket;
    //private ArrayList<String> encabezado;
    //private ArrayList<String> pie;

    public int numeroLineas() {
        return datosTicket.size();
    }

    public Ticket() {
        this.datosTicket = new ArrayList<String>();
    }

    public void agregaLinea(String linea) {
        datosTicket.add(linea + "\n");
    }

    public void agregaLineaGeneral(String cliente){
        datosTicket.add(Formateador.formatearTexto(FORMATO_GENERAL, cliente) + "\n" );
    }

    public void agregaVenta(Object[] ventas){
        datosTicket.add(Formateador.formatearObjetos(FORMATO_VENTA, ventas) + "\n");
    }

    public void agregaAbono(Object[] abonos){
        datosTicket.add(Formateador.formatearObjetos(FORMATO_ABONO, abonos) + "\n" );
    }

    public void agregaDinero(Object[] dinero){
       datosTicket.add(Formateador.formatearObjetos(FORMATO_DINERO, dinero) + "\n");
    }

    public String obtenLinea(int numLinea) {
        return datosTicket.get(numLinea);
    }
}
