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
    
    static Graficos juego;
    public static void main(String[] args) {
        juego = new Graficos();
        juego.crearVentana();
        juego.crearCuadricula(); 
        juego.crearBotones();  
        juego.dibujarMinas(1);
    }
}
