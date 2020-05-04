/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca.minas;

/**
 *
 * @author Angel
 */
public class Principal {
    
    
    private int k;
    static Graficos juego;
    
    public Principal(int k){
        
        this.k=k;
        
        inicio(k);
        
    }
    
    public static void main(String[] args) {
        
        //juego = new Graficos();
        //juego.crearVentana();
        //juego.crearCuadricula(); 
        //juego.crearBotones();  
        //juego.dibujarMinas(2);
    }
    
    public void inicio(int k){
        
        juego = new Graficos();
        juego.crearVentana();
        juego.crearCuadricula(); 
        juego.crearBotones();  
        juego.dibujarMinas(k);
        
    }

    /**
     * @return the dificultad
     */
    public int getDificultad() {
        return k;
    }

    /**
     * @param dificultad the dificultad to set
     */
    public void setDificultad(int dificultad) {
        this.k = dificultad;
    }
    
    
    
    
}
