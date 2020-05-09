package busca.minas;
/**
 *Clase Principal: La clase principal sirve unicamente para inicializar la ventana principal del juego.
 * @author Angel Ponce
 * @author Sergio Morán
 * @version Java 1.8, NetBeans IDE 8.2
 */
public class Principal {
    //static Graficos juego;
    static Menu iniciarjuego;
    /***
     * Método main: El programa iniciaria directamente aquí.
     * @param args 
     */
    public static void main(String[] args) {
        
        iniciarjuego = new Menu();
        iniciarjuego.iniciar();
    }
  
    }

    
