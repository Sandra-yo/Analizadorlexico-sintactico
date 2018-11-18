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
    public String muestra(){
        return tope.palabra;
    }
//    public void push(String palabra){
//        Nodo nuevo= new Nodo(palabra);
//        if(tope==null){
//            tope=nuevo;
//        }else{
//            tope.anterior=nuevo;
//            nuevo.siguiente=tope;
//            tope=nuevo;    
//        }
//    }
      public void push(String información){
        Nodo nuevo = new Nodo(información);

        if(empty()){
            tope = nuevo;
        }else{
            nuevo.siguiente = tope;
            tope = nuevo;
        }
    }

   
//    public String pop(){
//        Nodo nuevo;
//        if(tope!=null){
//            nuevo=tope;
//            tope=tope.siguiente;
//            if(tope!=null){
//            tope.anterior=null;}
//            return nuevo.palabra;
//        }else{
//            return null;
//        }
//        
//    }
    public String pop(){
        if(empty()) // - código Mickey
            return null;
        else{
            Nodo temp = tope;
            tope= tope.siguiente;
            return temp.palabra;
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
    public boolean empty(){
        if(tope==null){
        return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Pila o= new Pila();
        o.push("uno");
        o.push("dos");
        o.push("tres");
        o.push("cuatro");
        o.push("cinco");
        o.push("seis");
        o.mostrar();
        o.pop();
        System.out.println("..");
        o.mostrar();

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

