/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seccionc2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

/**
 *
 * @author oscar
 */
public class Controlador implements ActionListener{
    
    Thread[] hilo;

    private boolean empezar = false;

    
    
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Iniciar")){
            empezar = true;
            SeccionC2.comenzar(empezar);            
        }
        
        if (e.getActionCommand().equals("Alto")){
            
            for(int i=0; i<hilo.length/2; i++){
                ((Consumidor)hilo[i]).kill();
            }
            for(int i=(hilo.length/2); i<hilo.length; i++){
                ((Productor)hilo[i]).kill();
            }
            System.out.println("click en matar");
        }
        
        
    }
    
    void getHilo(Thread[] h){
        hilo = h;
    }
    
    boolean devuelveIndicacion(){
        return empezar;
    }

}

