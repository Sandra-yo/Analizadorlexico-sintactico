/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lexico1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author alector
 */
public class lectorPrinc {
    
    public void lee() throws FileNotFoundException{
                String entrada;
                
        FileReader f = new FileReader("src/Lexico1/entradas.txt");
        try (BufferedReader b = new BufferedReader(f)) {
            
            while ((entrada = b.readLine()) != null) {
                System.out.println(entrada);
                identifica(entrada);
               
            }
            
        } catch (Exception e) {
            System.out.println("archivo no encontrado");

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
    public static void main(String[] args) throws FileNotFoundException {
        lectorPrinc n = new lectorPrinc();
        n.lee();
    }
    
}
