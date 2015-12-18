import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by campbell on 2015/12/18.
 */
public class SumOfPrimesTest {
    Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Main();
    }

    @Test
    public void testPrime() throws Exception {
        assertTrue(classUnderTest.isPrime(2));
        assertTrue(classUnderTest.isPrime(3));
        assertTrue(classUnderTest.isPrime(5));
        assertTrue(classUnderTest.isPrime(7));
        assertTrue(classUnderTest.isPrime(11));

        assertFalse(classUnderTest.isPrime(4));
        assertFalse(classUnderTest.isPrime(6));
        assertFalse(classUnderTest.isPrime(21));
    }

    @Test
    public void testSumOfPrime() throws Exception {
        assertEquals(2 + 3 + 5, classUnderTest.calculateSumOfPrimes(3));
        assertEquals(2 + 3 + 5 + 7 + 11, classUnderTest.calculateSumOfPrimes(5));
        assertEquals(3682913, classUnderTest.calculateSumOfPrimes(1000));
    }
}
