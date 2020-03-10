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
public class VoltearColumna extends Opcion{
    
    private Tapete tapete;

    public VoltearColumna(Tapete tapete) {
        super("Voltear carta en columna");
        this.tapete = tapete;
    }
    
    
    @Override
    public void ejecutar() {
        tapete.recogerColumna("De").voltear();
    }
    
}
