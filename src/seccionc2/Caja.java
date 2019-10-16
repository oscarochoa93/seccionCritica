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
public class Caja {
    Tabla tabla;
    //private int id;
    
    public Caja(Tabla tablita){
        tabla = tablita;
    }
    
    
    public synchronized void seccionCritica(int id, int t){
        try {
            Thread.sleep(t+500);
        } catch (InterruptedException ex) {}
     

        tabla.model.setValueAt("0", id, 2);
        tabla.model.setValueAt("dentro", id, 3);
        tabla.model.setValueAt("0", id, 4);
        tabla.model.setValueAt("0", id, 5);
        
             try {
                Thread.sleep(t);
            } catch (InterruptedException ex) {}
            
        
    }

    void recibeNoHilos(int no){
        //id=no;
    }
    
}
