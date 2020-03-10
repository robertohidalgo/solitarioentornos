/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.menuopciones.opciones;

import main.juego.Tapete;

/**
 *
 * @author rhidalgo
 */
public class MovimientoColumnaColumna  extends OpcionTapete {
   
    public MovimientoColumnaColumna(Tapete tapete) {
        super(tapete, "Mover de columna a columna");
      
    }
    
    @Override
    public void ejecutar() {
        tapete.recogerColumna("De").moverA(tapete.recogerColumna("A"));
    }
    
    
    
}
