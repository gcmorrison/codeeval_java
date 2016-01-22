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
public class LongestWordTest {

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
        String testOutput = "foshizzle";

        classUnderTest = spy(classUnderTest);
        doReturn(testOutput).when(classUnderTest).findLongestWord(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.findLongestWord(null));
        assertNull(classUnderTest.findLongestWord(""));
    }

    @Test
    public void testOneWord() throws Exception {
        String testOutput = "foshizzle";
        assertEquals(testOutput, classUnderTest.findLongestWord(testOutput));
    }

    @Test
    public void testTwoWordsOfDifferentLength() throws Exception {
        assertEquals("world", classUnderTest.findLongestWord("hey world"));
    }

    @Test
    public void testOneCharacterWords() throws Exception {
        assertEquals("a", classUnderTest.findLongestWord("a b c"));
    }
}
