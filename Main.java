import java.util.Scanner;

public class Main {

    public static void main(String[] argumentos) {
        Robot miRobot = new Robot("robot", 100, 100);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1 - Mostrar información del robot");
            System.out.println("2 - Jugar");
            System.out.println("3 - Aumentar energia");
            System.out.println("4 - Aumentar vida");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            if (opcion == 1) {
                miRobot.mostrarInfo();
            } 
            // Función de juego
            else if (opcion == 2) {
                Mapa mapa = new Mapa(10, 10);
                Scanner input = new Scanner(System.in);
                
                while (mapa.i != mapa.largo - 1 && mapa.j != mapa.ancho - 1) { // Bucle hasta llegar a (filas, columnas)
                    System.out.print("¿Desea iniciar movimiento? (Y/N): ");
                    String respuesta = input.nextLine();
                    
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
                }
            } 
            // Función para aumentar la energía
            else if (opcion == 3) {
                Robot.recargar();
            } 
            // Función para aumentar la vida
            else if (opcion == 4) {
                Robot.reparar();
            } 
            // Función para salir del menú del juego
            else if (opcion == 5) {
                System.out.println("Saliendo...");
                break;
            } 
            else {
                System.out.println("Comando no válido, intente de nuevo.");
            }
        }   
        scanner.close();
    }
}
