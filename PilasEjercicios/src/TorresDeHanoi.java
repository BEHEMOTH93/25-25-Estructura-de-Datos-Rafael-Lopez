/**
 * Clase que resuelve el problema de las Torres de Hanoi usando pilas.
 * Muestra paso a paso el movimiento de discos entre las torres.
 * 
 */
/**
 *
 * @author Rafael Lopez
 */
import java.util.Stack;


public class TorresDeHanoi {

    private final Stack<Integer> torreA = new Stack<>();
    private final Stack<Integer> torreB = new Stack<>();
    private final Stack<Integer> torreC = new Stack<>();
    private final int numDiscos;

    /**
     * Constructor que inicializa las torres y los discos.
     * 
     * @param numDiscos número de discos a usar en el juego.
     */
    public TorresDeHanoi(int numDiscos) {
        this.numDiscos = numDiscos;
        // Inicializamos torre A con discos de mayor a menor (de abajo hacia arriba)
        for (int i = numDiscos; i >= 1; i--) {
            torreA.push(i);
        }
    }

    /**
     * Método público para iniciar el movimiento de discos.
     */
    public void resolver() {
        moverDiscos(numDiscos, torreA, torreC, torreB, "A", "C", "B");
    }

    /**
     * Método recursivo que mueve los discos entre torres mostrando los pasos.
     * 
     * @param n número de discos a mover.
     * @param origen torre origen.
     * @param destino torre destino.
     * @param auxiliar torre auxiliar.
     * @param nombreOrigen nombre de la torre origen.
     * @param nombreDestino nombre de la torre destino.
     * @param nombreAuxiliar nombre de la torre auxiliar.
     */
    private void moverDiscos(int n, Stack<Integer> origen, Stack<Integer> destino, Stack<Integer> auxiliar,
                             String nombreOrigen, String nombreDestino, String nombreAuxiliar) {
        if (n == 1) {
            int disco = origen.pop();
            destino.push(disco);
            System.out.println("Mover disco " + disco + " de " + nombreOrigen + " a " + nombreDestino);
            imprimirTorres();
        } else {
            moverDiscos(n - 1, origen, auxiliar, destino, nombreOrigen, nombreAuxiliar, nombreDestino);
            moverDiscos(1, origen, destino, auxiliar, nombreOrigen, nombreDestino, nombreAuxiliar);
            moverDiscos(n - 1, auxiliar, destino, origen, nombreAuxiliar, nombreDestino, nombreOrigen);
        }
    }

    /**
     * Imprime el estado actual de las torres.
     */
    private void imprimirTorres() {
        System.out.println("Torre A: " + torreA);
        System.out.println("Torre B: " + torreB);
        System.out.println("Torre C: " + torreC);
        System.out.println("-----------------------------");
    }

    /**
     * Método principal para ejecutar el programa.
     * 
     * @param args Argumentos de línea de comando (no usados).
     */
    public static void main(String[] args) {
        TorresDeHanoi juego = new TorresDeHanoi(3); // Cambia el número para probar con más discos
        System.out.println("Estado inicial:");
        juego.imprimirTorres();
        juego.resolver();
    }
}
