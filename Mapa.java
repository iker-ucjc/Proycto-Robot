public class Mapa {
    private int[][] tablero;
    public int largo, ancho;
    private int[][] posicionactual;
    public int i = 0;
    public int j = 0;
    
    public Mapa(int largo, int ancho) {
        this.ancho = ancho;
        this.largo = largo;
        this.tablero = new int[largo][ancho];
        this.posicionactual = new int[largo][ancho]; 

        posicionactual[i][j] = 2; 
        creacionDeZombies();
        creacionDeSalud();
        creacionDeCarga();
    }

    private void creacionDeZombies() {
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho; j++) {
                boolean tieneZombieCercano = false;

                if (i > 0 && tablero[i - 1][j] == 1) tieneZombieCercano = true;
                if (i < largo - 1 && tablero[i + 1][j] == 1) tieneZombieCercano = true;
                if (j > 0 && tablero[i][j - 1] == 1) tieneZombieCercano = true;
                if (j < ancho - 1 && tablero[i][j + 1] == 1) tieneZombieCercano = true;

                if (!tieneZombieCercano && Math.random() < 0.3) { 
                    tablero[i][j] = 1;
                }
            }
        }
    }

    private void creacionDeSalud() {
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho; j++) {
                if (tablero[i][j] == 0 && Math.random() < 0.1) {
                    tablero[i][j] = 3;
                }
            }
        }
    }

    private void creacionDeCarga() {
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho; j++) {
                if (tablero[i][j] == 0 && Math.random() < 0.1) {
                    tablero[i][j] = 4;
                }
            }
        }
    }

    public void imprimirMapa() {
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho; j++) {
                if (posicionactual[i][j] == 2) { 
                    System.out.print(" J ");
                } else if (tablero[i][j] == 1) {
                    System.out.print(" Z "); 
                } else if (tablero[i][j] == 3) {
                    System.out.print(" S "); 
                } else if (tablero[i][j] == 4) {
                    System.out.print(" C "); 
                } else {
                    System.out.print(" . "); 
                }
            }
            System.out.println(); 
        }
    }

    public void actualizarPosicion(int nuevaI, int nuevaJ) {
        if (nuevaI >= 0 && nuevaI < largo && nuevaJ >= 0 && nuevaJ < ancho) {
            posicionactual[i][j] = 0; 
            i = nuevaI;
            j = nuevaJ;
            posicionactual[i][j] = 2; 
        } else {
            System.out.println("Movimiento fuera de los límites del mapa.");
        }
    }

    public void zombie() {
        if (tablero[i][j] == 1) {        
            System.out.println("Te enfrentas a un zombie!");
            Robot.gastarVida(10);
            System.out.println("Tu salud actual es de " + Robot.getVida() + " puntos de vida");
        }
    }

    public void salud() {
        if (tablero[i][j] == 3) {        
            System.out.println("Te encuentras en un punto de salud!");
            Robot.reparar();
        }
    }

    public void carga() {
        if (tablero[i][j] == 4) {        
            System.out.println("Te encuentras en un punto de carga!");
            Robot.recargar();
        }
    }
}
