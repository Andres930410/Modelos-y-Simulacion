/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author andres
 */
public class EstadistcasSimulacion extends JPanel{
    private JPanel unpanel1;
    private JPanel unpanel2;
    private JPanel unpanel3;
    public static JLabel label1;
    public static JLabel label2;
    public static JLabel label3;
    public static JLabel label4;
    public static JLabel label5;
    public static JLabel label6;
    public static double tiempo;
    public static double tiempoTotal;
    public static String camino ="A";
    public EstadistcasSimulacion(){
        this.setLayout(new GridLayout(0,3));
        label1 = new JLabel("Tiempo Recorrido");
        label2 = new JLabel("Camino Seleccionado");
        label3 = new JLabel("Tiempo Total");
        label4 = new JLabel(""+tiempo);
        label5 = new JLabel(camino);
        label6 = new JLabel(""+tiempoTotal);
        unpanel1=new JPanel(new GridLayout(2,0));
        unpanel2=new JPanel(new GridLayout(2,0));
        unpanel3=new JPanel(new GridLayout(2,0));
        unpanel1.setBackground(Color.white);
        unpanel2.setBackground(Color.white);
        unpanel3.setBackground(Color.white);
        unpanel1.add(label1);
        unpanel2.add(label2);
        unpanel3.add(label3);    
        unpanel1.add(label4);
        unpanel2.add(label5);
        unpanel3.add(label6);
        
        this.add(unpanel1);
        this.add(unpanel2);
        this.add(unpanel3);
        
        
    }
}
