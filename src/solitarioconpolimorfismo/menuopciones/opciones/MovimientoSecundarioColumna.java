/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitarioconpolimorfismo.menuopciones.opciones;

import solitarioconpolimorfismo.juego.Tapete;

/**
 *
 * @author rhidalgo
 */
public class MovimientoSecundarioColumna extends OpcionTapete {

    public MovimientoSecundarioColumna(Tapete tapete) {
        super(tapete, "Mover de secundario a columna");

    }

    @Override
    public void ejecutar() {
        tapete.getSecundario().moverA(tapete.recogerColumna("A"));  
    }
    
}
