import java.util.Scanner;

/**
 *
 * @author Rafael Lopez
 */

public class Main {

    // Clase interna Nodo: representa cada elemento del árbol
    static class Nodo {
        int dato;           // Valor almacenado en el nodo
        Nodo izquierdo;     // Hijo izquierdo
        Nodo derecho;       // Hijo derecho

        public Nodo(int dato) {
            this.dato = dato;
            izquierdo = null;
            derecho = null;
        }
    }

    // Clase interna ArbolBinario: contiene todas las operaciones
    static class ArbolBinario {
        Nodo raiz;  // Nodo raíz del árbol

        public ArbolBinario() {
            raiz = null;
        }

        // Método para insertar un dato en el árbol
        public void insertar(int dato) {
            raiz = insertarRec(raiz, dato);
        }

        private Nodo insertarRec(Nodo raiz, int dato) {
            if (raiz == null) { // Si el árbol está vacío
                raiz = new Nodo(dato);
                return raiz;
            }
            if (dato < raiz.dato) {
                raiz.izquierdo = insertarRec(raiz.izquierdo, dato);
            } else if (dato > raiz.dato) {
                raiz.derecho = insertarRec(raiz.derecho, dato);
            }
            return raiz;
        }

        // Recorrido Inorden (Izquierdo - Raíz - Derecho)
        public void inorden(Nodo raiz) {
            if (raiz != null) {
                inorden(raiz.izquierdo);
                System.out.print(raiz.dato + " ");
                inorden(raiz.derecho);
            }
        }

        // Recorrido Preorden (Raíz - Izquierdo - Derecho)
        public void preorden(Nodo raiz) {
            if (raiz != null) {
                System.out.print(raiz.dato + " ");
                preorden(raiz.izquierdo);
                preorden(raiz.derecho);
            }
        }

        // Recorrido Postorden (Izquierdo - Derecho - Raíz)
        public void postorden(Nodo raiz) {
            if (raiz != null) {
                postorden(raiz.izquierdo);
                postorden(raiz.derecho);
                System.out.print(raiz.dato + " ");
            }
        }

        // Buscar un elemento en el árbol
        public boolean buscar(int dato) {
            return buscarRec(raiz, dato);
        }

        private boolean buscarRec(Nodo raiz, int dato) {
            if (raiz == null) return false;
            if (raiz.dato == dato) return true;
            return dato < raiz.dato
                    ? buscarRec(raiz.izquierdo, dato)
                    : buscarRec(raiz.derecho, dato);
        }

        // Eliminar un nodo del árbol
        public Nodo eliminar(Nodo raiz, int dato) {
            if (raiz == null) return raiz;

            if (dato < raiz.dato) {
                raiz.izquierdo = eliminar(raiz.izquierdo, dato);
            } else if (dato > raiz.dato) {
                raiz.derecho = eliminar(raiz.derecho, dato);
            } else {
                // Caso 1: nodo sin hijos
                if (raiz.izquierdo == null && raiz.derecho == null) {
                    return null;
                }
                // Caso 2: nodo con un solo hijo
                else if (raiz.izquierdo == null) {
                    return raiz.derecho;
                } else if (raiz.derecho == null) {
                    return raiz.izquierdo;
                }
                // Caso 3: nodo con dos hijos
                raiz.dato = valorMinimo(raiz.derecho);
                raiz.derecho = eliminar(raiz.derecho, raiz.dato);
            }
            return raiz;
        }

        // Método auxiliar: encontrar el valor mínimo en un subárbol
        private int valorMinimo(Nodo raiz) {
            int min = raiz.dato;
            while (raiz.izquierdo != null) {
                raiz = raiz.izquierdo;
                min = raiz.dato;
            }
            return min;
        }
    }

    // Método principal con el menú interactivo
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        int opcion, dato;

        do {
            System.out.println("\n--- MENU ARBOL BINARIO ---");
            System.out.println("1. Insertar nodo");
            System.out.println("2. Recorrido Inorden");
            System.out.println("3. Recorrido Preorden");
            System.out.println("4. Recorrido Postorden");
            System.out.println("5. Buscar elemento");
            System.out.println("6. Eliminar nodo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor del nodo: ");
                    dato = sc.nextInt();
                    arbol.insertar(dato);
                    System.out.println("Nodo insertado correctamente.");
                    break;
                case 2:
                    System.out.println("Recorrido Inorden:");
                    arbol.inorden(arbol.raiz);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Recorrido Preorden:");
                    arbol.preorden(arbol.raiz);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Recorrido Postorden:");
                    arbol.postorden(arbol.raiz);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Ingrese el valor a buscar: ");
                    dato = sc.nextInt();
                    System.out.println(arbol.buscar(dato)
                            ? "Elemento encontrado"
                            : "Elemento no encontrado");
                    break;
                case 6:
                    System.out.print("Ingrese el valor a eliminar: ");
                    dato = sc.nextInt();
                    arbol.raiz = arbol.eliminar(arbol.raiz, dato);
                    System.out.println("Nodo eliminado si existía.");
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 7);

        sc.close();
    }
}