package sinJUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import solitarioconpolimorfismo.util.Intervalo;
/**
 *
 * @author Rober
 */
public class IntervaloTest {
    
    public void testLongitud() throws Exception {
		Intervalo intervalo = new Intervalo(3, 10);
		double resultadoObtenido = intervalo.longitud();
		double resultadoEsperado = 7;
		if (resultadoObtenido != resultadoEsperado) {
			throw new Exception("Con " + intervalo + " esperaba " + resultadoEsperado
					+ " pero fue " + resultadoObtenido);
		}
	}

	public void testDesplazar() throws Exception {
		Intervalo intervalo = new Intervalo(3, 10);
		int valor = 5;
		Intervalo intervaloObtenido = new Intervalo(3, 10);
		intervaloObtenido.desplazar(valor);
		Intervalo intervaloEsperado = new Intervalo(8, 15);
		if (!intervaloObtenido.equals(intervaloEsperado)) {
			throw new Exception("Con " + intervalo + " y " + valor
					+ " esperaba " + intervaloEsperado + " pero fue "
					+ intervaloObtenido);
		}
	}
	
	public void testIncluyeValor() throws Exception {
		Intervalo intervalo = new Intervalo(3, 10);
		int valor = 5;
		boolean resultadoObtenido = intervalo.incluye(valor);
		boolean resultadoEsperado = true;
		if (resultadoEsperado != resultadoObtenido) {
			throw new Exception("Con " + intervalo + " y " + valor
					+ " esperaba " + resultadoEsperado + " pero fue "
					+ resultadoObtenido);
		}
	}
	
	public static void main(String[] args) {
		IntervaloTest intervaloTest = new IntervaloTest();
		try {
			intervaloTest.testLongitud();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			intervaloTest.testDesplazar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			intervaloTest.testIncluyeValor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}
