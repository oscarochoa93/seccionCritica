/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seccionc2;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscar
 */
public class Tabla extends JFrame{

    private String[] header = { "Nombre", "Accesos", "Esperando", "Sección Crítica", "Muriendo", "Muerto" }; 
    private static String[][] data;
    private int noHilos;
    public DefaultTableModel model;
    private JTable table;
    Controlador control;
    
    
    // CONSTRUCTOR
    public Tabla(int h, Controlador esc) { 
        super("Tabla");
        
        noHilos = h;
        control = esc;
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        
    }
    
    // CREATE TABLE
    public void create() {

        data = new String[noHilos][6];
        
        for (int i=0; i<noHilos; i++) {
            data[i] = new String[]{"Hilo "+(i+1), "0", "x", "", "", ""};
        }
        
        model = new DefaultTableModel(data, header);
        table = new JTable(model); 
        table.setBounds(30, 40, 200, 300); 
        
        JScrollPane scroll = new JScrollPane(table); 
        add(scroll); 

        setVisible(true);
        
    }
    void recibeNoHilos(int no){
        noHilos=no;
    }


}
