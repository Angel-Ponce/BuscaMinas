/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.minas;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Angel
 */
public class Emergentes extends JFrame{
    JFrame ventanaEmergente;
    JPanel lienzoEmergente;
    JLabel textoEmergente;
    JButton aceptarEmergente;
    JLabel fondoEmergente;
    TextField areaNombre;
    int alto = 200;
    int ancho = 400;
    static boolean  scape = false;
    String nombre;
    private static boolean boton=false;
    
    public void estadoWin(int punteo){
        setBoton(true);
        ventanaEmergente = new JFrame();
        ventanaEmergente.setLocationRelativeTo(null);
        //ventanaEmergente.setLocation(440, 450);
        ventanaEmergente.setTitle("BUSCAMINAS");
        ventanaEmergente.setLayout(null);
        ventanaEmergente.setSize(ancho,alto);
        ventanaEmergente.setVisible(true);
        //ventanaEmergente.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventanaEmergente.setResizable(false);
        
        lienzoEmergente = new JPanel();
        lienzoEmergente.setLayout(null);
        lienzoEmergente.setSize(ancho, alto);
        lienzoEmergente.setLocation(0, 0);
        lienzoEmergente.setBackground(Color.gray);
        lienzoEmergente.setVisible(true);
        ventanaEmergente.add(lienzoEmergente,0);
        
        fondoEmergente = new  JLabel(new ImageIcon("Trofeo.png"));
        fondoEmergente.setSize(128, 128);
        fondoEmergente.setVisible(true);
        fondoEmergente.setLocation(0,50);
        lienzoEmergente.add(fondoEmergente,0);
        
        textoEmergente = new JLabel();
        textoEmergente.setSize(250,50);
        textoEmergente.setLocation(125,45);
        textoEmergente.setText("¡WINNER! Score: "+punteo);
        textoEmergente.setFont(new Font("Cooper Black",Font.BOLD,18));
        textoEmergente.setHorizontalAlignment(SwingConstants.CENTER);
        textoEmergente.setVisible(true);
        lienzoEmergente.add(textoEmergente,0);
        
        aceptarEmergente = new JButton();
        aceptarEmergente.setText("ACEPTAR");
        aceptarEmergente.setFont(new Font("Cooper Black",Font.BOLD,14));
        aceptarEmergente.setHorizontalAlignment(SwingConstants.CENTER);
        aceptarEmergente.setBounds(280,130,120,50);
        aceptarEmergente.setBackground(Color.red);
        lienzoEmergente.add(aceptarEmergente,0);
        
        eventoClick();
        lienzoEmergente.repaint();
    }
    public void estadoLose(int punteo){
        setBoton(true);
        ventanaEmergente = new JFrame();
        ventanaEmergente.setLocationRelativeTo(null);
        //ventanaEmergente.setLocation(440, 450);
        ventanaEmergente.setTitle("BUSCAMINAS");
        ventanaEmergente.setLayout(null);
        ventanaEmergente.setSize(ancho,alto);
        ventanaEmergente.setVisible(true);
        //ventanaEmergente.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventanaEmergente.setResizable(false);
        
        lienzoEmergente = new JPanel();
        lienzoEmergente.setLayout(null);
        lienzoEmergente.setSize(ancho, alto);
        lienzoEmergente.setLocation(0, 0);
        lienzoEmergente.setBackground(Color.gray);
        lienzoEmergente.setVisible(true);
        ventanaEmergente.add(lienzoEmergente,0);
        
        fondoEmergente = new  JLabel(new ImageIcon("explosion.png"));
        fondoEmergente.setSize(128, 128);
        fondoEmergente.setVisible(true);
        fondoEmergente.setLocation(0,30);
        lienzoEmergente.add(fondoEmergente,0);
        
        textoEmergente = new JLabel();
        textoEmergente.setSize(250,50);
        textoEmergente.setLocation(125,45);
        textoEmergente.setText("¡LOSER! Score: "+punteo);
        textoEmergente.setFont(new Font("Cooper Black",Font.BOLD,18));
        textoEmergente.setHorizontalAlignment(SwingConstants.CENTER);
        textoEmergente.setVisible(true);
        lienzoEmergente.add(textoEmergente,0);
        
        aceptarEmergente = new JButton();
        aceptarEmergente.setText("ACEPTAR");
        aceptarEmergente.setFont(new Font("Cooper Black",Font.BOLD,14));
        aceptarEmergente.setHorizontalAlignment(SwingConstants.CENTER);
        aceptarEmergente.setBounds(280,130,120,50);
        aceptarEmergente.setBackground(Color.red);
        lienzoEmergente.add(aceptarEmergente,0);
        
        eventoClick();
        lienzoEmergente.repaint();
        
        int fakeCerrar = ventanaEmergente.getDefaultCloseOperation();
       
     
    }
    
    public void pedirNombre(int cantidadMinas){
        ventanaEmergente = new JFrame();
        ventanaEmergente.setLocationRelativeTo(null);
        //ventanaEmergente.setLocation(440, 450);
        ventanaEmergente.setTitle("BUSCAMINAS");
        ventanaEmergente.setLayout(null);
        ventanaEmergente.setSize(ancho,alto);
        ventanaEmergente.setVisible(true);
        //ventanaEmergente.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventanaEmergente.setResizable(false);
        
        lienzoEmergente = new JPanel();
        lienzoEmergente.setLayout(null);
        lienzoEmergente.setSize(ancho, alto);
        lienzoEmergente.setLocation(0, 0);
        lienzoEmergente.setBackground(Color.gray);
        lienzoEmergente.setVisible(true);
        ventanaEmergente.add(lienzoEmergente,0);
        
        fondoEmergente = new  JLabel(new ImageIcon("user.png"));
        fondoEmergente.setSize(128, 128);
        fondoEmergente.setVisible(true);
        fondoEmergente.setLocation(0,30);
        lienzoEmergente.add(fondoEmergente,0);
        
        textoEmergente = new JLabel();
        textoEmergente.setSize(250,50);
        textoEmergente.setLocation(125,45);
        textoEmergente.setText("Dígite su nombre: ");
        textoEmergente.setFont(new Font("Cooper Black",Font.BOLD,18));
        textoEmergente.setHorizontalAlignment(SwingConstants.CENTER);
        textoEmergente.setVisible(true);
        lienzoEmergente.add(textoEmergente,0);
        
        aceptarEmergente = new JButton();
        aceptarEmergente.setText("ACEPTAR");
        aceptarEmergente.setFont(new Font("Cooper Black",Font.BOLD,14));
        aceptarEmergente.setHorizontalAlignment(SwingConstants.CENTER);
        aceptarEmergente.setBounds(280,130,120,50);
        aceptarEmergente.setBackground(Color.red);
        lienzoEmergente.add(aceptarEmergente,0);
        
        areaNombre = new TextField();
        areaNombre.setText("Nick");
        areaNombre.setBounds(160, 85, 150, 40);
        areaNombre.setBackground(Color.GRAY);
        areaNombre.setFont(new Font("Cooper Black",Font.BOLD,14));
        lienzoEmergente.add(areaNombre,0);
        
        
        
        areaNombre.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                areaNombre.setText("");
            }
        });
        
           aceptarEmergente.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                //scape=true;
                nombre = areaNombre.getText();
                ventanaEmergente.dispose();
                Menu2 salir = new Menu2();
                String dif =salir.getDificultad();
                System.out.println(dif);
                Graficos jugador = new Graficos();
                //----------------------------------------PRUEBA-----------------------------------------------
            if(nombre!=null){    
            
            if(nombre.equals(null) || nombre.equals("") || nombre.equals("Nick") || nombre.equals("Debe poner un nombre")){
                areaNombre.setText("Debe poner un nombre");
                pedirNombre(cantidadMinas);
                
            }else{
                
                jugador.setNombre(areaNombre.getText());
                jugador.setDificultad(dif);
//               
                
            ventanaEmergente.dispose();
            Graficos juego = new Graficos();
            juego.crearVentana();
            juego.crearCuadricula();
            juego.crearBotones();
            juego.dibujarMinas(cantidadMinas);
            
            }
          
            }
          //--------------------------------------------------PRUEBA---------------------------------------------
            }
        });
           
           
            ventanaEmergente.addWindowListener(new WindowAdapter(){
             @Override
             public void windowClosing(WindowEvent e){
                scape =true;
                ventanaEmergente.dispose();
                Menu2 salir = new Menu2();
                salir.menu();
             }
         });
        
    }
    
    
    
    
    public void eventoClick(){
         aceptarEmergente.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                setBoton(false);
                scape=true;
                ventanaEmergente.dispose();
                Graficos fuera =  new Graficos();
                fuera.exit();
                fuera.setBoton(isBoton());
                Menu2 salir = new Menu2();
                salir.menu();
                
            }
        });
         
         ventanaEmergente.addWindowListener(new WindowAdapter(){
             @Override
             public void windowClosing(WindowEvent e){
                setBoton(false);
                scape = true;
                ventanaEmergente.dispose();
                Graficos fuera =  new Graficos();
                fuera.exit();
                fuera.setBoton(isBoton());
                Menu2 salir = new Menu2();
                salir.menu(); 
             }
         });
    }
    
    public boolean exit(){
        return scape;
    }
    public boolean exit2(){
       if(ventanaEmergente.getDefaultCloseOperation()==0){
           scape=true;
       }
    return scape;
    }
    
    public String name(){
        System.out.println(areaNombre.getText());
        return areaNombre.getText();
    }

    /**
     * @return the boton
     */
    public static boolean isBoton() {
        return boton;
    }

    /**
     * @param aBoton the boton to set
     */
    public static void setBoton(boolean aBoton) {
        boton = aBoton;
    }
}

