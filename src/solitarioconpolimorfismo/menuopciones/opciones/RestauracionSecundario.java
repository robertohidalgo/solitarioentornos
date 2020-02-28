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
public class RestauracionSecundario extends OpcionTapete{
    
    public RestauracionSecundario(Tapete tapete) {
        super(tapete, "Restaurar principal");
      
    }
    
    
    @Override
    public void ejecutar() {
        tapete.getSecundario().restaurar(tapete.getPrincipal());
    }
    
    
    
}
