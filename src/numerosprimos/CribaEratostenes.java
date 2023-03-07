/**
 * Clase para generar todos los números primos de 1 hasta
 * un número máximo especificado por el usuario. Como
 * algoritmo se utiliza la criba de Eratóstenes.
 *
 * Eratóstenes de Cirene (276 a.C., Cirene, Libia – 194
 * a.C., Alejandría, Egipto) fue el primer hombre que
 * calculó la circunferencia de la Tierra. También
 * se le conoce por su trabajo con calendarios que ya
 * incluían años bisiestos y por dirigir la mítica
 * biblioteca de Alejandría.
 *
 * El algoritmo es bastante simple: Dado un vector de
 * enteros empezando en 2, se tachan todos los múltiplos
 * de 2. A continuación, se encuentra el siguiente
 * entero no tachado y se tachan todos sus múltiplos. El
 * proceso se repite hasta que se pasa de la raíz cuadrada
 * del valor máximo. Todos los números que queden sin
 * tachar son números primos.
 */
package numerosprimos;

public class CribaEratostenes {

    /**
     * Generar números primos de 1 a max
     *
     * @param max es el valor máximo
     * @return Vector de números primos
     */
    public static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0];
        }

        boolean[] esPrimo = new boolean[max + 1];
        inicializarArray(esPrimo);
        cribaDeEratostenes(esPrimo);

        int[] primos = llenarVectorPrimos(esPrimo);
        return primos;
    }

    private static void inicializarArray(boolean[] esPrimo) {
        for (int i = 2; i < esPrimo.length; i++) {
            esPrimo[i] = true;
        }
    }

    private static void cribaDeEratostenes(boolean[] esPrimo) {
        int raizCuadrada = (int) Math.sqrt(esPrimo.length);
        for (int i = 2; i <= raizCuadrada; i++) {
            if (esPrimo[i]) {
                eliminarMultiplos(i, esPrimo);
            }
        }
    }

    private static void eliminarMultiplos(int i, boolean[] esPrimo) {
        for (int j = i * i; j < esPrimo.length; j += i) {
            esPrimo[j] = false;
        }
    }

    private static int[] llenarVectorPrimos(boolean[] esPrimo) {
        int cuenta = contarPrimos(esPrimo);
        int[] primos = new int[cuenta];
        for (int i = 2, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
        return primos;
    }

    private static int contarPrimos(boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 2; i < esPrimo.length; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }
}
