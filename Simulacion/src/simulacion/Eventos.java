/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

/**
 *
 * @author andres
 */
public class Eventos {
   public static int x;
   public static int y;
  
   public static double ab;
   public static double countab;
   public static double ac;
   public static double countac;
   public static double bd;
   public static double countbd;
   public static double be;
   public static double countbe;
   public static double ce;
   public static double countce;
   public static double cf;
   public static double countcf;
   public static double eg;
   public static double counteg;
   public static double fg;
   public static double countfg;
   public static double dg;
   public static double countdg;
   public static double total;
   public static double counttotal;
   public static int delay=101;
   
   
   public Eventos(){
       this.x=20;
       this.y=330;
   }
   public void init() throws InterruptedException{
       x=20;
       y=330;
       
   }
   public void seleccion1() throws InterruptedException{//Evento para elegir la primera ruta
       init();
       Simulacion unaSimulacion = Simulacion.getInstance();
       
       unaSimulacion.repaint();
       Thread.sleep(100);
       int valor=(int)(Math.random()*10);
       if(valor>=0 && valor<=4){//Camino B
           EstadistcasSimulacion.tiempo=uniforme(18,22,Math.random());
           
           EstadistcasSimulacion.label4.setText(""+EstadistcasSimulacion.tiempo);
           EstadistcasSimulacion.tiempoTotal+=EstadistcasSimulacion.tiempo;
           EstadistcasSimulacion.label6.setText(""+EstadistcasSimulacion.tiempoTotal);
           EstadistcasSimulacion.camino+="-B";
           EstadistcasSimulacion.label5.setText(EstadistcasSimulacion.camino);
           for(int i=0; i<=100; i+=10){
               x+=14;
               y-=14;
               unaSimulacion.repaint();
               Thread.sleep(delay*(int)EstadistcasSimulacion.tiempo);

           }
           ab+=EstadistcasSimulacion.tiempo;
           countab++;
           seleccion21();
       }else{
           EstadistcasSimulacion.tiempo=uniforme(14,16,Math.random());
           EstadistcasSimulacion.label4.setText(""+EstadistcasSimulacion.tiempo);
           EstadistcasSimulacion.tiempoTotal+=EstadistcasSimulacion.tiempo;
           EstadistcasSimulacion.label6.setText(""+EstadistcasSimulacion.tiempoTotal);
           EstadistcasSimulacion.camino+="-C";
           EstadistcasSimulacion.label5.setText(EstadistcasSimulacion.camino);
           for(int i=0; i<=100; i+=10){
               x+=14;
               y+=14;
               unaSimulacion.repaint();
               Thread.sleep(delay*(int)EstadistcasSimulacion.tiempo);
               
           }
           ac+=EstadistcasSimulacion.tiempo;
           countac++;
           seleccion22();
       }
       
       
   }
   public void seleccion21() throws InterruptedException{
       Simulacion unaSimulacion = Simulacion.getInstance();
       unaSimulacion.repaint();
       Thread.sleep(100);
       int eleccion =(int)(Math.random()*10);
       if(eleccion>=0 && eleccion<=7){//selecciona el camino D
           EstadistcasSimulacion.tiempo=uniforme(5,6,Math.random());
           EstadistcasSimulacion.label4.setText(""+EstadistcasSimulacion.tiempo);
           EstadistcasSimulacion.tiempoTotal+=EstadistcasSimulacion.tiempo;
           EstadistcasSimulacion.label6.setText(""+EstadistcasSimulacion.tiempoTotal);
           EstadistcasSimulacion.camino+="-D";
           EstadistcasSimulacion.label5.setText(EstadistcasSimulacion.camino);
           for(int i=0; i<=100; i+=10){
               x+=29;
               unaSimulacion.repaint();
               Thread.sleep(delay*(int)EstadistcasSimulacion.tiempo);
           }
           bd+=EstadistcasSimulacion.tiempo;
           countbd++;
           seleccion211();
       }else{
           EstadistcasSimulacion.tiempo=uniforme(6,8,Math.random());
           EstadistcasSimulacion.label4.setText(""+EstadistcasSimulacion.tiempo);
           EstadistcasSimulacion.tiempoTotal+=EstadistcasSimulacion.tiempo;
           EstadistcasSimulacion.label6.setText(""+EstadistcasSimulacion.tiempoTotal);
           EstadistcasSimulacion.camino+="-E";
           EstadistcasSimulacion.label5.setText(EstadistcasSimulacion.camino);
           for(int i=0; i<=100; i+=10){//selecciona el camino E
               x+=18;
               y+=14;
               unaSimulacion.repaint();
               Thread.sleep(delay*(int)EstadistcasSimulacion.tiempo);
               
           }
           be+=EstadistcasSimulacion.tiempo;
           countbe++;
           seleccion212();
       } 
   }
   public void seleccion22() throws InterruptedException{
       Simulacion unaSimulacion = Simulacion.getInstance();
       unaSimulacion.repaint();
       Thread.sleep(100);
       int eleccion =(int)(Math.random()*10);
       if(eleccion>=0 && eleccion<=3){//selecciona el camino F
           EstadistcasSimulacion.tiempo=uniforme(8,12,Math.random());
           EstadistcasSimulacion.label4.setText(""+EstadistcasSimulacion.tiempo);
           EstadistcasSimulacion.tiempoTotal+=EstadistcasSimulacion.tiempo;
           EstadistcasSimulacion.label6.setText(""+EstadistcasSimulacion.tiempoTotal);
           EstadistcasSimulacion.camino+="-F";
           EstadistcasSimulacion.label5.setText(EstadistcasSimulacion.camino);
           for(int i=0; i<=100; i+=10){
               x+=29;
               unaSimulacion.repaint();
               Thread.sleep(delay*(int)EstadistcasSimulacion.tiempo);
           }
           cf+=EstadistcasSimulacion.tiempo;
           countcf++;
           seleccion221();
       }else{
           EstadistcasSimulacion.tiempo=uniforme(5,7,Math.random());
           EstadistcasSimulacion.label4.setText(""+EstadistcasSimulacion.tiempo);
           EstadistcasSimulacion.tiempoTotal+=EstadistcasSimulacion.tiempo;
           EstadistcasSimulacion.label6.setText(""+EstadistcasSimulacion.tiempoTotal);
           EstadistcasSimulacion.camino+="-E";
           EstadistcasSimulacion.label5.setText(EstadistcasSimulacion.camino);
           for(int i=0; i<=100; i+=10){//selecciona el camino E
               x+=18;
               y-=14;
               unaSimulacion.repaint();
               Thread.sleep(delay*(int)EstadistcasSimulacion.tiempo);
               
           }
           ce+=EstadistcasSimulacion.tiempo;
           countce++;
           seleccion212();
       } 
   }
   public void seleccion211() throws InterruptedException{//Va de D-G
       Simulacion unaSimulacion = Simulacion.getInstance();
       unaSimulacion.repaint();
       Thread.sleep(100);
       EstadistcasSimulacion.tiempo=uniforme(4,6,Math.random());
       EstadistcasSimulacion.label4.setText(""+EstadistcasSimulacion.tiempo);
       EstadistcasSimulacion.tiempoTotal+=EstadistcasSimulacion.tiempo;
       EstadistcasSimulacion.label6.setText(""+EstadistcasSimulacion.tiempoTotal);
       EstadistcasSimulacion.camino+="-G";
       EstadistcasSimulacion.label5.setText(EstadistcasSimulacion.camino);
       for(int i=0; i<=100; i+=10){
           x+=16;
           y+=14;
           unaSimulacion.repaint();
           Thread.sleep(delay*(int)EstadistcasSimulacion.tiempo);
       }
       dg+=EstadistcasSimulacion.tiempo;
       countdg++;
       unaSimulacion.repaint();
       Thread.sleep(1000);
   }
   public void seleccion212() throws InterruptedException{//Va de E-G
       EstadistcasSimulacion.tiempo=uniforme(5,6,Math.random());
       EstadistcasSimulacion.label4.setText(""+EstadistcasSimulacion.tiempo);
       EstadistcasSimulacion.tiempoTotal+=EstadistcasSimulacion.tiempo;
       EstadistcasSimulacion.label6.setText(""+EstadistcasSimulacion.tiempoTotal);
       EstadistcasSimulacion.camino+="-G";
       EstadistcasSimulacion.label5.setText(EstadistcasSimulacion.camino);
       Simulacion unaSimulacion = Simulacion.getInstance();
       unaSimulacion.repaint();
       Thread.sleep(100);
       for(int i=0; i<=100; i+=10){
           x+=27;
         
           unaSimulacion.repaint();
           Thread.sleep(delay*(int)EstadistcasSimulacion.tiempo);
       }
       eg+=EstadistcasSimulacion.tiempo;
       counteg++;
       unaSimulacion.repaint();
       Thread.sleep(1000);
   }
   public void seleccion221() throws InterruptedException{//Va F-G
       
       Simulacion unaSimulacion = Simulacion.getInstance();
       unaSimulacion.repaint();
       Thread.sleep(100);
       EstadistcasSimulacion.tiempo=uniforme(6,9,Math.random());
       EstadistcasSimulacion.label4.setText(""+EstadistcasSimulacion.tiempo);
       EstadistcasSimulacion.tiempoTotal+=EstadistcasSimulacion.tiempo;
       EstadistcasSimulacion.label6.setText(""+EstadistcasSimulacion.tiempoTotal);
       EstadistcasSimulacion.camino+="-G";
       EstadistcasSimulacion.label5.setText(EstadistcasSimulacion.camino);
       for(int i=0; i<=100; i+=10){
           x+=16;
           y-=14;
           unaSimulacion.repaint();
           Thread.sleep(delay*(int)EstadistcasSimulacion.tiempo);
       }
       fg+=EstadistcasSimulacion.tiempo;
       countfg++;
       unaSimulacion.repaint();
       Thread.sleep(1000);
   }
   public double uniforme(double a, double b, double aleatorio){
       return a+aleatorio*(b-a);
   }

   
   
}
