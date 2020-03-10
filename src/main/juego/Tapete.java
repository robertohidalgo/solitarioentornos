package main.juego;

import main.util.GestorIO;
import main.util.Intervalo;
import main.juego.Mazo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rhidalgo
 */
public class Tapete {

    private Mazo[] mazos;

    private static final int NUM_COLUMNAS = 7;

    public Tapete() {
        mazos = new Mazo[13];
        mazos[0] = new Principal();
        mazos[1] = new Secundario();
        for (int i = 0; i < Principal.NUM_PALOS; i++) {
            mazos[i + 2] = new Palo();
        }

        for (int i = 0; i < NUM_COLUMNAS; i++) {
            mazos[i + 6] = new Columna(i + 1, getPrincipal());
        }
    }

    public Principal getPrincipal() {
        return (Principal) mazos[0];
    }

    public Secundario getSecundario() {
        return (Secundario) mazos[1];
    }

    public Palo getPalo(int numPalo) {
        return (Palo) mazos[numPalo + 2];
    }

    public Columna getColumna(int numColumna) {
        return (Columna) mazos[numColumna + 6];
    }

    public Palo recogerPalo(String prefijo) {
        GestorIO gestorIO = new GestorIO();
        int palo;
        boolean error;
        do {
            gestorIO.out("¿" + prefijo + " qué palo? [1-" + Principal.NUM_PALOS + "]: ");
            palo = gestorIO.inInt();
            error = !new Intervalo(1, Principal.NUM_PALOS).incluye(palo);
            if (error) {
                gestorIO.out("Error!!! Debe ser un número entre 1 y " + Principal.NUM_PALOS);
            }
        } while (error);
        return getPalo(palo - 1);
    }

    public Columna recogerColumna(String prefijo) {
        GestorIO gestorIO = new GestorIO();
        int columna;
        boolean error;
        do {
            gestorIO.out("¿" + prefijo + " qué columna? [1-" + NUM_COLUMNAS + "]: ");
            columna = gestorIO.inInt();
            error = !new Intervalo(1, NUM_COLUMNAS).incluye(columna);
            if (error) {
                gestorIO.out("Error!!! Debe ser un número entre 1 y " + NUM_COLUMNAS);
            }
        } while (error);
        return getColumna(columna - 1);
    }

    public void mostrar() {
        for (Mazo mazo : mazos) {
            mazo.mostrar();
        }
    }
}
