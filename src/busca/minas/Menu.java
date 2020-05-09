
package busca.minas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *Clase Menu: esta clase se hizo para poder mostrar la primera pantalla con el boton Inicio.
 * @author Sergio Morán
 * @author Angel Ponce
 */
public class Menu {
    
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

    /***
     * Metodo iniciar: aquí es donde se le dio la estructura a la ventana y se coloco en el centro el boton de inicio.
     */
    public void iniciar(){
        
       ventana = new JFrame();
       ventana.setSize(558,586);
       ventana.setLayout(null);
       ventana.setLocationRelativeTo(null);
       ventana.setResizable(false);
       ventana.setVisible(true);
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       panel = new JPanel();
       panel.setLayout(null);
       panel.setSize(558,590);
       panel.setVisible(true);
       
       ventana.add(panel);
       
       fondo = new JLabel(new ImageIcon("Buscaminas.png"));
       //fondo.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
       fondo.setSize(558,558);
       fondo.setOpaque(true);
       fondo.setVisible(true);
       panel.add(fondo,0);

       
       comenzar = new JButton("Inicio");
       comenzar.setBounds(220, 230, 120, 50);
       comenzar.setForeground(Color.black);
       comenzar.setBackground(Color.red);
       comenzar.setFont(new Font("Cooper Black",Font.BOLD,16));
       comenzar.setVisible(true);
       panel.add(comenzar,0);
       panel.repaint();
       
       
       
       
       comenzar.addMouseListener(new MouseAdapter(){
          /***
           * Metodo mousePressed: este metodo nos sirve para que al momento de hacer un click sobre el boton inicar nos muestre la siguiente pantalla.
           * @param e 
           * Recibe en parametro e el cual solo india que si se ha hecho un click sobre el boton.
           */
           public void mousePressed(MouseEvent e){
               
               Menu2 ob = new Menu2();
               ob.menu();
               ventana.dispose();
           }
           
       });
       
    }    
}
