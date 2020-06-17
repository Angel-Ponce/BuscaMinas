package busca.minas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Clase Record: en esta clase se encuentran todos los elementos que forman las ventanas de record en cada una de las diferentes dificultades.
 * @author Sergio Morán
 * @author Angel Ponce
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
    JButton reset = new JButton();
    ArrayList<JButton> botonesLista = new ArrayList();
    int x=0;
    ArrayList<String> jugadoresFacil   = new ArrayList();
    ArrayList<String> jugadoresMedio   = new ArrayList();
    ArrayList<String> jugadoresDemente = new ArrayList();
    
    ArrayList<String> jugadoresFacilSort   = new ArrayList();
    ArrayList<String> jugadoresMedioSort   = new ArrayList();
    ArrayList<String> jugadoresDementeSort = new ArrayList();
    
    final private ImageIcon dificultad = new ImageIcon(getClass().getResource("/resources/Dificultad.png"));
    final private ImageIcon fWiners = new ImageIcon(getClass().getResource("/resources/FondoWiners.png"));
    final private ImageIcon iconV = new ImageIcon(getClass().getResource("/resources/icon.png"));
    
    public static int parametro;
    /***
     *Metodos records: Aqui se genera la ventana del record y los botones de las diferentes dificultades.
     */
    public void records(){
       ventanaRecords = new JFrame("BUSCAMINAS");
       ventanaRecords.setSize(558,586);
       ventanaRecords.setLayout(null);
       ventanaRecords.setLocationRelativeTo(null);
       ventanaRecords.setResizable(false);
       ventanaRecords.setVisible(true);
       ventanaRecords.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ventanaRecords.setIconImage(iconV.getImage());
       
       panelRecord = new JPanel();
       panelRecord.setLayout(null);
       panelRecord.setSize(558,558);
       panelRecord.setVisible(true);
       ventanaRecords.add(panelRecord);
       
       fondoRecord = new JLabel(dificultad);
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
       facil.setBackground(new Color(255,255,100));
       facil.setFont(new Font("Cooper Black",Font.BOLD,16));
       facil.setVisible(true);
       facil.setBounds(218,180,120,50);
       panelRecord.add(facil,0);
       
       medio.setForeground(Color.black);
       medio.setBackground(new Color(255,255,60));
       medio.setFont(new Font("Cooper Black",Font.BOLD,16));
       medio.setVisible(true);
       medio.setBounds(218,240,120,50);
       panelRecord.add(medio,0);
      
       
       demente.setForeground(Color.black);
       demente.setBackground(Color.YELLOW);
       demente.setFont(new Font("Cooper Black",Font.BOLD,15));
       demente.setVisible(true);
       demente.setBounds(218,300,120,50);
       panelRecord.add(demente,0);
        
            panelRecord.repaint();
     
       botonesLista.add(demente);
       botonesLista.add(medio);
       botonesLista.add(facil);
       eventoClick();
    }
    /***
     * Metodo eventoClick: aqui se hace el llamado a la acción que sucedera una vez se clica sobre cada boton
     */
    public void eventoClick(){
        facil.addMouseListener(new MouseAdapter(){
          /***
           * Metodo mousePressed: se indica las acciones a realizar al tocar el boton.
           * @param e 
           * Este parametro es el que indica cuando se a clicado sobre el boton.
           */
           public void mousePressed(MouseEvent e){
              fondoRecord.setIcon(fWiners);
              parametro = 0; 
              listado(parametro);
               for(JButton botones: botonesLista){
                   botones.setVisible(false);
                
               }
       //reset = new JButton();
       reset.setText("REINICIAR");
       reset.setSize(140, 40);
       reset.setLocation(0, 518);
       reset.setBackground(Color.red);
       reset.setForeground(Color.BLACK);
       reset.setVisible(true);
       reset.setFont(new Font("Cooper Black",Font.BOLD,16));
       reset.setVisible(true);
       panelRecord.add(reset,0);
           }
           
       });
         medio.addMouseListener(new MouseAdapter(){
          /***
           * Metodo mousePressed: se indica las acciones a realizar al tocar el boton.
           * @param e
           * Este parametro es el que indica cuando se a clicado sobre el boton.
           */
           public void mousePressed(MouseEvent e){
               fondoRecord.setIcon(fWiners);
               parametro = 1;
               listado(parametro);
               for(JButton botones: botonesLista){
                   botones.setVisible(false);
                
               }
       //reset = new JButton();
       reset.setText("REINICIAR");
       reset.setSize(140, 40);
       reset.setLocation(0, 518);
       reset.setBackground(Color.red);
       reset.setForeground(Color.BLACK);
       reset.setVisible(true);
       reset.setFont(new Font("Cooper Black",Font.BOLD,16));
       reset.setVisible(true);
       panelRecord.add(reset,0);
           }
           
       });
          demente.addMouseListener(new MouseAdapter(){
          /***
           * Metodo mousePressed: se indica las acciones a realizar al tocar el boton.
           * @param e
           * Este parametro es el que indica cuando se a clicado sobre el boton.
           */
           public void mousePressed(MouseEvent e){
               fondoRecord.setIcon(fWiners);
               parametro =2;
               listado(parametro);
               for(JButton botones: botonesLista){
                   botones.setVisible(false);
                
               }
       //reset = new JButton();
       reset.setText("REINICIAR");
       reset.setSize(140, 40);
       reset.setLocation(0, 518);
       reset.setBackground(Color.red);
       reset.setForeground(Color.BLACK);
       reset.setVisible(true);
       reset.setFont(new Font("Cooper Black",Font.BOLD,16));
       reset.setVisible(true);
       panelRecord.add(reset,0);
           }
           
       });
          
       
       regresar.addMouseListener(new MouseAdapter(){
          /***
           * Metodo mousePressed: se indica las acciones a realizar al tocar el boton.
           * @param e 
           * Este parametro es el que indica cuando se a clicado sobre el boton.
           */
           public void mousePressed(MouseEvent e){
               
               Menu2 ob = new Menu2();
               ob.menu();
               jugadoresFacil.clear();  
               jugadoresMedio.clear();
               jugadoresDemente.clear();
               ventanaRecords.setVisible(false);
           }
           
       });
       
        reset.addMouseListener(new MouseAdapter(){
          /***
           * Metodo mousePressed: se indica las acciones a realizar al tocar el boton.
           * @param e 
           * Este parametro es el que indica cuando se a clicado sobre el boton.
           */
           public void mousePressed(MouseEvent e){
               File texto=null;
               FileWriter fichero = null;
            PrintWriter pw = null;
            try{ 
                fichero = new FileWriter("Records.txt");
                pw = new PrintWriter(fichero);
                
                //int cantidad = jugadoresFacil.size()+jugadoresMedio.size()+jugadoresDemente.size();
                pw.print(" , , "+"\n");
                leerRecords();
                System.out.println(parametro);
                switch(parametro){
                    case 0: jugadoresFacil.clear();
                        break;
                    case 1: jugadoresMedio.clear();
                        break;
                    case 2: jugadoresDemente.clear();
                        break;
                    default:
                        break;
                }
                listado(parametro);
                ventanaRecords.dispose();
                Menu2 reback = new Menu2();
                reback.menu();
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
               
               
               
           }
           
       });
    }
    /***
     * Metodo listado: aqui se almacenan los nombres, dificultades y records de cada uno de los jugadores
     * @param categoria 
     * Recibe el parametro categorias para poder saber a que espacio mandarlo.
     */
    public void listado(int categoria){
        leerRecords();
        int longitud;
        
        switch(categoria){
            
            case 0: sort(jugadoresFacil,jugadoresFacilSort);
                longitud = jugadoresFacilSort.size();
             listadoGanadores = new JLabel[longitud];
       for(int x=0; x<longitud; x++){
           listadoGanadores[x] = new JLabel();  
       }
       
        for(int x=0; x<longitud; x++){
          
        listadoGanadores[x].setText(jugadoresFacilSort.get(x));
        listadoGanadores[x].setForeground(Color.BLACK);
        listadoGanadores[x].setFont(new Font("Cooper Black",Font.BOLD,15));
        listadoGanadores[x].setHorizontalAlignment(SwingConstants.CENTER);
        listadoGanadores[x].setBounds(170,(x+4)*40,220,50);
        listadoGanadores[x].setVisible(true);
          if(x==0){
                listadoGanadores[0].setLocation(170, 150);
            }
        panelRecord.add(listadoGanadores[x],0);
        }
       panelRecord.repaint();
                break;
            case 1: sort(jugadoresMedio,jugadoresMedioSort);
                longitud = jugadoresMedioSort.size();
            listadoGanadores = new JLabel[longitud];
       for(int x=0; x<longitud; x++){
           listadoGanadores[x] = new JLabel();  
       }
        
       
       
        for(int x=0; x<longitud; x++){
        listadoGanadores[x].setText(jugadoresMedioSort.get(x));
        listadoGanadores[x].setForeground(Color.black);
        listadoGanadores[x].setFont(new Font("Cooper Black",Font.BOLD,15));
        listadoGanadores[x].setHorizontalAlignment(SwingConstants.CENTER);
        listadoGanadores[x].setBounds(170,(x+4)*40,220,50);
        listadoGanadores[x].setVisible(true);
        if(x==0){
                listadoGanadores[0].setLocation(170, 150);
            }
        panelRecord.add(listadoGanadores[x],0);
        }
       panelRecord.repaint();
                break;
            case 2: sort(jugadoresDemente,jugadoresDementeSort);
                longitud = jugadoresDementeSort.size();
            listadoGanadores = new JLabel[longitud];
       for(int x=0; x<longitud; x++){
           listadoGanadores[x] = new JLabel();  
       }
        
       
       
        for(int x=0; x<longitud; x++){
        listadoGanadores[x].setText(jugadoresDementeSort.get(x));
        listadoGanadores[x].setForeground(Color.black);
        listadoGanadores[x].setFont(new Font("Cooper Black",Font.BOLD,15));
        listadoGanadores[x].setHorizontalAlignment(SwingConstants.CENTER);
        listadoGanadores[x].setBounds(170,(x+4)*40,220,50);
        listadoGanadores[x].setVisible(true);
        if(x==0){
                listadoGanadores[0].setLocation(170, 150);
            }
        panelRecord.add(listadoGanadores[x],0);
        }
        panelRecord.repaint();
                break;
            default:
                break;
        }
        
       
        
    }
    
    /***
     * Metodo leerRecords: en este metodo se ordenan a los jugadores dependiendo de la dificultad en la que hallan jugado.
     */
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
                switch(ln[1]){
                    case "FÁCIL":
                        jugadoresFacil.add(ln[0]+" -->: "+ln[2]);
                        jugadoresFacilSort.add(null);
                        break;
                    case "MEDIO":
                        jugadoresMedio.add(ln[0]+" -->: "+ln[2]);
                        //jugadoresMedioSort.add(ln[0]+" -->: "+ln[2]);
                        jugadoresMedioSort.add(null);
                        break;
                    case "DEMENTE":
                        jugadoresDemente.add(ln[0]+" -->: "+ln[2]);
                        //jugadoresDementeSort.add(ln[0]+" -->: "+ln[2]);
                        jugadoresDementeSort.add(null);
                        break;
                    default:
                        break;
            }
                
            }
            
        }catch(IOException er){
            
        }
    }
    /***
     * Metodo sort: en este metodo se ardenan los jugadores por el punteo y la dificultad donde se encuentran.
     * @param tipoJugadores
     * Se recibe el parametro tipoJugadores para saber en que categoría se jugo.
     * @param tipoJugadores2 
     * Se recibe el parametro tipoJugadores2 para remplazar la categoría pero ya ordenada.
     */
    public void sort(ArrayList<String> tipoJugadores,ArrayList<String> tipoJugadores2){
        
       
        int[] valores = new int[tipoJugadores.size()];
        
      int x = 0;
      for(String split: tipoJugadores){
          String[] array = split.split(" -->: ");
          valores[x] = Integer.parseInt(array[1]);
          x++;
      }  
        
        Arrays.sort(valores);
            
        int aux=0;
        String[] valoresString = new String[valores.length];
        //Pasar los puntajes a valores tipo String
        for(int a=valores.length-1; a>=0; a--){
            valoresString[aux] = Integer.toString(valores[a]);
            aux++;
        }
        
        if(valoresString.length>6){
            for(int i=6; i<valoresString.length; i++){
            valoresString[i] = null;
        }
            
        }
       
        
        for(String jugadores: tipoJugadores){
            String[] punteo = jugadores.split(" -->: ");
            
            for(int posiciones=0; posiciones<valoresString.length; posiciones++){
                if(punteo[1].equals(valoresString[posiciones])){
                    if(tipoJugadores2.get(posiciones)==null){
                    tipoJugadores2.set(posiciones, jugadores);
                    break;
                    }
                } 
            }
        }       
        
    }
    
}
