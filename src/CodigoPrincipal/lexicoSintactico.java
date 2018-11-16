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

/**
 *
 * @author alector
 */
public class lexicoSintactico {
    int matriz[][];
    
    public lexicoSintactico() throws IOException{
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
        FileReader f = new FileReader("src/Lexico1/entradas.txt");
        try (BufferedReader b = new BufferedReader(f)) {
           if ((entrada = b.readLine()) != null) {
                System.out.println(entrada);
            }
        } catch (Exception e) {
            System.out.println("archivo no encontrado");

        }

    }

    public static void main(String[] args) throws IOException {
        lexicoSintactico n = new lexicoSintactico();
    }
    
}
