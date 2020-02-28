/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitarioconpolimorfismo.juego;

/**
 *
 * @author Rober
 */
public enum PaloCarta {
    CORAZONES, PICAS, TREBOLES, DIAMANTES;
    
    public static int indicePalo(PaloCarta palo) {
        switch (palo) {
            case CORAZONES:
                return 0;
            case PICAS:
                return 1;
            case TREBOLES:
                return 2;
            case DIAMANTES:
                return 3;
        }
        
        return -1;
    }
}
