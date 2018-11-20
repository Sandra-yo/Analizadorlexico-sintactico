/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lexico1;

import CodigoPrincipal.lexicoSintactico;
import Lexico2.Lector;
import Lexico2.LexicoSwitch;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alector
 */
public class lectorPrinc {
    LexicoSwitch l;
    lexicoSintactico ls;
    Lector lec;
    
    public lectorPrinc() throws FileNotFoundException, IOException{
      lec = new Lector();
      lee();
      //separa();
    }
    public void lista(){
    
}
    
    public void lee() throws FileNotFoundException{
       String entrada;
       boolean listo =false;
       int i=0;
        FileReader f = new FileReader("src/Lexico1/entradas.txt");
        try (BufferedReader b = new BufferedReader(f)) {
           
            while ((entrada = b.readLine()) != null) {
                
               
                
                System.out.println(entrada);
               
               
                
            }
            
        } catch (Exception e) {
            System.out.println("archivo no encontrado");

        }
               
    }
    public void separa(String entrada) {
        String palabra = "";
        for (int i = 0; i < entrada.length(); i++) {
            System.out.println(entrada.charAt(i));
//            if (isCharacter(entrada.charAt(i))) {
//                proceso(palabra);
//                palabra = "";
//                palabra += entrada.charAt(i);
//                
//                proceso(palabra);
//                palabra = "";
//            } else if (i == entrada.length() - 1) {
//                palabra += entrada.charAt(i);
//                proceso(palabra);
//                palabra = "";
//            } else if (!isCharacter(entrada.charAt(i))) {
//                palabra += entrada.charAt(i);
//            }

        }

    }
    
    
    public void identifica(String c){
    //    System.out.println(c);
    c=c.replace(" ","");
          int inicio=0,fin=0;
          String palabra="";
           for (int i = 0; i < c.length();) {
              // System.out.println(c);
                   fin=i-1;
                   while(inicio!=fin){
                        palabra+=c.charAt(inicio);
                        inicio++;
                        System.out.println(palabra);
                   }
                   inicio=i+1;
                   fin=c.length(); 
                   
               
                   
               
               i++;
           }
            
       
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        lectorPrinc n = new lectorPrinc();
        
    }
    
}
