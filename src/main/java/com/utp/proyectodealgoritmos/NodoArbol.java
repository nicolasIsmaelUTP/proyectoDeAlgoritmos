package com.utp.proyectodealgoritmos;

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
}
