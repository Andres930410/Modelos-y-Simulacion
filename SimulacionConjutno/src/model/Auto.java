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
public class Auto implements Comparable<Auto>{
    public double entrada;
    public double galones;
    public double demora;

    public Auto(double entrada,double galones,double demora){
        this.entrada=entrada;
        this.galones=galones;
        this.demora=demora;
  
       
    }
    public double gasto(){
        return 8.2*galones;
    }
    public double salida(){
        return (entrada+(demora/60));
    }

    @Override
    public int compareTo(Auto o) {
        return new Double(entrada).compareTo(new Double(o.entrada));
    }
}
