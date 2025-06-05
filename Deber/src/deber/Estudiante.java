public class Estudiante {
    // ====================
    // Atributos privados
    // ====================
    // Estos campos almacenan la información básica del estudiante.
    private String id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String[] telefonos; // Usamos un array para guardar múltiples teléfonos

    // ============================
    // Constructor de la clase
    // ============================
    // El constructor permite crear un objeto Estudiante inicializado con valores.
    public Estudiante(String id, String nombres, String apellidos, String direccion, String[] telefonos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    // ===============================
    // Método para mostrar la información
    // ===============================
    // Este método imprime en pantalla todos los datos del estudiante.
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombres: " + nombres);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Direccion: " + direccion);
        System.out.println("Telefonos:");

        // Se recorre el array de teléfonos y se imprime cada uno
        for (String tel : telefonos) {
            System.out.println(" - " + tel);
        }
    }

    // ===================
    // Método main
    // ===================
    // Es el punto de entrada del programa. Aquí se ejecuta todo.
    public static void main(String[] args) {
        // Creamos un array con 3 teléfonos
        String[] telefonos = {"0912345678", "0987654321", "0925897462"};

        // Creamos un objeto Estudiante usando el constructor
        Estudiante estudiante = new Estudiante(
            "1234567890",           // ID
            "Rafael",               // Nombres
            "Lopez",                // Apellidos
            "Quito, Ecuador",       // Dirección
            telefonos               // Array de teléfonos
        );

        // Llamamos al método para mostrar la información del estudiante
        estudiante.mostrarInformacion();
    }
}
