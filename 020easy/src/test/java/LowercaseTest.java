import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by campbell on 2015/12/18.
 */
public class LowercaseTest {

    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Main();
    }

    @Test
    public void testPrintResult() throws Exception {
        assertNotNull(classUnderTest.printResult(""));
        assertEquals("a", classUnderTest.printResult("a"));
        assertEquals("a", classUnderTest.printResult("A"));
        assertEquals("abc", classUnderTest.printResult("AbC"));
        assertEquals("abcdefghijklmnopqrstuvwxyz", classUnderTest.printResult("aBcDeFgHiJkLmNoPqRsTuVwXyZ"));
        assertEquals("here are some words.", classUnderTest.printResult("Here are SOME words."));
        assertEquals("123", classUnderTest.printResult("123"));
        assertEquals("1.2!3?", classUnderTest.printResult("1.2!3?"));
    }
}