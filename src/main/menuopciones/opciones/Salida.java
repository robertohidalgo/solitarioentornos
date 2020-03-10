/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.menuopciones.opciones;

import main.menuopciones.opciones.Opcion;

/**
 *
 * @author rhidalgo
 */
public class Salida  extends Opcion{

    private boolean ejecutado;
    
    public Salida() {
        super("Salir");
        this.ejecutado = false;
    }
    
    @Override
    public void ejecutar() {
       this.ejecutado = true;
    }
    
    public boolean ejecutado() {
        return this.ejecutado;
    }
    
}
