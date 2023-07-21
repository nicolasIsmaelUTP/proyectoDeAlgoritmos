/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.proyectodealgoritmos;

/**
 *
 * @author Grupo 01
 */

import java.util.Objects;

public class G_Vertice {
    
    private String etiqueta;

    public G_Vertice(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    @Override
    // Comprueba si el objeto actual es igual al objeto pasado como argumento.
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Convierte el objeto pasado como argumento a la clase G_Vertice para comparar sus etiquetas.
        G_Vertice vertice = (G_Vertice) obj;
        return Objects.equals(etiqueta, vertice.etiqueta);
    }

    @Override
    // Devuelve un valor de código hash basado en la etiqueta del vértice.
    public int hashCode() {
        return Objects.hash(etiqueta);
    }

}