/**
 *
 * @author Rafael Lopez
 */
package debersemana5.ejercicio3;

public class NumerosInversos {

    // Clase Nodo
    static class Nodo {
        int valor;
        Nodo siguiente;

        public Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    // Lista enlazada simple
    static class ListaSimple {
        private Nodo cabeza;

        // Agregar al final (orden normal del 1 al 10)
        public void agregar(int valor) {
            Nodo nuevo = new Nodo(valor);
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

        // Mostrar en orden inverso usando recursión
        public void mostrarInverso() {
            System.out.print("Números en orden inverso: ");
            mostrarInversoRecursivo(cabeza);
            System.out.println(); // Salto de línea final
        }

        private void mostrarInversoRecursivo(Nodo nodo) {
            if (nodo == null) return;
            mostrarInversoRecursivo(nodo.siguiente);
            System.out.print(nodo.valor);
            if (nodo != cabeza) System.out.print(", ");
        }
    }

    // Método main
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        // Agregar números del 1 al 10
        for (int i = 1; i <= 10; i++) {
            lista.agregar(i);
        }

        // Mostrar en orden inverso
        lista.mostrarInverso();
    }
}
