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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sergio Morán
 */
public class Menu2 {
    
    JFrame ventana;
     JFrame ventanam;
    //Primera pantalla
    JPanel panel;
    JButton comenzar;
    JLabel fondo;

    
    //Seleccion  del juego
    String nombre;
    JButton boton[];
    JPanel panelm;
    JLabel fondom;
    private static String dificultad;
    
    static public int punteo;
    
    public void menu(){
        
        boton = new JButton[5];
       for(int x=0; x<boton.length; x++){
           boton[x] = new JButton();
           
       }
        
       ventanam = new JFrame();
       ventanam = new JFrame("Buscaminas");
       ventanam.setSize(558,586);
       ventanam.setLayout(null);
       ventanam.setLocationRelativeTo(null);
       ventanam.setResizable(false);
       ventanam.setVisible(true);
       ventanam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //panel.setVisible(true);
        panelm = new JPanel();
        panelm.setLayout(null);
        panelm.setBounds(0, 0, ventanam.getWidth(), ventanam.getHeight());
        panelm.setVisible(true);
        ventanam.add(panelm);
        
       fondom = new JLabel(new ImageIcon("Buscaminas.png"));
       fondom.setSize(558,558);
       fondom.setOpaque(true);
       fondom.setVisible(true);
       panelm.add(fondom,0);
       
       panelm.repaint();
        
        boton[0].setText("FÁCIL");
        boton[1].setText("MEDIO");
        boton[2].setText("DEMENTE");
        
       boton[0].setForeground(Color.black);
       boton[0].setBackground(Color.cyan);
       boton[0].setFont(new Font("Cooper Black",Font.BOLD,16));
       
       boton[1].setForeground(Color.black);
       boton[1].setBackground(Color.yellow);
       boton[1].setFont(new Font("Cooper Black",Font.BOLD,16));
       
       boton[2].setForeground(Color.black);
       boton[2].setBackground(Color.green);
       boton[2].setFont(new Font("Cooper Black",Font.BOLD,15));
       
        boton[3].setText("REGRESAR");
        boton[3].setSize(140,40);
        boton[3].setLocation(0,518);
        boton[3].setForeground(Color.BLACK);
        boton[3].setBackground(Color.red);
        boton[3].setFont(new Font("Cooper Black",Font.BOLD,16));
        boton[3].setVisible(true);
        panelm.add(boton[3],0);
        
        boton[4].setText("RECORDS");
        boton[4].setSize(135,40);
        boton[4].setLocation(416,518);
        boton[4].setForeground(Color.BLACK);
        boton[4].setBackground(Color.red);
        boton[4].setVisible(true);
        boton[4].setFont(new Font("Cooper Black",Font.BOLD,16));
        panelm.add(boton[4],0);
       
        for(int x=0; x<3; x++){
            boton[x].setBounds(220,(x+3)*60,120,50);
            boton[x].setVisible(true);
            panelm.add(boton[x],0);
            
        }
        
        panelm.repaint();
        eventosmenu();
        
    }
    
    public void eventosmenu(){
        Emergentes nombres = new Emergentes();
        Graficos jugador = new Graficos();
        boton[0].addMouseListener(new MouseAdapter(){
            
            @Override
            public void mousePressed(MouseEvent e){
                
            jugador.setDificultad("FÁCIL");
            dificultad = "FÁCIL";
            ventanam.dispose();
            nombres.pedirNombre(1);
            }
        });
        
        boton[1].addMouseListener(new MouseAdapter(){
            
            public void mousePressed(MouseEvent e){
                //Principal ob = new Principal(1);
             jugador.setDificultad("MEDIO");
            dificultad = "MEDIO";
            ventanam.dispose();
            nombres.pedirNombre(2);
           
            
            }
        });
        
        boton[2].addMouseListener(new MouseAdapter(){
            
            public void mousePressed(MouseEvent e){
             jugador.setDificultad("DEMENTE");
            dificultad = "DEMENTE";
            ventanam.dispose();
            nombres.pedirNombre(3);
          
            }
        });
        
        boton[3].addMouseListener(new MouseAdapter(){
            
            public void mousePressed(MouseEvent e){
                
                ventanam.dispose();
                Menu ob = new Menu();
                ob.iniciar();
                
            }
        });
        
        boton[4].addMouseListener(new MouseAdapter(){
            
           public void mousePressed(MouseEvent e){
           Record ob = new Record();
           ob.records();
           ventanam.setVisible(false);
              
            }
        });
        
    }
    
    
    public void  enviarPunteo(int h){
       punteo = h;
    }
    
    public String agregarJugador(String nombre, String dificultad, int score){
            FileWriter fichero = null;
            PrintWriter pw = null;
            try{ 
                fichero = new FileWriter("Records.txt",true);
                pw = new PrintWriter(fichero);
                
                pw.println(nombre+","+dificultad+","+score);
        
            }catch(FileNotFoundException ex){  
            }catch(IOException er){
                
            }
            finally {
                try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                   fichero.close();
                } catch (Exception e2) {
                   e2.printStackTrace();
                }
             }
            return nombre;
            }

    /**
     * @return the dificultad
     */
    public String getDificultad() {
        return dificultad;
    }

    /**
     * @param dificultad the dificultad to set
     */
    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
    
}
