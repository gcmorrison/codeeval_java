import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/02/01.
 */
public class RacingCharsTest {

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
        doReturn(testOutput).when(classUnderTest).handleRaceLine(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertNull(classUnderTest.handleRaceLine(null));
        assertNull(classUnderTest.handleRaceLine(""));
    }

    @Test
    public void testFirstLineWithGateOnly() throws Exception {
        assertEquals("##|##", classUnderTest.handleRaceLine("##_##"));
    }

    @Test
    public void testFirstLineWithGateAndCheckpoint() throws Exception {
        assertEquals("#_##|##", classUnderTest.handleRaceLine("#_##C##"));
    }

    @Test
    public void testMultipleLines_NoCheckpoints() throws Exception {
        assertEquals("|##", classUnderTest.handleRaceLine("_##"));
        assertEquals("#\\#", classUnderTest.handleRaceLine("#_#"));
        assertEquals("##\\", classUnderTest.handleRaceLine("##_"));
        assertEquals("#/#", classUnderTest.handleRaceLine("#_#"));
    }

    @Test
    public void testMultipleLines_WithCheckpoints() throws Exception {
        assertEquals("#|###", classUnderTest.handleRaceLine("#_###"));
        assertEquals("#_\\##", classUnderTest.handleRaceLine("#_C##"));
        assertEquals("#/#_#", classUnderTest.handleRaceLine("#C#_#"));
        assertEquals("##\\##", classUnderTest.handleRaceLine("##C##"));
        assertEquals("###\\#", classUnderTest.handleRaceLine("###_#"));
        assertEquals("##/_#", classUnderTest.handleRaceLine("##C_#"));
    }
}
