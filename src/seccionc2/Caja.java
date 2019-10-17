/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seccionc2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JTable;

/**
 *
 * @author oscar
 */
public class Caja {
    Tabla tabla;
    boolean contenedorlleno = false;
    int capacidad;
    Queue queue = new LinkedList<>();
    Lock aLock = new ReentrantLock();
    Condition noHayProd = aLock.newCondition();
    Condition noHayLugar = aLock.newCondition();
    //private int id;
    
    public Caja(Tabla tablita){
        tabla = tablita;
    }
    
    
    public int get(int idGet, int t){
        System.out.println("get no. antes->"+idGet);
        aLock.lock();
        try {
            Thread.sleep(t+500);
        } catch (InterruptedException ex) {}
     
        while (queue.isEmpty()){
            try {
                noHayProd.await();
            } 
            catch (InterruptedException e){System.err.println("Contenedor: Error en get -> " + e.getMessage());}
        }
        
        
        int valor =((Integer)queue.poll());

        System.out.println("no get despues->"+idGet);
        tabla.model.setValueAt("0", idGet, 2);
        tabla.model.setValueAt("consumidor", idGet, 3);
        tabla.model.setValueAt("0", idGet, 4);
        tabla.model.setValueAt("0", idGet, 5);
        
        noHayLugar.signalAll();
        
       aLock.unlock();
        return valor;
    }
    
    //------------PUT-------------
    
    public void put(int idPut, int t){
        aLock.lock();
        System.out.println("put no. antes->"+idPut);
        
        try {
            Thread.sleep(t+500);
        } catch (InterruptedException ex) {}
        
        
        
        while (queue.size() == capacidad){
            try {
                noHayLugar.await();
            } 
            catch (InterruptedException e){System.err.println("Contenedor: Error en get -> " + e.getMessage());}
        }
     
        System.out.println("no put despues->"+idPut);
        
        queue.offer(3);
        tabla.model.setValueAt("0", idPut, 2);
        tabla.model.setValueAt("productor", idPut, 3);
        tabla.model.setValueAt("0", idPut, 4);
        tabla.model.setValueAt("0", idPut, 5);
        
        noHayProd.signalAll();
        
        aLock.unlock();
        
    }

    void recibeTamBufer(int no){
        capacidad=no;
    }
    
}
