/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.minas;


import java.awt.Color;
import java.awt.Font;                                            
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//import javax.swing.JPanel;
/**
 *
 * @author angelponce
 */
public class Graficos extends JFrame {
    //Creamos una lista para almacenar todos los elementos del juego.
    protected ArrayList<JButton> listaBotones = new ArrayList();
    protected ArrayList<JLabel>  listaCuadros = new ArrayList();
    protected JFrame ventana;
    protected JPanel lienzo;
    protected static int i;
  
    //Este metodo crea nuestra ventana con todas las propiedades ya listas
    public void crearVentana(){
        ventana = new JFrame();
        ventana.setSize(530,553);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("BUSCAMINAS");
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);  
        lienzo = new JPanel();
        lienzo.setSize(530,525);
        lienzo.setLocation(0, 0);
        lienzo.setLayout(null);
        ventana.add(lienzo);
        
    }
    //Este metodo crea una cuadricula de JLabels interna, aquí se dibujaran las bombas y los números
    public void crearCuadricula(){
        for(int x=0; x<=500; x+=25){
            for(int y=0; y<=500; y+=25){ 
                JLabel nuevoCuadro = new JLabel();
                nuevoCuadro.setSize(25,25);
                nuevoCuadro.setLocation(x,y);
                nuevoCuadro.setBackground(Color.gray);
                nuevoCuadro.setOpaque(true);
                nuevoCuadro.setText(" ");
                nuevoCuadro.setFont(new Font("Times New Roman",Font.BOLD,12));
                nuevoCuadro.setHorizontalAlignment(SwingConstants.CENTER);
                nuevoCuadro.setVisible(false);
                lienzo.add(nuevoCuadro);
                listaCuadros.add(nuevoCuadro);
                lienzo.repaint();
               
            }   
        } 
    }
    //Este metodo crea una cuadricula de JButtons externa, es para la interfaz del juego.
    public void crearBotones(){
        for(int x=0; x<=500; x+=25){
            for(int y =0; y<=500; y+=25){
                JButton nuevoBoton = new JButton();
                nuevoBoton.setSize(25,25);
                nuevoBoton.setLocation(x,y);
                nuevoBoton.setVisible(true);
                nuevoBoton.setBackground(Color.darkGray);
                lienzo.add(nuevoBoton);
                listaBotones.add(nuevoBoton);
                lienzo.repaint();
            }
        }
        eventoClick();
    }
   
    //Con este metodo asignamos el evento clcik para todos los botones, asi sabremos cuando el usuario hace click sobre cualquiera de ellos.
    public void eventoClick(){
        
  
        for(JButton iterador: listaBotones){
            MouseListener click = new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                     boolean valor;
                     iterador.setVisible(false);
                     i = listaBotones.indexOf(iterador);
                     listaCuadros.get(i).setVisible(true);
                     valor = encontrarMinas(i);
                     if(valor==false){
                         trifuersa(i);
                     }
                     
                     System.out.println(listaCuadros.get(i).getText());
                }

                @Override
                public void mousePressed(MouseEvent me) {

                }

                @Override
                public void mouseReleased(MouseEvent me) {

                }

                @Override
                public void mouseEntered(MouseEvent me) {

                }

                @Override
                public void mouseExited(MouseEvent me) {

                }
            };
            
            iterador.addMouseListener(click);
        }
      
    }
    
    //----------------------------------------------------MECANICA DE MINAS----------------------------------------------------------//
    //Este array contiene las posiciones exactas de minas en el array de labels
    protected int[] minas;
    protected Random random = new Random();
    protected int cantidadMinas;
    protected static int pos;
    protected boolean posR;

    String ruta = System.getProperty("user.dir");
    String rutat = "\""+ruta+"\""; 
   
   //Con este metodo dibujaremos las minas aleatoriamente en la cuadricula (los valores no se repiten)
    //y lo haremos dependiendo la dificultad que el jugador eliga.
   public void dibujarMinas(int dificultad){
       
       switch(dificultad){
           case 1: cantidadMinas = 20;
           break;
           case 2: cantidadMinas = 100;
           break;
           case 3: cantidadMinas = 200;
           default:
               break;  
       }
       
       minas  = new int[cantidadMinas];
       System.out.println(rutat);
       
       //Asigacion de valores aleatorios sin repeticion en cada espacio del array de minas
       for(int iterador=0; iterador<cantidadMinas; iterador++){
           pos = random.nextInt(440);
           buscarMinasRepetidas();
           minas[iterador] = pos;
           System.out.println(minas[iterador]);    
       }
       //En este for each, lo que se hace es que se sustituye un label tipo texto por un label tipo imagen
       //Se coloca y se guarda en la posicion exacta en el lienzo y en la lista de Labels
       for(int it: minas){
           
           JLabel sustituto = new JLabel(new ImageIcon("bomba.jpg"));
           sustituto.setSize(25,25);
           
           int posx = listaCuadros.get(it).getLocation().x;
           int posy = listaCuadros.get(it).getLocation().y;
           
           sustituto.setLocation(posx, posy);
           listaCuadros.get(it).setVisible(false);
           
           listaCuadros.set(it, sustituto);
           lienzo.add(sustituto);
           
           lienzo.repaint(); 
       }
   }
   //El motodo para que la posicion de las minas no se repitan.
   public void buscarMinasRepetidas(){
       boolean valor = false;
       while(valor==false){
           
        for(int min: minas){
            if(min==pos){
               
                pos = random.nextInt(440);
             
            }else{
                valor=true;
            }
        }
       }
   }
   
   //Este metodo es utilizado por el evento click y lo que hace es que si el usuario apacha la posicion de una mina
   //Automaticamente aparecen todas las demas.
   //Recibe el parametro "pos" porque en ese parametro ira la posicion donde se origino el click
   public boolean encontrarMinas(int pos){
       boolean valor = false;
        for(int min: minas){
                         if(pos==min){
                             valor = true;
                             for(int min2: minas){
                                 listaBotones.get(min2).setVisible(false);
                             }
                         }
                     }
      return valor;
   }
   //El algoritmo cruz es uno de los mas importantes
   //Lo que hará es estudiar las posiciones en cruz de un botón centrico
   //Encontrará si en esas posiciones hay minas y de ser así las contara.
   //retornara la cantidad de minas que encuentra
   public int algoritmoCruz(int i2){
       int contador = 0;
       for(int min: minas){
                         if(i2==min){
                           contador++;
                         }
                     }
       return contador;
   }
   
   //El algoritmo trifuersa, es la base fundamental del juego.
   //Aquí es donde se implementa el algoritmo cruz hacia todos los botones.
   public void trifuersa(int i2){
       int arriba;
       int abajo;
       int derecha;
       int izquierda;
       boolean columna1 = false;
       
       for(int a = 0; a<21; a++){
           if(i2==a){
               columna1 = true;
           }
       }
     
       
     if(columna1==true){
         int suma = 0;
      
        if(i2==0){
            derecha = i2+21;
            abajo = i2+1;
            
            suma+=algoritmoCruz(derecha);
          
            suma+=algoritmoCruz(abajo);
            
            listaCuadros.get(i2).setText(Integer.toString(suma));
            //-----------------------------------------------------EN PRUEBA-------------------------------------------------------//
            if(suma==0){
                listaCuadros.get(i2).setText(null);           //Vamos a ponerle un indicador null a los labels donde ya hayamos hecho el algoritmos trifuersa
                listaBotones.get(derecha).setVisible(false);  //en las posiciones cruz donde no hay mina apagar los botones.
                listaBotones.get(abajo).setVisible(false);    //en las posiciones cruz donde no hay mina apagar los botones.
                listaCuadros.get(derecha).setVisible(true);   //en las posiciones cruz donde no hay mina, encender los labeles
                listaCuadros.get(abajo).setVisible(true);     //en las posiciones cruz donde no hay mina, encender los labeles
                
                if(listaCuadros.get(derecha).getText()!=null){
                trifuersa(derecha); //Realizar el procedimiento en los cuadros que regalara el algoritmo.
                }
                if(listaCuadros.get(abajo).getText()!=null){
                trifuersa(abajo); //Realizar el procedimiento en los cuadros que regalara el algoritmo
                }
            }
           //------------------------------------------------------EN PRUEBA------------------------------------------------------//
            
        }else if(i2==20){
            arriba = i2-1;
            derecha = i2+21;
            suma+=algoritmoCruz(arriba);
            suma+=algoritmoCruz(derecha);
             listaCuadros.get(i2).setText(Integer.toString(suma));
        }else{
            arriba = i2-1;
            abajo = i2+1;
            derecha = i2+21;
           
            suma+=algoritmoCruz(derecha);
            suma+=algoritmoCruz(abajo);
            suma+=algoritmoCruz(arriba);
             listaCuadros.get(i2).setText(Integer.toString(suma));      
        }  
    }
  }
}
