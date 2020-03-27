package main.juego.util;

import main.exceptions.IntervaloException;
import static org.junit.Assert.*;
import org.junit.Test;
import main.util.Intervalo;

public class IntervaloTest {
    
    private Intervalo intervalo12_34;
    private Intervalo intervalo_8_4;
    
    public IntervaloTest() {
        this.intervalo12_34 = new Intervalo(12,34);
        this.intervalo_8_4 = new Intervalo(-8,-4);
    }

    @Test
    public void testLongitud() {
        assertEquals(22, intervalo12_34.longitud(), .0001);
        assertEquals(4, intervalo_8_4.longitud(), .0001);
    }

    @Test
    public void testDesplazar() {
        Intervalo intervaloSUT = intervalo12_34;
        intervaloSUT.desplazar(16);
        assertEquals(new Intervalo(28, 50), intervaloSUT);
        intervaloSUT = intervalo_8_4;
        intervaloSUT.desplazar(6);
        assertEquals(new Intervalo(-2, 2), intervaloSUT);
    }

    @Test
    public void testIncluyeValor() {
        assertTrue(intervalo12_34.incluye(16));
        assertFalse(intervalo_8_4.incluye(4));
    }

    @Test
    public void testIncluyeIntervalo() {
        assertTrue(intervalo12_34.incluye(new Intervalo(16, 30)));
        assertTrue(intervalo_8_4.incluye(new Intervalo(-7, -5)));
    }

    @Test
    public void testIntersecta() {
        assertTrue(intervalo12_34.intersecta(new Intervalo(16, 30)));
        assertTrue(intervalo_8_4.intersecta(new Intervalo(-7, -5)));
    }

    @Test
    public void testInterseccion() {
        try {
            assertEquals(new Intervalo(16, 30), intervalo12_34.interseccion(new Intervalo(16, 30)));
        }catch(IntervaloException ex) {
            fail();
        }
        
        try {
            assertEquals(new Intervalo(-7, -5), intervalo_8_4.interseccion(new Intervalo(5, 7)));
            fail();
        }catch(IntervaloException ex) {
        }catch(Exception ex) {
            fail();
        }
    }
}
