package com.utp.proyectodealgoritmos;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class NodoArbol {
    // Atributos

    int valor;
    NodoArbol izq, der;

    // Constructores

    public NodoArbol(int valor) {
        this(null, valor, null);
    }

    public NodoArbol(NodoArbol izq, int valor, NodoArbol der) {
        this.izq = izq;
        this.valor = valor;
        this.der = der;
    }

    // Getters y Setters

    public int getValor() {
        return valor;
    }

    public NodoArbol getIzq() {
        return izq;
    }

    public NodoArbol getDer() {
        return der;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }

    // Métodos

    public static NodoArbol agregar(NodoArbol raiz, int valor) {
        if (raiz == null) {
            raiz = new NodoArbol(valor);
        } else if (valor < raiz.valor) {
            NodoArbol izq = agregar(raiz.izq, valor);
            raiz.setIzq(izq);
        } else if (valor > raiz.valor) {
            NodoArbol der = agregar(raiz.der, valor);
            raiz.setDer(der);
        }
        return raiz;
    }

    public static boolean buscar(NodoArbol raiz, int valor) {
        if (raiz == null) {
            return false;
        } else if (raiz.valor == valor) {
            return true;
        } else if (valor < raiz.valor) {
            return buscar(raiz.izq, valor);
        } else {
            return buscar(raiz.der, valor);
        }
    }

    public int numeroNodos() {
        int n = 1;
        if (izq != null) {
            n += izq.numeroNodos();
        }
        if (der != null) {
            n += der.numeroNodos();
        }
        return n;
    }

    // Métodos de recorrido
    // Preorden: raíz, izquierda, derecha

    public ArrayList<Integer> preorden() {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(valor);
        if (izq != null) {
            lista.addAll(izq.preorden());
        }
        if (der != null) {
            lista.addAll(der.preorden());
        }
        return lista;
    }

    // Inorden: izquierda, raíz, derecha

    public ArrayList<Integer> inorden() {
        ArrayList<Integer> lista = new ArrayList<>();
        if (izq != null) {
            lista.addAll(izq.inorden());
        }
        lista.add(valor);
        if (der != null) {
            lista.addAll(der.inorden());
        }
        return lista;
    }

    // Postorden: izquierda, derecha, raíz

    public ArrayList<Integer> postorden() {
        ArrayList<Integer> lista = new ArrayList<>();
        if (izq != null) {
            lista.addAll(izq.postorden());
        }
        if (der != null) {
            lista.addAll(der.postorden());
        }
        lista.add(valor);
        return lista;
    }

}
