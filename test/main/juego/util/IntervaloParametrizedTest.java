package main.juego.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.util.Intervalo;

@RunWith(Parameterized.class)
public class IntervaloParametrizedTest {

    private int inferiorSUT;
    private int superiorSUT;

    private int desplazamiento;
    private Intervalo intervaloAuxiliar;

    private int longitudEsperada;
    private Intervalo intervaloDesplazadoEsperado;
    private boolean incluyeValorEsperado;
    private boolean incluyeIntervaloEsperado;
    private boolean intersectaEsperado;
    private Intervalo intervaloInterseccionEsperado;

    @Parameters(name = "{index}: Para [{0}, {1}], con desplazamiento {2} y intervalo auxiliar {3}")
    public static Object[][] datos() {
        return new Object[][]{
            // private int inferiorSUT;
            // private int superiorSUT;
            //
            // private int desplazamiento;
            // private Intervalo intervaloAuxiliar;
            //
            // private int longitudEsperada;
            // private Intervalo intervaloDesplazadoEsperado;
            // private boolean incluyeValorEsperado;
            // private boolean incluyeIntervaloEsperado;
            // private boolean intersectaEsperado;
            // private Intervalo intervaloInterseccionEsperado;
            {12, 34,
                16, new Intervalo(16, 30),
                22, new Intervalo(28, 50), true, true, true,
                new Intervalo(16, 30)},
            {-8, -4,
                6, new Intervalo(-7, -5),
                4, new Intervalo(-2, 2), false, true, true,
                new Intervalo(-7, -5)},
            {-8, 4,
                -2, new Intervalo(-7, -5),
                12, new Intervalo(-10, 2), true, true, true,
                new Intervalo(-7, -5)},
            {-8, 4,
                10, new Intervalo(-7, -5),
                12, new Intervalo(2, 14), false, true, true,
                new Intervalo(-7, -5)},
            {-8, 4,
                6, new Intervalo(2, 9),
                12, new Intervalo(-2, 10), false, false, true,
                new Intervalo(2, 4)}
        };
    }

    public IntervaloParametrizedTest(
            int inferiorSUT, int superiorSUT, // valores para creación del sut
            int desplazamiento, Intervalo closedInterval, // valores auxiliares
            int longitudEsperada, // resultados
            Intervalo intervaloDesplazadoEsperado,
            boolean incluyeValorEsperado,
            boolean incluyeIntervaloEsperado,
            boolean intersectaEsperado,
            Intervalo intervaloInterseccionEsperado) {
        this.inferiorSUT = inferiorSUT;
        this.superiorSUT = superiorSUT;

        this.longitudEsperada = longitudEsperada;
        this.desplazamiento = desplazamiento;

        this.intervaloDesplazadoEsperado = intervaloDesplazadoEsperado;
        this.incluyeValorEsperado = incluyeValorEsperado;
        this.intervaloAuxiliar = closedInterval;
        this.incluyeIntervaloEsperado = incluyeIntervaloEsperado;
        this.intersectaEsperado = intersectaEsperado;
        this.intervaloInterseccionEsperado = intervaloInterseccionEsperado;
    }

    private Intervalo intervaloSUT;

    @Before
    public void before() {
        intervaloSUT = new Intervalo(inferiorSUT, superiorSUT);
    }

    @Test
    public void testLongitud() {
        assertEquals(longitudEsperada, intervaloSUT.longitud(), .0001);
    }

    @Test
    public void testDesplazar() {
        intervaloSUT.desplazar(desplazamiento);
        assertEquals(intervaloDesplazadoEsperado, intervaloSUT);
    }

    @Test
    public void testIncluyeValor() {
        assertEquals(incluyeValorEsperado, intervaloSUT.incluye(desplazamiento));
    }

    @Test
    public void testIncluyeIntervalo() {
        assertEquals(incluyeIntervaloEsperado, intervaloSUT.incluye(intervaloAuxiliar));
    }

    @Test
    public void testIntersecta() {
        assertEquals(intersectaEsperado, intervaloSUT.intersecta(intervaloAuxiliar));
    }

    @Test
    public void testInterseccion() {
        assertEquals(intervaloInterseccionEsperado, intervaloSUT.interseccion(intervaloAuxiliar));
    }
}
