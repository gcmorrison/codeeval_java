import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/20.
 */
public class ShortestRepetitionTest {

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
        doReturn(testOutput).when(classUnderTest).determineShortestRepetition(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testNoInput() throws Exception {
        assertEquals(0, classUnderTest.determineShortestRepetition(null));
        assertEquals(0, classUnderTest.determineShortestRepetition(""));
    }

    @Test
    public void testOneCharacter() throws Exception {
        assertEquals(1, classUnderTest.determineShortestRepetition("a"));
    }

    @Test
    public void testNoRepetition() throws Exception {
        assertEquals(5, classUnderTest.determineShortestRepetition("abcde"));
    }

    @Test
    public void testOneRepeatingCharacter() throws Exception {
        assertEquals(1, classUnderTest.determineShortestRepetition("ooooo"));
    }

    @Test
    public void testTwoRepeatingCharacters() throws Exception {
        assertEquals(2, classUnderTest.determineShortestRepetition("tototototo"));
    }
}
