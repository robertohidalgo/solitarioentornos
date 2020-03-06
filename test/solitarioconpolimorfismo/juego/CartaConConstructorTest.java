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
public class CartaConConstructorTest {
    
    private Carta cartaRoja;
    private Carta cartaNegra;
    
    public CartaConConstructorTest(){
        this.cartaRoja = new Carta(PaloCarta.CORAZONES, 4);
        this.cartaNegra = new Carta(PaloCarta.PICAS, 5);
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
