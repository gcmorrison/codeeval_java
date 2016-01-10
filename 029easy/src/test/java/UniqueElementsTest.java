import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by Campbell on 2016/01/10.
 */
public class UniqueElementsTest {
    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testPrintResult_EmptyInput() throws Exception {
        classUnderTest.printResult(null);
        verify(mockOut).println("");
        reset(mockOut);

        classUnderTest.printResult("");
        verify(mockOut).println("");
        reset(mockOut);

        classUnderTest.printResult(" ");
        verify(mockOut).println("");
    }

    @Test
    public void testPrintResult_OneNumber() throws Exception {
        classUnderTest.printResult("1");
        verify(mockOut).println("1");
    }

    @Test
    public void testPrintResult_TwoUniqueNumbers() throws Exception {
        classUnderTest.printResult("1,5");
        verify(mockOut).println("1,5");
    }

    @Test
    public void testPrintResult_DuplicateNumbers() throws Exception {
        classUnderTest.printResult("1,1");
        verify(mockOut).println("1");
    }

    @Test
    public void testPrintResult_ManyNumbers() throws Exception {
        classUnderTest.printResult("1,1,2,3,4,4,5,6,7,8,8,8,8,9");
        verify(mockOut).println("1,2,3,4,5,6,7,8,9");
    }
}
