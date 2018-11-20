package Lexico1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LexicoSwitch {

    int estado;
    String palabraR;
    String tipo;
    boolean permiso;
    public LexicoSwitch(String palabra) {
        separa(palabra);
    }

    public void ingresa() throws FileNotFoundException, IOException {

        String entrada;
        FileReader f = new FileReader("src/Lexico1/entradas.txt");
        try (BufferedReader b = new BufferedReader(f)) {
            if ((entrada = b.readLine()) != null) {

                separa(entrada);
            }
        } catch (Exception e) {
            System.out.println("archivo no encontrado");

        }

    }

    public void separa(String entrada) {
        String palabra = "";
      //  do{
            
//        }while(permiso==true)
        for (int i = 0; i < entrada.length(); i++) {
            if (isCharacter(entrada.charAt(i))) {
                proceso(palabra);
                palabra = "";
                palabra += entrada.charAt(i);
                
                proceso(palabra);
                palabra = "";
            } else if (i == entrada.length() - 1) {
                palabra += entrada.charAt(i);
                proceso(palabra);
                palabra = "";
            } else if (!isCharacter(entrada.charAt(i))) {
                palabra += entrada.charAt(i);
            }

        }

    }

    public void proceso(String c) {
        String cadena = c.replace(" ", "");
        estado = 0;

        for (int i = 0; i < cadena.length(); i++) {

            switch (estado) {

                case 0:
                    if (cadena.charAt(i) == '0') {
                        estado = 1;
                    } else if (isDigit(cadena.charAt(i)) && cadena.charAt(i) != '0') {
                        estado = 2;
                    } else if (isAlph(cadena.charAt(i))) {
                        estado = 3;
                    } else if (isCharacter(cadena.charAt(i))) {

                        estado = 4;
                    } else if (!isAlph(cadena.charAt(i)) && !isDigit(cadena.charAt(i))
                            && !isCharacter(cadena.charAt(i))) {
                        estado = 5;
                    }

                    break;
                case 1:
                    if (isDigit(cadena.charAt(i)) | isAlph(cadena.charAt(i))
                            | isCharacter(cadena.charAt(i))) {
                        estado = 5;
                        
                    }

                    break;
                case 2:
                    if (!isDigit(cadena.charAt(i))) {
                        estado = 5;
                    }

                    break;
                case 3:
                    if (isAlph(cadena.charAt(i)) | isDigit(cadena.charAt(i))) {

                    } else {
                        estado = 5;
                    }

                    break;
                case 4:
                    if (isCharacter(cadena.charAt(i))) {

                    } else {
                        estado = 5;
                    }

                    break;
                case 5:

                    break;

            }

        }

        if (estado == 1 | estado == 2) {
            System.out.println("Digito: " + cadena);
            palabraR=cadena;
            tipo="intLiteral";

        }

        if (estado == 3) {
                        tipo= "id";
        }
        if (estado == 4) {
            System.out.println("Caracter simple: " + cadena);
            palabraR=cadena;

        }
        if (estado == 5) {
            System.err.println("Entrada no valida: " + cadena);
            System.exit(0);
        }

    }
    public String regresaPalabra(){
        return palabraR;
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
        return c == '+' || c == '-' || c == '/' || c == '$' || c == '=' || c == ';';
    }
    


}
