import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/19.
 */
public class LowestUniqueNumberTest {

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
        int winningPlayer = 2;

        classUnderTest = spy(classUnderTest);
        doReturn(winningPlayer).when(classUnderTest).findPlayerWithLowestUnique(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(winningPlayer);
    }

    @Test
    public void testAllUnique() throws Exception {
        assertEquals(2, classUnderTest.findPlayerWithLowestUnique("7 4 5"));
    }

    @Test
    public void testAllSame() throws Exception {
        assertEquals(0, classUnderTest.findPlayerWithLowestUnique("1 1 1"));
    }

    @Test
    public void testOneUnique() throws Exception {
        assertEquals(7, classUnderTest.findPlayerWithLowestUnique("1 2 1 3 2 3 5 7 7"));
    }

    @Test
    public void testMultipleUnique() throws Exception {
        assertEquals(5, classUnderTest.findPlayerWithLowestUnique("1 7 6 1 3 6"));
    }
}
