import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/27.
 */
public class CompressedSequenceTest {

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
        doReturn(testOutput).when(classUnderTest).compressSequence(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.compressSequence(null));
        assertNull(classUnderTest.compressSequence(""));
    }

    @Test
    public void testSequenceWithOneNumber() throws Exception {
        assertEquals("1 1", classUnderTest.compressSequence("1"));
        assertEquals("3 31", classUnderTest.compressSequence("31 31 31"));
    }

    @Test
    public void testSequenceWithOneSequencePerNumber() throws Exception {
        assertEquals("2 1 3 2", classUnderTest.compressSequence("1 1 2 2 2"));
        assertEquals("3 31 1 44", classUnderTest.compressSequence("31 31 31 44"));
        assertEquals("4 6 2 3", classUnderTest.compressSequence("6 6 6 6 3 3"));
    }

    @Test
    public void testSequenceWithMultipleSequencesPerNumber() throws Exception {
        assertEquals("2 1 1 2 2 1 1 3", classUnderTest.compressSequence("1 1 2 1 1 3"));
    }
}
