/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author andresgutierrez
 */
public class Titulo extends JPanel {
    private ImageIcon escudo;
    private JLabel label;
    private JLabel label1;
    public Titulo (){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.white);
        escudo =new ImageIcon("/Users/andresgutierrez/NetBeansProjects/Simulacion/src/simulacion/unal.jpg");
        
        label=new JLabel(escudo);
        label.setToolTipText("Universidad Nacional de Colombia");
        label.setToolTipText("Universidad Nacional de Colombia");
        label1 =new JLabel("Simulacion Estacion de Servicio");
        label1.setFont(new Font("TAHOMA", 1, 30));
        this.add(label);
        this.add(label1);
    }
    
}
