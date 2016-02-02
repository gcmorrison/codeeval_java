import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/02/01.
 */
public class SplitNumberTest {

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
        int testOutput = 5;

        classUnderTest = spy(classUnderTest);
        doReturn(testOutput).when(classUnderTest).splitAndCalculate(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertEquals(-1, classUnderTest.splitAndCalculate(null));
        assertEquals(-1, classUnderTest.splitAndCalculate(""));
    }

    @Test
    public void testNoOperator() throws Exception {
        assertEquals(3, classUnderTest.splitAndCalculate("3 a"));
        assertEquals(35, classUnderTest.splitAndCalculate("35 ab"));
        assertEquals(67684, classUnderTest.splitAndCalculate("67684 abcde"));
    }

    @Test
    public void testNoLeftOperand() throws Exception {
        assertEquals(-3, classUnderTest.splitAndCalculate("3 -a"));
        assertEquals(2487, classUnderTest.splitAndCalculate("2487 +abcd"));
    }

    @Test
    public void testNoRightOperand() throws Exception {
        assertEquals(5, classUnderTest.splitAndCalculate("5 a-"));
        assertEquals(47687, classUnderTest.splitAndCalculate("47687 abcde+"));
    }

    @Test
    public void testMinusOperand() throws Exception {
        assertEquals(2, classUnderTest.splitAndCalculate("53 a-b"));
        assertEquals(27, classUnderTest.splitAndCalculate("7346 ab-cd"));
    }

    @Test
    public void testPlusOperand() throws Exception {
        assertEquals(67, classUnderTest.splitAndCalculate("4522 ab+cd"));
        assertEquals(27687, classUnderTest.splitAndCalculate("734620341 abcd+efghi"));
    }
}
