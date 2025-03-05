import java.util.Scanner;


public class Main {

    public static void main(String[] argumentos) {
        Robot miRobot = new Robot("robot", 100, 100);
        Scanner scanner = new Scanner(System.in);

        OUTER:
        while (true) {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1 - Mostrar información del robot");
            System.out.println("2 - Jugar");
            System.out.println("3 - Aumentar energia");
            System.out.println("4 - Aumentar vida");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    miRobot.mostrarInfo();
                    break;
                case 2:
                    Mapa mapa = new Mapa(10, 10);
                    while (mapa.i != mapa.largo - 1 && mapa.j != mapa.ancho - 1) { 
                        System.out.print("¿Desea iniciar movimiento? (Y/N): ");
                        String respuesta = scanner.nextLine();
                        
                        if (respuesta.equalsIgnoreCase("Y")) {
                            mapa.imprimirMapa();
                            Movimiento movimiento = new Movimiento(mapa);
                            movimiento.mover();
                            movimiento.imprimirposicion();
                            mapa.zombie();
                            mapa.salud();
                            mapa.carga();
                            mapa.imprimirMapa();
                        } else if (respuesta.equalsIgnoreCase("N")) {
                            System.out.println("Saliendo del juego....");
                            break;
                        } else {
                            System.out.println("Ingrese Y si quiere iniciar el movimiento o N para salir");
                        }
                    }   break;
                case 3:
                    miRobot.recargar();
                    break;
                case 4:
                    miRobot.reparar();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break OUTER;
                default:
                    System.out.println("Comando no válido, intente de nuevo.");
                    break;
            }
        }   
        scanner.close();
    }
}
