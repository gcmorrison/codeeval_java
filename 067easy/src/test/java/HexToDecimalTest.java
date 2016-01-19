import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by campbell on 2016/01/14.
 */
public class HexToDecimalTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testHexToDecimal_IllegalDigit() throws Exception {
        try {
            classUnderTest.convertHexToDecimal("g");
        } catch (IllegalArgumentException e) {
            // Test passes
            return;
        }
        fail();
    }

    @Test
    public void testHexToDecimal_SingleDigit() throws Exception {
        assertEquals(0, classUnderTest.convertHexToDecimal("0"));
        assertEquals(1, classUnderTest.convertHexToDecimal("1"));
        assertEquals(2, classUnderTest.convertHexToDecimal("2"));
        assertEquals(3, classUnderTest.convertHexToDecimal("3"));
        assertEquals(4, classUnderTest.convertHexToDecimal("4"));
        assertEquals(5, classUnderTest.convertHexToDecimal("5"));
        assertEquals(6, classUnderTest.convertHexToDecimal("6"));
        assertEquals(7, classUnderTest.convertHexToDecimal("7"));
        assertEquals(8, classUnderTest.convertHexToDecimal("8"));
        assertEquals(9, classUnderTest.convertHexToDecimal("9"));
        assertEquals(10, classUnderTest.convertHexToDecimal("a"));
        assertEquals(11, classUnderTest.convertHexToDecimal("b"));
        assertEquals(12, classUnderTest.convertHexToDecimal("c"));
        assertEquals(13, classUnderTest.convertHexToDecimal("d"));
        assertEquals(14, classUnderTest.convertHexToDecimal("e"));
        assertEquals(15, classUnderTest.convertHexToDecimal("f"));
    }

    @Test
    public void testHexToDecimal_MultipleDigits() throws Exception {
        assertEquals(16, classUnderTest.convertHexToDecimal("10"));
        assertEquals(17, classUnderTest.convertHexToDecimal("11"));
        assertEquals(31, classUnderTest.convertHexToDecimal("1f"));
        assertEquals(159, classUnderTest.convertHexToDecimal("9f"));
        assertEquals(427, classUnderTest.convertHexToDecimal("1ab"));
        assertEquals(16777215, classUnderTest.convertHexToDecimal("ffffff"));
    }

    @Test
    public void testPrintResult() throws Exception {
        classUnderTest.printResult("123");
        verify(mockOut).println(291);
    }
}
