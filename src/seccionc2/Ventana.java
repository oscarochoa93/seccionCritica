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
    private JLabel tex1, tex2, tex3,tex4;
    private JTextArea noHilos, texTiempoCons, texTiempoProd, tamanoBufer;
    JTable table;
    Canvas c1;
    

            
    //Controlador esc = new Controlador();
    
    public Ventana(Controlador esc){
        super("Ventana");
        setSize(300, 200);      
        
        BorderLayout border = new BorderLayout();
        setLayout(border);
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(5,2);
        panel.setLayout(grid);
        add(panel, BorderLayout.CENTER);
        
        noHilos = new JTextArea("0");
        texTiempoCons = new JTextArea();
        texTiempoProd = new JTextArea();
        tamanoBufer = new JTextArea();
        
        tex1 = new JLabel("No. Hilos:");
        tex2 = new JLabel("No. tiempo cons:");
        tex3 = new JLabel("No. tiempo prod:");
        tex4 = new JLabel("Tamano del bufer:");
        
        empezar = new JButton("Iniciar");
        empezar.addActionListener(esc);
        parar= new JButton("Alto");
        parar.addActionListener(esc);
        
        panel.add(tex1);
        panel.add(noHilos);
        panel.add(tex2);
        panel.add(texTiempoCons);
        panel.add(tex3);
        panel.add(texTiempoProd);
        panel.add(tex4);
        panel.add(tamanoBufer);
        
        panel.add(empezar);
        panel.add(parar);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }
    
    
    public int getNoHilos(){
        return Integer.parseInt(noHilos.getText());
    }
    public int getTiempo(){
        return Integer.parseInt(texTiempoCons.getText());
    }
    public int getTiempoProd(){
        return Integer.parseInt(texTiempoProd.getText());
    }
    public int gettamBufer(){
        return Integer.parseInt(tamanoBufer.getText());
    }
    public JTable getTable(){
        return table;
    }

    
}
