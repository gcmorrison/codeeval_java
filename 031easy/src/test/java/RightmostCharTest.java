import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by Campbell on 2016/01/10.
 */
public class RightmostCharTest {
    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testPrintResult_EmptyLines() throws Exception {
        classUnderTest.printResult(null);
        classUnderTest.printResult("");
        verifyZeroInteractions(mockOut);
    }

    @Test
    public void testPrintResult_NoMatchingChar() throws Exception {
        classUnderTest.printResult("hello,r");
        verify(mockOut).println(-1);
    }

    @Test
    public void testPrintResult_OneMatchingChar() throws Exception {
        classUnderTest.printResult("hello,e");
        verify(mockOut).println(1);

        classUnderTest.printResult("hello,h");
        verify(mockOut).println(1);
    }

    @Test
    public void testPrintResult_MultipleMatchingChars() throws Exception {
        classUnderTest.printResult("hello,l");
        verify(mockOut).println(3);
    }
}
