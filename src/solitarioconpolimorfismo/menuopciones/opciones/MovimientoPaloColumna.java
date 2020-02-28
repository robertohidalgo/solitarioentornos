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
public class MovimientoPaloColumna extends OpcionTapete{
    
    
    public MovimientoPaloColumna(Tapete tapete) {
        super(tapete, "Mover de palo a columna");

    }
   
    @Override
    public void ejecutar() {
        tapete.recogerPalo("De").moverA(tapete.recogerColumna("A"));
    }

    
    
}
