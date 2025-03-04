import java.util.Random;

class Robot {
    private String nombre;
    private static int energia = 100;
    private static int vida = 100;
    public static int getEnergia(){
        return energia;
    }
    public static int getVida(){
        return vida;
    }
    public Robot(String nombre, int vida, int energia) {
        this.nombre = nombre;

        
    }

    public void mostrarInfo() {
        System.out.println("Robot: " + nombre + " | Energía: " + energia + " | Vida: " + vida);
    }

    public void jugar() {
        if (vida > 10 && energia > 10) {
            Random rand = new Random();
            int vidaPerdida = rand.nextInt(10) + 1;
            int energiaGastada = rand.nextInt(15) + 5;
            
            vida = Math.max(0, vida - vidaPerdida); // Evitar vida negativa
            energia = Math.max(0, energia - energiaGastada); // Evitar energía negativa
            
            System.out.println(nombre + " ha jugado y perdió " + vidaPerdida + " de vida y " + energiaGastada + " de energía.");
        } else {
            System.out.println(nombre + " está demasiado débil o sin energía para jugar.");
        }
    }

    public static void reparar() {
        vida = 100;
        System.out.println("El robot ha sido reparado. Vida actual: " + vida);
    }

    public static void recargar() {
        energia = 100;
        System.out.println("El robot ha sido recargado. Energía actual: " + energia);
    }
    public static void gastarEnergia(int cantidad) {
        if (energia >= cantidad) {
            energia -= cantidad;
        } else {
            System.out.println("No hay suficiente energía.");
        }
    }
    public static void gastarVida(int cantidad) {
        if (vida > cantidad) {
            vida -= cantidad;
            System.out.println("El robot ha perdido " + cantidad + " puntos de salud." );
        }
        }
    
    public static void muerte(){
        if(vida <= 0){
            System.out.println("El robot ha muerto");
        }
        else{
            System.out.println("El robot ahora tiene" + vida + "puntos de salud.");
        }
    }
}
