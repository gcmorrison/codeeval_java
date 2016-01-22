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
public class MultiplyListsTest {

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
        doReturn(testOutput).when(classUnderTest).parseListsAndMultiply(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.parseListsAndMultiply(null));
        assertNull(classUnderTest.parseListsAndMultiply(""));
    }

    @Test
    public void testListsOfOnes() throws Exception {
        assertEquals("1", classUnderTest.parseListsAndMultiply("1 | 1"));
        assertEquals("1 1 1 1", classUnderTest.parseListsAndMultiply("1 1 1 1 | 1 1 1 1"));
    }

    @Test
    public void testDuplicateLists() throws Exception {
        assertEquals("1 4 9", classUnderTest.parseListsAndMultiply("1 2 3 | 1 2 3"));
        assertEquals("100 400 900", classUnderTest.parseListsAndMultiply("10 20 30 | 10 20 30"));
    }

    @Test
    public void testUniqueLists() throws Exception {
        assertEquals("4 10 18", classUnderTest.parseListsAndMultiply("1 2 3 | 4 5 6"));
    }
}
