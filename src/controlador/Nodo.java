/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Cliente;
import modelo.Producto;


/**
 *
 * @author jhaco
 */
public class Nodo {
    
    Object valor;
    Nodo siguiente;
    
    public Nodo(Object valor){
        this.valor = valor;
        this.siguiente = null;
    }
    
    public Cliente obtenerCliente(){
        return (Cliente)valor;
    }

    public Producto obtenerProducto(){
        return (Producto)valor;
    }
    public Nodo obtenerSiguiente(){
        return siguiente;
    }
    
    public void enlazarSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
}
