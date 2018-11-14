package Lexico1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LexicoSwitch {

    int estado;
    boolean IsAccept;
    int cont;
    
    

    public String ingresa() throws FileNotFoundException, IOException {
        
        String entrada;
        FileReader f = new FileReader("src/Lexico1/entradas.txt");
        try (BufferedReader b = new BufferedReader(f)) {
            
            while ((entrada = b.readLine()) != null) {
                cont=0;
                proceso(entrada);
                System.out.println(entrada+"...");
               
            }
        } catch (Exception e) {
            System.out.println("archivo no encontrado");

        }
       
        return null;
    }

    public boolean proceso(String c) {
        boolean resultado=true;
        String cadena = c.replace(" ", "");
        for (int i = 0; i < cadena.length(); i++) {
//            if(cadena.charAt(i)){
//                
//            }
        }
        estado = 0;

        for (int i = 0; i < cadena.length(); i++) {

            switch (estado) {

                case 0:
                    if(cadena.charAt(i)=='0'){
                    estado=1;
                }else  if(isDigit(cadena.charAt(i))&&cadena.charAt(i)!='0'){
                     estado=2;   
                    }
                    else  if(isAlph(cadena.charAt(i))){
                     estado=3;   
                    }
                    else if(isCharacter(cadena.charAt(i))){
                        cont=1;
                        estado=4;
                    }
                    else if(!isAlph(cadena.charAt(i)) && !isDigit(cadena.charAt(i))
                            && !isCharacter(cadena.charAt(i))){
                        estado=5;
                    }
                    

                    break;
                case 1:
                    if(isDigit(cadena.charAt(i))|isAlph(cadena.charAt(i))
                            |isCharacter(cadena.charAt(i))){
                        estado=5;
                    }

                    break;
                case 2: if(!isDigit(cadena.charAt(i))){
                        estado=5;
                    }
                   

                    break;
                case 3:
                    if(isAlph(cadena.charAt(i))|isDigit(cadena.charAt(i))){
                        
                    }else{
                        estado=5;
                    }

                    break;
                case 4:
                    if(isCharacter(cadena.charAt(i))){
                        cont=cont+1;
                        
                }else{
                        estado=5;
                    }

                    break;
                case 5:

                    break;
                
            }

        }
        
        if(estado==1|estado==2){
          //  System.out.println("Digito: "+cadena);
           
        }
        
        if(estado==3){
           // System.out.println("Identificador: "+cadena);
        }
        if(estado==4){
            if(cont==1){
           // System.out.println("Caracter simple: "+cadena);
            }else if(cont!=1){
                            System.out.println("Tienes "+cont+" caracter simple: "+cadena);
            }
                
        }
        if(estado==5){
            resultado=true;
          //  System.err.println("Entrada no valida: "+cadena);
        }
return resultado;
    }

    public boolean isDigit(char c) {
        try {
            return Integer.parseInt("" + c) >= 0 && Integer.parseInt("" + c) <= 9;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isAlph(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    public boolean isCharacter(char c) {
        return c == '+' || c == '-' || c == '/' || c == '$';
    }

    public static void main(String[] args) throws IOException {
        LexicoSwitch t = new LexicoSwitch();
        t.ingresa();
        
    }

}
