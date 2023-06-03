package com.utp.proyectodealgoritmos;

/**
 *
 * @author NICOLAS
 */
public class Tiempo {
    private int hora;
    private int minuto;

    public Tiempo(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    @Override
    public String toString() {
        if (minuto < 10) {
            return hora + ":0" + minuto;
        }
        return hora + ":" + minuto;
    }

    public void agregarMinutos(int m) {
        minuto += m;
        if (minuto >= 60) {
            hora += minuto / 60;
            minuto = minuto % 60;
        }
    }

    public boolean esMayorQue(Tiempo t2) {
        if (hora > t2.hora) {
            return true;
        } else if (hora == t2.hora) {
            if (minuto > t2.minuto) {
                return true;
            }
        }
        return false;
    }
}
