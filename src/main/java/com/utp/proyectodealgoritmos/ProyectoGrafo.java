/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.utp.proyectodealgoritmos;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Grupo 01
 */
public class ProyectoGrafo {

       public static void main() {
           
        Scanner scanner = new Scanner(System.in);
        
        G_Grafo grafo = new G_Grafo(); //Objeto Grafo

        int opcion = 0;

        while (opcion != 6) {
            System.out.println(" ______________________________________________________");
            System.out.println("|                        MENU                          |");
            System.out.println("|_____________________________________________________ |");
            System.out.println("|    1. Agregar docente o estudiante.                  |");
            System.out.println("|    2. Establecer relacion entre docente y estudiante.|");
            System.out.println("|    3. Mostrar docentes y estudiantes.                |");
            System.out.println("|    4. Mostrar relaciones existentes.                 |");
            System.out.println("|    5. Eliminar docente o estudiante.                 |");
            System.out.println("|    6. Salir.                                         |");
            System.out.println("|______________________________________________________|\n");
            System.out.print("   Seleccione una opcion por favor: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la etiqueta del docente o estudiante: ");
                    String etiqueta = scanner.nextLine();
                    grafo.agregarVertice(new G_Vertice(etiqueta));
                    System.out.println("_____________________________________________________");
                    System.out.println("Docente o estudiante agregado.");
                    break;
                 
                case 2:
                    System.out.print("Ingrese la etiqueta del docente: ");
                    String etiquetaDocente = scanner.nextLine();
                    G_Vertice docente = new G_Vertice(etiquetaDocente);//Crea el nuevo vertice.
                    grafo.agregarVertice(docente);

                    System.out.print("Desea conectar al docente con uno o varios estudiantes? (uno/varios): ");
                    String opcionConexion = scanner.nextLine();

                    //Evaluacion de la conexion.
                        //Si es uno.
                    if (opcionConexion.equalsIgnoreCase("uno")) {
                        System.out.print("Ingrese la etiqueta del estudiante: ");
                        String etiquetaEstudiante = scanner.nextLine();
                        // Crear nuevo vértice y lo agregarlo al grafo respectivamente de su etiqueta.
                        G_Vertice estudiante = new G_Vertice(etiquetaEstudiante);
                        grafo.agregarVertice(estudiante);
                        grafo.agregarRelacion(docente, estudiante);
                        //Terminando el proceso se imprime el resultado.
                        System.out.println("_____________________________________________________");
                        System.out.println("Relacion establecida entre docente y estudiante.");
                    } 
                        //Si es varios.
                        else if (opcionConexion.equalsIgnoreCase("varios")) {
                        System.out.print("Ingrese la cantidad de estudiantes a conectar con el docente: ");
                        int cantidadEstudiantes = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        
                        //Bucle para la cantidad de estudiantes.
                        for (int i = 0; i < cantidadEstudiantes; i++) {
                            System.out.print("Ingrese la etiqueta del estudiante " + (i + 1) + ": ");
                            String etiquetaEstudiante = scanner.nextLine();
                            // Crear nuevo vértice y lo agregarlo al grafo respectivamente de su etiqueta.
                            G_Vertice estudiante = new G_Vertice(etiquetaEstudiante);
                            grafo.agregarVertice(estudiante);
                            grafo.agregarRelacion(docente, estudiante);
                        }
                        //Terminando el proceso se imprime el resultado del bucle.
                        System.out.println("_____________________________________________________");
                        System.out.println("Relaciones establecidas entre docente y estudiantes.");
                    } else {
                        System.out.println("_____________________________________________________");
                        System.out.println("Opcion invalida. Intente nuevamente.");
                    }
                    break;
                case 3:
                System.out.println("Docentes y estudiantes:");
                System.out.println("_____________________________________________________");
                //Obtencion de la lista de vertices de estudiantes.
                List<G_Vertice> vertices = grafo.obtenerVertices();
                //Foreach para mostar la etiqueta de cada vertice de la  lista.
                for (G_Vertice vertice : vertices) {
                    System.out.println(vertice.getEtiqueta());
                }
                break;    
                
                case 4:
                    System.out.println("Relaciones existentes:");
                    System.out.println("_____________________________________________________");
                    //Obtencion del Mapa de relacioens del grafo, donde los docentes son las claves y los valores de la lista estudiantes.
                    Map<G_Vertice, List<G_Vertice>> relaciones = grafo.obtenerRelaciones();
                    // Iteracion a traves de las entradas del mapa, con ello se muestran las relaciones.
                    for (Map.Entry<G_Vertice, List<G_Vertice>> entry : relaciones.entrySet()) {
                        G_Vertice docenteActual = entry.getKey();
                        // Obtener la lista de estudiantes conectados al docente actual (valor de la entrada).
                        List<G_Vertice> estudiantes = entry.getValue();
                        //Se muestra cada relacion con el formato establecido (Docente, Estudiante).
                        for (G_Vertice estudiante : estudiantes) {
                            System.out.println("(" + docenteActual.getEtiqueta() + ", " + estudiante.getEtiqueta() + ")");
                        }
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la etiqueta del docente o estudiante a eliminar: ");
                    String etiquetaEliminar = scanner.nextLine();
                    // Creacion del nuevo vertice con la etiqueta a eliminar.
                    G_Vertice verticeEliminar = new G_Vertice(etiquetaEliminar);
                    grafo.eliminarVertice(verticeEliminar);
                    System.out.println("_____________________________________________________");
                    System.out.println("Docente o estudiante y sus relaciones eliminados.");
                    break;
                case 6:
                    // Salir del programa, recibe la condicion del while y se sale..
                    System.out.println("_____________________________________________________");
                    System.out.println("   Saliendo..................                        ");
                    System.out.println("_____________________________________________________");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println();
        }
        // Cierro el scanner y se libreran recursos.
        scanner.close();
    }
}

