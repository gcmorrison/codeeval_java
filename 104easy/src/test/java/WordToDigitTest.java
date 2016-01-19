import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Campbell on 2016/01/19.
 */
public class WordToDigitTest {

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
        String testOutput = "123";

        classUnderTest = spy(classUnderTest);
        doReturn(testOutput).when(classUnderTest).convertWordsToNumber(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testZero() throws Exception {
        assertEquals("0", classUnderTest.convertWordsToNumber("zero"));
    }

    @Test
    public void testKeepLeadingZeroes() throws Exception {
        assertEquals("000", classUnderTest.convertWordsToNumber("zero;zero;zero"));
    }

    @Test
    public void testOne() throws Exception {
        assertEquals("1", classUnderTest.convertWordsToNumber("one"));
    }

    @Test
    public void testTwo() throws Exception {
        assertEquals("2", classUnderTest.convertWordsToNumber("two"));
    }

    @Test
    public void testThree() throws Exception {
        assertEquals("3", classUnderTest.convertWordsToNumber("three"));
    }

    @Test
    public void testFour() throws Exception {
        assertEquals("4", classUnderTest.convertWordsToNumber("four"));
    }

    @Test
    public void testFive() throws Exception {
        assertEquals("5", classUnderTest.convertWordsToNumber("five"));
    }

    @Test
    public void testSix() throws Exception {
        assertEquals("6", classUnderTest.convertWordsToNumber("six"));
    }

    @Test
    public void testSeven() throws Exception {
        assertEquals("7", classUnderTest.convertWordsToNumber("seven"));
    }

    @Test
    public void testEight() throws Exception {
        assertEquals("8", classUnderTest.convertWordsToNumber("eight"));
    }

    @Test
    public void testNine() throws Exception {
        assertEquals("9", classUnderTest.convertWordsToNumber("nine"));
    }

    @Test
    public void testSequence() throws Exception {
        assertEquals("11234509", classUnderTest.convertWordsToNumber("one;one;two;three;four;five;zero;nine"));
    }
}
