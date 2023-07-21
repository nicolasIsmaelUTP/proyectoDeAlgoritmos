/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.proyectodealgoritmos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Grupo 01
 */


public class G_Grafo {
    
    // Grafo como un mapa de relaciones, donde cada vértice está asociado con una lista de vértices adyacentes.
   private Map<G_Vertice, List<G_Vertice>> grafo;
   private Map<G_Vertice, List<G_Vertice>> relaciones;

    public G_Grafo() {
        grafo = new HashMap<>();
        relaciones = new HashMap<>();
    }
    
    //Metodos
    
    // Agrega un nuevo vértice al grafo si aún no existe en el mapa de relaciones.
    public void agregarVertice(G_Vertice vertice) {
        if (!relaciones.containsKey(vertice)) {
            relaciones.put(vertice, new ArrayList<>());
        }
    }
    
    // Establece una relación bidireccional entre dos vértices en el grafo.
    public void agregarRelacion(G_Vertice vertice1, G_Vertice vertice2) {
        relaciones.get(vertice1).add(vertice2);
        relaciones.get(vertice2).add(vertice1);
    }
    
     // Obtiene una lista de todos los vértices presentes en el grafo.
    public List<G_Vertice> obtenerVertices() {
        return new ArrayList<>(relaciones.keySet());
    }
    
    // Obtiene una copia del mapa de relaciones del grafo.
    public Map<G_Vertice, List<G_Vertice>> obtenerRelaciones() {
        return new HashMap<>(relaciones);
    }
    
    
    // Agrega  aristas al grafo, conectando dos vértices mediante la arista.
    public void agregarArista(G_Arista arista) {
        G_Vertice vertice1 = arista.getVertice1();
        G_Vertice vertice2 = arista.getVertice2();
        
        // Lanza una excepción si al menos uno de los vértices no existe en el grafo.
        if (!relaciones.containsKey(vertice1) || !relaciones.containsKey(vertice2)) {
            throw new IllegalArgumentException("Al menos uno de los vértices no existe en el grafo.");
        }
        // Agrega los vértices a la lista de adyacencia del otro si aún no están conectados.
        if (!relaciones.get(vertice1).contains(vertice2)) {
            relaciones.get(vertice1).add(vertice2);
            relaciones.get(vertice2).add(vertice1);
        }
    }

    // Elimina un vértice y sus relaciones asociadas del grafo.
   public void eliminarVertice(G_Vertice vertice) {
    relaciones.remove(vertice);
    for (List<G_Vertice> estudiantes : relaciones.values()) {
        estudiantes.remove(vertice);
    }
}

    // Elimina una arista del grafo, rompiendo la relación entre los dos vértices que conecta.
    public void eliminarArista(G_Arista arista) {
        G_Vertice vertice1 = arista.getVertice1();
        G_Vertice vertice2 = arista.getVertice2();
        
        // Lanza una excepción si al menos uno de los vértices no existe en el grafo.
        if (!grafo.containsKey(vertice1) || !grafo.containsKey(vertice2)) {
            throw new IllegalArgumentException("Al menos uno de los vértices no existe en el grafo.");
        }
        
        grafo.get(vertice1).remove(vertice2);
        grafo.get(vertice2).remove(vertice1);
    }
    
   
    // Obtiene una lista de todas las aristas presentes en el grafo (relaciones únicas entre vértices).
    public List<G_Arista> obtenerAristas() {
        List<G_Arista> aristas = new ArrayList<>();
        Set<G_Arista> aristasSet = new HashSet<>();
        
        for (Map.Entry<G_Vertice, List<G_Vertice>> entry : grafo.entrySet()) {
            G_Vertice vertice1 = entry.getKey();
            for (G_Vertice vertice2 : entry.getValue()) {
                G_Arista arista = new G_Arista(vertice1, vertice2);
                if (!aristasSet.contains(arista)) {
                    aristas.add(arista);
                    aristasSet.add(arista);
                }
            }
        }
        
        return aristas;
    }
     
    // Obtiene una lista de vértices adyacentes al vértice dado en el grafo.
    public List<G_Vertice> obtenerAdyacentes(G_Vertice vertice) {
        // Lanza una excepción si el vértice no existe en el grafo.
        if (!grafo.containsKey(vertice)) {
            throw new IllegalArgumentException("El vértice no existe en el grafo.");
        }
        
        return new ArrayList<>(grafo.get(vertice));
    }
}

   