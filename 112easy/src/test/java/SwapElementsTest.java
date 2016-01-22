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
public class SwapElementsTest {

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
        String testOutput = "testOutput";

        classUnderTest = spy(classUnderTest);
        doReturn(testOutput).when(classUnderTest).swapElements(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.swapElements(null));
        assertNull(classUnderTest.swapElements(""));
    }

    @Test
    public void testNoSwap() throws Exception {
        String testOutput = "1 2";
        assertEquals(testOutput, classUnderTest.swapElements(testOutput));
    }

    @Test
    public void testEmptySwap() throws Exception {
        assertEquals("1 2", classUnderTest.swapElements("1 2 :"));
    }

    @Test
    public void testSimpleSingleSwap() throws Exception {
        assertEquals("2 1", classUnderTest.swapElements("1 2 : 0-1"));
    }

    @Test
    public void testLongSingleSwap() throws Exception {
        assertEquals("10 2 5487 574 1 67 957 333", classUnderTest.swapElements("10 2 333 574 1 67 957 5487 : 2-7"));
    }

    @Test
    public void testMultipleSwaps() throws Exception {
        assertEquals("2 3 4 5 6 1 7", classUnderTest.swapElements("1 2 3 4 5 6 7 : 0-1, 1-2, 2-3, 3-4, 4-5"));
    }
}
