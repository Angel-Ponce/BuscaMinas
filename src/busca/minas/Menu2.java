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
        
        boton[0].setText("FACIL");
        boton[1].setText("MEDIO");
        boton[2].setText("DEMENTE");
        
       boton[0].setForeground(Color.black);
       boton[0].setBackground(Color.cyan);
       boton[0].setFont(new Font("Stencil",Font.BOLD,16));
       
       boton[1].setForeground(Color.black);
       boton[1].setBackground(Color.yellow);
       boton[1].setFont(new Font("Stencil",Font.BOLD,16));
       
       boton[2].setForeground(Color.black);
       boton[2].setBackground(Color.green);
       boton[2].setFont(new Font("Stencil",Font.BOLD,16));
       
        boton[3].setText("REGRESAR");
        boton[3].setSize(135,40);
        boton[3].setLocation(0,518);
        boton[3].setForeground(Color.BLACK);
        boton[3].setBackground(Color.red);
        boton[3].setFont(new Font("Stencil",Font.BOLD,16));
        boton[3].setVisible(true);
        panelm.add(boton[3],0);
        
        boton[4].setText("RECORDS");
        boton[4].setSize(135,40);
        boton[4].setLocation(416,518);
        boton[4].setForeground(Color.BLACK);
        boton[4].setBackground(Color.red);
        boton[4].setVisible(true);
        boton[4].setFont(new Font("Stencil",Font.BOLD,16));
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
        
        boton[0].addMouseListener(new MouseAdapter(){
            
            @Override
            public void mousePressed(MouseEvent e){
                
                //Principal ob = new Principal(0);
                
            
           
            nombre = JOptionPane.showInputDialog(ventana,"Nombre del jugador","Nick");
            
            if(nombre!=null){    
            
            if(nombre.equals(null) || nombre.equals("") || nombre.equals("Nick")){
                JOptionPane.showMessageDialog(ventana,"Necesita un nombre para poder jugar");
            }else{
            ventanam.dispose();
            Graficos juego = new Graficos();
            juego.crearVentana();
            juego.crearCuadricula();
            juego.crearBotones();
            juego.dibujarMinas(1);
            }
          
            }
            }
        });
        
        boton[1].addMouseListener(new MouseAdapter(){
            
            public void mousePressed(MouseEvent e){
                //Principal ob = new Principal(1);
           
            nombre = JOptionPane.showInputDialog(ventana,"Nombre del jugador","Nick");
            
            if(nombre!=null){
            if(nombre.equals(null) || nombre.equals("") || nombre.equals("Nick")){
                JOptionPane.showMessageDialog(ventana,"Necesita un nombre para poder jugar");
            }else{
            ventanam.dispose();
            Graficos juego = new Graficos();
            juego.crearVentana();
            juego.crearCuadricula();
            juego.crearBotones();
            juego.dibujarMinas(2);
            }
            }
            
            }
        });
        
        boton[2].addMouseListener(new MouseAdapter(){
            
            public void mousePressed(MouseEvent e){
           //Principal ob = new Principal(3);
                
            nombre = JOptionPane.showInputDialog(ventana,"Nombre del jugador","Nick");
           
            if(nombre!=null){
            if(nombre.equals(null) || nombre.equals("") || nombre.equals("Nick")){
                JOptionPane.showMessageDialog(ventana,"Necesita un nombre para poder jugar");
            }else{
            ventanam.dispose();
            Graficos juego = new Graficos();
            juego.crearVentana();
            juego.crearCuadricula();
            juego.crearBotones();
            juego.dibujarMinas(3);
            }
            }
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
      
    
}
