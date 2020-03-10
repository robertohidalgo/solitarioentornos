
package main.juego;

import main.util.Intervalo;

/**
 *
 * @author profesor
 */
public class Carta {
    
    private PaloCarta palo;
    private int indiceNumero; 
    private boolean bocaAbajo;
    
    private static final String[] NOMBRE_PALOS = {"Corazones", "Picas", "Tréboles", "Diamantes"};
    private static final String[] NUMEROS = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; 
    private static final int INDICE_REY = 12;
    private static final int INDICE_AS = 0;
    
    public Carta(PaloCarta palo, int numero){
        assert new Intervalo(1, 12).incluye(numero);
        this.palo = palo;
        this.indiceNumero = numero - 1;
        this.bocaAbajo = true;
    }
    
    @Override
    public String toString() {
        String numero = "???";
        String palo= "???";
        if (!bocaAbajo){
            numero = NUMEROS[this.indiceNumero];
            palo = NOMBRE_PALOS[PaloCarta.indicePalo(this.palo)];
        }
        return "(" + numero + " de " + palo + ")";
    }

    public void voltea() {
      bocaAbajo = !bocaAbajo;  
    }

    public boolean esRey() {
       return indiceNumero == INDICE_REY;
    }
    
    public boolean esAs() {
        return indiceNumero == INDICE_AS;
    }

    public boolean igualPalo(Carta carta) {
        assert carta!= null;
        return palo == carta.palo;
    }
    
    public boolean bocaArriba() {
        return !bocaAbajo;
    }

    public boolean distintoColor(Carta carta) {
        assert carta!=null;
        return this.rojo() && !carta.rojo() 
                || !this.rojo() && carta.rojo();
    }
    
    private boolean rojo() {
        return palo == PaloCarta.CORAZONES || palo == PaloCarta.DIAMANTES;
    }
    
    public boolean esUnNumeroMenor(Carta carta) {
        assert carta != null;
        return indiceNumero == carta.indiceNumero-1;
    }

    
    
}
