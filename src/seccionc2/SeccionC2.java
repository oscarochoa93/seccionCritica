/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seccionc2;

import javax.swing.JTable;

/**
 *
 * @author oscar
 */
public class SeccionC2 {
    private static Controlador control;
    private static Thread[] hilos;
    private static Caja caja;
    private static Ventana win;
    private static Tabla tablita;
    
    private static boolean empezar=false;
    static int noHilos;
    static int tiempo;
    static int timepoProd;
    static int tamBuf;
    
    static JTable tabla;

    public static void main(String[] args) {
        
        control = new Controlador();
        
        win = new Ventana(control);    

    }
    
    public static void comenzar(boolean empezar){
        if(empezar){
                      
            noHilos=win.getNoHilos();
            tiempo=win.getTiempo();
            timepoProd=win.getTiempoProd();
            tamBuf=win.gettamBufer();
            
            tablita = new Tabla(noHilos, control);
            tablita.create();
            caja = new Caja(tablita);
            JTable tabla=win.getTable();
          
            
            hilos = new Thread[noHilos];

            caja.recibeTamBufer(tamBuf);
            for(int i=0; i<noHilos/2;i++){
                System.out.println("no for->"+i);
                
                hilos[i] = new Consumidor(caja, tiempo, tablita, i);
                hilos[i].start();

                                
            }
            for(int j=(noHilos/2); j<noHilos;j++){
           
                hilos[j] = new Productor(caja, timepoProd, tablita, j);
                hilos[j].start();
                                
            }

            control.getHilo(hilos);
        }
    }
    
}
