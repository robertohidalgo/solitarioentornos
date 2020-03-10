package main.menuopciones;

import main.util.GestorIO;
import main.util.Intervalo;
import main.menuopciones.opciones.Salida;
import main.menuopciones.opciones.Opcion;


public class Menu {

    private Opcion[]opciones;
    private int numOpciones;
    
    public Menu() {
        this.opciones = new Opcion[50];
        this.numOpciones = 0;
    }
 
    
    
    public void añadir(Opcion opcion) {
        opciones[numOpciones] = opcion;
        numOpciones++;
    }
    
    public void mostrar(){
        for (int i = 0; i < numOpciones; i++) {
            opciones[i].mostrar(i+1);
        }
    }
    
    public Opcion getOpcion() {
        GestorIO gestorIO = new GestorIO();
        int opcion;
        boolean error;
        do {
            gestorIO.out("\nOpción? [1-" + numOpciones + "]: ");
            opcion = gestorIO.inInt();
            error = !new Intervalo(1,numOpciones).incluye(opcion);
            if (error){
                gestorIO.out("Error!!! La opción debe ser entre 1 y " + numOpciones);
            }
        } while (error);
        return opciones[opcion-1];
    }

    public boolean terminado() {
        Salida salida = (Salida)opciones[numOpciones-1];
        return salida.ejecutado();
    }
}
