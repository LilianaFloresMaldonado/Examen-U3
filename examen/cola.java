package examen;

public class cola {
  
    nodo inicioComun, finComun,inicioVip, finVip;;
    nodo Ventanilla[];

    public cola() {
        inicioComun = finComun=null;
        inicioVip = finVip = null;
        Ventanilla = new nodo[3];
    }

    public boolean EstaVacia() {
        return VipestaVacia() && ComunestaVacia();
    }

    private boolean VipestaVacia() {
        return inicioVip == null;
    }

    private boolean ComunestaVacia() {
        return inicioComun == null;
    }

    public void Usuario(String tipo, boolean vip, int i) {
        if (vip) {
            IncorporarVip(tipo, vip, i);
        } else {
            IncorporarComun(tipo, vip, i);
        }
    }

    private void IncorporarVip(String tipo, boolean vip, int i) {
        nodo nuevo = new nodo(tipo, vip, i);
        if (VipestaVacia()) {
            inicioVip = nuevo;
        } else {
            finVip.siguiente = nuevo;
        }
        finVip = nuevo;
    }

    private void IncorporarComun(String tipo, boolean vip, int i) {
        nodo nuevo = new nodo(tipo, vip, i);
        if (ComunestaVacia()) {
            inicioComun = nuevo;
        } else {
            finComun.siguiente = nuevo;
        }
        finComun = nuevo;
    }

    private nodo SacarVip() {
        nodo aux = inicioVip;
        inicioVip = inicioVip.siguiente;
        return aux;
    }

    private nodo SacarComun() {
        nodo aux = inicioComun;
        inicioComun = inicioComun.siguiente;
        return aux;
    }

    public void Empujar() {
        int i = 0;
        for (; i < Ventanilla.length; i++) {
            if (!VipestaVacia()) {
                Ventanilla[i] = SacarVip();
                System.out.println("Usuario en Ventanilla[" + (i + 1) + "]: "  + Ventanilla[i].tipoVipoComun + " " + Ventanilla[i].i + "");
                Ventanilla[i] = null;
            } else {
                break;
            }
        }
        if (i < Ventanilla.length) {
            for (; i < Ventanilla.length; i++) {
                if (!ComunestaVacia()) {
                    Ventanilla[i] = SacarComun();
                System.out.println("Usuario en Ventanilla[" + (i + 1) + "]: "  + Ventanilla[i].tipoVipoComun + " " + Ventanilla[i].i + "");
                    Ventanilla[i] = null;
                } else {
                    break;
                }
            }
        }
    }

    public void Ventanilla(int i) {
        if (i >= 0 && i < Ventanilla.length) {
            if (!VipestaVacia()) {
                Ventanilla[i] = SacarVip();
                System.out.println("Usuario en Ventanilla[" + (i + 1) + "]: " + Ventanilla[i].tipoVipoComun + " " + Ventanilla[i].i + "");
                Ventanilla[i] = null;
            } else if (!ComunestaVacia()) {
                Ventanilla[i] = SacarComun();
                System.out.println("Usuario en Ventanilla[" + (i + 1) + "]: "  + Ventanilla[i].tipoVipoComun + " " + Ventanilla[i].i + "");
                Ventanilla[i] = null;
            }
        }
    }

    public void VisualizarColaVip() {
        if (!VipestaVacia()) {
            nodo vip01 = inicioVip;
            System.out.print("ColaVip:");
            while (vip01 != null) {
                System.out.print(vip01);
                vip01 = vip01.siguiente;
            }
            System.out.println("");
        } else {
            System.out.println("La cola vip esta vacia");
        }
    }

    public void VisualizarColaComun() {
        if (!ComunestaVacia()) {
            nodo comun02 = inicioComun;
            System.out.print("ColaComún: ");
            while (comun02 != null) {
                System.out.print(comun02);
                comun02 = comun02.siguiente;
            }
            System.out.println("");
        } else {
            System.out.println("La cola comun esta vacia");
        }
    
    }
    
  public static boolean RandomVip() {
        int n = (int) (Math.random() * 2);
        return n == 0;
    }

}
