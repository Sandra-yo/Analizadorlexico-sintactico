/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 *
 * @author alector
 */
public class EstructuraGramatica {
    public Nodo inicio,fin;
    
    public EstructuraGramatica(){
        inicio = fin = null;
    }
    
    public void agregar(String palabra){
        Nodo nuevo= new Nodo(palabra);
        
        if(inicio==null){
            inicio=fin=nuevo;
        }else{
            fin.siguiente=nuevo;
            nuevo.anterior=fin;
            fin=nuevo;
        }
    }
    public void mostrar(){
        Nodo aux= inicio;
        while(true){
            System.out.println(aux.palabra);
            if(aux==fin){
                break;
            }
            aux=aux.siguiente;
            
        }
    }
    
    public int buscar(String aBuscar){
        int posición = -1, i = 1;
        Nodo aux = inicio;
        
        while(aux != null){
           if(aux.palabra.equals(aBuscar)){
               posición = i;
               break;
           }else{
               aux = aux.siguiente;
               i++;
           }
        }
        return posición;
    }
    
    
   
// -------------------- clase privada----------------------------------
    
   public class Nodo{
       public String palabra;
       Nodo anterior,siguiente;

        public Nodo(String palabra){
            this.palabra=palabra;
            anterior = siguiente = null;
        }

        public Nodo getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo anterior) {
            this.anterior = anterior;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
       
} 
}

