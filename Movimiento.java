import java.util.Scanner;

public class Movimiento {
    public int i;
    public int j;
    private Mapa mapa; 
    static Scanner input = new Scanner(System.in);

    public Movimiento(Mapa mapa) {
        this.mapa = mapa;
        this.i = 0;
        this.j = 0;
    }

    public void mover() {
      
            System.out.print("Desea iniciar movimiento??");
            String afirmacion = input.next();
                if (afirmacion.equalsIgnoreCase("Y")){
                    System.out.println("Consumiendo 10 de energia.....");
                    
                    Robot.gastarEnergia(10);
                    System.out.println("Su energia actual es de " + Robot.getEnergia() + " puntos de energia");
            
                    System.out.print("En qué dirección desea moverse? (arriba (a), abajo (b), derecha (d), izquierda (i)): ");
                        String direccion = input.next();

                    

                    if (direccion.equalsIgnoreCase("a")) {
                        moverArriba(1);
                    } else if (direccion.equalsIgnoreCase("b")) {
                        moverAbajo(1);
                    } else if (direccion.equalsIgnoreCase("d")) {
                        moverDerecha(1);
                    } else if (direccion.equalsIgnoreCase("i")) {
                        moverIzquierda(1);
                    } else {
                        System.out.println("La dirección ingresada no es válida");
                    }
                    System.out.println("La posición actual es: (" + j + ", " + i + ")");
                    
                }
                if (afirmacion.equalsIgnoreCase("N")){
                    System.out.println("Saliendo del juego....");
                    
                }
                else {
                    System.out.println("Ingrese Y si quiere iniciar el movimiento");
                }
        mapa.actualizarPosicion(i, j); 
        
        
    }
    public void moverArriba(int n) {
        if ((i - n)>= 0) {
           i = i - n;
        } else {
            System.out.println("No se puede mover hacia arriba, ya que está en el límite del tablero.");
        }
    }

    public void moverAbajo(int n) {
        if ((i + n)>=0) {
            i = i + n;
        } else {
            System.out.println("No se puede mover hacia abajo, ya que está en el límite del tablero.");
        }
    }

    public void moverDerecha(int n) {
        if ((j + n)>=0) {
            j = j + n;
        } else {
            System.out.println("No se puede mover hacia la derecha, ya que está en el límite del tablero.");
        }
    }

    public void moverIzquierda(int n) {
        if ((j - n)>= 0) {
            j = j - n;
        } else {
            System.out.println("No se puede mover hacia la izquierda, ya que está en el límite del tablero.");
        }
    }

    public void imprimirposicion() {
        System.out.println("La posición actual es: (" + i + ", " + j + ")");
    }
}
