import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/08.
 */
public class OddNumbersTest {
    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testPrintOddNumbers_None() throws Exception {
        verify(mockOut, never()).print(anyString());

        classUnderTest.printOddNumbers(0);
        verify(mockOut, never()).print(anyString());
    }

    @Test
    public void testPrintOddNumbers_1() throws Exception {
        classUnderTest.printOddNumbers(1);
        verify(mockOut).println(1);
    }

    @Test
    public void testPrintOddNumbers_2() throws Exception {
        classUnderTest.printOddNumbers(2);
        verify(mockOut).println(1);
    }

    @Test
    public void testPrintOddNumbers_10() throws Exception {
        classUnderTest.printOddNumbers(10);
        verify(mockOut).println(1);
        verify(mockOut).println(3);
        verify(mockOut).println(5);
        verify(mockOut).println(7);
        verify(mockOut).println(9);
    }
}
