import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by campbell on 2015/12/18.
 */
public class PrimePalindromeTest {
    Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Main();
    }

    @Test
    public void testPalindrome() throws Exception {
        assertTrue(classUnderTest.isPalindrome(1));
        assertTrue(classUnderTest.isPalindrome(121));
        assertTrue(classUnderTest.isPalindrome(212));
        assertTrue(classUnderTest.isPalindrome(999));

        assertFalse(classUnderTest.isPalindrome(12));
        assertFalse(classUnderTest.isPalindrome(12));
        assertFalse(classUnderTest.isPalindrome(123));
        assertFalse(classUnderTest.isPalindrome(2121));
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
    public void testFindLargestPrimePalindrome() throws Exception {
        assertEquals(7, classUnderTest.findLargestPrimePalindrome(10));
        assertEquals(11, classUnderTest.findLargestPrimePalindrome(20));
        assertEquals(11, classUnderTest.findLargestPrimePalindrome(100));
        assertEquals(191, classUnderTest.findLargestPrimePalindrome(200));
        assertEquals(929, classUnderTest.findLargestPrimePalindrome(1000));
    }
}
