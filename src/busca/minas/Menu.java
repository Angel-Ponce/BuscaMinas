
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
 *
 * @author Sergio Morán
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
          
           public void mousePressed(MouseEvent e){
               
               Menu2 ob = new Menu2();
               ob.menu();
               ventana.dispose();
           }
           
       });
       
    }    
}
