/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import com.itextpdf.text.Chunk;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.text.html.parser.Element;

/**
 *
 * @author andres
 */
public class PanelBotones extends JPanel{
   private JButton simular;
   private JButton reporte;
   private JButton salir;
   private ImageIcon imagen1 = new ImageIcon(getClass().getResource("flecha.png"));
   private ImageIcon imagenEscalada = new ImageIcon(imagen1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
   private Eventos unEventos;
   public PanelBotones(){
       unEventos=new Eventos();
       this.setLayout(new GridLayout(0, 2));
       
       reporte=new JButton(imagenEscalada);
       salir=new JButton("Salir");
       reporte.setToolTipText("Seleccione para generar un reporte de los resultados");
       this.add(salir);
    
       this.add(reporte);
       
       salir.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent ae) {
                System.exit(0);
           }
       });
       reporte.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent ae)  {
               
               FileOutputStream archivo = null;
               try {
                   archivo = new FileOutputStream("/Users/andresgutierrez/NetBeansProjects/Simulacion/src/simulacion/estadisticas.pdf");
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(PanelBotones.class.getName()).log(Level.SEVERE, null, ex);
               }
               Document documento = new Document();
               try {
                   PdfWriter.getInstance(documento, archivo);
               } catch (DocumentException ex) {
                   Logger.getLogger(PanelBotones.class.getName()).log(Level.SEVERE, null, ex);
               }
               documento.open();
               try
               {
                    com.itextpdf.text.Image foto= com.itextpdf.text.Image.getInstance("/Users/andresgutierrez/NetBeansProjects/Simulacion/src/simulacion/unal.jpg");
                    foto.scaleToFit(100, 100);
                    
                    foto.setAlignment(Chunk.ALIGN_LEFT);
                    documento.addAuthor("Andres Gutierez");
                    documento.add(foto);
                    Font unaFont = new Font(FontFamily.COURIER);
                    unaFont.setSize(50);
                    documento.add(new Paragraph("Estadisticas",unaFont));
                }
                catch ( Exception e )
                {
                    e.printStackTrace();
                }

               try {
                        
                   documento.add(new Paragraph("Tiempo entre A-B: "+(Eventos.ab/Eventos.countab)));
                   documento.add(new Paragraph("Tiempo entre A-C: "+(Eventos.ac/Eventos.countac)));
                   documento.add(new Paragraph("Tiempo entre B-D: "+(Eventos.bd/Eventos.countbd)));
                   documento.add(new Paragraph("Tiempo entre B-E: "+(Eventos.be/Eventos.countbe)));
                   documento.add(new Paragraph("Tiempo entre C-F: "+(Eventos.cf/Eventos.countcf)));
                   documento.add(new Paragraph("Tiempo entre C-E: "+(Eventos.ce/Eventos.countce)));
                   documento.add(new Paragraph("Tiempo entre D-G: "+(Eventos.dg/Eventos.countdg)));
                   documento.add(new Paragraph("Tiempo entre E-G: "+(Eventos.eg/Eventos.counteg)));
                   documento.add(new Paragraph("Tiempo entre F-G: "+(Eventos.fg/Eventos.countfg)));
                   documento.add(new Paragraph("Tiempo total del recorrido: "+(Eventos.total/Eventos.counttotal)));
                   documento.add(new Paragraph("Viajes Totales: "+(Eventos.counttotal)));
                   
               } catch (DocumentException ex) {
                   Logger.getLogger(PanelBotones.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               documento.close();
           }
       });
   } 
    
}
