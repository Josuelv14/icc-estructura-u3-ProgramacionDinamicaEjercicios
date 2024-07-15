package Ejercicio;

import java.util.List;
import java.util.ArrayList;
/*
 * Dados n pares de paréntesis, implementa un algoritmo para generar todas las combinaciones
 * válidas de paréntesis.
 *
 * Ejemplo 1:
 *  Input:
 *    n: 1
 *  Output:
 *    ["()"]
 *
 * Ejemplo 2:
 *  Input:
 *    n: 3
 *  Output:
 *    ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Ecoja la mejor estructura de datos para que sea mas eficiente
 * Se debe usar StringBuilder
 */
public class EjercicioDos {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder actual, int abrir, int cerrar, int max) {
        if (actual.length() == max * 2) {
            result.add(actual.toString());
            return;
        }
        if (abrir < max) {
            actual.append('(');
            backtrack(result, actual, abrir + 1, cerrar, max);
            actual.deleteCharAt(actual.length() - 1);
        }
        if (cerrar < abrir) {
            actual.append(')');
            backtrack(result, actual, abrir, cerrar + 1, max);
            actual.deleteCharAt(actual.length() - 1);
        }
    
    }
}
