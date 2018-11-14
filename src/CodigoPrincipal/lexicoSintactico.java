/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoPrincipal;

import Estructura.Pila;
import Lexico1.LexicoSwitch;
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
    
    
    public lexicoSintactico(){
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
    
    public void lldriver(){
        // simbolo inicial en la pila
        pila.push("System_goal");
        //asignar a x el simbolo el simbolo en la parte alta de la pila
        x=pila.pop();
        //asigne a "a" el token de entrada
        
        
    }
    public static void main(String[] args) {
        lexicoSintactico n = new lexicoSintactico();
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 13; j++) {
                if(n.matriz[i][j]!=0){
                System.out.println(i+","+j+"  "+n.matriz[i][j]);
            }
            }
        }
    }
    
}
