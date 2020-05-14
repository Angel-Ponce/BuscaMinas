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
 *Clase Emergentes: Está clase crea las ventanas "emergentes" que indican cuando un jugador perdió, ganó, o quiera ingresar su nombre.
 * @author Angel Ponce
 * @author Sergio Morán
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
    /***
     * Método estadoWin: Este método crea una ventana pequeña que tiene propiedades gráficas especiales.
     * Es utilizado para indicarle a un jugador que ganó su juego e indicarle su puntuación total.
     * @param punteo 
     * Recibe el parámetro punteo, para escribir sobre la pantalla el punteo obtenido.
     */
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
        aceptarEmergente.setForeground(Color.BLACK);
        aceptarEmergente.setBounds(280,130,120,50);
        aceptarEmergente.setBackground(Color.red);
        lienzoEmergente.add(aceptarEmergente,0);
        
        eventoClick();
        lienzoEmergente.repaint();
    }
    /***
     * Método estadoLose: Este método crea una ventana pequeña que tiene propiedades gráficas especiales.
     * Es utilizado para indicarle al jugador que perdió su juego e indicarle su puntuación total.
     * @param punteo 
     * Recibe el parámetro punteo, para escribir sobre la pantalla el punteo obtenido.
     */
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
        aceptarEmergente.setForeground(Color.BLACK);
        aceptarEmergente.setBackground(Color.red);
        lienzoEmergente.add(aceptarEmergente,0);
        
        eventoClick();
        lienzoEmergente.repaint();
        
        int fakeCerrar = ventanaEmergente.getDefaultCloseOperation();
       
     
    }
    /***
     * Método pedirNombre: Este método sirve para crear una ventana pequeña con propiedades gráficas especiales.
     * Es utilizado para indicarle al jugador que debé ingresar su nombre, y solo podrá jugar media vez indique un nombre que sea diferente de: "", null, "Nick", "Debe poner un nombre".
     * @param cantidadMinas 
     */
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
        aceptarEmergente.setForeground(Color.BLACK);
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
            /***
             * Método mousePresed: Este método le da la propiedad al área de texto que cuando presionen un click sobre ella limpiara el texto que tenga sobre ella.
             */
            public void mousePressed(MouseEvent e){
                areaNombre.setText("");
            }
        });
        
           aceptarEmergente.addMouseListener(new MouseAdapter(){
            @Override
            /***
             * Método mosuePressed: Este método está instanciado para el botón "Aceptar" que incluye la ventana emergente pediNombre();
             * Sirve para saber si el jugador ha ingresado un nombre correcto y que inicié o no su juego.
             */
            public void mousePressed(MouseEvent e){
                //scape=true;
                nombre = areaNombre.getText();
                ventanaEmergente.dispose();
                Menu2 salir = new Menu2();
                String dif =salir.getDificultad();
                System.out.println(dif);
                Graficos jugador = new Graficos();
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
            }
        });
           
           
            ventanaEmergente.addWindowListener(new WindowAdapter(){
             @Override
             /***
              * Método windowClosing: Este método es sobre escrito para cambiar las propiedades del botón "X" de la ventana emergente.
              * Es utilizado para que en lugar de cerrar la ventana únicamente también regrese al menú de selección de dificultad.
              */
             public void windowClosing(WindowEvent e){
                scape =true;
                ventanaEmergente.dispose();
                Menu2 salir = new Menu2();
                salir.menu();
             }
         });
        
    }
    
    
    
    /***
     * Método eventoClick: Con esté método indicamos las propiedades del evento click para los botones "Aceptar" de los métodos: estadoWin(); y estadoLose();
     */
    public void eventoClick(){
         aceptarEmergente.addMouseListener(new MouseAdapter(){
            @Override
            /***
             * Método mousePressed: Acá indicamos a la clase Gráficos que la ventana Emergente esta abierta y también regresaremos al menú de selección de dificultad.
             */
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
             /***
              * Método windowClosing: Se cambián las propiedades para el evento click del botón "X" de las ventanas emergentes de los métodos: estadoWin(); y estadoLose();
              * Le indicará a la calse gráficos que la ventana emergente está abierta y también regresará al menú de selcción de dificultad.
              */
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
    /***
     * Método exit: Srive para indicar que la ventana emergente está cerrada o abierta.
     * @return 
     * retorna el valor de la variable booleana scape.
     */
    public boolean exit(){
        return scape;
    }
    /***
     * Método exit2: de manera alternativa por si falla el método exit(); se indicará el valor que tenga la ventana, abierta o cerrada.
     * @return
     * retorna el valor de la variable booleana scape.
     */
    public boolean exit2(){
       if(ventanaEmergente.getDefaultCloseOperation()==0){
           scape=true;
       }
    return scape;
    }
    /***
     * Método name: Es utilizado para retornar el valor que se tiene en el área de texto.
     * @return 
     * Retorna el valor que se obtiene en el área de texto.
     */
    public String name(){
        System.out.println(areaNombre.getText());
        return areaNombre.getText();
    }

   /***
    * Método isBoton: es utilizado para obtener el valor de la variable botón, que es utilizada primordialmente para saber si una ventana emergente esta en curso.
    * @return 
    * Retorna el valor de la variable boton.
    */
    public static boolean isBoton() {
        return boton;
    }

   /***
    * Método setBoton: Es utilzado para cambiar el valor de la variable boton, que indica si una ventana emergente esta en curso o no.
    * @param aBoton 
    * Recibe el parámetro aBoton, para cambiar el valor del atributo boton.
    */
    public static void setBoton(boolean aBoton) {
        boton = aBoton;
    }
}

