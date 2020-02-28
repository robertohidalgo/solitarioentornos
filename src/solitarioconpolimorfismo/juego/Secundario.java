/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitarioconpolimorfismo.juego;

import solitarioconpolimorfismo.util.GestorIO;

/**
 *
 * @author profesor
 */
public class Secundario extends Mazo{
    
    
    public Secundario() {
        super(52 - 28, "Secundario");
    }

   

    public void moverA(Columna columna) {
        if (this.vacio()) {
            new GestorIO().out("Error!!! No hay cartas en secundario");
        } else {
            Carta carta = this.quita();
            if (columna.esValida(carta)) {
                columna.pon(carta);
            } else {
                this.pon(carta);
                new GestorIO().out("Error!!! No se puede realizar ese movimiento");
            }
        }
    }
    
    public void moverA(Palo palo) {
        if (this.vacio()) {
            new GestorIO().out("Error!!! No hay cartas en descarte");
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

    public void restaurar(Principal principal) {
        if (this.vacio()) {
            new GestorIO().out("Error!!! No hay cartas en descarte");
        } else {
            while (!this.vacio()) {
                Carta carta = this.quita();
                carta.voltea();
                principal.pon(carta);
            }
        }
    }

    @Override
    public void mostrarContenido() {
        int primeraVisible = ultima - 3;
            if (primeraVisible < 0) {
                primeraVisible = 0;
            }
            for (int i = primeraVisible; i < ultima; i++) {
                new GestorIO().out(cartas[i]);
            }
    }
    
}
