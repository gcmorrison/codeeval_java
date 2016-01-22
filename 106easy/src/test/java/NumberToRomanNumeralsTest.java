import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/20.
 */
public class NumberToRomanNumeralsTest {

    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testPrintResult() throws Exception {
        String testOutput = "VII";

        classUnderTest = spy(classUnderTest);
        doReturn(testOutput).when(classUnderTest).convertNumberToRomanNumeral(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.convertNumberToRomanNumeral(null));
        assertNull(classUnderTest.convertNumberToRomanNumeral(""));
        assertNull(classUnderTest.convertNumberToRomanNumeral("0"));
    }

    @Test
    public void testNumeralForOne() throws Exception {
        assertEquals("I", classUnderTest.convertNumberToRomanNumeral("1"));
    }

    @Test
    public void testNumeralForTwo() throws Exception {
        assertEquals("II", classUnderTest.convertNumberToRomanNumeral("2"));
    }

    @Test
    public void testNumeralForThree() throws Exception {
        assertEquals("III", classUnderTest.convertNumberToRomanNumeral("3"));
    }

    @Test
    public void testNumeralForFour() throws Exception {
        assertEquals("IV", classUnderTest.convertNumberToRomanNumeral("4"));
    }

    @Test
    public void testNumeralForFive() throws Exception {
        assertEquals("V", classUnderTest.convertNumberToRomanNumeral("5"));
    }

    @Test
    public void testNumeralForSix() throws Exception {
        assertEquals("VI", classUnderTest.convertNumberToRomanNumeral("6"));
    }

    @Test
    public void testNumeralForSeven() throws Exception {
        assertEquals("VII", classUnderTest.convertNumberToRomanNumeral("7"));
    }

    @Test
    public void testNumeralForEight() throws Exception {
        assertEquals("VIII", classUnderTest.convertNumberToRomanNumeral("8"));
    }

    @Test
    public void testNumeralForNine() throws Exception {
        assertEquals("IX", classUnderTest.convertNumberToRomanNumeral("9"));
    }

    @Test
    public void testNumeralForTen() throws Exception {
        assertEquals("X", classUnderTest.convertNumberToRomanNumeral("10"));
    }

    @Test
    public void testNumeralForThirty() throws Exception {
        assertEquals("XXX", classUnderTest.convertNumberToRomanNumeral("30"));
    }

    @Test
    public void testNumeralForLargeNumber() throws Exception {
        assertEquals("MMCLXXXVI", classUnderTest.convertNumberToRomanNumeral("2186"));
    }
}
