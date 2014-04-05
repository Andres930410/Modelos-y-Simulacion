/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import java.util.*;
import simulacionconjunto.SimulacionConjunto;
import static simulacionconjunto.SimulacionConjunto.getInstance;

/**
 *
 * @author andresgutierrez
 */
public class Simulacion {
    public static int numeroDeSimulaciones;
    public static double numeroAutos;
    public static double perdidas;
    public static double numeroAuotosProbabilidad;
    public static double perdidasProbabilidad;
    public static List<Auto> list= new ArrayList<Auto>();
    public static List<Tipo> eventos = new ArrayList<Tipo>();
    public static List<Auto> listProbabilida= new ArrayList<Auto>();
    public static List<Tipo> eventosProbabilidad = new ArrayList<Tipo>();
    public static List<Auto> colaEspera = new ArrayList<Auto>();
    public double tiempoSalida;
    public int tamañoColatemp;
    public static int tamñoCola;
    
    public Servidor servidor1;
    public Servidor servidor2;
    public Servidor servidor1Probabilidad;
    public Servidor servidor2Probabilidad;
    
    public Auto auto;
   
    
    
    public static double numeroAutosTemp;
    public static double perdidasTemp;
    
    public static double perdidasProbabilidadTemp;
    public static double numerosAtuos1Temp;
    public static double numerosAtuos1TempProbabilidad;
    public static double  numeroAutosTempProbabilidad;
    
    public Simulacion(){
        init();
    }
    public void init(){
        servidor1=new Servidor();
        servidor2=new Servidor();
        servidor1Probabilidad=new Servidor();
        servidor2Probabilidad=new Servidor();
        //numeroAuotosProbabilidadTemp=0;
        perdidasTemp=0;
        numeroAutosTemp=0;
        perdidasProbabilidadTemp=0;
        numeroAutosTempProbabilidad=0;
        numerosAtuos1Temp=0;
        numerosAtuos1TempProbabilidad=0;
        tamañoColatemp=0;
        listProbabilida=new ArrayList<>();
        colaEspera=new ArrayList<>();
        eventosProbabilidad=new ArrayList<>();
        
    }
    public void simulaciones() throws InterruptedException{
            numeroDeSimulaciones--;
            Distribuciones.tiempoTotal=0;//Dia nuevo
            init();
            simular();
            numeroAutos+=numeroAutosTemp;
            numeroAuotosProbabilidad += numeroAutosTempProbabilidad;
            perdidas+=perdidasTemp;
            perdidasProbabilidad+=perdidasProbabilidadTemp;
            tamñoCola+=tamañoColatemp;
            view.Estadisticas.label.setText("Dinero Perdido: "+perdidasTemp);
            view.Estadisticas.label1.setText("Nº autos(No aten-Aten): "+numeroAutosTemp+"-"+numerosAtuos1Temp);
            view.Estadisticas.label2.setText("Dinero Perdido por auto: "+(perdidasTemp/numeroAutosTemp));
            view.Estadisticas.label3.setText("Dinero Perdido P: "+perdidasProbabilidadTemp);
            view.Estadisticas.label4.setText("Nº autos(No aten-Aten) P: "+numeroAutosTempProbabilidad+"-"+numerosAtuos1TempProbabilidad);
            view.Estadisticas.label5.setText("Dinero Perdido por auto P: "+perdidasProbabilidadTemp/numeroAutosTempProbabilidad);
            view.Estadisticas.label6.setText("Maximo Tamañao en la cola: "+tamañoColatemp);
            SimulacionConjunto ventana=getInstance();
            ventana.pack();
            Thread.sleep(100);
                    
        
    }
    public void simular(){
        double x;
        int count=0;
        for(int i=0; Distribuciones.tiempoTotal<=24; i++){//Halla cada llegada
            x=Distribuciones.poisson();
            
            if(Distribuciones.tiempoTotal<=24){
                auto=new Auto(x, Distribuciones.uniforme(3, 7),Distribuciones.exponencial((double)1/5));
                list.add(auto);
                eventos.add(new Tipo(x,"Entrada"));
                eventos.add(new Tipo(auto.salida(), "Salida"));
                listProbabilida.add(auto);
                eventosProbabilidad.add(new Tipo(x,"Entrada"));
                //eventosProbabilidad.add(new Tipo(auto.salida(), "Salida")); No agregamos el evento ya que puede cambiar si entra a la cola
                
                Collections.sort(eventos);
                Collections.sort(eventosProbabilidad);
                //Collections.sort(list);
                if(Distribuciones.tiempoTotal<=24){
                        for(int j=0; (!eventos.isEmpty()); j++){
                            if(eventos.get(0).tiempo<=Distribuciones.tiempoTotal){
                                simulacionEstacionServicios();
                               
                            
                            }else{
                                break;
                            }
                        
                        }
                        for(int j=0; !eventosProbabilidad.isEmpty(); j++){
                            if(eventosProbabilidad.get(0).tiempo<=Distribuciones.tiempoTotal){
                                
                                SimulacionEstacionServiciosProbabilidad();
                            
                            }else{
                                break;
                            }
                        }
                        
                        count++;
                }
                
            
                //System.out.println(Distribuciones.tiempoTotal+" "+x+" "+eventos.size()+" "+list.size());
                //System.out.println(x+"-"+auto.salida());
            }
        }
        System.out.println(count);
        
        finalizar();
        finalizarProbabilidad();
        
        //System.out.println(eventos.size());
    }
    public void simulacionEstacionServicios(){
        //TODO
        if(eventos.get(0).evento.equals("Entrada")){//Se asigna servidores
            if(servidor1.libre){
                servidor1.libre=false;
                servidor1.tiempo=list.get(0).salida();
                //System.out.println("entrada "+list.get(0).entrada+" salida "+servidor1.tiempo);
                numerosAtuos1Temp++;
                list.remove(0);
                
                
                
            }else if(servidor2.libre){
                servidor2.libre=false;
                servidor2.tiempo=list.get(0).salida();
                //System.out.println("entrada2 "+list.get(0).entrada+" salida "+servidor2.tiempo);
                numerosAtuos1Temp++;
                list.remove(0);
                
                
            }else{
                //System.out.println("Me fui "+servidor1.libre+"-"+servidor1.tiempo+" "+servidor2.libre+"-"+servidor2.tiempo);
                //System.out.println("Legada "+list.get(0).entrada);
                numeroAutosTemp++;
                perdidasTemp+=list.get(0).gasto();
                list.remove(0);
                
                
            }
        }else if(eventos.get(0).evento.equals("Salida")){
            
            if(servidor1.tiempo==eventos.get(0).tiempo){
                servidor1.libre=true;
                //System.out.println("salida "+servidor1.tiempo);
                
                
            }else if(servidor2.tiempo==eventos.get(0).tiempo){
                servidor2.libre=true;
                //System.out.println("salida2 "+servidor2.tiempo);
                
                
            }
        }
        
        eventos.remove(0);
        
        
            
        
        
    }
    public void finalizar(){//Atiende a los clienetes que faltan
        for(int i=0; !eventos.isEmpty(); i++){
            if(servidor1.tiempo==eventos.get(0).tiempo){
                servidor1.libre=true;
                //System.out.println("finalizando salida "+servidor1.tiempo);
            }else if(servidor2.tiempo==eventos.get(0).tiempo){
                servidor2.libre=true;
                //System.out.println("finalizando salida2 "+servidor2.tiempo);
                   
            }
            eventos.remove(0);
        }
        
    }
    public void SimulacionEstacionServiciosProbabilidad(){
        //TODO
        if(eventosProbabilidad.get(0).evento.equals("Entrada")){//Se asigna servidores
            if(servidor1Probabilidad.libre){
                eventosProbabilidad.add(eventosProbabilidad.size(),new Tipo(listProbabilida.get(0).salida(), "Salida"));
                servidor1Probabilidad.libre=false;
                servidor1Probabilidad.tiempo=listProbabilida.get(0).salida();
                //System.out.println("entrada "+list.get(0).entrada+" salida "+servidor1.tiempo);
                numerosAtuos1TempProbabilidad++;
                listProbabilida.remove(0);
                
                
                
            }else if(servidor2Probabilidad.libre){
                eventosProbabilidad.add(eventosProbabilidad.size(),new Tipo(listProbabilida.get(0).salida(), "Salida"));
                servidor2Probabilidad.libre=false;
                servidor2Probabilidad.tiempo=listProbabilida.get(0).salida();
                //System.out.println("entrada2 "+list.get(0).entrada+" salida "+servidor2.tiempo);
                numerosAtuos1TempProbabilidad++;
                listProbabilida.remove(0);
                
                
            }else{
                //System.out.println("Me fui "+servidor1.libre+"-"+servidor1.tiempo+" "+servidor2.libre+"-"+servidor2.tiempo);
                //System.out.println("Legada "+list.get(0).entrada);
                double x=Math.random();
                if(x>=0.4 && x<1){
                   colaEspera.add(listProbabilida.remove(0));
                   if(tamañoColatemp<colaEspera.size()){
                       tamañoColatemp=colaEspera.size();
                   }
                   
                   
                }else{
                    numeroAutosTempProbabilidad++;
                    perdidasProbabilidadTemp+=listProbabilida.get(0).gasto();
                    listProbabilida.remove(0);
                }
                
                
                
            }
        }else if(eventosProbabilidad.get(0).evento.equals("Salida")){
            
            if(servidor1Probabilidad.tiempo==eventosProbabilidad.get(0).tiempo){
               if(colaEspera.isEmpty()){
                    servidor1Probabilidad.libre=true;
               }else{
                   tiempoSalida=eventosProbabilidad.get(0).tiempo+(colaEspera.get(0).demora/60);
                   eventosProbabilidad.add(eventosProbabilidad.size(),new Tipo(tiempoSalida, "Salida"));
                   servidor1Probabilidad.tiempo=tiempoSalida;
                   numerosAtuos1TempProbabilidad++;
                   colaEspera.remove(0);
               }
                
                
                
            }else if(servidor2Probabilidad.tiempo==eventosProbabilidad.get(0).tiempo){
                if(colaEspera.isEmpty()){
                    servidor2Probabilidad.libre=true;
                }else{
                   tiempoSalida=eventosProbabilidad.get(0).tiempo+(colaEspera.get(0).demora/60);
                   eventosProbabilidad.add(eventosProbabilidad.size(),new Tipo(tiempoSalida, "Salida"));
                   servidor2Probabilidad.tiempo=tiempoSalida;
                   numerosAtuos1TempProbabilidad++;
                   colaEspera.remove(0);
                }
                //System.out.println("salida2 "+servidor2.tiempo);
                
                
            }
            
        }
        
        eventosProbabilidad.remove(0);
        
        
        
        
            
        
        
    }
    
    public void finalizarProbabilidad(){
        for(int i=0; !eventosProbabilidad.isEmpty(); i++){
            if(servidor1Probabilidad.tiempo==eventosProbabilidad.get(0).tiempo){
                servidor1Probabilidad.libre=true;
                //System.out.println("finalizando salida "+servidor1.tiempo);
            }else if(servidor2Probabilidad.tiempo==eventosProbabilidad.get(0).tiempo){
                servidor2Probabilidad.libre=true;
                //System.out.println("finalizando salida2 "+servidor2.tiempo);
                   
            }
            eventosProbabilidad.remove(0);
        }
        System.out.println(colaEspera.size());
        if(tamañoColatemp<colaEspera.size()){
            tamañoColatemp=colaEspera.size();
        }
        for(int i=0; !colaEspera.isEmpty(); i++){
            colaEspera.remove(0);//Se atienden las clientes en la cola
            numerosAtuos1TempProbabilidad++;
        }
    }
    
}
