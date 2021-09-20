package org.grupocuatro.utiles;

public class Tupla {

    private int primero;
    private int segundo;

    public Tupla(int primero, int segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public boolean parExistente(int x, int y) {
        return ((this.primero == x && this.segundo == y) || (this.primero == y && this.segundo == x));
    }


}
