/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * @andres version 2.0
 */
package simulacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author andres
 */
public class Simulacion extends JPanel{
    private ImageIcon imagen1 = new ImageIcon(getClass().getResource("A.jpg"));
    private ImageIcon imagen2 = new ImageIcon(getClass().getResource("B.jpg"));
    private ImageIcon imagen3 = new ImageIcon(getClass().getResource("C.jpg"));
    private ImageIcon imagen4 = new ImageIcon(getClass().getResource("D.jpg"));
    private ImageIcon imagen5 = new ImageIcon(getClass().getResource("E.jpg"));
    private ImageIcon imagen6 = new ImageIcon(getClass().getResource("F.jpg"));
    private ImageIcon imagen7  = new ImageIcon(getClass().getResource("G.jpg"));
    private ImageIcon imagen8  = new ImageIcon(getClass().getResource("carro.jpg"));
    private static Eventos unEvento=new Eventos();;
    private static Simulacion instance;
    public static int j=500;
    public static int i;
    public static JFrame unJFrame;
   
    
    
    
    private  Simulacion(){
        this.setBackground(Color.white);    
        
        
    }
    public static  Simulacion getInstance(){//singleton
        if(instance==null){
            instance=new Simulacion();
        }
        return instance;
        
    }
    public void run() throws InterruptedException{
      repaint();
      for(i=0; i<j; i++){
        int valor = ((i*100)/j);
        Ventana.barra.setValue(valor);
        Ventana.barra.setStringPainted(true);
        Ventana.unLabel1.setText("Faltan ejecutar "+(j-i)+" Simulaciones");
        unEvento.seleccion1();
        Eventos.total+=EstadistcasSimulacion.tiempoTotal;
        EstadistcasSimulacion.tiempo=0;
        EstadistcasSimulacion.tiempoTotal=0;
        EstadistcasSimulacion.camino="A";
        Eventos.counttotal++;
                
      }
      int valor = ((i*100)/j);
      Border border = BorderFactory.createTitledBorder("Simulacion Finalizado");
      Ventana.barra.setBorder(border);
      Ventana.barra.setValue(valor);
      Ventana.barra.setStringPainted(true);
      Ventana.unLabel1.setText("Faltan ejecutar "+(j-i)+" Simulaciones");
      JOptionPane.showMessageDialog(null, "Fin de la simulacion presione la flecha para generar el reporte");
        
    }
    
    
    
    /**
     *
     * @param g
     */
    @Override
     public void paint(Graphics g) {
        super.paint(g);
        //this.setOpaque(false);
        this.setBackground(Color.white);
        g.drawImage(imagen1.getImage(),0 , 300, 100, 100, this);
        g.drawImage(imagen2.getImage(),150 , 150, 100, 100, this);
        g.drawImage(imagen3.getImage(),150 , 450, 100, 100, this);
        g.drawImage(imagen5.getImage(),350 , 300, 100, 100, this);
        g.drawImage(imagen4.getImage(),450 , 150, 100, 100, this);
        g.drawImage(imagen6.getImage(),480 , 480, 50, 50, this);
        g.drawImage(imagen7.getImage(),650 , 300, 100,100, this);
        g.drawImage(imagen8.getImage(),unEvento.x,unEvento.y, 40,40,this);
        g.drawLine(50, 350,190,200);
        g.drawLine(50, 350,190,500);
        g.drawLine(200, 200,400,350);
        g.drawLine(200, 500,400,350);
        g.drawLine(200, 200,500,200);
        g.drawLine(200, 500,500,500);
       
        g.drawLine(400,350,700,350);
        g.drawLine(500, 200,700,350);
        g.drawLine(500, 500,700,350);
        
    }
   
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws InterruptedException {
        Simulacion.unJFrame =new JFrame("Simulacion");
        EstadistcasSimulacion unaEstadistica=new EstadistcasSimulacion();
        JPanel unJPanel = new JPanel(new BorderLayout());
        Simulacion unaSimulacion =getInstance();
        Ventana unaVentana=new Ventana();
        PanelBotones unPanelBotones=new PanelBotones();
        Simulacion.unJFrame.setLayout(new BorderLayout());
        unJPanel.add(unaSimulacion,BorderLayout.CENTER);
        unJPanel.add(unPanelBotones,BorderLayout.SOUTH);
        unJPanel.add(unaEstadistica,BorderLayout.NORTH);
        unJPanel.add(unaVentana,BorderLayout.EAST);
        JScrollPane jScrollPane=new JScrollPane(unJPanel);
        Simulacion.unJFrame.getContentPane().add(jScrollPane);
                   
        Simulacion.unJFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        unJFrame.setVisible(true);
        Simulacion.unJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //unJFrame.setBounds(100,100,500,500);
        Simulacion.unJFrame.setVisible(true);
        Simulacion.unJFrame.setResizable(false);
      
      
        
        unaSimulacion.run();
        //unJFrame.setBackground(Color.WHITE);
        
        
    }
}
