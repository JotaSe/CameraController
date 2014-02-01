/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cameracontroller.opencv;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Gaming
 */
public class Print {
             public void print(BufferedImage image) {

        JasperReport reporte;
        JasperPrint reporte_view;
        try{
         String D = "C:\\Users\\Gaming\\Documents\\;DDD.jpg";
            System.out.println("D = " + D);
         //direccion del archivo JASPER
          URL  in = this.getClass().getResource("report1.jasper");
          reporte = (JasperReport) JRLoader.loadObject( in);
          //Se crea un objeto HashMap
           Map parametros = new HashMap();
          parametros.clear();
          //parametros de entrada
  
          ImageIcon photo = new ImageIcon(image);
          parametros.put( "logo",photo );
          

          //-----------------------------------
          reporte_view= JasperFillManager.fillReport( reporte, parametros );
                         //   JRExporter exporter = new JRPdfExporter();
                  
        
       // exporter.setParameter(JRExporterParameter.JASPER_PRINT, reporte_view);
      //  exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Codigos/COD"+num+".pdf"));
      //  exporter.exportReport();
         JasperViewer.viewReport( reporte_view , false );
//             File path = new File ("Codigos/COD"+num+".pdf");
//                try {
//                    Desktop.getDesktop().open(path);
//                  //  imprimirCOD(num,path);
//                   // imprimirCOD(num,path);
//                    
//                } catch (IOException ex) {
//                    Logger.getLogger(ControllerPedido.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
          

          //terminamos la conexion a la base de datos

	  }catch (JRException E){
          }
    
    }
}
