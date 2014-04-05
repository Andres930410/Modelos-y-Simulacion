/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BorderFactory;



/**
 *
 * @author andresgutierrez
 */
public class Ventana extends JPanel implements ActionListener{
    private static JTextField texto;
    private static JButton boton;
    private static JLabel label;
    private static JLabel unLabel;
    public static JLabel unLabel1;
    private static JLabel unLabel2;
    private static JSlider slider;
    public static JProgressBar barra;
    
    
    public Ventana(){
        JPanel unPanel1= new JPanel(new FlowLayout());
        JPanel unPanel2= new JPanel();
        JPanel unPanel3= new JPanel(new GridLayout(3, 0));
        slider=new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        barra=new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
        Border borde = BorderFactory.createTitledBorder("Simulando...");
        barra.setBorder(borde);
        //slider.setPaintTicks(true);
        //slider.setPaintLabels(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if(!source.getValueIsAdjusting()){
                    int valor  = (int)source.getValue();
                    Eventos.delay=101;
                    Eventos.delay=Eventos.delay-valor;
                
                    
                }
            }
        });
    
        unLabel2=new JLabel("Velocidad de la simulacion");
        unLabel=new JLabel("Se estan ejcutando "+Simulacion.j+" Simulaciones-");
        unLabel1=new JLabel("Faltan ejecutar "+(Simulacion.j-Simulacion.i)+" Simulaciones");
        texto=new JTextField(15);
        label=new JLabel("Introdusca el numero de Simulaciones");
        boton=new JButton("Siguiente");
        label.setToolTipText("Por defecto 500 se puede cambiar en tiempo de ejecucion");
        setLayout(new GridLayout(3,0));
        unPanel1.add(label);
        unPanel1.add(texto);
        unPanel1.add(boton);
        unPanel2.add(unLabel);
        unPanel2.add(unLabel1);
        unPanel3.add(unLabel2);
        unPanel3.add(slider);
        unPanel3.add(barra);
        unPanel1.setBackground(Color.white);
        unPanel2.setBackground(Color.white);
        unPanel3.setBackground(Color.white);
        add(unPanel1);
        add(unPanel2);
        add(unPanel3);
        setBackground(Color.white);
        boton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Simulacion.j=Integer.parseInt(texto.getText());
        texto.setText("");  
        unLabel.setText("Se estan ejcutando "+Simulacion.j+" Simulaciones-");
        unLabel1.setText("Faltan ejecutar "+(Simulacion.j-Simulacion.i)+" Simulaciones");
        
        
    }
    
}
