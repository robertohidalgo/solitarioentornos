package main.juego;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import main.util.Intervalo;

@RunWith(Parameterized.class)
public class IntervaloSinConstructorParametrizedTest {

    @Parameter(0) public int inferiorSUT;
    @Parameter(1) public int superiorSUT;

    @Parameter(2) public int desplazamiento;
    @Parameter(3) public Intervalo intervaloAuxiliar;

    @Parameter(4) public int longitudEsperada;
    @Parameter(5) public Intervalo intervaloDesplazadoEsperado;
    @Parameter(6) public boolean incluyeValorEsperado;
    @Parameter(7) public boolean incluyeIntervaloEsperado;
    @Parameter(8) public boolean intersectaEsperado;
    @Parameter(9) public Intervalo interseccionEsperado;

    @Parameters(name = "{index}: Para Intervalo[{0}, {1}], desplazamiento {2} y intervaloAuxiliar {3}")
    public static Object[][] datos() {
        return new Object[][]{
            {12, 34,
                16, new Intervalo(16, 30), 
                22,
                new Intervalo(28, 50), true, true, true,
                new Intervalo(16, 30)},
            {-8, -4, 6, new Intervalo(-7, -5), 4,
                new Intervalo(-2, 2), false, true, true,
                new Intervalo(-7, -5)},
            {-8, 4, -2, new Intervalo(-7, -5), 12,
                new Intervalo(-10, 2), true, true, true,
                new Intervalo(-7, -5)},
            {-8, 4, 10, new Intervalo(-7, -5), 12,
                new Intervalo(2, 14), false, true, true,
                new Intervalo(-7, -5)},
            {-8, 4, 6, new Intervalo(2, 9), 12,
                new Intervalo(-2, 10), false, false, true,
                new Intervalo(2, 4)}
        };
    }

    private Intervalo intervaloSUT;

    @Before
    public void before() {
        intervaloSUT = new Intervalo(inferiorSUT, superiorSUT);
    }

    @Test
    public void testLongitud() {
        double longitudObtenida = intervaloSUT.longitud();
        assertEquals(longitudEsperada, longitudObtenida, .0001);
    }

    @Test
    public void testDesplazar() {
        intervaloSUT.desplazar(desplazamiento);
        assertEquals(intervaloDesplazadoEsperado, intervaloSUT);
    }

    @Test
    public void testIncluyeValor() {
        boolean incluyeValorObtenido = intervaloSUT.incluye(desplazamiento);
        assertEquals(incluyeValorEsperado, incluyeValorObtenido);
    }

    @Test
    public void testIncluyeIntervalo() {
        boolean incluyeIntervaloObtenido = intervaloSUT.incluye(intervaloAuxiliar);
        assertEquals(incluyeIntervaloEsperado, incluyeIntervaloObtenido);
    }

    @Test
    public void testIntersecta() {
        boolean invertaloIntersectaObtenido = intervaloSUT.intersecta(intervaloAuxiliar);
        assertEquals(intersectaEsperado, invertaloIntersectaObtenido);
    }

    @Test
    public void testInterseccion() {
        Intervalo interseccionObtenido = intervaloSUT.interseccion(intervaloAuxiliar);
        assertEquals(interseccionEsperado, interseccionObtenido);
    }
}
