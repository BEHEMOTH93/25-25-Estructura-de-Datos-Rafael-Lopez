/**
 *
 * @author Rafael Lopez
 */

public class ListaAsignaturas {

    // Clase interna Nodo
    static class Nodo {
        String valor;
        Nodo siguiente;

        public Nodo(String valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    // Clase interna ListaSimple
    static class ListaSimple {
        private Nodo cabeza;

        public void agregar(String valor) {
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

        public void mostrar() {
            Nodo actual = cabeza;
            System.out.println("Asignaturas del curso:");
            while (actual != null) {
                System.out.println("- " + actual.valor);
                actual = actual.siguiente;
            }
        }
    }

    // Método main
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        lista.agregar("Matemáticas");
        lista.agregar("Inglés");
        lista.agregar("Literatura");
        lista.agregar("Física");
        lista.agregar("Historia");
        lista.mostrar();
    }
}
