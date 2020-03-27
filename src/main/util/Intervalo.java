package main.util;

import main.exceptions.IntervaloException;

public class Intervalo {

    private double inferior;
    private double superior;

    /**
     * Proporciona un intervalo con los límites inferior y superior dados
     *
     * @param inferior
     * @param superior
     */
    public Intervalo(double inf, double sup) {
        assert sup >= inf;
        this.inferior = inf;
        this.superior = sup;
    }

    /**
     * Proporciona un intervalo con límite superior dado
     *
     * @param superior
     */
    public Intervalo(double sup) {
        inferior = 0;
        assert sup >= this.inferior;
        this.superior = sup;
    }

    /**
     * Proporciona un intervalo a partir de otro (copia)
     *
     * @param intervalo
     */
    public Intervalo(Intervalo intervalo) {
        this.superior = intervalo.superior;
        this.inferior = intervalo.inferior;
    }

    /**
     * Proporciona un intervalo con límites por defecto
     */
    public Intervalo() {
        this.superior = 10;
        this.inferior = 0;
    }

    /**
     * Clona el intervalo
     *
     * @return
     */
    public Intervalo clone() {

        return new Intervalo(this.inferior, this.superior);
    }

    /**
     * Longitud del intervalo
     *
     * @return
     */
    public double longitud() {
        return (superior - inferior);
    }

    /**
     * Desplaza los límites del intervalo según lo indicado
     *
     * @param desplazamiento
     */
    public void desplazar(double desplazamiento) {
        this.superior += desplazamiento;
        this.inferior += desplazamiento;
    }

    /**
     * Obtiene el intervalo desplazado según el desplazamiento proporcionado
     *
     * @param desplazamiento
     * @return
     */
    public Intervalo desplazado(double desplazamiento) {

        return new Intervalo(this.inferior + desplazamiento, this.superior + desplazamiento);
    }

    /**
     * Determina el valor está dentro del intervalo
     *
     * @param valor
     * @return
     */
    public boolean incluye(double valor) {

        if (valor < this.inferior || valor > this.superior) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * Determina si el intervalo proporcionado está incluido en el intervalo
     *
     * @param intervalo
     * @return
     */
    public boolean incluye(Intervalo intervalo) {

        if (intervalo.inferior > this.inferior && intervalo.superior <= this.superior) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Determina si dos intervalos son iguales
     *
     * @param intervalo
     * @return
     */
    public boolean equals(Intervalo intervalo) {

        if (this.inferior == intervalo.inferior && this.superior == intervalo.superior) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return equals((Intervalo) obj );
    }
    
    /**
     * Obtiene el intervalo que intersecta
     *
     * @param intervalo
     * @return
     */
    public Intervalo interseccion(Intervalo intervalo) throws IntervaloException{

         if (this.inferior < intervalo.superior && intervalo.inferior < this.superior) {
             double min;
             double max;
             if (this.inferior >= intervalo.inferior) {
                 min = this.inferior;
             } else {
                 min = intervalo.inferior;
             }
             if (this.superior <= intervalo.superior) {
                 max = this.superior;
             } else {
                 max = intervalo.superior;
             }
             return new Intervalo(min, max);
             
         } else {
             throw new IntervaloException("Los intervalos no intersectan");
         }
    }

    /**
     * Deterimna si un intervalo intersecta
     *
     * @param intervalo
     * @return
     */
    public boolean intersecta(Intervalo intervalo) {

        if (this.inferior < intervalo.superior && intervalo.inferior < this.superior) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Transforma el intervalo a su opuesto
     */
    public void oponer() {
        double infOpuesto = -inferior;
        double supOpuesto = -superior;
        this.inferior = supOpuesto;
        this.superior = infOpuesto;
        
    }

    /**
     * Aumenta el tamaño del intervalo al doble de su longitud por ambos
     * extremos
     */
    public void doblar() {
        double valorADoblar = (superior - inferior)/2;
        this.inferior -= valorADoblar;
        this.superior += valorADoblar;
    }

    /**
     * Obtiene los subintervalos en tamaños iguales según los trozos
     * proporcionados
     *
     * @param trozos
     * @return
     */
    public Intervalo[] trocear(int trozos) {
        
        Intervalo[] troceado = new Intervalo[trozos];
        double longitud = superior - inferior;
        double longitudTrozos = longitud / trozos;
        troceado[0].inferior = this.inferior;
        troceado[0].superior = troceado[0].inferior + longitudTrozos;
        
        for(int i = 1; i < troceado.length; i++) {
            troceado[i].inferior = troceado[i - 1].superior;
            troceado[i].superior = troceado[i].inferior + longitudTrozos; 
        }
        
        return troceado;
    }
    
    @Override
    public String toString() {
        return "["+ inferior + "," + superior+"]";
    }

}
