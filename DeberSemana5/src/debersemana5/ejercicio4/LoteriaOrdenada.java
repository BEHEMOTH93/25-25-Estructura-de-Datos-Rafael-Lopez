/**
 *
 * @author Rafael Lopez
 */
package debersemana5.ejercicio4;

import java.util.Scanner;

public class LoteriaOrdenada {

    // Clase Nodo
    static class Nodo {
        int valor;
        Nodo siguiente;

        public Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    // Clase ListaSimple con inserción ordenada
    static class ListaSimple {
        private Nodo cabeza;

        // Insertar en orden (de menor a mayor)
        public void insertarOrdenado(int valor) {
            Nodo nuevo = new Nodo(valor);

            // Caso 1: Lista vacía o insertar al inicio
            if (cabeza == null || valor < cabeza.valor) {
                nuevo.siguiente = cabeza;
                cabeza = nuevo;
                return;
            }

            // Caso 2: Buscar posición adecuada
            Nodo actual = cabeza;
            while (actual.siguiente != null && actual.siguiente.valor < valor) {
                actual = actual.siguiente;
            }

            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }

        // Mostrar la lista
        public void mostrar() {
            Nodo actual = cabeza;
            System.out.println("Números ganadores ordenados:");
            while (actual != null) {
                System.out.println(actual.valor);
                actual = actual.siguiente;
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaSimple lista = new ListaSimple();

        System.out.println("Ingrese los 6 números ganadores de la lotería primitiva:");

        for (int i = 1; i <= 6; i++) {
            System.out.print("Número " + i + ": ");
            int numero = scanner.nextInt();
            lista.insertarOrdenado(numero); // Se insertan ordenados
        }

        System.out.println();
        lista.mostrar();
    }
}

