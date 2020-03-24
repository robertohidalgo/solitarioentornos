/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.juego.carta;

import main.juego.Carta;
import main.juego.PaloCarta;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)

/**
 * Totalmente desaconsejable
 * @author Rober
 */
public class CartaCompartidoTest {
    
    private static Carta cartaRoja;
    private static Carta cartaNegra;
    
    @BeforeClass
    public static void beforeClass(){
        cartaRoja = new Carta(PaloCarta.CORAZONES, 4);
        cartaNegra = new Carta(PaloCarta.PICAS, 5);
    }
    
    @Test
    public void testDistintoColor() {
            assertTrue(cartaRoja.distintoColor(cartaNegra));
    }
    
    @Test
    public void testEsUnNumeroMenor() {
            assertTrue(cartaRoja.esUnNumeroMenor(cartaNegra));
            assertFalse(cartaNegra.esUnNumeroMenor(cartaRoja));
    }
    
    @Test
    public void testBocaArriba() {
            assertFalse(cartaRoja.bocaArriba());
            assertFalse(cartaNegra.bocaArriba());
    }
    
    @Test
    public void testVoltea() {
            cartaRoja.voltea();
            assertTrue(cartaRoja.bocaArriba());
            cartaNegra.voltea();
            assertTrue(cartaRoja.bocaArriba());
            cartaRoja.voltea();
            assertFalse(cartaRoja.bocaArriba());
    }   
    
    
    
}
