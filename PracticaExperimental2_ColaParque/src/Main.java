/**
 *
 * @author Rafael Lopez
 * @author Kerly Roman
 * @author Santiago Rios
 */
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // Clase Persona
    static class Persona {
        private final String nombre;
        private int asientoAsignado;

        public Persona(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public int getAsientoAsignado() {
            return asientoAsignado;
        }

        public void setAsientoAsignado(int asientoAsignado) {
            this.asientoAsignado = asientoAsignado;
        }

        @Override
        public String toString() {
            return "Nombre: " + nombre + ", Asiento N: " + asientoAsignado;
        }
    }

    // Clase Parque
    static class Parque {
        private Queue<Persona> cola;
        private final int TOTAL_ASIENTOS = 30;
        private int contadorAsientos = 1;

        public Parque() {
            cola = new LinkedList<>();
        }

        public void agregarPersona(String nombre) {
            if (contadorAsientos <= TOTAL_ASIENTOS) {
                Persona p = new Persona(nombre);
                p.setAsientoAsignado(contadorAsientos++);
                cola.add(p);
                System.out.println("Persona agregada: " + p);
            } else {
                System.out.println("Ya no hay asientos disponibles para: " + nombre);
            }
        }

        public void mostrarCola() {
            System.out.println("\n️ Lista de personas que subirán a la atracción:");
            for (Persona p : cola) {
                System.out.println(p);
            }
        }

        public int obtenerTotalPersonas() {
            return cola.size();
        }
    }

    // Método principal
    public static void main(String[] args) {
        Parque parque = new Parque();

        // Simulamos el ingreso de personas
        parque.agregarPersona("Rafael");
        parque.agregarPersona("Kerly");
        parque.agregarPersona("Alejandro");
        parque.agregarPersona("Micaela");
        parque.agregarPersona("Santiago");
        parque.agregarPersona("Jonatan");

        // Mostrar resultados
        parque.mostrarCola();
        System.out.println("\n Total de personas en la cola: " + parque.obtenerTotalPersonas());
    }
}
