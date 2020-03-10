/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.juego;

import main.util.GestorIO;

/**
 *
 * @author profesor
 */
public class Columna extends Mazo {

    private int numColumna;

    public Columna(int numColumna, Principal principal) {
        super(numColumna + Principal.NUM_CARTAS_PALO - 1, "Columna");
        this.numColumna = numColumna;

        for (int i = 0; i < numColumna; i++) {
            Carta carta = principal.quita();

            if (i == numColumna - 1) {
                carta.voltea();
            }

            this.pon(carta);

        }
    }

    private Columna(int numColumna) {
        super(numColumna + Principal.NUM_CARTAS_PALO - 1, "Columna");
        this.numColumna = numColumna;
    }

    public void moverA(Columna columna) {
        if (this.vacio()) {
            new GestorIO().out("Error!!! No hay cartas en columna");
        } else if (!this.hayCartasBocaArriba()) {
            new GestorIO().out("Error!!! No hay cartas boca arriba en la columna");
        } else {

            Columna columnaAux = this.quitaCartasBocaArriba();

            if (!columnaAux.vacio()) {
                Carta carta = columnaAux.cima();
                if (columna.esValida(carta)) {
                    columna.pon(columnaAux);
                } else {
                    this.pon(columnaAux);
                    new GestorIO().out("Error!!! No se puede realizar ese movimiento");
                }
            }
        }
    }

    public void moverA(Palo palo) {
        if (this.vacio()) {
            new GestorIO().out("Error!!! No hay cartas en columna");
        } else {
            Carta carta = this.quita();
            if (palo.esValida(carta)) {
                palo.pon(carta);
            } else {
                this.pon(carta);
                new GestorIO().out("Error!!! No se puede realizar ese movimiento");
            }
        }
    }

    public void voltear() {
        if (this.vacio()) {
            new GestorIO().out("Error!!! No hay carta que voltear");
        } else if (this.cima().bocaArriba()) {
            new GestorIO().out("Error!!! No hay carta boca abajo en la cima");
        } else {
            this.cima().voltea();
        }
    }

    public void pon(Columna columna) {
        while (!columna.vacio()) {
            Carta carta = columna.quita();
            this.pon(carta);
        }
    }

    public boolean esValida(Carta carta) {
        assert carta != null;
        return this.vacio() && carta.esRey()
                || !this.vacio() && this.cima().bocaArriba()
                && carta.esUnNumeroMenor(this.cima())
                && this.cima().distintoColor(carta);
    }

    private Columna quitaCartasBocaArriba() {
        assert hayCartasBocaArriba();
        GestorIO gestorIO = new GestorIO();

        gestorIO.out("\nCuántas cartas quitas?");
        int numCartas = gestorIO.inInt();
        Columna columna = new Columna(this.numColumna);

        while (numCartas > 0 && hayCartasBocaArriba()) {
            Carta carta = this.quita();

            if (carta.bocaArriba()) {
                columna.pon(carta);
                numCartas--;

            } else {
                this.pon(carta);
            }

            if (numCartas > 0 && !hayCartasBocaArriba()) {
                gestorIO.out("\nSe movieron menos cartas de las que se pidieron mover");
            }
        }

        return columna;
    }

    private boolean hayCartasBocaArriba() {
        return !this.vacio() && this.cima().bocaArriba();
    }

   
    @Override
    public void mostrarContenido() {
        for (int i = 0; i < ultima; i++) {
            new GestorIO().out(cartas[i]);
        }
    }

}
