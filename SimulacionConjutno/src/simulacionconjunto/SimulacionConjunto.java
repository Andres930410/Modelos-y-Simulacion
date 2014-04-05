/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionconjunto;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import view.Estadisticas;
import view.NumeroSimulaciones;
import view.PanelBotones;
import view.Titulo;

/**
 *
 * @author andresgutierrez
 */
//Singleton
public class SimulacionConjunto extends JFrame{
    protected static SimulacionConjunto instance;
    private SimulacionConjunto(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        //this.setSize(200, 200);
        this.setLayout(new BorderLayout());
        //this.setLocationRelativeTo(null);
        
    }
    public static SimulacionConjunto getInstance(){
        if(instance==null){
            instance=new SimulacionConjunto();
        }
        return instance;
    }
    public static void main(String[] args) {
        SimulacionConjunto ventana=getInstance();
        PanelBotones botones = new PanelBotones();
        NumeroSimulaciones cantidad= new NumeroSimulaciones();
        Titulo titulo =new Titulo();
        Estadisticas estadisticias =new Estadisticas();
        
        ventana.add(botones, BorderLayout.SOUTH);
        ventana.add(cantidad,BorderLayout.EAST);
        ventana.add(titulo, BorderLayout.NORTH);
        ventana.add(estadisticias,BorderLayout.CENTER);
        ventana.pack();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
                
        
    }
    
}
