package agendaturnos;

/**
 *
 * @authores Rafael Lopez, Kerly Roman, Santiago Rios
 */
import java.util.Scanner;

public class AgendaTurnos {

    static class Paciente {
        String cedula;
        String nombre;
        int edad;
        String telefono;

        public Paciente(String cedula, String nombre, int edad, String telefono) {
            this.cedula = cedula;
            this.nombre = nombre;
            this.edad = edad;
            this.telefono = telefono;
        }

        @Override
        public String toString() {
            return "Cedula: " + cedula + ", Nombre: " + nombre + ", Edad: " + edad + ", Telefono: " + telefono;
        }
    }

    static final int DIAS = 5;
    static final int TURNOS_POR_DIA = 8;
    static Paciente[][] turnos = new Paciente[DIAS][TURNOS_POR_DIA];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- AGENDA DE TURNOS DE PACIENTES ---");
            System.out.println("1. Agendar nuevo turno");
            System.out.println("2. Ver turnos asignados");
            System.out.println("3. Cancelar un turno");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> agendarTurno();
                case 2 -> mostrarTurnos();
                case 3 -> cancelarTurno();
                case 4 -> System.out.println("Gracias por usar nuestro sistema!");
                default -> System.out.println("Opcion invalida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    public static void agendarTurno() {
        System.out.println("\n--- Registro de nuevo paciente ---");

        System.out.print("Cedula: ");
        String cedula = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();

        Paciente paciente = new Paciente(cedula, nombre, edad, telefono);

        System.out.print("Ingrese el dia (0 = Lunes, 1 = Martes, 2 = Miercoles, 3= jueves, 4 = Viernes): ");
        int dia = scanner.nextInt();

        System.out.print("Ingrese el turno (0 a 7): ");
        int turno = scanner.nextInt();

        if (dia >= 0 && dia < DIAS && turno >= 0 && turno < TURNOS_POR_DIA) {
            if (turnos[dia][turno] == null) {
                turnos[dia][turno] = paciente;
                System.out.println("Turno asignado con exito.");
            } else {
                System.out.println("Ese turno ya esta ocupado. Intente otro.");
            }
        } else {
            System.out.println("Dia o turno fuera de rango.");
        }
    }

    public static void mostrarTurnos() {
        System.out.println("\n--- Turnos Asignados ---");
        for (int d = 0; d < DIAS; d++) {
            for (int t = 0; t < TURNOS_POR_DIA; t++) {
                if (turnos[d][t] != null) {
                    System.out.println("Dia " + diaTexto(d) + ", Turno " + t + ": " + turnos[d][t]);
                }
            }
        }
    }

    public static void cancelarTurno() {
        System.out.println("\n--- Cancelar un turno ---");

        System.out.print("Ingrese el dia (0 = Lunes, 1 = Martes, 2 = Miercoles, 3 = jueves, 4 = Viernes): ");
        int dia = scanner.nextInt();

        System.out.print("Ingrese el turno (0 a 7): ");
        int turno = scanner.nextInt();

        if (dia >= 0 && dia < DIAS && turno >= 0 && turno < TURNOS_POR_DIA) {
            if (turnos[dia][turno] != null) {
                System.out.println("Turno cancelado: " + turnos[dia][turno]);
                turnos[dia][turno] = null;
            } else {
                System.out.println("Ese turno ya estaba vacio.");
            }
        } else {
            System.out.println("Dia o turno fuera de rango.");
        }
    }

    public static String diaTexto(int dia) {
        return switch (dia) {
            case 0 -> "Lunes";
            case 1 -> "Martes";
            case 2 -> "Miercoles";
            case 3 -> "Jueves";
            case 4 -> "Viernes";
            default -> "Desconocido";
        };
    }
}
