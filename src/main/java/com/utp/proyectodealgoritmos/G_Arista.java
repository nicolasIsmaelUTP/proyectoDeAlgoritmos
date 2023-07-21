/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.proyectodealgoritmos;

import java.util.Objects;

/**
 *
 * @author Grupo 01
 */
public class G_Arista {
    
    private G_Vertice vertice1;
    private G_Vertice vertice2;

    public G_Arista(G_Vertice vertice1, G_Vertice vertice2) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
    }
    
    //Obtencion de vertices con get
    public G_Vertice getVertice1() {
        return vertice1;
    }

    public G_Vertice getVertice2() {
        return vertice2;
    }

    
    @Override
    // Sobrescritura del método equals para comparar dos aristas y determinar si son iguales.
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        G_Arista arista = (G_Arista) obj;
        // Compara los vértices de ambas aristas en ambas direcciones para determinar si son iguales.
        return (Objects.equals(vertice1, arista.vertice1) && Objects.equals(vertice2, arista.vertice2))
            || (Objects.equals(vertice1, arista.vertice2) && Objects.equals(vertice2, arista.vertice1));
    }

    @Override
    // Código hash para combinar los dos vertices de la arista bidireccionalmente..
    public int hashCode() {
        return Objects.hash(vertice1, vertice2) + Objects.hash(vertice2, vertice1);
    }
}