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
public class Pila {
    public Nodo tope;
    
    public Pila(){
        tope =  null;
    }
    
    public void agregar(String palabra){
        Nodo nuevo= new Nodo(palabra);
        
        
        if(tope==null){
            tope=nuevo;
        }else{
            tope.anterior=nuevo;
            nuevo.siguiente=tope;
            tope=nuevo;
            
            
            
        }
    }
    public void mostrar(){
        Nodo aux= tope;
        while(true){
            System.out.println(aux.palabra);
            if(aux.siguiente==null){
                break;
            }
            aux=aux.siguiente;
            
            //System.out.println(aux);
        }
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

