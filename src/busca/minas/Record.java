/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.minas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author atera
 */
public class Record {
    
    JFrame ventanaRecords;
    JPanel panelRecord;
    JLabel fondoRecord;
    JLabel listadoGanadores[];
    JLabel titulo;
    JButton regresar;
    
    public void records(){
        
       ventanaRecords = new JFrame("Buscaminas");
       ventanaRecords.setSize(558,586);
       ventanaRecords.setLayout(null);
       ventanaRecords.setLocationRelativeTo(null);
       ventanaRecords.setResizable(false);
       ventanaRecords.setVisible(true);
       ventanaRecords.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       panelRecord = new JPanel();
       panelRecord.setLayout(null);
       panelRecord.setSize(558,558);
       panelRecord.setVisible(true);
       
       ventanaRecords.add(panelRecord);
       regresar = new JButton();
       regresar.setText("REGRESAR");
        regresar.setSize(135,40);
        regresar.setLocation(425,518);
        regresar.setForeground(Color.BLACK);
        regresar.setBackground(Color.red);
        regresar.setVisible(true);
        regresar.setFont(new Font("Cooper Black",Font.BOLD,16));
        panelRecord.add(regresar,0);
       
        
       fondoRecord = new JLabel(new ImageIcon("Buscaminas.png"));
       fondoRecord.setSize(558,558);
       fondoRecord.setOpaque(true);
       fondoRecord.setVisible(true);
       panelRecord.add(fondoRecord,0);
       panelRecord.repaint();
       
       listado();
       
       regresar.addMouseListener(new MouseAdapter(){
          
           public void mousePressed(MouseEvent e){
               
               Menu2 ob = new Menu2();
               ob.menu();
               
               ventanaRecords.setVisible(false);
           }
           
       });
       
    }
    
    public void listado(){
        
        listadoGanadores = new JLabel[5];
       for(int x=0; x<listadoGanadores.length; x++){
           listadoGanadores[x] = new JLabel();
           
       }
       
        
        for(int x=0; x<5; x++){
        listadoGanadores[x].setText("Jugador: " + (x+1));
        listadoGanadores[x].setForeground(Color.black);
        listadoGanadores[x].setFont(new Font("Times New Roman",Font.BOLD,16));
        listadoGanadores[x].setBounds(220,(x+4)*40,120,50);
        listadoGanadores[x].setVisible(true);
        //listadoGanadores[x].setOpaque(true);
        panelRecord.add(listadoGanadores[x],0);
        //panelRecord.repaint();
        
        
        }
        panelRecord.repaint();
    }
    
}
