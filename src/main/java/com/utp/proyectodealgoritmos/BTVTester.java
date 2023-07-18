package com.utp.proyectodealgoritmos;

import java.util.Random;

/**
 * BTVTester
 *
 * @author Gahwon Lee
 */
public class BTVTester {

    public static void main(String[] args) {
        viewerTest();
    }

    private static void viewerTest() {

        NodoArbol raiz = new NodoArbol(3);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            raiz = NodoArbol.agregar(raiz, r.nextInt(5));
        }

        new BinaryTreeViewer("valor","izq","der")
                .setDataMethod("getValor()")
                .setLeftChildMethod("getIzq()")
                .display(raiz, 500, 500);
    }

}
