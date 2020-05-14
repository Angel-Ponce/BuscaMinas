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
 * Clase Menu2: en esta clase se encuenta toda la estructura de la segunda pantalla, en la cual se encontraran los botones de las dificultades y el boton que nos dirige hacia la vantana de records
 * @author Sergio Morán
 * @author Angel Ponce
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
    /***
     * Metodo Menu: aquí se colocaron todos los componentes que forman nuestra ventana.
     */
    public void menu(){
        
        boton = new JButton[5];
       for(int x=0; x<boton.length; x++){
           boton[x] = new JButton();
           
       }
        
       ventanam = new JFrame();
       ventanam = new JFrame("BUSCAMINAS");
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
        
       fondom = new JLabel(new ImageIcon("Buscaminas2.png"));
       fondom.setSize(558,558);
       fondom.setOpaque(true);
       fondom.setVisible(true);
       panelm.add(fondom,0);
       
       panelm.repaint();
        
        boton[0].setText("FÁCIL");
        boton[1].setText("MEDIO");
        boton[2].setText("DEMENTE");
        
       boton[0].setForeground(Color.BLACK);
       boton[0].setBackground(new Color(250,85,85));
       boton[0].setFont(new Font("Cooper Black",Font.BOLD,16));
       
       boton[1].setForeground(Color.BLACK);
       boton[1].setBackground(new Color(250,50,50));
       boton[1].setFont(new Font("Cooper Black",Font.BOLD,16));
       
       boton[2].setForeground(Color.BLACK);
       boton[2].setBackground(Color.RED);
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
    /***
     * Metodo eventosmenu: aquí se hace el llamado a las acciones del metodo mousePressed.
     */
    public void eventosmenu(){
        Emergentes nombres = new Emergentes();
        Graficos jugador = new Graficos();
        boton[0].addMouseListener(new MouseAdapter(){
            
            @Override
            /***
             * MetodomousePressed: este metodo llama a las acciones del click cuando se presione sobre el boton "FÁCIL".
             * @param e
             * Recibe el parametro e el cual le indica que debe realizar la acción una vez se apriete el boton.
             */
            public void mousePressed(MouseEvent e){
                
            jugador.setDificultad("FÁCIL");
            dificultad = "FÁCIL";
            ventanam.dispose();
            nombres.pedirNombre(1);
            }
        });
        
        boton[1].addMouseListener(new MouseAdapter(){
            /***
             * MetodomousePressed: este metodo llama a las acciones del click cuando se presione sobre el boton "MEDIO".
             * @param e 
             * Recibe el parametro e el cual le indica que debe realizar la acción una vez se apriete el boton.
             */
            public void mousePressed(MouseEvent e){
                //Principal ob = new Principal(1);
             jugador.setDificultad("MEDIO");
            dificultad = "MEDIO";
            ventanam.dispose();
            nombres.pedirNombre(2);
           
            
            }
        });
        
        boton[2].addMouseListener(new MouseAdapter(){
            /***
             * MetodomousePressed: este metodo llama a las acciones del click cuando se presione sobre el boton "DEMENTE".
             * @param e 
             * Recibe el parametro e el cual le indica que debe realizar la acción una vez se apriete el boton.
             */
            public void mousePressed(MouseEvent e){
             jugador.setDificultad("DEMENTE");
            dificultad = "DEMENTE";
            ventanam.dispose();
            nombres.pedirNombre(3);
          
            }
        });
        
        boton[3].addMouseListener(new MouseAdapter(){
            /***
             * MetodomousePressed: este metodo llama a la clase Menu. 
             * @param e 
             * Recibe el parametro e el cual le indica que debe realizar la acción una vez se apriete el boton.
             */
            public void mousePressed(MouseEvent e){
                
                ventanam.dispose();
                Menu ob = new Menu();
                ob.iniciar();
                
            }
        });
        
        boton[4].addMouseListener(new MouseAdapter(){
            /***
             * MetodomousePressed: este metodo llama a la clase Record.
             * @param e 
             * Recibe el parametro e el cual le indica que debe realizar la acción una vez se apriete el boton.
             */
           public void mousePressed(MouseEvent e){
           Record ob = new Record();
           ob.records();
           ventanam.setVisible(false);
              
            }
        });
        
    }
    
    /***
     * Metodo enviarPunteo: aqui se mandan los punteos a la clase Record.
     * @param h 
     * Recibe el parametro h el cual nos indica el punteo del jugador ingresado.
     */
    public void  enviarPunteo(int h){
       punteo = h;
    }
    /***
     * Metodo agregarJugador: aquí se le manda los nombres ingresados a un .txt para luego poder usarlos en la clase record.
     * @param nombre
     * Recibe el parametro nombre que nos indica el nombre del jugador ingresado.
     * @param dificultad
     * Recibe el parametro dificultad que nos indica la dificultad del jugador ingresado.
     * @param score
     * Recibe el parametro score que nos indica el score del jugador ingresado.
     * @return 
     * Retorna la variable nombre hacia la clase record.
     */
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
     * Metodo getDificultad: aquí se toma la dificultad.
     * @return the dificultad
     * Retorna la variable dificultad hacia la clase Record
     */
    public String getDificultad() {
        return dificultad;
    }

    /**
     * Metodo set Dificultad: aqui se le modifica la dificultad a otra variable. 
     * @param dificultad the dificultad to set
     * Recibe el parametro dificultad, para alamacenarlo en otra vareable.
     */
    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
    
}
