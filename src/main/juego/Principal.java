/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.juego;

import java.util.Random;
import main.util.GestorIO;

/**
 *
 * @author profesor
 */
public class Principal extends Mazo {

    public static final int NUM_PALOS = 4;
    public static final int NUM_CARTAS_PALO = 13;

    public Principal() {
        super(NUM_PALOS * NUM_CARTAS_PALO, "Principal");

        for (int i = 0; i < NUM_PALOS; i++) {
            for (int j = 0; j < NUM_CARTAS_PALO; j++) {

                pon(new Carta(PaloCarta.values()[i], j));
            }
        }

        mezclar();
    }

    private void mezclar() {
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {

            int origen = random.nextInt(NUM_PALOS * NUM_CARTAS_PALO);
            int destino = random.nextInt(NUM_PALOS * NUM_CARTAS_PALO);
            Carta cartaAuxiliar = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = cartaAuxiliar;
        }
    }

    public void moverA(Secundario secundario) {
        if (!this.vacio()) {
            for (int i = 0; i < 3; i++) {
                Carta carta = this.quita();
                carta.voltea();
                secundario.pon(carta);
            }
        } else {
            new GestorIO().out("El mazo principal está vacío!");
        }

    }

    @Override
    public void mostrarContenido() {
        new GestorIO().out(ultima + " cartas");
    }

}
