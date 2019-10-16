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
    private static Consumidor[] consumidor;
    private static Caja caja;
    private static Ventana win;
    private static Tabla tablita;
    
    private static boolean empezar=false;
    static int noHilos;
    static JTable tabla;

    public static void main(String[] args) {
        
        control = new Controlador();
        
        win = new Ventana(control);    

    }
    
    public static void comenzar(boolean empezar){
        if(empezar){
                      
            noHilos=win.getNoHilos();
            int tiempo=win.getTiempo();
            
            tablita = new Tabla(noHilos, control);
            tablita.create();
            caja = new Caja(tablita);
            JTable tabla=win.getTable();
          
            
            consumidor = new Consumidor[noHilos];
            
            for(int i=0; i<noHilos;i++){
                
                consumidor[i] = new Consumidor(caja, tiempo, tablita, i);
                consumidor[i].start();
                //control.getHilo(consumidor[i]);
                
                caja.recibeNoHilos(i);
                
            }
            control.getHilo(consumidor);
        }
    }
    
}
