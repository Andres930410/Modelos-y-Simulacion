/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Simulacion;

import simulacionconjunto.SimulacionConjunto;
import static simulacionconjunto.SimulacionConjunto.getInstance;

/**
 *
 * @author andresgutierrez
 */
public class PanelBotones extends JPanel {
    private JButton salir;
    protected static JButton simular;
    public static int simulaciones;
    private static JButton estadisticas;
    private ImageIcon flecha;
    private ImageIcon imagenEscalada;
    public PanelBotones(){
        this.setLayout(new GridLayout(0, 3));
        this.setBackground(Color.white);
        salir=new JButton("Salir");
        estadisticas = new JButton("Estadisticas");
        flecha = new ImageIcon("/Users/andresgutierrez/NetBeansProjects/Simulacion/src/simulacion/flecha.png");
        
        imagenEscalada = new ImageIcon(flecha.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        simular=new JButton(imagenEscalada);
        simular.setEnabled(false);
        simular.setToolTipText("Apretar para inicir cada simulacion");
        this.add(salir);
        this.add(simular);
        this.add(estadisticas);
        estadisticas.setEnabled(false);
        salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        estadisticas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                view.Estadisticas.label.setText("Dinero Perdido: "+Simulacion.perdidas);
                view.Estadisticas.label1.setText("Nº autos(No aten por dia): "+Simulacion.numeroAutos/simulaciones);
                view.Estadisticas.label2.setText("Dinero Perdido por auto: "+(Simulacion.perdidas/Simulacion.numeroAutos));
                view.Estadisticas.label3.setText("Dinero Perdido P: "+Simulacion.perdidasProbabilidad);
                view.Estadisticas.label4.setText("Nº autos(No aten por dia) P: "+Simulacion.numeroAuotosProbabilidad/simulaciones);
                view.Estadisticas.label5.setText("Dinero Perdido por auto P: "+Simulacion.perdidasProbabilidad/Simulacion.numeroAuotosProbabilidad);
                view.Estadisticas.label6.setText("Tamaño maximo promedio de la cola "+(double)Simulacion.tamñoCola/simulaciones);
                SimulacionConjunto ventana=getInstance();
                ventana.pack();
            }
        });
        simular.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //PanelBotones.simular.setEnabled(false);
                NumeroSimulaciones.entrada.setEnabled(false);
                NumeroSimulaciones.texto.setEditable(false);
                model.Simulacion simulacion = new Simulacion();
                
                try {
                    if(model.Simulacion.numeroDeSimulaciones>0){
                        simulacion.simulaciones();
                    }
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(PanelBotones.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(model.Simulacion.numeroDeSimulaciones==0){
                    PanelBotones.simular.setEnabled(false);
                    PanelBotones.estadisticas.setEnabled(true);
                }
                
            }
        });
        
    }
    
}
