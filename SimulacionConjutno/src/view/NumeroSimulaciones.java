/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author andresgutierrez
 */
public class NumeroSimulaciones extends JPanel{
    public static JTextField texto;
    public static JButton entrada;
    private static JPanel unPanel;
    private static JLabel label;
    public NumeroSimulaciones(){
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.white);
        label = new JLabel("Ingrese el numero de simulaciones");
        texto=new JTextField(10);
        texto.setMaximumSize(new Dimension(300, 40));
        entrada = new JButton("Entrada");
        unPanel = new JPanel(new FlowLayout());
        unPanel.add(texto);
        unPanel.add(entrada);
        unPanel.setBackground(Color.white);
        this.add(label);
        this.add(unPanel);
        entrada.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.Simulacion.numeroDeSimulaciones = Integer.parseInt(NumeroSimulaciones.texto.getText());
                PanelBotones.simulaciones=model.Simulacion.numeroDeSimulaciones;
                NumeroSimulaciones.texto.setText("");
                PanelBotones.simular.setEnabled(true);
            }
        });
    }
}
