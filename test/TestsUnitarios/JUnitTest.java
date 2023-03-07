package TestsUnitarios;

import numerosprimos.CribaEratostenes;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitTest {

    @Test
    public void testGenerarPrimos0() {
        int[] result = CribaEratostenes.generarPrimos(0);
        assertArrayEquals(new int[0], result);
    }

    @Test
    public void testGenerarPrimos2() {
        int[] result = CribaEratostenes.generarPrimos(2);
        assertArrayEquals(new int[]{2}, result);
    }

    @Test
    public void testGenerarPrimos3() {
        int[] result = CribaEratostenes.generarPrimos(3);
        assertArrayEquals(new int[]{2, 3}, result);
    }

    @Test
    public void testGenerarPrimos100() {
        int[] result = CribaEratostenes.generarPrimos(100);
        int[] expected = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        assertArrayEquals(expected, result);
    }
}
