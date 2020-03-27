package main.juego.util;


import org.junit.Test;

import main.util.Intervalo;

public class IntervaloSinParametrizarTest {

	public static Object[][] datos() {
		return new Object[][] {
//				private int inferiorSUT;
//				private int superiorSUT;
//				
//				private int desplazamiento;
//				private Intervalo intervaloAuxiliar;
//				private Intervalo intervaloAuxiliarExcepcion;
//				
//				private int longitudEsperada;
//                              private Intervalo intervaloDesplazadoEsperado;
//                              private boolean estaIncluidoEsperado;
//                              private boolean incluyeIntervaloEsperado;
//                              private boolean intersectaEsperado;
//                              private Intervalo intervaloInterseccionEsperado;

				{ 12, 34, 
                                  16, new Intervalo(16, 30), new Intervalo(0, 5),
                                  22, new Intervalo(28, 50), true, true, true,
                                        new Intervalo(16, 30)},
				{ -8, -4, 
                                   6, new Intervalo(-7, -5), new Intervalo(0, 5),
                                   4, new Intervalo(-2, 2), false, true, true,
					new Intervalo(-7, -5)},
				{ -8, 4, 
                                    -2, new Intervalo(-7, -5), new Intervalo(10, 15),
                                    12,	new Intervalo(-10, 2), true, true, true,
					new Intervalo(-7, -5)},
				{ -8, 4, 
                                    10, new Intervalo(-7, -5), new Intervalo(10, 15),
                                    12, new Intervalo(2, 14), false, true, true,
					new Intervalo(-7, -5)},
				{ -8, 4, 
                                    6, new Intervalo(2, 9), new Intervalo(10, 15),
                                    12, new Intervalo(-2, 10), false, false, true,
					new Intervalo(2, 4)}
                };
	}

	@Test
	public void test() {
		for (Object[] objetos : IntervaloSinParametrizarTest.datos()) {
			IntervaloObjectTest intervaloObjectTest = new IntervaloObjectTest(
				(int) objetos[0], (int) objetos[1], // OUT
				(int) objetos[2], (Intervalo) objetos[3], (Intervalo) objetos[4],// arguments
				(int) objetos[5],
				(Intervalo) objetos[6],
				(boolean) objetos[7],
				(boolean) objetos[8],
				(boolean) objetos[9],
				(Intervalo) objetos[10]);

			intervaloObjectTest.testLongitud();
			intervaloObjectTest.testDesplazar();
			intervaloObjectTest.testIncluyeValor();
			intervaloObjectTest.testIncluyeIntervalo();
			intervaloObjectTest.testIntersecta();
			intervaloObjectTest.testInterseccionNoExcepcion();
                        intervaloObjectTest.testInterseccionExcepcion();
		}
	}

}