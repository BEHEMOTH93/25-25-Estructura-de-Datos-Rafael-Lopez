package practicaconjuntosmapas;

/**
 *
 * @author Rafael Lopez
 */
import java.util.*;

// -----------------------------
// Implementación Manual Conjunto
// -----------------------------
class ConjuntoLista<E> {
    private final List<E> elements = new LinkedList<>();

    // Insertar elemento (evita duplicados)
    public void insert(E x) {
        if (!elements.contains(x)) {
            elements.add(x);
        }
    }

    // Eliminar elemento
    public void delete(E x) {
        elements.remove(x);
    }

    // Verificar pertenencia
    public boolean member(E x) {
        return elements.contains(x);
    }

    // Unión de dos conjuntos
    public ConjuntoLista<E> union(ConjuntoLista<E> other) {
        ConjuntoLista<E> res = new ConjuntoLista<>();
        for (E e : elements) res.insert(e);
        for (E e : other.elements) res.insert(e);
        return res;
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}

// -----------------------------
// Implementación Manual Mapa
// -----------------------------
class MapaLista<K, V> {
    private class Entry {
        K key;
        V value;
        Entry(K k, V v) { key = k; value = v; }
    }

    private List<Entry> entries = new LinkedList<>();

    // Insertar clave-valor
    public void put(K k, V v) {
        for (Entry e : entries) {
            if (e.key.equals(k)) {
                e.value = v; // sobrescribe valor
                return;
            }
        }
        entries.add(new Entry(k, v));
    }

    // Obtener valor
    public V get(K k) {
        for (Entry e : entries) {
            if (e.key.equals(k)) return e.value;
        }
        return null;
    }

    // Eliminar clave
    public void remove(K k) {
        Iterator<Entry> it = entries.iterator();
        while (it.hasNext()) {
            Entry e = it.next();
            if (e.key.equals(k)) {
                it.remove();
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        for (Entry e : entries) {
            sb.append(e.key).append("=").append(e.value).append(" ");
        }
        sb.append("}");
        return sb.toString();
    }
}

// -----------------------------
// Programa Principal
// -----------------------------
public class PracticaConjuntosMapas {
    public static void main(String[] args) {
        System.out.println("=== PRÁCTICA EXPERIMENTAL #3: CONJUNTOS Y MAPAS ===");

        // ==========================
        // Ejemplo con HashSet
        // ==========================
        System.out.println("\n--- Conjunto con HashSet ---");
        Set<String> equipos = new HashSet<>();
        equipos.add("Barcelona");
        equipos.add("Emelec");
        equipos.add("LDU Quito");
        equipos.add("Barcelona"); // duplicado

        System.out.println("Equipos registrados: " + equipos);
        System.out.println("¿Existe 'Emelec'? " + equipos.contains("Emelec"));

        // ==========================
        // Ejemplo con Conjunto Manual
        // ==========================
        System.out.println("\n--- Conjunto con Lista Manual ---");
        ConjuntoLista<String> conjuntoManual = new ConjuntoLista<>();
        conjuntoManual.insert("Deportivo Quito");
        conjuntoManual.insert("Aucas");
        conjuntoManual.insert("Aucas"); // duplicado
        conjuntoManual.insert("Macará");

        System.out.println("Conjunto manual: " + conjuntoManual);
        System.out.println("¿'Aucas' pertenece? " + conjuntoManual.member("Aucas"));

        // ==========================
        // Ejemplo con HashMap
        // ==========================
        System.out.println("\n--- Mapa con HashMap ---");
        Map<String, String> jugadores = new HashMap<>();
        jugadores.put("Messi", "Barcelona");
        jugadores.put("Enner Valencia", "Internacional");
        jugadores.put("Damián Díaz", "Barcelona");

        System.out.println("Mapa jugadores (HashMap): " + jugadores);
        System.out.println("Equipo de Enner Valencia: " + jugadores.get("Enner Valencia"));

        // ==========================
        // Ejemplo con Mapa Manual
        // ==========================
        System.out.println("\n--- Mapa con Lista Manual ---");
        MapaLista<String, String> mapaManual = new MapaLista<>();
        mapaManual.put("Noboa", "Trabzonspor");
        mapaManual.put("Caicedo", "Chelsea");
        mapaManual.put("Estupiñán", "Brighton");
        mapaManual.put("Caicedo", "Chelsea FC"); // sobrescribir

        System.out.println("Mapa manual: " + mapaManual);
        System.out.println("Equipo de 'Caicedo': " + mapaManual.get("Caicedo"));

        // ==========================
        // Comparación de estructuras
        // ==========================
        System.out.println("\n--- Comparación ---");
        System.out.println("HashSet/HashMap = eficiencia alta (O(1) promedio).");
        System.out.println("Implementaciones manuales = correctas pero más lentas (O(n)).");
    }
}
