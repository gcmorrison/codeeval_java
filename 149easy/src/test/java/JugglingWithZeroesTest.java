import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/02/04.
 */
public class JugglingWithZeroesTest {

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
        long testOutput = 3;

        classUnderTest = spy(classUnderTest);
        doReturn(testOutput).when(classUnderTest).parse(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertEquals(0, classUnderTest.parse(null));
        assertEquals(0, classUnderTest.parse(""));
    }

    @Test
    public void testOneSequenceAllOnes() throws Exception {
        assertEquals(1, classUnderTest.parse("00 0"));
        assertEquals(3, classUnderTest.parse("00 00"));
        assertEquals(127, classUnderTest.parse("00 0000000"));
    }

    @Test
    public void testOneSequenceAllZeroes() throws Exception {
        assertEquals(0, classUnderTest.parse("0 0"));
        assertEquals(0, classUnderTest.parse("0 00"));
        assertEquals(0, classUnderTest.parse("0 0000000"));
    }

    @Test
    public void testMultipleSequencesOfOnes() throws Exception {
        assertEquals(7, classUnderTest.parse("00 0 00 0 00 0"));
    }

    @Test
    public void testMixedSequences() throws Exception {
        assertEquals(5, classUnderTest.parse("00 0 0 0 00 0"));
        assertEquals(399, classUnderTest.parse("00 00 0 000 00 0000"));
    }
}
