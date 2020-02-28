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
public class MovimientoPrincipalSecundario extends OpcionTapete{

    
    public MovimientoPrincipalSecundario(Tapete tapete){
        super(tapete, "Mover de principal a secundario");

    }
    
    @Override
    public void ejecutar() {
      
        tapete.getPrincipal().moverA(tapete.getSecundario());
    }
    
}
