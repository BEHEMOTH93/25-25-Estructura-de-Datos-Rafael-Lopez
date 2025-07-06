/**
 *
 * @author Rafael Lopez
 */
// Clase principal
public class ContarElementosLista {

    // Clase Nodo: representa un elemento de la lista enlazada
    static class Nodo {
        int dato;           // Información del nodo
        Nodo siguiente;     // Apunta al siguiente nodo

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null; // Al crear, no tiene siguiente
        }
    }

    // Clase ListaEnlazada: maneja toda la estructura de la lista
    static class ListaEnlazada {
        Nodo cabeza; // Primer nodo de la lista

        // Método para agregar elementos al final de la lista
        void agregarAlFinal(int dato) {
            Nodo nuevo = new Nodo(dato);
            if (cabeza == null) {
                cabeza = nuevo; // Si la lista está vacía, el nuevo nodo es la cabeza
            } else {
                Nodo actual = cabeza;
                // Se recorre la lista hasta el final
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo; // Se agrega el nuevo nodo al final
            }
        }

        // Método que cuenta cuántos elementos hay en la lista
        int contarElementos() {
            int contador = 0;
            Nodo actual = cabeza;
            // Se recorre nodo por nodo y se incrementa el contador
            while (actual != null) {
                contador++;
                actual = actual.siguiente;
            }
            return contador;
        }
    }

    // Método main: punto de inicio del programa
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        // Agregamos algunos elementos a la lista
        lista.agregarAlFinal(10);
        lista.agregarAlFinal(20);
        lista.agregarAlFinal(30);

        // Mostramos la cantidad de elementos en la lista
        System.out.println("Cantidad de elementos en la lista: " + lista.contarElementos());
    }
}
