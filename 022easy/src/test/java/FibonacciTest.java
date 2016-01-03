import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Campbell on 2016/01/03.
 */
public class FibonacciTest {
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Main();
    }

    @Test
    public void testSolution() throws Exception {
        assertEquals(0, classUnderTest.printResult("0"));
        assertEquals(1, classUnderTest.printResult("1"));
        assertEquals(1, classUnderTest.printResult("2"));
        assertEquals(2, classUnderTest.printResult("3"));
        assertEquals(3, classUnderTest.printResult("4"));
        assertEquals(5, classUnderTest.printResult("5"));
        assertEquals(8, classUnderTest.printResult("6"));
        assertEquals(13, classUnderTest.printResult("7"));
        assertEquals(21, classUnderTest.printResult("8"));
    }
}
