/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitarioconpolimorfismo.juego;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rober
 */
public class CartaCompactTest {
    
    @Test
    public void testDistintoColor() {
            Carta cartaRoja = new Carta(PaloCarta.CORAZONES, 4);
            cartaRoja.voltea();
            Carta cartaNegra = new Carta(PaloCarta.PICAS, 5);
            cartaNegra.voltea();
            
            assertTrue(cartaRoja.distintoColor(cartaNegra));
    }
    
    @Test
    public void testVoltea() {
            Carta cartaRoja = new Carta(PaloCarta.CORAZONES, 4);
            cartaRoja.voltea();
            assertTrue(cartaRoja.bocaArriba());
            cartaRoja.voltea();
            assertFalse(cartaRoja.bocaArriba());
            cartaRoja.voltea();
            assertTrue(cartaRoja.bocaArriba());
    }   
    
    @Test
    public void testEsUnNumeroMenor() {
            Carta cartaRoja = new Carta(PaloCarta.CORAZONES, 4);
            cartaRoja.voltea();
            Carta cartaNegra = new Carta(PaloCarta.PICAS, 5);
            cartaNegra.voltea();
            
            assertTrue(cartaRoja.esUnNumeroMenor(cartaNegra));
            assertFalse(cartaNegra.esUnNumeroMenor(cartaRoja));
    }
}
