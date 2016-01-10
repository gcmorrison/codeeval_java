/**
 * Created by Campbell on 2016/01/10.
 */

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class SetIntersectionTest {
    private PrintStream mockOut;
    private Main classUnderTest;

    @Before
    public void setUp() throws Exception {
        mockOut = mock(PrintStream.class);
        System.setOut(mockOut);

        classUnderTest = new Main();
    }

    @Test
    public void testPrintResult_ListsEmpty() throws Exception {
        classUnderTest.printResult(";");
        verify(mockOut).println("");
        reset(mockOut);

        classUnderTest.printResult("1;");
        verify(mockOut).println("");
        reset(mockOut);

        classUnderTest.printResult(";1");
        verify(mockOut).println("");
        reset(mockOut);
    }

    @Test
    public void testPrintResult_NoIntersections() throws Exception {
        classUnderTest.printResult("1,2;3,4");
        verify(mockOut).println("");
    }

    @Test
    public void testPrintResult_HasOneIntersection() throws Exception {
        classUnderTest.printResult("1,2;1,4");
        verify(mockOut).println("1");
    }

    @Test
    public void testPrintResult_HasManyIntersections() throws Exception {
        classUnderTest.printResult("1,2,3,4,5;2,3,4");
        verify(mockOut).println("2,3,4");
    }

    @Test
    public void testPrintResult_HasLargeNumbersWithIntersections() throws Exception {
        classUnderTest.printResult("12,23;23,25712");
        verify(mockOut).println("23");
    }

    @Test
    public void testPrintResult_HasIntersections() throws Exception {
        classUnderTest.printResult("9,10,11;11,12,13");
        verify(mockOut).println("11");
    }
}
