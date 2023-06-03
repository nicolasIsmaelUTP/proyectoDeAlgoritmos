package com.utp.proyectodealgoritmos;

import java.util.Scanner;

/**
 *
 * @author GRUPO 1
 */
public class ProyectoDeAlgoritmos {

    private static final Scanner input = new Scanner(System.in);

    /**
     * Este método ingresa notas en un arreglo de enteros.
     *
     * @param cantidadNotas La cantidad de notas que se van a ingresar.
     * @return Un arreglo de enteros que contiene las notas ingresadas.
     */
    public static int[] ingresarNotas(int cantidadNotas) {
        int[] notas = new int[cantidadNotas];
        for (int i = 0; i < cantidadNotas; i++) {
            // Mientras la nota ingresada no sea válida se pide que se ingrese
            do {
                System.out.print("Ingrese la nota " + (i + 1) + ": ");
                notas[i] = input.nextInt();
                if (notas[i] < 0 || notas[i] > 20) {
                    System.out.println("Nota no válida.");
                }
            } while (notas[i] < 0 || notas[i] > 20);
        }
        return notas;
    }

    /**
     * Imprime las notas ingresadas en la consola.
     *
     * @param notas el arreglo de notas a imprimir
     */
    public static void imprimirNotas(int[] notas) {
        System.out.print("[");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]);
            if (i < notas.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Ordena un arreglo de notas por el método de inserción.
     *
     * @param notas El arreglo de notas a ordenar.
     */
    public static void ordenarPorInsercion(int[] notas) {
        int aux;
        // Seleccionamos un elemento i del arreglo.
        for (int i = 0; i < notas.length; i++) {
            // Recorremos el arreglo desde i hasta el final.
            for (int j = i; j < notas.length; j++) {
                // Si encontramos una nota menor se intercambian las posiciones.
                if (notas[i] > notas[j]) {
                    aux = notas[i];
                    notas[i] = notas[j];
                    notas[j] = aux;
                }
            }
        }
    }

    /**
     * Ordena un arreglo de notas por el método de burbuja.
     *
     * @param notas El arreglo de notas a ordenar.
     */
    public static void ordenarPorBurbuja(int[] notas) {
        int aux;
        for (int i = 1; i < notas.length; i++) {
            // Se resta i porque los últimos elementos ya estarán ordenados.
            for (int j = 0; j < notas.length - i; j++) {
                // Si el elemento actual es mayor que el siguiente
                // entonces se intercambian los elementos.
                if (notas[j] > notas[j + 1]) {
                    aux = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = aux;
                }
            }
        }
    }

    /**
     * Este método elige el método de ordenamiento a utilizar.
     *
     * @param notas El arreglo de notas a ordenar.
     */
    public static void ordenarNotas(int[] notas) {
        System.out.println("Eligiendo método de ordenamiento:");
        System.out.println("1. Inserción");
        System.out.println("2. Burbuja");
        while (true) {
            System.out.print("Ingrese el número del método: ");
            int metodo = input.nextInt();
            switch (metodo) {
                case 1 -> {
                    ordenarPorInsercion(notas);
                    return;
                }
                case 2 -> {
                    ordenarPorBurbuja(notas);
                    return;
                }
                default ->
                    System.out.println("Método no válido.");
            }
        }
    }

    /**
     * Calcula la nota media de un conjunto de notas.
     *
     * @param notas Un array de enteros que contiene las notas.
     * @return La nota media de las notas.
     */
    public static double calcularNotaMedia(int[] notas) {
        int total = 0;
        for (int nota : notas) {
            total += nota;
        }
        double media = (double) total / notas.length;
        return media;
    }

    /**
     * Obtiene la nota mayor de un arreglo de notas.
     *
     * @param notas El arreglo de notas.
     * @return La nota mayor.
     */
    public static int obtenerNotaMayor(int[] notas) {
        int notaMayor = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > notaMayor) {
                notaMayor = notas[i];
            }
        }
        return notaMayor;
    }

    /**
     * Este método recibe un arreglo de notas y devuelve la nota más baja.
     *
     * @param notas El arreglo de notas del cual se quiere obtener la nota más
     * baja.
     * @return La nota más baja del arreglo de notas.
     */
    public static int obtenerNotaMenor(int[] notas) {
        int notaMenor = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < notaMenor) {
                notaMenor = notas[i];
            }
        }
        return notaMenor;
    }

    public static void main(String[] args) {
        // Se pide al usuario que ingrese la cantidad de notas.
        System.out.print("Ingrese el número de notas: ");
        int cantidadNotas = input.nextInt();

        // Se ingresan las notas.
        int[] notas = ingresarNotas(cantidadNotas);

        // Se imprimen las notas.
        System.out.println("Notas ingresadas:");
        imprimirNotas(notas);

        // Se ordenan las notas.
        ordenarNotas(notas);

        // Se imprimen las notas ordenadas.
        System.out.println("Notas ordenadas:");
        imprimirNotas(notas);

        // Se calcula la nota media.
        double notaMedia = calcularNotaMedia(notas);
        System.out.println("Nota media: " + notaMedia);

        // Se obtiene la nota mayor y la nota menor.
        int notaMayor = obtenerNotaMayor(notas);
        System.out.println("Nota mayor: " + notaMayor);

        int notaMenor = obtenerNotaMenor(notas);
        System.out.println("Nota menor: " + notaMenor);
    }
}
