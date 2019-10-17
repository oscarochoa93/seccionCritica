/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seccionc2;

/**
 *
 * @author oscar
 */
public class Productor extends Thread{
     boolean condicion=true;
    int id;
    int tiempo;
    int conteo;
    Caja caja;
    Tabla tabla;
    
    
    public Productor (Caja x, int t, Tabla ta, int nH){
        caja = x;
        tiempo = t;
        tabla = ta;
        id = nH;
    }
    
    public void run(){
        System.out.println("productor ->"+id);
        while(condicion){

            esperando();
            caja.put(id, tiempo);
            conteo++;
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {}
            
            esperando();            
        }
        System.out.println("afuera");
        seMurio();
        
    }
    
    public void kill(){
        //se estan muriendo
        
        tabla.model.setValueAt("0", id, 2);
        tabla.model.setValueAt("0", id, 3);
        tabla.model.setValueAt("muriendo", id, 4);
        tabla.model.setValueAt("0", id, 5);
        
        condicion = false;
        System.out.println("fn matar activada");
    }
    
    public void esperando (){
        
        tabla.model.setValueAt(conteo +" ", id, 1);
        tabla.model.setValueAt("esperando", id, 2);
        tabla.model.setValueAt("0", id, 3);
        tabla.model.setValueAt("0", id, 4);
        tabla.model.setValueAt("0", id, 5);
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {}

    }
    
    public void seMurio(){
        System.out.println("dentro semurio");
        tabla.model.setValueAt("0", id, 2);
        tabla.model.setValueAt("0", id, 3);
        tabla.model.setValueAt("0", id, 4);
        tabla.model.setValueAt("dead", id, 5);
    }
    
}
