/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author andresgutierrez
 */
public class Distribuciones {
    public static  double tiempoTotal;
    public Distribuciones(){
        init();
    }
    public void init(){ 
        tiempoTotal=0;
    }
    public static double uniforme(int a, int b){
        return a+Math.random()*(b-a);
    }
    public static double exponencial(double lamda){
        return -((double)1/lamda)*Math.log(Math.random());
    }
    public static double functionLamda(double tiempo){
        double lamda=0;
        if(tiempo>=0 && tiempo<=7){//Se mantiene constante en 2
            lamda=2;
        }
        else if(tiempo>7 && tiempo<=17){//Aumento lineal 
            lamda=2+2.8*(tiempo-7);
            
            
            
        }else if(tiempo>17 && tiempo<=22){//Se mantiene constante en 30
            lamda=30;
        }else {//Disminucion lineal hasta 2
            lamda=30-14*(tiempo-22);
            
        }
        return lamda;
    }
    public static double poisson(){
        double x=Math.random();
        double carros=0;
        double lamdaMaximo=30;
        /*double lambda=-((double)1/30);
        double p= Math.pow(Math.E,lambda);
        //System.out.println(p);
        double f=p;
        while(x>f){
            p=-((lambda*p)/((double)(carros+1)));
            f=f+p;
            carros++;
        }
        */
        tiempoTotal =  (tiempoTotal + exponencial(lamdaMaximo));
        if(tiempoTotal<=24){
            while(x>(functionLamda((double)tiempoTotal)/lamdaMaximo)){
                tiempoTotal =  (tiempoTotal + exponencial(lamdaMaximo));   
                if(tiempoTotal>24){
                    tiempoTotal=25;
                    return 0;
                }
                x=Math.random();
            
            }
            carros=tiempoTotal;
            
            return carros;
        }
        return 0;
    }
}
