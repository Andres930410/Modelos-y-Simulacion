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
public class Tipo implements Comparable<Tipo>{
    public double tiempo;
    public String evento;

    public Tipo(double tiempo,String evento){
        this.tiempo=tiempo;
        this.evento=evento;
    }
    @Override
    public int compareTo(Tipo o) {
        return new Double(tiempo).compareTo(new Double(o.tiempo));
    }
    
}
