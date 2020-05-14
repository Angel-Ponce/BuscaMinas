/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.minas;


import java.awt.Color;
import java.awt.Font;                                            
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/***
 * Clase Graficos: Esta clase extiende de JFrame, para así obtener sus métodos.
 * En esta clase se almacena el corazón del juego, se inicializa la ventana de juego con todas sus propiedades.
 * También se establecen todas las reglas y funcionamientos del juego.
 * @author Angel Ponce
 * @author Sergio Morán
 */
public class Graficos extends JFrame {
    //Creamos una lista para almacenar todos los elementos del juego.
    protected ArrayList<JButton> listaBotones = new ArrayList();
    protected ArrayList<JLabel>  listaCuadros = new ArrayList();
    public static JFrame ventana;
    protected JPanel lienzo;
    protected static int i;
    protected JButton botonSalir;
    public int puntaje = 0;
    protected JLabel puntajePantalla;
    protected JLabel bombita;
    private static String nombre;
    private static String dificultad;
    private static boolean boton;
    /***
     * Metodo Crear Ventana: Este método crea la ventana de juego con todas las propiedades ya listas.
     */
    public void crearVentana(){ 
        ventana = new JFrame();
        ventana.setSize(530,593);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("BUSCAMINAS");
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setResizable(false); 
        ventana.setVisible(true);  
        lienzo = new JPanel();
        lienzo.setSize(530,565);
        lienzo.setLocation(0, 0);
        lienzo.setBackground(Color.gray);
        lienzo.setVisible(true);
        lienzo.setLayout(null);
        ventana.add(lienzo);
        
        botonSalir = new JButton();
        botonSalir.setText("SALIR");
        botonSalir.setSize(135,40);
        botonSalir.setLocation(0,525);
        botonSalir.setForeground(Color.BLACK);
        botonSalir.setBackground(Color.RED);
        botonSalir.setFont(new Font("Cooper Black",Font.BOLD,16));
        botonSalir.setVisible(true);
         boton = false;
        botonSalir.addMouseListener(new MouseAdapter(){
        
            @Override
            /***
             * Método mousePressed: Nos serivira para dar los eventos del click al botón "Salir" de la ventana de juego.
             * Según el el retorno del método isBoton(); del objeto bot, el botón cerrara la ventana principal o regresará al menú de inicio.
             * El retonro del método isBoton es booleano y si su valor es true, significa que el usuario ha perdido o ha ganado la partida.
             */
            public void mousePressed(MouseEvent e){
                Emergentes bot = new Emergentes();
                ventana.dispose();
                System.out.println(boton);
                if(bot.isBoton()==false){
                Menu2 salir = new Menu2();
                salir.menu();
                }else{
                    ventana.dispose();
                }
            }
        });
        lienzo.add(botonSalir);
        
        puntajePantalla = new JLabel();
        puntajePantalla.setText("PUNTAJE: ");
        puntajePantalla.setFont(new Font("Cooper Black",1,15));
        puntajePantalla.setSize(135,40);
        puntajePantalla.setLocation(390, 525);
        puntajePantalla.setBackground(Color.gray);
        puntajePantalla.setVisible(true);
        puntajePantalla.setOpaque(true);
        lienzo.add(puntajePantalla);
        
        bombita = new JLabel(new ImageIcon("Bomba.png"));
        bombita.setVisible(true);
        bombita.setSize(25,25);
        bombita.setLocation(359, 532);
        lienzo.add(bombita);
    }
    /***
     * Método crearCuadricula: Este método nos crea una cuadricula de JLabels tal que sea la parte interna del juego, en donde
     * iran los números y las minas ocultas.
     */
    public void crearCuadricula(){
        for(int x=0; x<=500; x+=25){
            for(int y=0; y<=500; y+=25){ 
                JLabel nuevoCuadro = new JLabel();
                nuevoCuadro.setSize(25,25);
                nuevoCuadro.setLocation(x,y);
                nuevoCuadro.setBackground(Color.gray);
                nuevoCuadro.setOpaque(true);
                nuevoCuadro.setText(" ");
                nuevoCuadro.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
                nuevoCuadro.setFont(new Font("Times New Roman",Font.BOLD,12));
                nuevoCuadro.setHorizontalAlignment(SwingConstants.CENTER);
                nuevoCuadro.setVisible(false);   
                lienzo.add(nuevoCuadro);
                listaCuadros.add(nuevoCuadro);
                lienzo.repaint();
               
            }   
        } 
    }
    /***
     * Método crearBotones: El método que crea una cuadricula identica a la de Labels del método crearCuadricula();
     * En lugar de ser Labels ahora son botones, para que el jugador pueda ir presionando la cuadricula. Esta nueva cuadricula esta repintada 
     * sobre los Labels, de manera que los oculte.
     */
    public void crearBotones(){
        for(int x=0; x<=500; x+=25){
            for(int y =0; y<=500; y+=25){
                JButton nuevoBoton = new JButton();
                nuevoBoton.setSize(25,25);
                nuevoBoton.setLocation(x,y);
                nuevoBoton.setVisible(true); 
                nuevoBoton.setBackground(Color.darkGray);
                nuevoBoton.setText("");
                lienzo.add(nuevoBoton);
                listaBotones.add(nuevoBoton);
                lienzo.repaint();
            }
        }
        eventoClick();
    }
   
    /***
     * Método eventoClick: Esté metodo asigna el evento click para todos los botones creados en el método crearBotones();
     * a cada botón le da la propiedar correspondiente para que el juego funcione correctamente.
     */
    public void eventoClick(){
        
        Menu2 jugador = new Menu2();
        Emergentes ventanaEmergente = new Emergentes();
  
        for(JButton iterador: listaBotones){
            MouseListener click = new MouseListener() {
                @Override
                /***
                 * Evento mouseClicked: Se sobre escriben los métodos del MouseListener para todos los botones.
                 * (Solo se utiliza el método mosueClicked).
                 */
                public void mouseClicked(MouseEvent me) {
                    
                     boolean valor;
                  
                     iterador.setVisible(false);
                     i = listaBotones.indexOf(iterador);
                     listaCuadros.get(i).setVisible(true);
                     valor = encontrarMinas(i);
                     if(valor==false){
                         trifuersa(i);
                         iterador.setText(null);
                         puntaje+=puntajeTotal();
                         puntajePantalla.setText(("PUNTAJE: "+puntaje));
                     }else{
                        puntaje+=puntajeTotal();
                        puntajePantalla.setText(("PUNTAJE: "+puntaje));
                        jugador.agregarJugador(nombre, dificultad, puntaje);
                        Menu2 retorno = new Menu2();
                        boolean cerrar = ventanaEmergente.exit();
                        ventanaEmergente.estadoLose(puntaje);
                     }
                  
                   if(algoritmoWin()==cantidadMinas){
                    puntaje+=puntajeTotal();
                    puntajePantalla.setText(("PUNTAJE: "+puntaje));
                    jugador.agregarJugador(nombre, dificultad, puntaje);
                    //ventana.dispose();
                    ventanaEmergente.estadoWin(puntaje);
                    Menu2 retorno = new Menu2();
                    boolean cerrar = ventanaEmergente.exit();
                }
                }
                @Override
                public void mousePressed(MouseEvent me) {
                }
                @Override
                public void mouseReleased(MouseEvent me) {
                }
                @Override
                public void mouseEntered(MouseEvent me) {
                    //System.out.println("GraphsPetén");
                }
                @Override
                public void mouseExited(MouseEvent me) {
                }
            };
            
            iterador.addMouseListener(click);
        }
    }
    
    //----------------------------------------------------MECANICA DE MINAS----------------------------------------------------------//
    protected int[] minas;
    protected Random random = new Random();
    protected int cantidadMinas;
    protected static int pos;
    protected boolean posR;
    String ruta = System.getProperty("user.dir");
    String rutat = "\""+ruta+"\"";
  /***
   * Método dibujarMinas: El método reemplaza los labeles de texto por labeles de imagén que contienen una bomba.
   * Las posiciones que elige para el intercambio están dadas por números aleatorios entre 0 y 440.
   * @param dificultad 
   * El parámetro difiultad le indica al método cuantas minas dibujar en la cuadricula.
   */
   public void dibujarMinas(int dificultad){
       
       switch(dificultad){
           case 1: cantidadMinas = 41;
           break;
           case 2: cantidadMinas = 76;
           break;
           case 3: cantidadMinas = 201;
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
       System.out.println("---------------------------------------------------------------------------------");
       //En este for each, lo que se hace es que se sustituye un label tipo texto por un label tipo imagen
       //Se coloca y se guarda en la posicion exacta en el lienzo y en la lista de Labels
       for(int it: minas){
           
           JLabel sustituto = new JLabel(new ImageIcon("Bomba.png"));
           sustituto.setSize(25,25);
           
           int posx = listaCuadros.get(it).getLocation().x;
           int posy = listaCuadros.get(it).getLocation().y;
           
           sustituto.setLocation(posx, posy);
           listaCuadros.get(it).setVisible(false);
           
           listaCuadros.set(it, sustituto);
           listaCuadros.get(it).setVisible(false);
           lienzo.add(sustituto,0);
           
           lienzo.repaint(); 
       }
   }
   /***
    * Método buscarMinasREpetidas: Este método es de gran útilidad ya que establece que ninguna mina quede en lugares repetidos
    * lo que asegura que se dibujen todas las minas.
    */
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
   /***
    * Método encontrarMinas: Este método es llamado por el evento click de todos los botones, lo que hace es que dependiendo de la úbicacion 
    * en donde se generó un click busca y determina si existe una mina o no.
    * @param pos
    * El parámetro pos sirve para saber en que posicion se genero el click y para ver si en esa posición hay una mina o no.
    * @return
    * El retorno de este método es booleano, y si encuentra que la posición donde se generó el click es una mina retorna el valor: true, en caso 
    * contrario retorna el valor: false.
    */
   public boolean encontrarMinas(int pos){
       boolean valor = false;
        for(int min: minas){
                         if(pos==min){
                             valor = true;
                             for(JButton min2: listaBotones){
                                 min2.setVisible(false);
                                 listaCuadros.get(listaBotones.indexOf(min2)).setVisible(true);
                             }
                             for(JLabel min3: listaCuadros){
                                 if(min3.getText()==" "){
                                     min3.setBackground(Color.DARK_GRAY);
                                     min3.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                                 }
                             }
                         }
                     }
      return valor;
   }
   /***
    * Método algoritmoCruz: Este metodo estudia las posiciones en cruz de un cuadro donde se genere un click y revisa si hay minas en esas posiciones.
    * @param i2
    * parametro es la posiocion en la cuadricula donde se genera click.
    * @return 
    * es un valor correspondiente a la cantidad de minas al rededor de donde se origino el click
    */
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
   /***
    * Método trifuersa: El algoritmo trifuersa es el más importante de todos, aquí es donde yace la base fundamental del juego.
    * Este algoritmo establecera las posiciones "Arriba", "Abajo", "Izquierda" y "Derecha" al rededor de un botón (en donde se genera el click).
    * A partir de estas posiciones hace llamado del método trifuersa(); para saber si hay minas en esas posiciones.
    * Si encuentra una cantidad de minas mayor a 0 manda impresión de la cantidad de minas encontradas en el label úbicado debajo del botón donde se generó el click.
    * Si encuentra que la cantidad de minas es igual a 0 se vuelve recursivo y dentro de el mismo hace llamado al método trifuersa() para proceder con el mismo procedimiento
    * pero con las posciciones "Arriba", "Abajo", "Izquierda" y "Derecha", es decir, ahora buscará minas al rededor de 4 botones.
    * Además, si la cantidad de minas al rededor (cruz) de un botón es 0, el algoritmo le regalará esas posiciones al jugador, para ahorrarle clicks inncesarios.
    * Todo acaba justo cuando el algoritmo detecta que hay al menos una mina.
    * @param i2 
    */
   public void trifuersa(int i2){
       int arriba;
       int abajo;
       int derecha;
       int izquierda;
       boolean columna1 = false;
       boolean horizontal1 = false;
       boolean columna2 = false;
       boolean horizontal2 = false;
       boolean centro = false;
       
       
       for(int a = 0; a<21; a++){
           if(i2==a){
               columna1 = true;
               break;
           }
       }
       
       for(int a=21; a<=420; a+=21){
           if(i2==a){
               horizontal1=true;
               break;
           }
       }
       
       for(int a=421; a<=440; a++){
           if(i2==a){
               columna2=true;
               break;
           }
       }
       
       for(int a=41; a<=419; a+=21){
           if(i2==a){
               horizontal2=true;
               break;
           }
       }
       
      if(columna1!=true && columna2!=true && horizontal1!=true && horizontal2!=true){
          centro = true;
      }
     
       
     if(columna1==true){
         int suma = 0;
      
        if(i2==0){
            derecha = i2+21;
            abajo = i2+1;
            
            suma+=algoritmoCruz(derecha);
          
            suma+=algoritmoCruz(abajo);
            
            listaCuadros.get(i2).setText(Integer.toString(suma));
           
            if(suma==0){
                // EN PRUEBA
                listaBotones.get(derecha).setText(null);
           
                listaBotones.get(abajo).setText(null);
              
                
                listaBotones.get(i2).setText(null);
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
          
            
        }else if(i2==20){
            arriba = i2-1;
            derecha = i2+21;
            suma+=algoritmoCruz(arriba);
            suma+=algoritmoCruz(derecha);
            listaCuadros.get(i2).setText(Integer.toString(suma));
            
            if(suma==0){
                //EN PRUEBA
                listaBotones.get(arriba).setText(null);
                listaBotones.get(derecha).setText(null);
                 
                
                listaBotones.get(i2).setText(null);
                listaCuadros.get(i2).setText(null);
                listaBotones.get(arriba).setVisible(false);
                listaBotones.get(derecha).setVisible(false);
                listaCuadros.get(arriba).setVisible(true);
                listaCuadros.get(derecha).setVisible(true);
                
                if(listaCuadros.get(derecha).getText()!=null){
                    trifuersa(derecha);
                     
                }
                if(listaCuadros.get(arriba).getText()!=null){
                    trifuersa(arriba);
                     
                }
                
                
            }
             
             
        }else{
            arriba = i2-1;
            abajo = i2+1;
            derecha = i2+21;
           
            suma+=algoritmoCruz(derecha);
            suma+=algoritmoCruz(abajo);
            suma+=algoritmoCruz(arriba);
             listaCuadros.get(i2).setText(Integer.toString(suma));   
             
             
             if(suma==0){
                 //EN PRUEBA
                 listaBotones.get(arriba).setText(null);
                 listaBotones.get(abajo).setText(null);
                 listaBotones.get(derecha).setText(null);
              
                 
                 listaBotones.get(i2).setText(null);
                 listaCuadros.get(i2).setText(null);
                 listaBotones.get(arriba).setVisible(false);
                 listaBotones.get(abajo).setVisible(false);
                 listaBotones.get(derecha).setVisible(false);
                 listaCuadros.get(arriba).setVisible(true);
                 listaCuadros.get(abajo).setVisible(true);
                 listaCuadros.get(derecha).setVisible(true);
                 
                 if(listaCuadros.get(arriba).getText()!=null){
                     trifuersa(arriba);
                     
                 }
                  if(listaCuadros.get(abajo).getText()!=null){
                     trifuersa(abajo);
                      
                 }
                   if(listaCuadros.get(derecha).getText()!=null){
                     trifuersa(derecha);
                     
                 }
                 
                 
                 
             }
        }  
    }//Fin de la columna 1
     
     if(horizontal1==true){
         int suma = 0;
            
        if(i2==420){
            izquierda = i2-21;
            abajo = i2+1;
            suma+=algoritmoCruz(izquierda);
            suma+=algoritmoCruz(abajo);
            
            listaCuadros.get(i2).setText(Integer.toString(suma));
            
            if(suma==0){
                //EN PRUEBA
                listaBotones.get(izquierda).setText(null);
                listaBotones.get(abajo).setText(null);
                
                
                listaBotones.get(i2).setText(null);
                listaCuadros.get(i2).setText(null);
                listaBotones.get(izquierda).setVisible(false);
                listaBotones.get(abajo).setVisible(false);
                listaCuadros.get(izquierda).setVisible(true);
                listaCuadros.get(abajo).setVisible(true);
                
                
                if(listaCuadros.get(izquierda).getText()!=null){
                    trifuersa(izquierda);
                     
                }
                if(listaCuadros.get(abajo).getText()!=null){
                    trifuersa(abajo);
                    
                }
            } 
        }else{
            izquierda = i2-21;
            abajo = i2+1;
            derecha = i2+21;
            
            suma+=algoritmoCruz(izquierda);
            suma+=algoritmoCruz(abajo);
            suma+=algoritmoCruz(derecha);
            
            listaCuadros.get(i2).setText(Integer.toString(suma));
            
          if(suma==0){
                //EN PRUEBA
                listaBotones.get(abajo).setText(null);
                listaBotones.get(izquierda).setText(null);
                listaBotones.get(derecha).setText(null);
                
              
                listaBotones.get(i2).setText(null);
                listaCuadros.get(i2).setText(null);
                listaBotones.get(izquierda).setVisible(false);
                listaBotones.get(abajo).setVisible(false);
                listaCuadros.get(izquierda).setVisible(true);
                listaCuadros.get(abajo).setVisible(true);
                listaBotones.get(derecha).setVisible(false);
                listaCuadros.get(derecha).setVisible(true);
                
                
                if(listaCuadros.get(izquierda).getText()!=null){
                    trifuersa(izquierda);
                     
                }
                if(listaCuadros.get(abajo).getText()!=null){
                    trifuersa(abajo);
                     
                }
                if(listaCuadros.get(derecha).getText()!=null){
                    trifuersa(derecha);
                     
                }
            } 
            
        }  
     }//Fin horizontal 1
     
     if(columna2==true){
         int suma=0;
         
         if(i2==440){
             izquierda = i2-21;
             arriba = i2-1;
             
             suma+=algoritmoCruz(izquierda);
             suma+=algoritmoCruz(arriba);
             
             listaCuadros.get(i2).setText(Integer.toString(suma));
             
             if(suma==0){
                 //EN PRUEBA
                 listaBotones.get(izquierda).setText(null);
                 listaBotones.get(arriba).setText(null);
                
                 
                 listaBotones.get(i2).setText(null);
                 listaCuadros.get(i2).setText(null);
                 listaBotones.get(izquierda).setVisible(false);
                 listaCuadros.get(izquierda).setVisible(true);
                 listaCuadros.get(arriba).setVisible(true);
                 listaBotones.get(arriba).setVisible(false);
                 
                 if(listaCuadros.get(izquierda).getText()!=null){
                    trifuersa(izquierda);
                    
                }
                if(listaCuadros.get(arriba).getText()!=null){
                    trifuersa(arriba);
                     
                }
             } 
         }else{
             arriba = i2-1;
             izquierda = i2-21;
             abajo = i2+1;
             
             suma+=algoritmoCruz(izquierda);
             suma+=algoritmoCruz(arriba);
             suma+=algoritmoCruz(abajo);
             
             listaCuadros.get(i2).setText(Integer.toString(suma));
             
             if(suma==0){
                 //EN PRUEBA
                 listaBotones.get(arriba).setText(null);
                 listaBotones.get(izquierda).setText(null);
                 listaBotones.get(abajo).setText(null);
                 
                 listaBotones.get(i2).setText(null);
                 listaCuadros.get(i2).setText(null);
                 listaBotones.get(izquierda).setVisible(false);
                 listaCuadros.get(izquierda).setVisible(true);
                 listaCuadros.get(arriba).setVisible(true);
                 listaBotones.get(arriba).setVisible(false);
                 listaCuadros.get(abajo).setVisible(true);
                 listaBotones.get(abajo).setVisible(false);
                 
                if(listaCuadros.get(izquierda).getText()!=null){
                    trifuersa(izquierda);
                    
                }
                if(listaCuadros.get(arriba).getText()!=null){
                    trifuersa(arriba);
                     
                }
                if(listaCuadros.get(abajo).getText()!=null){
                    trifuersa(abajo);
                    
                }
             }
         }
     }//Fin columna2
     
     if(horizontal2==true){
         int suma = 0;
         izquierda = i2-21;
         arriba = i2-1;
         derecha = i2+21;
         
         suma+=algoritmoCruz(izquierda);
         suma+=algoritmoCruz(arriba);
         suma+=algoritmoCruz(derecha);
         
         listaCuadros.get(i2).setText(Integer.toString(suma));
         
         if(suma==0){
             //EN PRUEBA
                 listaBotones.get(izquierda).setText(null);
                 listaBotones.get(arriba).setText(null);
                 listaBotones.get(derecha).setText(null);
                 
                 listaBotones.get(i2).setText(null);
                 listaCuadros.get(i2).setText(null);
                 listaBotones.get(izquierda).setVisible(false);
                 listaCuadros.get(izquierda).setVisible(true);
                 listaCuadros.get(arriba).setVisible(true);
                 listaBotones.get(arriba).setVisible(false);
                 listaCuadros.get(derecha).setVisible(true);
                 listaBotones.get(derecha).setVisible(false);
                 
                if(listaCuadros.get(izquierda).getText()!=null){
                    trifuersa(izquierda);
                     
                }
                if(listaCuadros.get(arriba).getText()!=null){
                    trifuersa(arriba);
                    
                }
                if(listaCuadros.get(derecha).getText()!=null){
                    trifuersa(derecha);
                    
                }
             }  
     }//Fin de la horizontal 2
     
     
     if(centro==true){
         int suma = 0;
         arriba = i2-1;
         abajo = i2+1;
         derecha = i2+21;
         izquierda = i2-21;
         
         suma+=algoritmoCruz(izquierda);
         suma+=algoritmoCruz(arriba);
         suma+=algoritmoCruz(derecha);
         suma+=algoritmoCruz(abajo);
         
         listaCuadros.get(i2).setText(Integer.toString(suma));
         
             if(suma==0){
                 //EN PRUEBA
                 listaBotones.get(i2).setText(null);
                 listaBotones.get(arriba).setText(null);
                 listaBotones.get(abajo).setText(null);
                 listaBotones.get(izquierda).setText(null);
                 listaBotones.get(derecha).setText(null);
                 
                 listaCuadros.get(i2).setText(null);
                 
                 listaBotones.get(izquierda).setVisible(false);
                 listaCuadros.get(izquierda).setVisible(true);
                 listaCuadros.get(arriba).setVisible(true);
                 listaBotones.get(arriba).setVisible(false);
                 listaCuadros.get(derecha).setVisible(true);
                 listaBotones.get(derecha).setVisible(false);
                 listaCuadros.get(abajo).setVisible(true);
                 listaBotones.get(abajo).setVisible(false);
                 
                if(listaCuadros.get(izquierda).getText()!=null){
                    trifuersa(izquierda);
                    
                }
                if(listaCuadros.get(arriba).getText()!=null){
                    trifuersa(arriba);
                     
                }
                if(listaCuadros.get(derecha).getText()!=null){
                    trifuersa(derecha);
                    
                }
                if(listaCuadros.get(abajo).getText()!=null){
                    trifuersa(abajo);
                    
                }
             }//Fin cuadricula central
     }
  }
/***
 * Método algoritmoWin: Este método estudia todas las posiciones de los botones, este método es llamado por el evento click de los botones.
 * @return
 * Si el método irá sumando todas las posiciones de botones restantes por precionar, el método en cada click retorna está cantidad,
 * si se detecta que la cantidad de botones restantes por precionar es la misma cantidad de minas existentes se establece que el jugador ganó la partida.
 */   
 public int algoritmoWin(){
     int suma = 0;
        
            for(JButton boton: listaBotones){
                
                if(boton.getText()!=" "){
                    suma++;
                }
            }
     return suma;       
 }
/***
 * Método puntajeTotal: esté método irá sumando la cantidad de clicks hechos por el usuario, incluyendo los que el algoritmo trifuersa() regala.
 * @return 
 * El retorno es la cantidad que el jugador lleva, sirve para imprimirlo en la ventana de juego.
 * También sirve para enviar ese punteo a la lista de records.
 */
public int puntajeTotal(){
    int suma = 0;
    for(JButton botones: listaBotones){
        if(botones.getText() == null){
            suma++;
            botones.setText(" ");
        }
    }
    return suma;
}
/***
 * Método getNombre:Sirve para obtener el nombre del jugador, en cualquier clase del proyecto.
 * @return 
 * retorna el valor del nombre.
 */
    public static String getNombre() {
        return nombre;
    }

 /***
  * Método setNombre: Es útilizado por la clase "Emergentes" y envía un cambio de nombre.
  * @param aNombre 
  * Recibe el parámetro aNombre, para hacer el cambio de atributo.
  */
    public static void setNombre(String aNombre) {
        nombre = aNombre;
    }

/***
 * Método getDificultad: Es utlizado por obras clases para obtener la dificultad elegida por el jugador.
 * @return 
 */
    public static String getDificultad() {
        return dificultad;
    }

/***
 * Método setDificultado: Es utilizado por la clase "Emergentes" y envía el cambio de dificultad.
 * @param aDificultad 
 * El parámetro aDificultad sirve para hacer el cambio de atributo.
 */
    public static void setDificultad(String aDificultad) {
        dificultad = aDificultad;
    }
/***
 * Método exit: Es utilizado por la clase "Emergentes" y lo que indica es el cierre de la ventana de juego.
 * Se utiliza cuando el jugador ya perdió o ganó.
 */
    public void exit(){
                ventana.dispose();
    }

/***
 * Método isBoton: Este método sirve para obtener el valor de la variable boton, utilizada por el botón "Salir" de la ventana de juego.
 * @return 
 * Retorna el valor de la variable boton.
 */
    public static boolean isBoton() {
        return boton;
    }

/***
 * Método setBoton: Es utilizado por la clase "Emergentes" y le indica al boton "Salir" si puede o no puede efectuar el método de regresar al menú de inicio.
 * @param aBoton 
 * Recibe el parámetro aBoton para que la clase "Emergentes" envíe True o False.
 */
    public static void setBoton(boolean aBoton) {
        boton = aBoton;
    }
}