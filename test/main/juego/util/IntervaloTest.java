package main.juego.util;

import static org.junit.Assert.*;
import org.junit.Test;
import main.util.Intervalo;

public class IntervaloTest {

    @Test
    public void testLength() {
        assertEquals(22, new Intervalo(12, 34).longitud(), .0001);
        assertEquals(4, new Intervalo(-8, -4).longitud(), .0001);
    }

    @Test
    public void testShift() {
        Intervalo intervaloSUT = new Intervalo(12, 34);
        intervaloSUT.desplazar(16);
        assertEquals(new Intervalo(28, 50), intervaloSUT);
        intervaloSUT = new Intervalo(-8, -4);
        intervaloSUT.desplazar(6);
        assertEquals(new Intervalo(-2, 2), intervaloSUT);
    }

    @Test
    public void testIncludesValue() {
        assertTrue(new Intervalo(12, 34).incluye(16));
        assertFalse(new Intervalo(-8, -4).incluye(4));
    }

    @Test
    public void testIncludesIntervalo() {
        assertTrue(new Intervalo(12, 34).incluye(new Intervalo(16, 30)));
        assertTrue(new Intervalo(-8, -4).incluye(new Intervalo(-7, -5)));
    }

    @Test
    public void testIntersected() {
        assertTrue(new Intervalo(12, 34).intersecta(new Intervalo(16, 30)));
        assertTrue(new Intervalo(-8, -4).intersecta(new Intervalo(-7, -5)));
    }

    @Test
    public void testIntersection() {
        assertEquals(new Intervalo(16, 30), new Intervalo(12, 34).interseccion(new Intervalo(16, 30)));
        assertEquals(new Intervalo(-7, -5), new Intervalo(-8, -4).interseccion(new Intervalo(-7, -5)));
    }
}
