import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by campbell on 2016/01/25.
 */
public class HiddenDigitsTest {

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
        doReturn(testOutput).when(classUnderTest).extractHiddenAndVisibleDigits(anyString());

        classUnderTest.printResult("");
        verify(mockOut).println(testOutput);
    }

    @Test
    public void testEmptyInput() throws Exception {
        assertEquals("NONE", classUnderTest.extractHiddenAndVisibleDigits(null));
        assertEquals("NONE", classUnderTest.extractHiddenAndVisibleDigits(""));
    }

    @Test
    public void testNoDigits() throws Exception {
        assertEquals("NONE", classUnderTest.extractHiddenAndVisibleDigits("A#$F"));
    }

    @Test
    public void testVisibleDigitsOnly() throws Exception {
        assertEquals("147", classUnderTest.extractHiddenAndVisibleDigits("147"));
    }

    @Test
    public void testHiddenDigitsOnly() throws Exception {
        assertEquals("147", classUnderTest.extractHiddenAndVisibleDigits("beh"));
    }

    @Test
    public void testHiddenAndVisibleDigits() throws Exception {
        assertEquals("123456", classUnderTest.extractHiddenAndVisibleDigits("1c3e5g"));
    }

    @Test
    public void testHasDigitsWithInvalidCharacters() throws Exception {
        assertEquals("123456", classUnderTest.extractHiddenAndVisibleDigits("1c!A3eHELLO WORLD5',{}g"));
    }
}
