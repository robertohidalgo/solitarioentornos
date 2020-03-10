package sinJUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.logging.Level;
import java.util.logging.Logger;
import main.juego.Carta;
import main.juego.PaloCarta;

/**
 *
 * @author Rober
 */
public class CartaTest {
    
    
        public void testDistintoColor() throws Exception {
            // Preparación del test
            Carta cartaRoja = new Carta(PaloCarta.CORAZONES, 1);
            cartaRoja.voltea();
            Carta cartaNegra = new Carta(PaloCarta.PICAS, 5);
            cartaNegra.voltea();
            
            // Ejecución del SUT
            boolean valorEsperado = true;
            boolean valorObtenido = cartaRoja.distintoColor(cartaNegra);
            
            // Análisis de los resultados
            if (valorEsperado != valorObtenido) {
                throw new Exception("TestDistintoColor: Error con " + cartaRoja + " y " + cartaNegra + ". Esperaba " + valorEsperado + " y se obtuvo " + valorObtenido);
            }
        }
        
        public void testEsUnNumeroMenor() throws Exception {
            // Preparación del test
            Carta cartaRoja = new Carta(PaloCarta.CORAZONES, 4);
            cartaRoja.voltea();
            Carta cartaNegra = new Carta(PaloCarta.PICAS, 5);
            cartaNegra.voltea();
            
            // Ejecución del SUT
            boolean valorEsperado = true;
            boolean valorObtenido = cartaRoja.esUnNumeroMenor(cartaNegra);
            
            // Análisis de los resultados
            if (valorEsperado != valorObtenido) {
                throw new Exception("TestEsUnNumeroMenor: Error con " + cartaRoja + " y " + cartaNegra + ". Esperaba " + valorEsperado + " y se obtuvo " + valorObtenido);
            }
        }
        
        
        
        public static void main(String[] args) {
     
            CartaTest cartaTest = new CartaTest();
            
            try {
                cartaTest.testDistintoColor();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            try {
                cartaTest.testEsUnNumeroMenor();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
    
}
