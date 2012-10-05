/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Luc3
 */
public class LeerDatos {

    private ArrayList<String> listHeader;
    private ArrayList<String> listFooter;

    public LeerDatos() {

        this.listHeader = new ArrayList<String>();
        this.listFooter = new ArrayList<String>();
    }

    public void leeDatos() {

        FileReader fr = null;
        boolean header = false;
        boolean footer = false;
        try {
            fr = new FileReader("C:/SistemaCobranza/conf/datos.txt");
            String s;
            //String texto = new String();

            BufferedReader entrada = new BufferedReader(fr);
            while ((s = entrada.readLine()) != null) {

                if ((s.contains("[header]"))) {
                    header = true;
                    s = entrada.readLine();
                }//if
                else if (s.contains("[footer]")) {
                    header = false;
                    footer = true;
                    s = entrada.readLine();
                }
                if (header) {
                    listHeader.add(s);
                } else if (footer) {
                    listFooter.add(s);
                }
            }//while
        } catch (IOException fnfex) {
            System.out.println("Error de i/o: " + fnfex);
        } finally {
            //cerrar los flujos de datos
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                }
            } // if
        } // finally
    }//leer datos

    public void escribirDatos(ArrayList<String> header, ArrayList<String> footer) throws IOException {

        FileWriter cp = null;
        BufferedWriter out = null;
        cp = new FileWriter("C:/SistemaCobranza/conf/datos.txt");
        out = new BufferedWriter(cp);

        out.write("[header]");
        out.newLine();
        for (int x = 0; x < header.size(); x++) {
            out.write(header.get(x));
            out.newLine();
        }

        out.newLine();
        out.write("[footer]");
        out.newLine();
        for (int x = 0; x < footer.size(); x++) {
            out.write(footer.get(x));
            out.newLine();
        }

        out.close();

    }

    public ArrayList getHeader() {

        return listHeader;
    }

    public ArrayList getFooter() {

        return listFooter;
    }
}
