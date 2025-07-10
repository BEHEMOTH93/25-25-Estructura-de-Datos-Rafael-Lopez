/**
 * Clase para verificar si los paréntesis, llaves y corchetes están balanceados en una expresión matemática.
 * Utilizamos una pila para hacer el seguimiento de los símbolos de apertura y cierre.
/**
 *
 * @author Rafael Lopez
 */
import java.util.Stack;


public class BalanceParentesis {

    /**
     * Verificamos si una expresión matemática tiene los paréntesis, llaves y corchetes balanceados.
     * 
     * @param expr La expresión matemática como cadena de texto.
     * @return true si los símbolos están balanceados, false en caso contrario.
     */
    public static boolean estaBalanceada(String expr) {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            // Si es un símbolo de apertura, lo apilamos
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            } 
            // Si es un símbolo de cierre, verificamos si corresponde con el último abierto
            else if (c == ')' || c == '}' || c == ']') {
                if (pila.isEmpty()) {
                    return false; // No hay símbolo de apertura que coincida
                }
                char ultimo = pila.pop();

                if (!corresponde(ultimo, c)) {
                    return false; // No coinciden los símbolos
                }
            }
        }
        // Si la pila está vacía, todos los símbolos están balanceados
        return pila.isEmpty();
    }

    /**
     * Verifica si un par de símbolos son correspondientes (apertura y cierre).
     * 
     * @param apertura símbolo de apertura.
     * @param cierre símbolo de cierre.
     * @return true si coinciden, false si no.
     */
    private static boolean corresponde(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '{' && cierre == '}') ||
               (apertura == '[' && cierre == ']');
    }

    /**
     * Método principal para probar la función con un ejemplo.
     * 
     * @param args Argumentos de línea de comando (no usados).
     */
    public static void main(String[] args) {
        String expr = "{7 + (8 * 5) - [(9 - 7) + (4 + 1)]}";

        if (estaBalanceada(expr)) {
            System.out.println("Fórmula balanceada.");
        } else {
            System.out.println("Fórmula no balanceada.");
        }
    }
}
