/**
 *
 * @author Rafael Lopez
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Traductor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ==============================
        // CREACIÓN DEL DICCIONARIO
        // ==============================
        // HashMap 
        Map<String, String> diccionario = new HashMap<>();

        // Palabras iniciales
        diccionario.put("tiempo", "time");
        diccionario.put("persona", "person");
        diccionario.put("año", "year");
        diccionario.put("camino", "way");
        diccionario.put("día", "day");
        diccionario.put("cosa", "thing");
        diccionario.put("hombre", "man");
        diccionario.put("mundo", "world");
        diccionario.put("vida", "life");
        diccionario.put("mano", "hand");
        diccionario.put("parte", "part");
        diccionario.put("niño", "child");
        diccionario.put("ojo", "eye");
        diccionario.put("mujer", "woman");
        diccionario.put("lugar", "place");
        diccionario.put("trabajo", "work");
        diccionario.put("semana", "week");
        diccionario.put("caso", "case");
        diccionario.put("punto", "point");
        diccionario.put("gobierno", "government");
        diccionario.put("empresa", "company");

        // ==============================
        // MENÚ INTERACTIVO
        // ==============================
        int opcion;
        do {
            System.out.println("\n==================== MENÚ ====================");
            System.out.println("1. Traducir una frase ");
            System.out.println("2. Agregar palabras al diccionario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer del Scanner

            switch (opcion) {
                case 1:
                    // ==============================
                    // OPCIÓN 1: Traducir una frase
                    // ==============================
                    System.out.print("\nIngrese una frase en español: ");
                    String frase = sc.nextLine();

                    // Dividimos la frase en palabras
                    String[] palabras = frase.split(" ");
                    StringBuilder traduccion = new StringBuilder();

                    for (String palabra : palabras) {
                        // Quitamos signos de puntuación básicos (, .)
                        String limpia = palabra.toLowerCase().replaceAll("[^a-záéíóúñ]", "");
                        // Buscamos la traducción en el diccionario
                        String traduccionPalabra = diccionario.get(limpia);

                        if (traduccionPalabra != null) {
                            // Si existe, usamos la traducción
                            traduccion.append(traduccionPalabra);
                        } else {
                            // Si no existe, dejamos la palabra como está
                            traduccion.append(palabra);
                        }
                        traduccion.append(" ");
                    }

                    System.out.println("Traducción: " + traduccion.toString());
                    break;

                case 2:
                    // ==============================
                    // OPCIÓN 2: Agregar palabras
                    // ==============================
                    System.out.print("\nIngrese la palabra en español: ");
                    String espanol = sc.nextLine().toLowerCase();
                    System.out.print("Ingrese la traducción en inglés: ");
                    String ingles = sc.nextLine().toLowerCase();

                    // Guardamos la nueva palabra en el diccionario
                    diccionario.put(espanol, ingles);
                    System.out.println("✅ Palabra agregada correctamente.");
                    break;

                case 0:
                    System.out.println("\nSaliendo del programa...");
                    break;

                default:
                    System.out.println("\n❌ Opción no válida, intente de nuevo.");
            }

        } while (opcion != 0);

        sc.close(); // cerramos el Scanner
    }
}

