/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author jhaco
 */
public class Lista_Enlazada {

    protected Nodo cabecera, ultimo;
    int tamano;

    public Lista_Enlazada() {
        this.cabecera = null;
        this.ultimo = null;
        this.tamano = 0;
    }

    public void agregarListaCliente(Cliente valor) {
        if (cabecera == null) {
            cabecera = new Nodo(valor);
        } else {
            Nodo temporal = cabecera;
            Nodo nuevo = new Nodo(valor);
            nuevo.enlazarSiguiente(temporal);
            cabecera = nuevo;
        }

        tamano++;
    }

    public void mostrarLista() {
        System.out.println("");
        System.out.println("Mostrar Valores de la Lista");
        int contador = 0;
        if (cabecera != null) {
            Nodo temporal = cabecera;
            while (contador < tamano) {
                temporal = temporal.obtenerSiguiente();
                System.out.println(temporal.obtenerCliente().getNombre());
                contador++;
            }
        } else {
            System.out.println("No Existen Datos");
        }
        System.out.println("--- FIN DEL INFORME ---");
        System.out.println("");
    }

    public Nodo getUltimoNodo() {
        Nodo ultimoNodo = null;
        if (cabecera != null) {
            ultimoNodo = cabecera;
            while (ultimoNodo.obtenerSiguiente() != null) {
                ultimoNodo = ultimoNodo.obtenerSiguiente();
            }
        }
        return ultimoNodo;
    }

    public boolean eliminarUltimoNodo() {
        int contador = 1;
        if (cabecera != null) {
            Nodo temp = cabecera;
            while (contador < tamano - 1) {
                temp = temp.obtenerSiguiente();
                contador++;
            }
            tamano--;
            if (tamano == 0) {
                cabecera = null;
            } else {
                temp.enlazarSiguiente(null);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPrimero() {
        if (cabecera != null) {
            cabecera = cabecera.obtenerSiguiente();
            tamano--;
            return true;
        }
        return false;
    }

    public void ingresarPrimero(Object p) {
        if (cabecera == null) {
            cabecera = new Nodo(p);
        } else {
            Nodo temporal = cabecera;
            cabecera = new Nodo(p);
            cabecera.enlazarSiguiente(temporal);
        }
        tamano++;
    }

    public Cliente buscar(int rut) {
        Nodo temporal  = cabecera;
        Cliente c = null;
        while(temporal != null){
            if(rut == temporal.obtenerCliente().getRut()){
                c = temporal.obtenerCliente();
                break;
            }
            temporal = temporal.obtenerSiguiente();
        }
        return c;
    }
    public void eliminarClienteXRut(int rut){
        if(cabecera==ultimo && cabecera.obtenerCliente().getRut() == rut){
            cabecera =  ultimo = null;
        }else if(cabecera.obtenerCliente().getRut() == rut){
            cabecera = cabecera.siguiente;
        }else{
            Nodo anterior = cabecera;
            Nodo temp = cabecera.siguiente;
            while(temp!=null && temp.obtenerCliente().getRut()!=rut){
                anterior = anterior.siguiente;
                temp = temp.siguiente;
            }
            if(temp!=null){
                anterior.siguiente = temp.siguiente;
                if(temp == ultimo){
                    ultimo = anterior;
                }
            }
        }
        tamano--;
    }
}
