package main.juego.util;

import static org.junit.Assert.*;
import main.util.Intervalo;

public class IntervaloObjectTest {
        
        //Valores para la creación del SUT
	private int inferiorSUT;
 	private int superiorSUT;

        //Valores adicionales para ejercitar el SUT
	private int desplazamiento;
	private Intervalo intervaloAuxiliar;

        // Valores obtenidos en la ejercitación de cada método del SUT
	private int longitudEsperada;
	private Intervalo intervaloDesplazadoEsperado;
        private boolean incluyeValorEsperado;
	private boolean incluyeIntervaloEsperado;
	private boolean intersectaEsperado;
	private Intervalo intervaloInterseccionEsperado;

	private Intervalo intervaloSUT;

	public IntervaloObjectTest(
			int inferior, int superior, // OUT
			int desplazamiento, Intervalo intervalo, // arguments
			int longitudEsperada, 
			Intervalo intervaloDesplazadoEsperado,
			boolean incluyeValorEsperado,
			boolean incluyeIntervaloEsperado,
			boolean intersectaEsperado, 
			Intervalo intervaloInterseccionEsperado) {
            
		this.inferiorSUT = inferior;
		this.superiorSUT = superior;

		this.desplazamiento = desplazamiento;
		this.intervaloAuxiliar = intervalo;

		this.longitudEsperada = longitudEsperada;
		this.intervaloDesplazadoEsperado = intervaloDesplazadoEsperado;
		this.incluyeValorEsperado = incluyeValorEsperado;
		this.incluyeIntervaloEsperado = incluyeIntervaloEsperado;
		this.intersectaEsperado = intersectaEsperado;
		this.intervaloInterseccionEsperado = intervaloInterseccionEsperado;
	}

	private void before() {
            intervaloSUT = new Intervalo(inferiorSUT, superiorSUT);
	}

	public void testLongitud() {
		this.before();
		double longitudObtenida = intervaloSUT.longitud();
		assertEquals("Para el intervalo " + intervaloSUT, longitudEsperada, longitudObtenida, .0001);
	}

	public void testDesplazar() {
		this.before();
		intervaloSUT.desplazar(desplazamiento);
		assertEquals("Para el intervalo " + intervaloSUT + " y desplazamiento " + desplazamiento,
				intervaloDesplazadoEsperado, intervaloSUT);
	}

	public void testIncluyeValor() {
		this.before();
		boolean incluyeValorObtenido = intervaloSUT.incluye(desplazamiento);
		assertEquals("Para el intervalo " + intervaloSUT + " y desplazamiento " + desplazamiento, 
				incluyeValorEsperado, incluyeValorObtenido);
	}

	public void testIncluyeIntervalo() {
		this.before();
		boolean incluyeIntervaloObtenido = intervaloSUT.incluye(intervaloAuxiliar);
		assertEquals("Para el intervalo " + intervaloSUT + " y intervalo " + intervaloAuxiliar,
				incluyeIntervaloEsperado, incluyeIntervaloObtenido);
	}

	public void testIntersecta() {
		this.before();
		boolean intersectaObtenido = intervaloSUT.intersecta(intervaloAuxiliar);
		assertEquals("Para el intervalo " + intervaloSUT + " y intervalo " + intervaloAuxiliar,
				intersectaEsperado, intersectaObtenido);
	}

	public void testInterseccion() {
		this.before();
		Intervalo intervaloInterseccionObtenido = intervaloSUT.interseccion(intervaloAuxiliar);
		assertEquals("Para el intervalo " + intervaloSUT + " y intervalo " + intervaloAuxiliar,
				intervaloInterseccionEsperado, intervaloInterseccionObtenido);
	}
}
