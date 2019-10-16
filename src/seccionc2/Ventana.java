/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seccionc2;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author oscar
 */
public class Ventana extends JFrame{

    
    private JButton empezar, parar;
    private JLabel tex1, tex2;
    private JTextArea noHilos, tiempo;
    JTable table;
    Canvas c1;
    

            
    //Controlador esc = new Controlador();
    
    public Ventana(Controlador esc){
        super("Ventana");
        setSize(300, 100);      
        
        BorderLayout border = new BorderLayout();
        setLayout(border);
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(3,2);
        panel.setLayout(grid);
        add(panel, BorderLayout.CENTER);
        
        noHilos = new JTextArea("0");
        tiempo = new JTextArea();
        tex1 = new JLabel("No. Hilos:");
        tex2 = new JLabel("No. tiempo:");
        
        empezar = new JButton("Iniciar");
        empezar.addActionListener(esc);
        parar= new JButton("Alto");
        parar.addActionListener(esc);
        
        panel.add(tex1);
        panel.add(noHilos);
        panel.add(tex2);
        panel.add(tiempo);
        panel.add(empezar);
        panel.add(parar);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }
    
    
    public int getNoHilos(){
        return Integer.parseInt(noHilos.getText());
    }
    public int getTiempo(){
        return Integer.parseInt(tiempo.getText());
    }
    public JTable getTable(){
        return table;
    }

    
}
