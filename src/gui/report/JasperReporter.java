/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.report;

import common.SQLBuilder;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author RVAFOD
 */
public class JasperReporter {

    private static JasperPrint jasperPrint;
    private static Connection jdbcConnection = SQLBuilder.getConnection();

    public JasperReporter(String designFile, HashMap parameters){
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(designFile);
            //Se compila para crear un objeto de tipo JasperReport
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            //Se manda de parametros el objeto del reporte, los parametros adiciones en un HashMap y
            //el objeto de la conexion
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jdbcConnection);

        } catch (JRException ex) {
            Logger.getLogger(JasperReporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void viewReport(){
        JasperViewer.viewReport(jasperPrint,false);
    }

    public void saveReport(String fileName) throws JRException{
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, fileName);
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.exportReport();
    }
}
