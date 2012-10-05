/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author RVAFOD
 */
public class ImpresoraTicket {

    private Ticket ticket;
    private OutputStream out;

    public ImpresoraTicket(Ticket t) throws FileNotFoundException {
        this.ticket = t;
        out = new FileOutputStream("LPT1:");

    }

    public void cierraConexion() throws IOException {
        if (out != null) {
            out.flush();
            out.close();
        }
    }

    public void cortaPapel() throws IOException {
        out.write(new Integer(27).byteValue());
        out.write(new Integer(105).byteValue());

    }

    public void desplazaLineas(int numLineas) throws IOException {

        out.write(new Integer(27).byteValue());
        out.write(new Integer(100).byteValue());
        out.write(new Integer(numLineas).byteValue());

    }

    public void cambiaColor(int color) throws IOException {
        out.write(new Integer(27).byteValue());
        out.write(new Integer(97).byteValue());
        out.write(new Integer(color).byteValue());
    }

    public void alineaTexto(int posicion) throws IOException {

        out.write(new Integer(27).byteValue());
        out.write(new Integer(114).byteValue());
        out.write(new Integer(posicion).byteValue());

    }

    public void imprimir() throws IOException {


        cambiaColor(48);
        alineaTexto(1);

        for (int i = 0; i < ticket.numeroLineas(); i++) {
            out.write(ticket.obtenLinea(i).getBytes());
            System.out.print(ticket.obtenLinea(i));
        }

        desplazaLineas(8);
        cortaPapel();
        cierraConexion();

    }
}
