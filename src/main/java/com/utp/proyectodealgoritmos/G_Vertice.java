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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        G_Vertice vertice = (G_Vertice) obj;
        return Objects.equals(etiqueta, vertice.etiqueta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etiqueta);
    }

}