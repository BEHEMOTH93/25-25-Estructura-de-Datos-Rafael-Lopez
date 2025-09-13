import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa: Catálogo de Revistas con Búsqueda
 * Autor: Rafael López
 * Descripción: Aplicación en Java que permite gestionar un catálogo de revistas
 *              y realizar búsquedas de títulos utilizando búsqueda iterativa.
 */
public class CatalogoRevistas {

    // Catálogo de revistas
    private static final ArrayList<String> catalogo = new ArrayList<>();

    public static void main(String[] args) {
        // Inicializar catálogo con 10 títulos
        try (Scanner sc = new Scanner(System.in)) {
            // Inicializar catálogo con 10 títulos
            inicializarCatalogo();
            
            int opcion;
            do {
                // Menú interactivo
                System.out.println("\n===== CATÁLOGO DE REVISTAS =====");
                System.out.println("1. Mostrar catálogo completo");
                System.out.println("2. Buscar revista por título (iterativa)");
                System.out.println("3. Buscar revista por título (recursiva)");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                
                switch (opcion) {
                    case 1 -> mostrarCatalogo();
                    case 2 -> {
                        System.out.print("Ingrese el título a buscar: ");
                        String tituloIter = sc.nextLine();
                        if (buscarIterativa(tituloIter)) {
                            System.out.println("Resultado: Encontrado ");
                        } else {
                            System.out.println("Resultado: No encontrado ");
                        }
                    }
                    case 3 -> {
                        System.out.print("Ingrese el título a buscar: ");
                        String tituloRec = sc.nextLine();
                        if (buscarRecursiva(tituloRec, 0)) {
                            System.out.println("Resultado: Encontrado ");
                        } else {
                            System.out.println("Resultado: No encontrado ");
                        }
                    }
                    case 4 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción inválida, intente nuevamente.");
                }
            } while (opcion != 4);
        }
    }

    // Método para inicializar el catálogo con al menos 10 revistas
    private static void inicializarCatalogo() {
        catalogo.add("Condorito");
        catalogo.add("Carburando");
        catalogo.add("Vistaso");
        catalogo.add("Revista Estadio");
        catalogo.add("Revista Hogar");
        catalogo.add("Acelerando");
        catalogo.add("Generación 21");
        catalogo.add("Caliman");
        catalogo.add("Ciencia y Tecnologia");
        catalogo.add("Arte y Ciencias");
    }

    // Mostrar catálogo completo
    private static void mostrarCatalogo() {
        System.out.println("\n--- Catálogo de Revistas ---");
        for (String revista : catalogo) {
            System.out.println("- " + revista);
        }
    }

    // Búsqueda iterativa
    private static boolean buscarIterativa(String titulo) {
        for (String revista : catalogo) {
            if (revista.equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    // Búsqueda recursiva
    private static boolean buscarRecursiva(String titulo, int indice) {
        // Caso base: llegamos al final del catálogo
        if (indice >= catalogo.size()) {
            return false;
        }
        // Comparar título actual
        if (catalogo.get(indice).equalsIgnoreCase(titulo)) {
            return true;
        }
        // Llamada recursiva
        return buscarRecursiva(titulo, indice + 1);
    }
}
