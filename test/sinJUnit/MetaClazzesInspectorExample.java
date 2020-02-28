package sinJUnit;


import java.io.File;

public class MetaClazzesInspectorExample {

	public static void main(String[] args){
		File directory = new File("C:\\Users\\Rober\\Desktop\\SolitarioEntornos\\src\\solitarioconpolimorfismo\\juego");
		String[] clazzes = directory.list();
		for(String clazz : clazzes) {
			System.out.println(clazz);
		}		
	}
}
