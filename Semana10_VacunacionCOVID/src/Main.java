/**
 * Programa ficticio de evaluación de vacunación contra el COVID-19.
 * 
 * Se generan 500 ciudadanos y se simula quiénes han recibido vacunas Pfizer,
 * AstraZeneca, ambas dosis o ninguna. 
 * Se aplican operaciones de teoría de conjuntos para obtener los listados.
 * 
 * @author Rafael Lopez
 */
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // ===== Configuración inicial =====
        final int TOTAL_CIUDADANOS = 500; // Tamaño del universo U
        final int PFIZER_SIZE = 75;       // Ciudadanos vacunados con Pfizer
        final int ASTRA_SIZE = 75;        // Ciudadanos vacunados con AstraZeneca
        final long RANDOM_SEED = 2025L;   // Semilla para reproducibilidad

                // Creamos 500 ciudadanos ficticios: "Ciudadano 001", ..., "Ciudadano 500"
        List<String> universoLista = new ArrayList<>();
        for (int i = 1; i <= TOTAL_CIUDADANOS; i++) {
            universoLista.add(String.format("Ciudadano %03d", i));
        }
        Set<String> U = new LinkedHashSet<>(universoLista);

        // ===== Selección aleatoria de ciudadanos vacunados =====
        Random rnd = new Random(RANDOM_SEED);

        // Pfizer: 75 ciudadanos seleccionados aleatoriamente
        List<String> barajada1 = new ArrayList<>(universoLista);
        Collections.shuffle(barajada1, rnd);
        Set<String> pfizer = new LinkedHashSet<>(barajada1.subList(0, PFIZER_SIZE));

        // AstraZeneca: 75 ciudadanos seleccionados aleatoriamente
        List<String> barajada2 = new ArrayList<>(universoLista);
        Collections.shuffle(barajada2, rnd);
        Set<String> astrazeneca = new LinkedHashSet<>(barajada2.subList(0, ASTRA_SIZE));

        // ===== Operaciones de teoría de conjuntos =====
        // Unión (P ∪ A) → todos los vacunados
        Set<String> unionVacunados = new LinkedHashSet<>(pfizer);
        unionVacunados.addAll(astrazeneca);

        // Diferencia (U − (P ∪ A)) → no vacunados
        Set<String> noVacunados = new LinkedHashSet<>(U);
        noVacunados.removeAll(unionVacunados);

        // Intersección (P ∩ A) → ambas dosis
        Set<String> ambasDosis = new LinkedHashSet<>(pfizer);
        ambasDosis.retainAll(astrazeneca);

        // Diferencia (P − A) → solo Pfizer
        Set<String> soloPfizer = new LinkedHashSet<>(pfizer);
        soloPfizer.removeAll(astrazeneca);

        // Diferencia (A − P) → solo AstraZeneca
        Set<String> soloAstra = new LinkedHashSet<>(astrazeneca);
        soloAstra.removeAll(pfizer);

        // ===== Reporte en consola =====
        System.out.println("=== Campaña de Vacunación COVID-19 (Datos Ficticios) ===\n");
        System.out.println("Total de ciudadanos: " + U.size());
        System.out.println("Vacunados con Pfizer (|P|): " + pfizer.size());
        System.out.println("Vacunados con AstraZeneca (|A|): " + astrazeneca.size());
        System.out.println("Vacunados (P ∪ A): " + unionVacunados.size());
        System.out.println("No vacunados (U − (P ∪ A)): " + noVacunados.size());
        System.out.println("Ambas dosis (P ∩ A): " + ambasDosis.size());
        System.out.println("Solo Pfizer (P − A): " + soloPfizer.size());
        System.out.println("Solo AstraZeneca (A − P): " + soloAstra.size());

        // Mostrar ejemplos (20 elementos máximo)
        imprimirMuestra("Lista - No vacunados", noVacunados, 20);
        imprimirMuestra("Lista - Ambas dosis (intersección)", ambasDosis, 20);
        imprimirMuestra("Lista - Solo Pfizer", soloPfizer, 20);
        imprimirMuestra("Lista - Solo AstraZeneca", soloAstra, 20);

        // ===== Guardar resultados en archivos .txt =====
        try {
            guardarListado("salida_no_vacunados.txt", noVacunados);
            guardarListado("salida_ambas_dosis.txt", ambasDosis);
            guardarListado("salida_solo_pfizer.txt", soloPfizer);
            guardarListado("salida_solo_astrazeneca.txt", soloAstra);
            guardarListado("salida_pfizer_total.txt", pfizer);
            guardarListado("salida_astrazeneca_total.txt", astrazeneca);
            System.out.println("\nArchivos de salida generados en el directorio del proyecto.");
        } catch (IOException e) {
            System.err.println("Error guardando archivos: " + e.getMessage());
        }
    }

    /**
     * Imprime en consola una muestra de hasta "limite" elementos del conjunto.
     */
    private static void imprimirMuestra(String titulo, Set<String> datos, int limite) {
        System.out.println("\n" + titulo + " (total: " + datos.size() + "):");
        int count = 0;
        for (String s : ordenar(datos)) {
            if (count++ >= limite) break;
            System.out.println(" - " + s);
        }
        if (datos.size() > limite) {
            System.out.println(" ... (" + (datos.size() - limite) + " más)");
        }
    }

    /**
     * Guarda un conjunto de ciudadanos en un archivo de texto.
     */
    private static void guardarListado(String nombreArchivo, Set<String> datos) throws IOException {
        List<String> ordenados = new ArrayList<>(ordenar(datos));
        Files.write(Paths.get(nombreArchivo), ordenados);
    }

    /**
     * Ordena un conjunto alfabéticamente.
     */
    private static List<String> ordenar(Set<String> datos) {
        List<String> lista = new ArrayList<>(datos);
        Collections.sort(lista);
        return lista;
    }
}
