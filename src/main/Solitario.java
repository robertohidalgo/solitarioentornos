package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import main.juego.Tapete;
import main.menuopciones.Menu;
import main.menuopciones.opciones.MovimientoColumnaColumna;
import main.menuopciones.opciones.MovimientoColumnaPalo;
import main.menuopciones.opciones.MovimientoPaloColumna;
import main.menuopciones.opciones.MovimientoPrincipalSecundario;
import main.menuopciones.opciones.MovimientoSecundarioColumna;
import main.menuopciones.opciones.MovimientoSecundarioPalo;
import main.menuopciones.opciones.RestauracionSecundario;
import main.menuopciones.opciones.Salida;
import main.menuopciones.opciones.VoltearColumna;

/**
 *
 * @author profesor
 */
public class Solitario {

    private Menu menu;
    private Tapete tapete;

    private Solitario() {
        this.tapete = new Tapete();
        this.menu = new Menu();
        this.menu.añadir(new MovimientoPrincipalSecundario(tapete));
        this.menu.añadir(new MovimientoSecundarioColumna(tapete));
        this.menu.añadir(new MovimientoColumnaColumna(tapete));
        this.menu.añadir(new MovimientoColumnaPalo(tapete));
        this.menu.añadir(new MovimientoPaloColumna(tapete));
        this.menu.añadir(new MovimientoSecundarioPalo(tapete));
        this.menu.añadir(new VoltearColumna(tapete));
        this.menu.añadir(new RestauracionSecundario(tapete));
        this.menu.añadir(new Salida());
    }

    private void jugar() {

        do {
            tapete.mostrar();
            menu.mostrar();
            menu.getOpcion().ejecutar();

        } while (!menu.terminado());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Solitario().jugar();
    }

}
