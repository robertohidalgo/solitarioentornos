/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.juego;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Rober
 */
public class CartaConExcepcionesTest {
    private Carta cartaRoja;
    private Carta cartaNegra;
    
    public CartaConExcepcionesTest(){
        this.cartaRoja = new Carta(PaloCarta.CORAZONES, 4);
        this.cartaNegra = new Carta(PaloCarta.PICAS, 5);
    }
    
    @Test
    public void testCarta() {
        try {
            Carta cartaRoja = new Carta(PaloCarta.CORAZONES, 100);
            cartaRoja.voltea();
            cartaRoja.toString();
            fail();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            
        }
        catch (Exception e) {
            fail();
        }
    }
    
    @Test
    public void testDistintoColor() {
            cartaRoja.voltea();
            cartaNegra.voltea();
            assertTrue(cartaRoja.distintoColor(cartaNegra));
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
    
    @Test
    public void testEsUnNumeroMenor() {
            cartaRoja.voltea();
            cartaNegra.voltea();
            assertTrue(cartaRoja.esUnNumeroMenor(cartaNegra));
            assertFalse(cartaNegra.esUnNumeroMenor(cartaRoja));
    }
}
