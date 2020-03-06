package conJUnit;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

//@FixMethodOrder(MethodSorters.DEFAULT)
@FixMethodOrder(MethodSorters.JVM)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExecutionTest {

	private static int miembroEstatico = 7;
	
	private int miembroInstancia;
	
	public ExecutionTest() {
		miembroInstancia = 666;
		System.out.println("Nuevo objeto: " + this);
	}
	
	@Test
	public void test5(){
		System.out.println("5> instancia: " + miembroInstancia + " y estático: " + miembroEstatico);
		miembroEstatico++;
		miembroInstancia++;
		System.out.println("5< instancia: " + miembroInstancia + " y estático: " + miembroEstatico);
	}
	
	@Test
	public void test4(){
		System.out.println("4> instancia: " + miembroInstancia + " y estático: " + miembroEstatico);
		miembroEstatico++;
		miembroInstancia++;
		System.out.println("4< instancia: " + miembroInstancia + " y estático: " + miembroEstatico);
	}
	
	@Test
	public void test3(){
		System.out.println("3> instancia: " + miembroInstancia + " y estático: " + miembroEstatico);
		miembroEstatico++;
		miembroInstancia++;
		System.out.println("3< instancia: " + miembroInstancia + " y estático: " + miembroEstatico);
	}
	
	@Test
	public void test2(){
		System.out.println("2> instancia: " + miembroInstancia + " y estático: " + miembroEstatico);
		miembroEstatico++;
		miembroInstancia++;
		System.out.println("2< instancia: " + miembroInstancia + " y estático: " + miembroEstatico);
	}
	
	@Test
	public void test1(){
		System.out.println("1> instancia: " + miembroInstancia + " y estático: " + miembroEstatico);
		miembroEstatico++;
		miembroInstancia++;
		System.out.println("1< instancia: " + miembroInstancia + " y estático: " + miembroEstatico);
	}
        
        public void test0(){
		System.out.println("0> instancia: " + miembroInstancia + " y estático: " + miembroEstatico);
		miembroEstatico++;
		miembroInstancia++;
		System.out.println("0< instancia: " + miembroInstancia + " y estático: " + miembroEstatico);
	}
	
}
