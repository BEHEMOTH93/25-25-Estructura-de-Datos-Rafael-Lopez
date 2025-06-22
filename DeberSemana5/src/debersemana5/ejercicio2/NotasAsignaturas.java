/**
 *
 * @author Rafael Lopez
 */
package debersemana5.ejercicio2;

import java.util.Scanner;

public class NotasAsignaturas {

    // Clase Nodo para asignatura y nota
    static class Nodo {
        String asignatura;
        double nota;
        Nodo siguiente;

        public Nodo(String asignatura, double nota) {
            this.asignatura = asignatura;
            this.nota = nota;
            this.siguiente = null;
        }
    }

    // Clase Lista que almacena los nodos
    static class ListaNotas {
        private Nodo cabeza;

        public void agregar(String asignatura, double nota) {
            Nodo nuevo = new Nodo(asignatura, nota);
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Nodo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
        }

        public void mostrar() {
            Nodo actual = cabeza;
            while (actual != null) {
                System.out.println("En " + actual.asignatura + " has sacado " + actual.nota);
                actual = actual.siguiente;
            }
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] materias = {"Matemáticas", "Física", "Química", "Historia", "Lengua"};
        ListaNotas lista = new ListaNotas();

        for (String asignatura : materias) {
            System.out.print("Ingresa la nota de " + asignatura + ": ");
            double nota = scanner.nextDouble();
            lista.agregar(asignatura, nota);
        }

        System.out.println("\nResumen de notas:");
        lista.mostrar();
    }
}
