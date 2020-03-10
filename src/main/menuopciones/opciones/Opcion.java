/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.menuopciones.opciones;

import main.util.GestorIO;

/**
 *
 * @author rhidalgo
 */
public abstract class Opcion {

    private String titulo;
    
    public Opcion(String titulo) {
        this.titulo = titulo;
        
    }
    
    public void mostrar(int numOpcion) {
        new GestorIO().out("\n" + numOpcion + "." + titulo);
    }
    
    public abstract void ejecutar();
    
    
}
