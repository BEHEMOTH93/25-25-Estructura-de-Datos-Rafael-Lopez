/**
 *
 * @author Rafael Lopez
 */
// Clase principal
public class InvertirLista {

    // Clase Nodo: contiene el dato y referencia al siguiente nodo
    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Clase ListaEnlazada: estructura y operaciones sobre la lista
    static class ListaEnlazada {
        Nodo cabeza; // Nodo inicial

        // Agregar nodo al final de la lista
        void agregarAlFinal(int dato) {
            Nodo nuevo = new Nodo(dato);
            if (cabeza == null) {
                cabeza = nuevo; // Si la lista está vacía, se asigna el nuevo nodo como cabeza
            } else {
                Nodo actual = cabeza;
                // Se recorre la lista hasta el último nodo
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo; // Se conecta el nuevo nodo al final
            }
        }

        // Método para mostrar los datos de la lista
        void imprimirLista() {
            Nodo actual = cabeza;
            while (actual != null) {
                System.out.print(actual.dato + " -> ");
                actual = actual.siguiente;
            }
            System.out.println("null"); // Indica el final de la lista
        }

        // Método que invierte la lista enlazada
        void invertirLista() {
            Nodo anterior = null;       // Nodo anterior (inicia en null)
            Nodo actual = cabeza;       // Nodo actual (empieza en la cabeza)
            Nodo siguiente;             // Nodo siguiente (usado para guardar temporalmente el siguiente nodo)

            // Proceso iterativo para invertir los punteros
            while (actual != null) {
                siguiente = actual.siguiente; // Se guarda el siguiente nodo
                actual.siguiente = anterior;  // Se invierte el puntero
                anterior = actual;            // Se mueve el anterior al nodo actual
                actual = siguiente;           // Se avanza al siguiente nodo original
            }

            cabeza = anterior; // Se actualiza la cabeza al nuevo primer nodo
        }
    }

    // Método principal: prueba de funcionamiento
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        // Agregamos nodos a la lista
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(3);
        lista.agregarAlFinal(4);

        // Lista antes de invertir
        System.out.println("Lista original:");
        lista.imprimirLista();

        // Invertimos la lista
        lista.invertirLista();

        // Lista después de invertir
        System.out.println("Lista invertida:");
        lista.imprimirLista();
    }
}
