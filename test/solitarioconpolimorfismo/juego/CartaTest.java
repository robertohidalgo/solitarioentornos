/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitarioconpolimorfismo.juego;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Rober
 */
public class CartaTest {
    
    
    @Test
    public void testVoltea() {
             // Preparación del test
            Carta cartaRoja = new Carta(PaloCarta.CORAZONES, 4);
            cartaRoja.voltea();
            
            // Ejecución del SUT
            boolean valorEsperado = true;
            boolean valorObtenido = cartaRoja.bocaArriba();
            assertEquals(valorEsperado, valorObtenido);
    }
    
    @Test
    public void testVolteaDosVeces() {
            // Preparación del test
            Carta cartaRoja = new Carta(PaloCarta.CORAZONES, 4);
            cartaRoja.voltea();
            cartaRoja.voltea();
            
            // Ejecución del SUT

            assertFalse(cartaRoja.bocaArriba());
    }
    
    @Test
    public void testVolteaTresVeces() {
            // Preparación del test
            Carta cartaRoja = new Carta(PaloCarta.CORAZONES, 4);
            cartaRoja.voltea();
            cartaRoja.voltea();
            cartaRoja.voltea();
            
            // Ejecución del SUT
            assertTrue(cartaRoja.bocaArriba());
    }
    
    @Test
    public void testDistintoColor() {
            // Preparación del test
            Carta cartaRoja = new Carta(PaloCarta.CORAZONES, 4);
            cartaRoja.voltea();
            Carta cartaNegra = new Carta(PaloCarta.PICAS, 5);
            cartaNegra.voltea();
            
            // Ejecución del SUT
            boolean valorEsperado = true;
            boolean valorObtenido = cartaRoja.distintoColor(cartaNegra);
            assertEquals(valorEsperado, valorObtenido);
    }
}
