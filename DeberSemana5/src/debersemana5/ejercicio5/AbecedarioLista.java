/**
 *
 * @author Rafael Lopez
 */
package debersemana5.ejercicio5;

public class AbecedarioLista {

    // Clase Nodo
    static class Nodo {
        char letra;
        Nodo siguiente;

        public Nodo(char letra) {
            this.letra = letra;
            this.siguiente = null;
        }
    }

    // Lista enlazada simple
    static class ListaSimple {
        private Nodo cabeza;

        // Agregar al final
        public void agregar(char letra) {
            Nodo nuevo = new Nodo(letra);
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

        // Eliminar nodos en posiciones múltiplos de 3
        public void eliminarMultiploDeTres() {
            Nodo actual = cabeza;
            Nodo anterior = null;
            int posicion = 1;

            while (actual != null) {
                if (posicion % 3 == 0) {
                    // Eliminar el nodo actual
                    if (anterior == null) {
                        // Si es el primer nodo
                        cabeza = actual.siguiente;
                    } else {
                        anterior.siguiente = actual.siguiente;
                    }
                    // Avanzar actual sin cambiar anterior
                    actual = actual.siguiente;
                    posicion++;
                    continue;
                }
                // Avanzar normalmente
                anterior = actual;
                actual = actual.siguiente;
                posicion++;
            }
        }

        // Mostrar lista
        public void mostrar() {
            Nodo actual = cabeza;
            System.out.print("Lista resultante: ");
            while (actual != null) {
                System.out.print(actual.letra);
                if (actual.siguiente != null) System.out.print(", ");
                actual = actual.siguiente;
            }
            System.out.println();
        }
    }

    // Método main
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        // Agregar abecedario (a-z)
        for (char c = 'a'; c <= 'z'; c++) {
            lista.agregar(c);
        }

        // Eliminar letras en posiciones múltiplos de 3
        lista.eliminarMultiploDeTres();

        // Mostrar lista resultante
        lista.mostrar();
    }
}

