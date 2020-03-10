/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.juego;

import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Rober
 */
public class TapeteConExcepcionesTest {
    
    
    @Test
    public void testGetColumna() {
        try {
            Tapete tapete = new Tapete();
            tapete.getColumna(-100);
            fail();
        }
        catch(ArrayIndexOutOfBoundsException ex) {
            
        }
        catch (Exception ex) {
            fail();
        }
    }
}
