package examen;


public class nodo {
    String tipoVipoComun;
    boolean vip;
    int i;
    nodo siguiente;

    public nodo(String tipo1, boolean vip1, int i) {
        tipoVipoComun = tipo1;
        vip = vip1;
        this.i = i;
        siguiente = null;
    }

    @Override
    public String toString() {
        return " [" + tipoVipoComun + " " + i + "]";
    }

}
