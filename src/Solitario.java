/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import solitarioconpolimorfismo.juego.Tapete;
import solitarioconpolimorfismo.menuopciones.Menu;
import solitarioconpolimorfismo.menuopciones.opciones.MovimientoColumnaColumna;
import solitarioconpolimorfismo.menuopciones.opciones.MovimientoColumnaPalo;
import solitarioconpolimorfismo.menuopciones.opciones.MovimientoPaloColumna;
import solitarioconpolimorfismo.menuopciones.opciones.MovimientoPrincipalSecundario;
import solitarioconpolimorfismo.menuopciones.opciones.MovimientoSecundarioColumna;
import solitarioconpolimorfismo.menuopciones.opciones.MovimientoSecundarioPalo;
import solitarioconpolimorfismo.menuopciones.opciones.RestauracionSecundario;
import solitarioconpolimorfismo.menuopciones.opciones.Salida;
import solitarioconpolimorfismo.menuopciones.opciones.VoltearColumna;

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
