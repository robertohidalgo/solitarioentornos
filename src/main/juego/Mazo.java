/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.juego;

import main.util.GestorIO;
import static main.juego.Principal.NUM_CARTAS_PALO;
import static main.juego.Principal.NUM_PALOS;

/**
 *
 * @author rhidalgo
 */
public abstract class Mazo {
    
    protected Carta[] cartas;
    protected int ultima;
    protected String titulo;
    
    public Mazo(int maxCartas, String titulo) {
        this.cartas = new Carta[maxCartas];
        this.ultima = 0;
        this.titulo = titulo;
    }
    
    public void pon(Carta carta) {
        assert carta != null;
        assert !carta.bocaArriba();
        assert !this.completa();
        cartas[ultima] = carta;
        ultima++;
    }
    
    public Carta quita() {
        assert !this.vacio();
        ultima--;
        return cartas[ultima];
    }
    
    protected boolean vacio() {
        return ultima == 0;
    }
    
    private boolean completa() {
        return ultima == NUM_PALOS * NUM_CARTAS_PALO;
    }
    
    protected Carta cima() {
        return cartas[ultima - 1];
    }
    
    public void mostrar() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("\n"+titulo+":");
        if (this.vacio()) {
            gestorIO.out("Vacío");
        } else {
            this.mostrarContenido();
        }
    }
    
    public abstract void mostrarContenido();
}
