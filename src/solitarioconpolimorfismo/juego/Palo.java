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
public class Palo extends Mazo {

    public Palo() {
        super(Principal.NUM_CARTAS_PALO, "Palo");

    }

    public void moverA(Columna columna) {
        if (this.vacio()) {
            new GestorIO().out("Error!!! No hay cartas en palo");
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


    public boolean esValida(Carta carta) {
        assert carta != null;
        return this.vacio() && carta.esAs()
                || !this.vacio() && this.cima().esUnNumeroMenor(carta) && carta.igualPalo(this.cima());
    }

    @Override
    public void mostrarContenido() {

        new GestorIO().out(this.cima());
    }
}
