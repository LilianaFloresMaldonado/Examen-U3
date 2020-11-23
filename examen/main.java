package examen;

import java.util.Scanner;


public class main {
     public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        cola colas = new cola();
        int opcion, i = 0;
        do {
          
            System.out.println("   ********MENÚ*********");
            System.out.println("   1.-Nuevo Cliente");     
            System.out.println("   2.-Pasar a Ventanilla");        
            System.out.println("   3.-Mostrar Colas");
            System.out.println("   4.-Terminar una Ventanilla"); 
            System.out.println("   5.-Salir"); 
            System.out.println("Elige alguna de las opciones");
            opcion = leer.nextInt();
            switch (opcion) {
                
                case 1:
                    boolean clientevip = cola.RandomVip();
                    if (i <= 0) {
                        i = (int) ((Math.random() * 10) + 1);
                    } else {
                        i++;
                    }
                    if (clientevip) {
                        System.out.println("ColaVip: Vip"+i);
                        colas.Usuario("Vip", clientevip, i);
                    } else {
                        System.out.println("ColaComún: Común"+i);
                        colas.Usuario("Comun", clientevip, i);
                        
                    }
                    break;
                case 2:
                    if (!colas.EstaVacia()) {
                        colas.Empujar();
                    } else {
                        System.out.println("No existe ningún cliente en la cola");
                           }
                      break;
                case 3:
                    System.out.println("Usuarios");
                   if (!colas.EstaVacia()) {
                        colas.VisualizarColaVip();
                        colas.VisualizarColaComun();
                    } else {
                        System.out.println("ColaVip:");
                        System.out.println("ColaComún:");
                        System.out.println("Las colas estan vacias");
                       }
                    break;
                    
                case 4:
                    
                    if (!colas.EstaVacia()) {
                        int n = (int) (Math.random() * 3);
                        colas.Ventanilla(n);
                        System.out.println("La ventanilla que se desocupo es:"+n);
                    } else {
                        
                        System.out.println("Todas las ventanillas estan desocupadas");

                    }
                    break;
                    
                case 5:
                    System.out.println("El programa ha finalizado");
                    break;
                default:
                    System.out.println("No existe la opción");
            }
        } while (opcion != 5);

    }
}
