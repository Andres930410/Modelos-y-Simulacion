/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author andresgutierrez
 */
public class Estadisticas extends JPanel{
    public static JLabel label;
    public static JLabel label1;
    public static JLabel label2;
    public static JLabel label3;
    public static JLabel label4;
    public static JLabel label5;
    public static JLabel label6;
    private static JPanel panel;
    private static JPanel panel1;
    private static JPanel panel2;
    
    public Estadisticas(){
        this.setLayout(new GridLayout(2, 2));
        this.setBackground(Color.white);
        panel = new JPanel(new GridLayout(3, 0));
        panel1 = new JPanel(new GridLayout(3, 0));
        panel2= new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.white);
        panel1.setBackground(Color.white);
        panel2.setBackground(Color.white);
        label=new JLabel("Dinero Perdido:");
        label1=new JLabel("Nº autos:");
        label2=new JLabel("Promedio Dinero Perdido:");
        panel.add(label);panel.add(label1);panel.add(label2);
        label3=new JLabel("Dinero Perdido Probabilidad:");
        label4=new JLabel("Nº autos Probabilidad:");
        label5=new JLabel("Promedio Dinero Perdido Probabilidad:");
        label6=new JLabel("Maximo Tamañao en la cola: ");
        panel1.add(label3);panel1.add(label4);panel1.add(label5);
        panel2.add(label6);
        this.add(panel);
        this.add(panel1);
        this.add(panel2);
    }
}
