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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
    JButton facil;
    JButton medio;
    JButton demente;
    ArrayList<JButton> botonesLista = new ArrayList();
    int x=0;
    ArrayList<String> jugadoresFacil   = new ArrayList();
    ArrayList<String> jugadoresMedio   = new ArrayList();
    ArrayList<String> jugadoresDemente = new ArrayList();
    
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
       
       fondoRecord = new JLabel(new ImageIcon("Buscaminas.png"));
       fondoRecord.setSize(558,558);
       fondoRecord.setOpaque(true);
       fondoRecord.setVisible(true);
       panelRecord.add(fondoRecord,0);
   
       //panelRecord.repaint();
      // ventanaRecords.add(panelRecord);
       regresar = new JButton();
       regresar.setText("REGRESAR");
       regresar.setSize(140,40);
       regresar.setLocation(415,518);
       regresar.setForeground(Color.BLACK);
       regresar.setBackground(Color.red);
       regresar.setVisible(true);
       regresar.setFont(new Font("Cooper Black",Font.BOLD,16));
       panelRecord.add(regresar,0);
       
        
       //panelRecord.repaint();
         
       facil = new JButton();
       medio = new JButton();
       demente = new JButton();
       
       facil.setText("FACIL");
       medio.setText("MEDIO");
       demente.setText("DEMENTE");
        
       facil.setForeground(Color.black);
       facil.setBackground(Color.cyan);
       facil.setFont(new Font("Cooper Black",Font.BOLD,16));
       facil.setVisible(true);
       facil.setBounds(218,180,120,50);
       panelRecord.add(facil,0);
       
       medio.setForeground(Color.black);
       medio.setBackground(Color.yellow);
       medio.setFont(new Font("Cooper Black",Font.BOLD,16));
       medio.setVisible(true);
       medio.setBounds(218,240,120,50);
       panelRecord.add(medio,0);
      
       
       demente.setForeground(Color.black);
       demente.setBackground(Color.green);
       demente.setFont(new Font("Cooper Black",Font.BOLD,15));
       demente.setVisible(true);
       demente.setBounds(218,300,120,50);
       panelRecord.add(demente,0);
        
            panelRecord.repaint();
     
       botonesLista.add(demente);
       botonesLista.add(medio);
       botonesLista.add(facil);
        
       eventoClick();
      
//       for(JButton boton: botonesLista){
//            boton.setBounds(220,(x+3)*60,120,50);
//            boton.setVisible(true);
//            panelRecord.add(boton,0);  
//        }
       
       //panelRecord.repaint();
              
        
 
    }
    public void eventoClick(){
        facil.addMouseListener(new MouseAdapter(){
          
           public void mousePressed(MouseEvent e){
               
              listado(0);
               for(JButton botones: botonesLista){
                   botones.setVisible(false);
                
               }
           }
           
       });
         medio.addMouseListener(new MouseAdapter(){
          
           public void mousePressed(MouseEvent e){
               
               listado(1);
               for(JButton botones: botonesLista){
                   botones.setVisible(false);
                
               }
           }
           
       });
          demente.addMouseListener(new MouseAdapter(){
          
           public void mousePressed(MouseEvent e){
               
               listado(2);
               for(JButton botones: botonesLista){
                   botones.setVisible(false);
                
               }
           }
           
       });
          
       
       regresar.addMouseListener(new MouseAdapter(){
          
           public void mousePressed(MouseEvent e){
               
               Menu2 ob = new Menu2();
               ob.menu();
               jugadoresFacil.clear();  
               jugadoresMedio.clear();
               jugadoresDemente.clear();
               ventanaRecords.setVisible(false);
           }
           
       });
    }
    public void listado(int categoria){
        leerRecords();
        int longitud;
        switch(categoria){
            
            case 0: longitud = jugadoresFacil.size();
             listadoGanadores = new JLabel[longitud];
       for(int x=0; x<longitud; x++){
           listadoGanadores[x] = new JLabel();  
       }
       
        for(int x=0; x<longitud; x++){
        listadoGanadores[x].setText(jugadoresFacil.get(x));
        listadoGanadores[x].setForeground(Color.black);
        listadoGanadores[x].setFont(new Font("Cooper Black",Font.BOLD,15));
        listadoGanadores[x].setHorizontalAlignment(SwingConstants.CENTER);
        listadoGanadores[x].setBounds(170,(x+4)*40,220,50);
        listadoGanadores[x].setVisible(true);
        panelRecord.add(listadoGanadores[x],0);
        }
       panelRecord.repaint();
                break;
            case 1: longitud = jugadoresMedio.size();
            listadoGanadores = new JLabel[longitud];
       for(int x=0; x<longitud; x++){
           listadoGanadores[x] = new JLabel();  
       }
        
       
       
        for(int x=0; x<longitud; x++){
        listadoGanadores[x].setText(jugadoresMedio.get(x));
        listadoGanadores[x].setForeground(Color.black);
        listadoGanadores[x].setFont(new Font("Cooper Black",Font.BOLD,15));
        listadoGanadores[x].setHorizontalAlignment(SwingConstants.CENTER);
        listadoGanadores[x].setBounds(170,(x+4)*40,220,50);
        listadoGanadores[x].setVisible(true);
        panelRecord.add(listadoGanadores[x],0);
        }
       panelRecord.repaint();
                break;
            case 2: longitud = jugadoresDemente.size();
            listadoGanadores = new JLabel[longitud];
       for(int x=0; x<longitud; x++){
           listadoGanadores[x] = new JLabel();  
       }
        
       
       
        for(int x=0; x<longitud; x++){
        listadoGanadores[x].setText(jugadoresDemente.get(x));
        listadoGanadores[x].setForeground(Color.black);
        listadoGanadores[x].setFont(new Font("Cooper Black",Font.BOLD,15));
        listadoGanadores[x].setHorizontalAlignment(SwingConstants.CENTER);
        listadoGanadores[x].setBounds(170,(x+4)*40,220,50);
        listadoGanadores[x].setVisible(true);
        panelRecord.add(listadoGanadores[x],0);
        }
        panelRecord.repaint();
                break;
            default:
                break;
        }
        
       
        
    }
    
    
    public void leerRecords(){
        File texto = null;
        FileReader textoR = null;
        BufferedReader textoB = null;
        String linea;
        try{
            texto = new File("Records.txt");
            textoR = new FileReader(texto);
            textoB = new BufferedReader(textoR);
            
            while((linea=textoB.readLine())!= null){
                System.out.println(linea);
                String[] ln = linea.split(",");
                
                    System.out.println(ln[1]);
                    
                switch(ln[1]){
                    case "FÁCIL":
                        jugadoresFacil.add(ln[0]+" record: "+ln[2]);
                        break;
                    case "MEDIO":
                        jugadoresMedio.add(ln[0]+" record: "+ln[2]);
                        break;
                    case "DEMENTE":
                        jugadoresDemente.add(ln[0]+" record: "+ln[2]);
                        break;
                    default:
                        break;
            }
                    
            }
        }catch(IOException er){
            
        }
    }
    
}
