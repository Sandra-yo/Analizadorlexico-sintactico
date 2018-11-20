/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoPrincipal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Estructura.Pila;
import Lexico2.LexicoSwitch;
import Lexico2.Lector;

/**
 *
 * @author alector
 */
public class lexicoSintactico {
    int matriz[][];
    String x,a;
    Lector l;
    LexicoSwitch ls;
    Pila pila;
    Pila doc;
    
    
    public lexicoSintactico() throws IOException{
     pila = new Pila();
     doc= new Pila();
     l= new Lector();
     creacionMatriz();
     ingresa();
     
    }
    public void creacionMatriz(){
        
        matriz = new int[14][13];
        matriz[0][0]=1;
        matriz[0][12]=22;
        matriz[1][2]=4;
        matriz[2][1]=2;
        matriz[2][2]=3;
        matriz[2][3]=5;
        matriz[2][4]=8;
        matriz[2][6]=11;
        matriz[2][8]=14;
        matriz[2][10]=18;
        matriz[4][9]=16;
        matriz[5][1]=2;
        matriz[5][2]=3;
        matriz[5][3]=6;
        matriz[6][6]=11;
        matriz[6][8]=14;
        matriz[6][10]=17; 
        matriz[7][5]=10;
        matriz[7][7]=13;
        matriz[7][9]=16;
        matriz[8][1]=2;
        matriz[8][2]=3;
        matriz[8][3]=7;
        matriz[9][5]=9;
        matriz[9][7]=12;
        matriz[9][9]=16;
        matriz[10][6]=11;
        matriz[10][8]=14;
        matriz[10][10]=19;
        matriz[11][9]=15;
        matriz[11][11]=20;
        matriz[12][9]=15;
        matriz[12][11]=21;
    }
    
    public void ingresa() throws FileNotFoundException, IOException {

        String entrada;
        int contador=0;
        FileReader f = new FileReader("src/Lexico1/entradas.txt");
        try (BufferedReader b = new BufferedReader(f)) {
           while ((entrada = b.readLine()) != null) {

               //doc.push(entrada);
            }
           
        } catch (Exception e) {
            System.out.println("archivo no encontrado");

        }

    }
    public String estadoInicial(){
        String estado=null;
        if(l.Estderecha.buscar(l.Estizquierda.inicio.palabra)==-1){
        l.Estderecha.mostrar();
        }
        return estado;
    }

    
    public void lldriver(){
        doc.push("end");
        doc.push(";");
                doc.push("intLiteral");
        doc.push("=");
                doc.push("id");    
                doc.push("begin");



        // simbolo inicial en la pila
        pila.push("system_goal");
        //asignar a "x" el simbolo el simbolo en la parte alta de la pila
        x=pila.muestra();
        //asigne a "a" el token de entrada
        a=doc.pop();
int ind=1;
        while(!pila.empty()){
            System.out.println("vuelta "+ind);
            //if x in noTerminals then
            if(l.estNoTerminales.buscar(x)!=-1){
                int fila=l.estNoTerminales.buscar(x);
                int columna=l.estTerminales.buscar(a);
                int posicion=matriz[columna][fila];
                if(posicion!=0){  

                    //pop() y push
                    
                    metPush(l.Estderecha.buscar(posicion-1));

                     // remplazar x con produccion de la matriz 
                    x=pila.muestra();
                   
                }else{
                    // procesa error de sintaxis
                    System.out.println("Error *1");
                    System.exit(0);
                }
                //end if
            }else{
              if(x.contains("'")){
                  x=x.replace("'", "");
              }
              
               if(x.equals(a)){
                   pila.pop();
                   
                   if(!pila.empty()){
                   x=pila.muestra();
                   a=doc.pop();
                   }
               }
               else{
                   System.out.println("Error *2");
                   System.exit(0);
               } //end if
                
            }//end if
            ind++;
        }//end while
        System.out.println("Terminado");
    }
   
    
    public void metPush(String n){
        //System.out.println("**inicio");
        pila.pop();
         String[] p=n.split(" ");
         
         Pila ext=new Pila();
                    for (int j = 0; j <p.length ; j++) {
                       ext.push(p[j]);
                    }
                    //los acomoda en el orden correcto
                    for (int i = 0; i < p.length; i++) {
                        pila.push(ext.pop());
                     }
   //                 pila.mostrar();
    }
        public static void main(String[] args) throws IOException {
        lexicoSintactico n= new lexicoSintactico();
        n.lldriver();
    }
        
    }
    
    

