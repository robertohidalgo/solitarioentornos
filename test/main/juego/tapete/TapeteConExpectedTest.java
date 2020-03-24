/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.juego.tapete;

import main.juego.Tapete;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Rober
 */
public class TapeteConExpectedTest {
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetColumna() {
            Tapete tapete = new Tapete();
            tapete.getColumna(-100);
            fail();
     
    }
}
