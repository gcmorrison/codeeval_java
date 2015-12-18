import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by campbell on 2015/12/18.
 */
public class SumOfDigitsTest {
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Main();
    }

    @Test
    public void testSumOfDigits() throws Exception {
        assertEquals(0, classUnderTest.printResult(""));
        assertEquals(1, classUnderTest.printResult("1"));
        assertEquals(2, classUnderTest.printResult("11"));
        assertEquals(3, classUnderTest.printResult("12"));
        assertEquals(45, classUnderTest.printResult("0123456789"));
    }
}
