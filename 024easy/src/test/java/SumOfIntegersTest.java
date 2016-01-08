import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by campbell on 2016/01/08.
 */
public class SumOfIntegersTest {
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new Main();
    }

    @Test
    public void testGetNextValue() throws Exception {
        assertEquals(0, classUnderTest.getNextValue(null));
        assertEquals(0, classUnderTest.getNextValue(""));
        assertEquals(0, classUnderTest.getNextValue("0"));
        assertEquals(1, classUnderTest.getNextValue("1"));
        assertEquals(12354, classUnderTest.getNextValue("12354"));
    }

    @Test
    public void testPrintResult() throws Exception {
        assertEquals("5", classUnderTest.printResult(5));
    }
}
