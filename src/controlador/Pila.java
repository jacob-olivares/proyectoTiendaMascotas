/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author jhaco
 */
public class Pila {
    Nodo cabecera;
    int tamano;

    public Pila() {
    }

    public Pila(Nodo cabecera, int tamano) {
        this.cabecera = cabecera;
        this.tamano = tamano;
    }
    
    public boolean apilar(Object valor){
        if(cabecera == null){
            cabecera = new Nodo(valor);
            tamano++;
            return true;
        }else{
           Nodo ulNodo = getUltimoNodo();
           if(valor != null && ulNodo != null){
               ulNodo.enlazarSiguiente(new Nodo(valor));
               tamano++;
               return true;
           }
        }
        return false;
    }
    
    public Nodo getUltimoNodo(){
        Nodo ultimoNodo = null;
        if(cabecera!=null){
            ultimoNodo = cabecera;
            while(ultimoNodo.obtenerSiguiente()!=null){
                ultimoNodo = ultimoNodo.obtenerSiguiente();
            }
        }
        return ultimoNodo;
    }
    
    public void desapilar(){
        int cont = 1;
        if(cabecera != null){
            Nodo temp = cabecera;
            while(cont<tamano-1){
                temp = temp.obtenerSiguiente();
                cont++;
            }
            tamano--;
            if(tamano==0){
                cabecera = null;
            }else{
                temp.enlazarSiguiente(null);
            }
        }
    }
    
    public void mostrarPila(){
        System.out.println();
        System.out.println("Mostrar valores de la pila");
        if(cabecera!=null){
            Nodo temp = cabecera;
 //           System.out.println(temp.obtenerValor());
            while(temp.obtenerSiguiente() != null){
                temp = temp.obtenerSiguiente();
 //               System.out.println(temp.obtenerValor());
            }
        }else{
            System.out.println("No existen datos");
            System.out.println("Fin de los datos");
            System.out.println();
        }
    }
}
