package com.utp.proyectodealgoritmos;

/**
 *
 * @author NICOLAS
 */
public class Solicitud {
    private String tipo;
    private String telefono;

    public Solicitud(String tipo, String telefono) {
        this.tipo = tipo;
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return tipo + ": " + telefono;
    }
}
