/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoPrincipal;

import Lexico1.LexicoSwitch;
import Lexico2.Lector;
import java.io.IOException;

/**
 *
 * @author alector
 */
public class Main {
    Lector estructuras;
    LexicoSwitch ls;
    
    public Main() throws IOException{
        estructuras = new Lector();
        ls = new LexicoSwitch("begin");
        imprime();
    }
    
    public void imprime(){
        System.out.println("Derecha:::");
        estructuras.Estderecha.mostrar();
        
        
    }
    
    public static void main(String[] args) throws IOException {
        Main n = new Main();
    }
    
}
