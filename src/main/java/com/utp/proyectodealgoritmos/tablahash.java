/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.utp.proyectodealgoritmos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ISAAC
 */
public class tablahash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Crear una instancia de HashMap
        Map<String, Integer> tablaHash = new HashMap<>();
        // Agregar elementos a la tabla hash
        System.out.println("Elije una opcion");
        System.out.println("1-Agregar \n2-buscar \n3-eliminar \n4-Listar");
        int x = sc.nextInt();
        
        switch(x){
            case 1:
            //Intruccion1;
            System.out.println("Escriba un numero de telefono (min->9 dig.) ");
            
            int telefono = sc.nextInt();
            //luego agregar una confirmacion en donde se verifique los numeros enteros
            //antes de pasarlos a un string
            
            String telefonoString = String.valueOf(telefono);

            if (telefonoString.length() == 9) {
            System.out.println("Número ingresado correctamente.");
            } else {
            System.out.println("Número mal ingresado.");
            }
            
            System.out.println("Ingrese su primer apellido");
            String Apellido1 = sc.nextLine();
            
            System.out.println("Ingrese su segundo apellido");
            String Apellido2 = sc.nextLine();
            
            System.out.println("Ingrese su primer nombre");
            String nombre1 = sc.nextLine();
            
            break;
            case 2:
            //Intruccion2;
            break;
            case 3:
            //Intruccion3;
            break;
                
            default:
            //IntruccionDefault;
                System.out.println("Ingrese uno de los numeros propuestos");
            }
        
        
        
        tablaHash.put("Clave1", 10);
        tablaHash.put("Clave2", 20);
        tablaHash.put("Clave3", 30);
        // Obtener el valor asociado a una clave
        int valor = tablaHash.get("Clave2");
        System.out.println("Valor asociado a Clave2: " + valor);
        // Verificar si una clave existe en la tabla hash
        boolean existe = tablaHash.containsKey("Clave3");
        System.out.println("Â¿Clave3 existe en la tabla hash?: "
                + existe);
        // Recorrer y mostrar todos los pares clave-valor
        for (Map.Entry<String, Integer> entry : tablaHash.entrySet()) {
            String clave = entry.getKey();
            int valorActual = entry.getValue();
            System.out.println("Clave: " + clave + ", Valor: "
                    + valorActual);
        }
        // Eliminar un par clave-valor de la tabla hash
        tablaHash.remove("Clave1");
        System.out.println("Tabla hash despuÃ©s de eliminar Clave1: "
                + tablaHash);
    }

}
