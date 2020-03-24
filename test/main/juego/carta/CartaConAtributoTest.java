/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.juego.carta;

import main.juego.Carta;
import main.juego.Carta;
import main.juego.PaloCarta;
import main.juego.PaloCarta;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Rober
 */
public class CartaConAtributoTest {
    private Carta cartaRoja;
    private Carta cartaNegra;
    
    private void preparaCartas() {
        this.cartaRoja = new Carta(PaloCarta.CORAZONES, 4);
        this.cartaNegra = new Carta(PaloCarta.PICAS, 5);
    }
    
    @Test
    public void testDistintoColor() {
            this.preparaCartas();
            cartaRoja.voltea();
            cartaNegra.voltea();
            
            assertTrue(cartaRoja.distintoColor(cartaNegra));
    }
    
    @Test
    public void testVoltea() {
            this.preparaCartas();
            cartaRoja.voltea();
            assertTrue(cartaRoja.bocaArriba());
            cartaNegra.voltea();
            assertTrue(cartaRoja.bocaArriba());
            cartaRoja.voltea();
            assertFalse(cartaRoja.bocaArriba());
    }   
    
    @Test
    public void testEsUnNumeroMenor() {
            this.preparaCartas();
            cartaRoja.voltea();
            cartaNegra.voltea();
            
            assertTrue(cartaRoja.esUnNumeroMenor(cartaNegra));
            assertFalse(cartaNegra.esUnNumeroMenor(cartaRoja));
    }
}
