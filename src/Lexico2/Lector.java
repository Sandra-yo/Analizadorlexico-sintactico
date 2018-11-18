package Lexico2;

import Estructura.EstructuraGramatica;
import Estructura.EstructuraGramatica.Nodo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lector {
    ArrayList listaIzquierda,listaDerecha;
    String  []derecha;
    String []izquierda;
  public  EstructuraGramatica Estizquierda,Estderecha,estTerminales,estNoTerminales;
    
    public Lector() throws IOException{
        Estizquierda = new EstructuraGramatica();
        Estderecha = new EstructuraGramatica();
        estNoTerminales = new EstructuraGramatica();
        estTerminales = new EstructuraGramatica();
        read();
        conseguirNoTerm(Estizquierda);
        conseguirTerm(Estderecha);
        despliega();
        

    }
       public void read() throws FileNotFoundException, IOException {

        String linea;
        FileReader f = new FileReader("src/Lexico2/entradas.txt");
        try (BufferedReader b = new BufferedReader(f)) {
            while ((linea=b.readLine()) != null) {
                 separa(linea);
                 
            }
        } catch (Exception e) {
            System.out.println("archivo no encontrado");
            System.out.println(e);
        }

    }
       public void separa(String c){    
          int inicio=0,fin=0;
          String palabra="";
           for (int i = 0; i < c.length();) {
               if(c.charAt(i) == '-' && c.charAt(i+1) == '>') {
                   fin=i-1;
                   while(inicio!=fin){
                        palabra+=c.charAt(inicio);
                        inicio++;
                   }
                   inicio=i+1;
                   fin=c.length();
                   Estizquierda.agregar(palabra);     
                   
               }else if(c.charAt(i) == '>'){
                   i++;
                   if(c.length()!=i){
                       
                   palabra="";
                   inicio=i;
                   if(c.charAt(inicio)==' '){
                       inicio++;
                   }
                   fin=c.length();
                   while(inicio!=fin){
                        palabra+=c.charAt(inicio);
                        inicio++;
                   }
                   }else{
                       palabra=" ";
                   }
                   
                   Estderecha.agregar(palabra);
               }
               i++;
           }
            
       }
       public void conseguirNoTerm(EstructuraGramatica n){      
           Nodo aux = n.inicio;
           while(aux!=n.fin){
                if(estNoTerminales.buscar(aux.palabra)==-1){
                      estNoTerminales.agregar(aux.palabra);
                }
                aux=aux.getSiguiente();
           }
         
        //  estNoTerminales.mostrar();
       }
       public void enviarTerm(String palabra){
           //System.out.println(palabra);
            if(estNoTerminales.buscar(palabra)==-1 && palabra != ""){                
                if(estTerminales.buscar(palabra)==-1){
                  //  System.out.println(palabra);
                      estTerminales.agregar(palabra);
                }
                }
            //estTerminales.mostrar();
            
       }
       
       public void conseguirTerm(EstructuraGramatica n){
           Nodo aux = n.inicio;
           int inicio=0, fin=0;
               String palabra="";
               int j=0;
               while(true){
                   while(true){
                                              
                       if(aux.palabra.length()==j){
                          fin=aux.palabra.length();
                          while(true){
                              if(inicio==fin){
                                break;
                                 }
                          palabra+=aux.palabra.charAt(inicio);
                          inicio++;    
                            }
                            enviarTerm(palabra);
                            palabra="";
                            break;
                       }
                       
                       if(aux.palabra.charAt(j) == ' '){                       
                           fin=j;
                   while(true){
                        if(inicio==fin){
                            break;
                   }
                        
                        palabra+=aux.palabra.charAt(inicio);
                        inicio++;
                   }
                       inicio=j+1;
                       enviarTerm(palabra);
                       palabra="";
                   }
                        j++;
                   }
                   
                   if(aux==n.fin){
                       
                       break;
                   }
                   aux=aux.getSiguiente();
                   j=0;
                   inicio=0;
               }
   
       }
       
       
        public void despliega(){
           // System.out.println("Lista Enlazada:");
//             System.out.println("izquierda----");
   //          Estizquierda.mostrar();
   //          System.out.println("derecha---");
          //   Estderecha.mostrar();
//             System.out.println("--- --- --- no terminales");
        //   estNoTerminales.mostrar();
//             System.out.println("... ... ...");
           // estTerminales.mostrar();
  //           
        }

    public static void main(String[] args) throws IOException {
        Lector t=new Lector();

    }
    
}
